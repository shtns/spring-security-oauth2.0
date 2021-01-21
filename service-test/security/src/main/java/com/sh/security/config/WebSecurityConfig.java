package com.sh.security.config;

import com.sh.api.common.constant.HtmlPageNameConstants;
import com.sh.api.common.constant.ResourceConstants;
import com.sh.security.user.service.UserInfoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 页面安全配置
 *
 *
 * @author 盛浩
 * @date 2021/1/16 13:38
 */
@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserInfoServiceImpl userInfoService;

    /**
     * 密码编码器
     *
     * @return 密码编码器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 资源拦截
     *
     * @param http http
     * @throws Exception e
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().formLogin().loginPage(HtmlPageNameConstants.LOGIN)
                .loginProcessingUrl(ResourceConstants.Url.USER_LOGIN)
                .defaultSuccessUrl(HtmlPageNameConstants.LOGIN_SUCCESS)
                .and().logout().logoutUrl(ResourceConstants.Url.LOGOUT)
                .logoutSuccessUrl(HtmlPageNameConstants.LOGIN)
                .and().authorizeRequests().antMatchers(ResourceConstants.Url.USER_TEST_RESOURCE_ARBITRARILY_ONE)
                .authenticated().anyRequest().permitAll()
                .and().exceptionHandling().accessDeniedPage(HtmlPageNameConstants.FOUR_ZERO_THREE)
                .and().rememberMe().userDetailsService(this.userInfoService);
    }
}