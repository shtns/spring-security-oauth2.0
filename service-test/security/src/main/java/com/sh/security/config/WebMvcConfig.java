package com.sh.security.config;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.sh.api.common.constant.HtmlPageNameConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 页面配置
 *
 *
 * @author 盛浩
 * @date 2021/1/16 13:36
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     *  注册视图登入页
     *
     * @param registry 注册
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(StringPool.SLASH).setViewName(HtmlPageNameConstants.LOGIN);
    }
}
