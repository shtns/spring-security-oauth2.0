package com.sh.session.common.interceptor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.sh.api.common.constant.HttpSessionConstants;
import com.sh.api.organization.user.vo.login.UserLoginVo;
import com.sh.session.feign.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 临时会话拦截器
 *
 *
 * @author 盛浩
 * @date 2021/1/16 3:48
 */
@Configuration
@RequiredArgsConstructor
public class SessionInterceptor implements HandlerInterceptor {

    private final UserInfoService userInfoService;

    /**
     * 前置拦截器
     *
     * @param request 请求
     * @param response 响应
     * @param handler 对象
     * @return 是否拦截成功
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean flag = Boolean.FALSE;

        Object object = request.getSession().getAttribute(HttpSessionConstants.USER_LOGIN_VO_KEY);
        if (ObjectUtil.isNotNull(object)) {
            UserLoginVo userLoginVo  = (UserLoginVo) object;
            flag = this.handlerRequest(response, this.userInfoService.queryUserPermissions(userLoginVo.getUserId()).getData(), request.getRequestURI());
        } else {
            this.writeContent(response, HttpSessionConstants.ForegroundPrompt.PLEASE_LOGON);
        }

        return  flag;
    }

    /**
     * 处理请求
     *
     * @param response 响应
     * @param permissions 权限列表
     * @param requestUrl 请求地址
     * @return 请求是否处理成功
     * @throws IOException e
     */
    private boolean handlerRequest(HttpServletResponse response, List<String> permissions, String requestUrl) throws IOException {

        boolean flag = Boolean.FALSE;

        for (String str : permissions) {
            if (StrUtil.equals(requestUrl, str)) {
                flag = Boolean.TRUE;
                break;
            }
        }
        if (! flag) {
            this.writeContent(response, HttpSessionConstants.ForegroundPrompt.ACCESS_DENIED_WITHOUT_PERMISSION);
        }

        return flag;
    }

    /**
     * 返回提示信息给客户端
     *
     * @param response 响应
     * @param prompt 提示
     */
    private void writeContent(HttpServletResponse response, String prompt) throws IOException {
        response.setContentType(HttpSessionConstants.RESPONSE_CODE);
        PrintWriter writer = response.getWriter();
        writer.println(prompt);
        writer.close();
    }
}
