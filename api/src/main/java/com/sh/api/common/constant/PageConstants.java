package com.sh.api.common.constant;

/**
 * 页面常量值
 *
 *
 * @author 盛浩
 * @date 2021/1/16 3:37
 */
public interface PageConstants {

    /**
     * 转发地址
     */
    interface ForwardingAddress {

        /**
         * /error/400
         */
        String ERROR_FOUR_HUNDRED  = "/error/400";

        /**
         * /error/401
         */
        String ERROR_FOUR_ZERO_ONE = "/error/401";

        /**
         * /error/403
         */
        String ERROR_FOUR_ZERO_THREE = "/error/403";

        /**
         * /error/404
         */
        String ERROR_FOUR_ZERO_FOUR = "/error/404";

        /**
         * /error/500
         */
        String ERROR_FIVE_HUNDRED = "/error/500";
    }

    /**
     * 前台提示语
     */
    interface ForegroundPrompt {

        /**
         * 400：请求报文存在语法错误
         */
        String FOUR_HUNDRED = "400：请求报文存在语法错误";

        /**
         * 401：未授权
         */
        String FOUR_ZERO_ONE = "401：未授权";

        /**
         * 403：权限不足
         */
        String FOUR_ZERO_THREE = "403：权限不足";

        /**
         * 404：没有找到请求的资源
         */
        String FOUR_ZERO_FOUR = "404：没有找到请求的资源";

        /**
         * 500：服务器端在执行请求时发生了错误
         */
        String FIVE_HUNDRED = "500：服务器端在执行请求时发生了错误";
    }
}
