package com.sh.api.common.constant;

/**
 * 临时会话常量值
 *
 *
 * @author 盛浩
 * @date 2021/1/16 4:07
 */
public interface HttpSessionConstants {

    /**
     * 前台提示语
     */
    interface ForegroundPrompt {

        /**
         * 请登入后，在进行退出
         */
        String PLEASE_LOG_IN_BEFORE_YOU_LOG_OUT = "请登入后，在进行退出";

        /**
         * 退出成功
         */
        String EXIT_THE_SUCCESS = "退出成功";

        /**
         * 访问资源
         */
        String ACCESSING_RESOURCES = "访问资源";

        /**
         * 没有权限，拒绝访问
         */
        String ACCESS_DENIED_WITHOUT_PERMISSION = "没有权限，拒绝访问";

        /**
         * 请登入
         */
        String PLEASE_LOGON = "请登入";
    }

    /**
     * 用户登入信息key
     */
    String USER_LOGIN_VO_KEY= "user_login_vo_key";

    /**
     * 响应编码
     */
    String RESPONSE_CODE ="text/html; charset=UTF-8";
}
