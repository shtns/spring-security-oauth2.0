package com.sh.session.user.controller;

import com.sh.api.common.constant.HttpSessionConstants;
import com.sh.api.common.util.R;
import com.sh.session.user.service.UserInfoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户信息管理
 *
 *
 * @author 盛浩
 * @date 2021/1/16 3:57
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserInfoController {

    private final UserInfoServiceImpl userInfoService;

    /**
     * 用户登入
     *
     * @param loginAccount 登入账号
     * @param password 密码
     * @param session 临时会话
     * @return 是否登入成功
     */
    @GetMapping(value = "/login/{loginAccount}/{password}")
    public R<Boolean> userLogin(@PathVariable String loginAccount, @PathVariable String password, HttpSession session) {
        return R.ok(this.userInfoService.userLogin(loginAccount, password, session));
    }

    /**
     * 获取临时会话信息
     *
     * @param session 临时会话
     * @return 对象
     */
    @GetMapping(value = "/session")
    public R<Object> getSessionInfo(HttpSession session) { return R.ok(session.getAttribute(HttpSessionConstants.USER_LOGIN_VO_KEY)); }

    /**
     * 退出临时会话
     *
     * @param session 临时会话
     * @return 退出提示
     */
    @GetMapping(value = "/logout")
    public R<String> logoutSession(HttpSession session) {
        return R.ok(this.userInfoService.logoutSession(session));
    }

    /**
     * 测试资源一
     *
     * @param request 请求
     * @param session 临时会话
     * @return 访问姓名+资源
     */
    @GetMapping(value = "/test_resource/one")
    public R<String> testResourceOne(HttpServletRequest request, HttpSession session) { return R.ok(this.userInfoService.testResource(request, session)); }

    /**
     * 测试资源二
     *
     * @param request 请求
     * @param session 临时会话
     * @return 访问姓名+资源
     */
    @GetMapping(value = "/test_resource/two")
    public R<String> testResourceTwo(HttpServletRequest request, HttpSession session) { return R.ok(this.userInfoService.testResource(request, session)); }
}
