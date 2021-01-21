package com.sh.security.user.controller;

import com.sh.api.common.constant.ResourceConstants;
import com.sh.api.common.constant.SecurityConstants;
import com.sh.api.common.util.R;
import com.sh.security.user.service.UserInfoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户信息管理
 *
 *
 * @author 盛浩
 * @date 2021/1/16 13:45
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserInfoController {

    private final UserInfoServiceImpl userInfoService;

    /**
     * 测试资源一
     *
     * @param request 请求
     * @return 访问姓名+资源
     */
    @GetMapping(value = "/test_resource/one")
    @Secured(value = ResourceConstants.Role.TEST)
    public R<String> testResourceOne(HttpServletRequest request) { return R.ok(this.userInfoService.testResource(request)); }

    /**
     * 测试资源二
     *
     * @param request 请求
     * @return 访问姓名+资源
     */
    @GetMapping(value = "/test_resource/two")
    @Secured(value = ResourceConstants.Role.ADMIN)
    public R<String> testResourceTwo(HttpServletRequest request) { return R.ok(this.userInfoService.testResource(request)); }

    /**
     * 测试资源三
     *
     * @param request 请求
     * @return 访问姓名+资源
     */
    @GetMapping(value = "/test_resource/three")
    @Secured(value = {ResourceConstants.Role.TEST, ResourceConstants.Role.ADMIN})
    public R<String> testResourceThree(HttpServletRequest request) { return R.ok(this.userInfoService.testResource(request)); }

    /**
     * 登入成功
     *
     * @return 提示
     */
    @GetMapping(value = "login_success")
    public R<String> loginSuccess() { return R.ok(SecurityConstants.ForegroundPrompt.LOGIN_SUCCESS); }

    /**
     * 退出成功
     *
     * @return 提示
     */
    @GetMapping(value = "logout_success")
    public R<String> logoutSuccess() { return R.ok(SecurityConstants.ForegroundPrompt.LOGOUT_SUCCESS); }
}
