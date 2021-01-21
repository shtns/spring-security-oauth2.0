package com.sh.session.common.config;

import com.sh.api.common.constant.PageConstants;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * 错误页面配置
 *
 *
 * @author 盛浩
 * @date 2021/1/16 3:36
 */
@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {

    /**
     * 错误页面地址转发
     *
     * @param registry 错误页面注册
     */
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        registry.addErrorPages(
//                new ErrorPage(HttpStatus.BAD_REQUEST, PageConstants.ForwardingAddress.ERROR_FOUR_HUNDRED),
//                new ErrorPage(HttpStatus.UNAUTHORIZED, PageConstants.ForwardingAddress.ERROR_FOUR_ZERO_ONE),
//                new ErrorPage(HttpStatus.FORBIDDEN, PageConstants.ForwardingAddress.ERROR_FOUR_ZERO_THREE),
                new ErrorPage(HttpStatus.NOT_FOUND, PageConstants.ForwardingAddress.ERROR_FOUR_ZERO_FOUR)
//                new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, PageConstants.ForwardingAddress.ERROR_FIVE_HUNDRED)
        );
    }
}
