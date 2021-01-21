package com.sh.oauth2.service;

import cn.hutool.core.collection.CollUtil;
import com.sh.api.common.constant.RedisConstants;
import com.sh.api.organization.user.vo.login.UserLoginVo;
import com.sh.oauth2.feign.OrganizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * 用户信息业务
 *
 *
 * @author 盛浩
 * @date 2021/1/17 21:54
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class    UserInfoServiceImpl implements UserDetailsService {

    private final OrganizationService organizationService;

    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * 通过登入账号查询用户信息
     *
     * @param loginAccount 登入账号
     * @return 用户详情
     * @throws UsernameNotFoundException 用户不存在
     */
    @Override
    public UserDetails loadUserByUsername(String loginAccount) throws UsernameNotFoundException {
        Map<String, String> permissionMap = CollUtil.newHashMap();
        UserLoginVo userLoginVo = this.organizationService.queryUserInfo(loginAccount).getData();
        List<String> permissions = this.organizationService.queryUserPermissions(userLoginVo.getUserId()).getData();
        permissions.forEach(permission -> permissionMap.put(permission, permission));
        String[] permissionArray = new String[permissions.size()];
        return User.withUsername(userLoginVo.getLoginAccount()).password(userLoginVo.getPassword())
                .authorities(permissions.toArray(permissionArray)).build();
    }

    @PostConstruct
    public void initData() {
        Map<String, String> permissionMap = CollUtil.newHashMap();
        List<String> permissions = this.organizationService.queryAccessPaths().getData();
        permissions.forEach(permission -> permissionMap.put(permission, permission));
        this.redisTemplate.opsForHash().putAll(RedisConstants.PermissionCacheKey.ACCESS_PATHS, permissionMap);
    }
}
