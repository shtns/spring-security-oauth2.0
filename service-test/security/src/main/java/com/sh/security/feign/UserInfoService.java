package com.sh.security.feign;

import com.sh.api.common.constant.MicroServiceNameConstants;
import com.sh.api.common.util.R;
import com.sh.api.organization.user.vo.login.UserLoginVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

/**
 * 用户信息服务
 *
 *
 * @author 盛浩
 * @date 2021/1/16 2:14
 */
@FeignClient(value = MicroServiceNameConstants.ORGANIZATION_SERVICE)
public interface UserInfoService {

    /**
     * 查询用户信息
     *
     * @param loginAccount 登入账号
     * @return 用户登入信息
     */
    @GetMapping(value = "/user/account/{loginAccount}")
    R<UserLoginVo> queryUserInfo(@PathVariable(value = "loginAccount") String loginAccount);

    /**
     * 用户登入
     *
     * @param loginAccount 登入账号
     * @param password 密码
     * @return 是否登入成功
     */
    @GetMapping(value = "/user/login/{loginAccount}/{password}")
    R<Boolean> userLogin(@PathVariable(value = "loginAccount") String loginAccount, @PathVariable(value = "password") String password);

    /**
     * 查询用户权限列表
     *
     * @param userId 用户id
     * @return 用户权限列表
     */
    @GetMapping(value = "/user/permissions/{userId}")
    R<List<String>> queryUserPermissions(@PathVariable(value = "userId") Long userId);
}
