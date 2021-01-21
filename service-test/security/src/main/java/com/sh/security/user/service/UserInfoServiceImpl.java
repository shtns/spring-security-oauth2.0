package com.sh.security.user.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.sh.api.common.constant.HttpSessionConstants;
import com.sh.api.organization.user.vo.login.UserLoginVo;
import com.sh.security.feign.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户信息业务
 *
 *
 * @author 盛浩
 * @date 2021/1/16 2:21
 */
@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserDetailsService {

    private final UserInfoService userInfoService;

    /**
     * 测试资源
     *
     * @param request 请求
     * @return 访问姓名+资源
     */
    public String testResource(HttpServletRequest request) {
        return StrUtil.concat(Boolean.TRUE, this.getNameCn(), StringPool.COMMA,
                HttpSessionConstants.ForegroundPrompt.ACCESSING_RESOURCES,
                StringPool.COLON, request.getRequestURI());
    }

    /**
     * 获取当前登入用户中文名称
     *
     * @return 用户中文名称
     */
    public String getNameCn() {

        String nameCn = null;

        //当前认证通过的用户身份
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //用户信息
        Object object = authentication.getPrincipal();
        if (object instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) object;
            UserLoginVo userLoginVo = this.userInfoService.queryUserInfo(userDetails.getUsername()).getData();
            nameCn = userLoginVo.getNameCn();
        } else {
            nameCn = object.toString();
        }

        return nameCn;
    }

    /**
     * 查询用户信息
     *
     * @param loginAccount 登入账号
     * @return 用户详情
     * @throws UsernameNotFoundException 登入账号不存在
     */
    @Override
    public UserDetails loadUserByUsername(String loginAccount) throws UsernameNotFoundException {
        UserLoginVo userLoginVo = this.userInfoService.queryUserInfo(loginAccount).getData();
        List<String> permissions = this.userInfoService.queryUserPermissions(userLoginVo.getUserId()).getData();
        String[] permissionsArray = new String[permissions.size()];
        return User.withUsername(userLoginVo.getLoginAccount()).password(userLoginVo.getPassword())
                .authorities(permissions.toArray(permissionsArray)).build();
    }
}
