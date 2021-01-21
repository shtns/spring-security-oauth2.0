package com.sh.session.user.service;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.sh.api.common.constant.HttpSessionConstants;
import com.sh.api.organization.user.vo.login.UserLoginVo;
import com.sh.session.feign.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户信息业务
 *
 *
 * @author 盛浩
 * @date 2021/1/16 4:01
 */
@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl {

    private final UserInfoService userInfoService;

    /**
     * 用户登入
     *
     * @param loginAccount 登入账号
     * @param password 密码
     * @param session 临时会话
     * @return 是否登入成功
     */
    public Boolean userLogin(String loginAccount, String password, HttpSession session) {

        boolean flag = Boolean.FALSE;

        if (this.userInfoService.userLogin(loginAccount, password).getData()) {
            session.setAttribute(HttpSessionConstants.USER_LOGIN_VO_KEY, this.userInfoService.queryUserInfo(loginAccount).getData());
            flag = Boolean.TRUE;
        }

        return flag;
    }

    /**
     * 退出临时会话
     *
     * @param session 临时会话
     * @return 退出提示
     */
    public String logoutSession(HttpSession session) {

        if (ObjectUtil.isNull(session.getAttribute(HttpSessionConstants.USER_LOGIN_VO_KEY))) {
            return HttpSessionConstants.ForegroundPrompt.PLEASE_LOG_IN_BEFORE_YOU_LOG_OUT;
        }

        session.invalidate();
        return HttpSessionConstants.ForegroundPrompt.EXIT_THE_SUCCESS;
    }

    /**
     * 测试资源
     *
     * @param request 请求
     * @param session 临时会话
     * @return 访问姓名+资源
     */
    public String testResource(HttpServletRequest request, HttpSession session) {
        Object object = session.getAttribute(HttpSessionConstants.USER_LOGIN_VO_KEY);
        UserLoginVo userLoginVo = (UserLoginVo)object;
        return StrUtil.concat(Boolean.TRUE, userLoginVo.getNameCn(), StringPool.COMMA,
                HttpSessionConstants.ForegroundPrompt.ACCESSING_RESOURCES,
                StringPool.COLON, request.getRequestURI());
    }
}
