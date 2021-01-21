package com.sh.session.common.config;

import com.sh.api.common.constant.ResourceConstants;
import com.sh.session.common.interceptor.SessionInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 页面资源拦截配置
 *
 *
 * @author 盛浩
 * @date 2021/1/16 3:45
 */
@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final SessionInterceptor sessionInterceptor;

    /**
     * 注册拦截器，拦截资源
     *
     * @param registry 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.sessionInterceptor).addPathPatterns(ResourceConstants.Url.USER_TEST_RESOURCE_ARBITRARILY_ONE);
    }
}
