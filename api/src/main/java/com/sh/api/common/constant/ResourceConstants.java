package com.sh.api.common.constant;

/**
 * 资源常量值
 *
 *
 * @author 盛浩
 * @date 2021/1/16 3:47
 */
public interface ResourceConstants {

    /**
     * 请求地址
     */
    interface Url {

        /**
         * 用户测试资源一
         */
        String USER_TEST_RESOURCE_ONE = "/user/test_resource/one";

        /**
         * 用户测试资源二
         */
        String USER_TEST_RESOURCE_TWO = "/user/test_resource/two";

        /**
         * 用户测试资源三
         */
        String USER_TEST_RESOURCE_THREE = "/user/test_resource/three";

        /**
         * 用户测试资源下的任意一个地址
         */
        String USER_TEST_RESOURCE_ARBITRARILY_ONE = "/user/test_resource/*";

        /**
         * security 默认登入接口
         */
        String USER_LOGIN = "/user/login";

        /**
         * 退出
         */
        String LOGOUT = "/logout";

        /**
         * 获取公钥
         */
        String GAIN_RSA = "/rsa/public_key";

        /**
         * 菜单访问地址前缀
         */
        String MENU_ACCESS_PATH_PREFIX = "/user";
    }

    /**
     * 角色
     */
    interface Role {

        /**
         * 管理员
         */
        String ADMIN = "ROLE_admin";

        /**
         * 测试
         */
        String TEST = "ROLE_test";
    }
}
