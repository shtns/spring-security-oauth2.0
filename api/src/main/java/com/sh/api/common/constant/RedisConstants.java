package com.sh.api.common.constant;

/**
 * redis常量值
 *
 *
 * @author 盛浩
 * @date 2021/1/17 22:32
 */
public interface RedisConstants {

    /**
     * 权限缓存key
     */
    interface PermissionCacheKey {

        /**
         * 权限访问路径列表key
         */
        String ACCESS_PATHS= "access_paths_key";
    }
}
