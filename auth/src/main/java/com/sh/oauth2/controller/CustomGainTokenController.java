package com.sh.oauth2.controller;

import cn.hutool.core.util.ObjectUtil;
import com.sh.api.common.constant.UserInfoErrorConstants;
import com.sh.api.common.util.R;
import com.sh.api.common.vo.Oauth2TokenVo;
import com.sh.oauth2.service.CustomGainTokenServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.Map;

/**
 * 自定义Oauth2获取令牌管理
 *
 *
 * @author 盛浩
 * @date 2021/1/14 14:18
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/oauth")
@Api(value = "oauth", tags = "自定义Oauth2获取令牌管理")
public class CustomGainTokenController {

    private final CustomGainTokenServiceImpl customGainTokenService;

    /**
     * 获取令牌
     *
     * @param principal 用户相关信息
     * @param parameters 获取令牌参数
     * @return 令牌信息
     * @throws HttpRequestMethodNotSupportedException e
     */
    @PostMapping(value = "/token")
    @ApiOperation(value = "获取令牌", tags = "获取令牌")
    public R<Oauth2TokenVo> postAccessToken(Principal principal, @RequestParam Map<String, String> parameters)
            throws HttpRequestMethodNotSupportedException {
        Oauth2TokenVo oauth2TokenVo = this.customGainTokenService.postAccessToken(principal, parameters);
        if (ObjectUtil.isNull(oauth2TokenVo)) {
            return R.failed(UserInfoErrorConstants.ForegroundPrompt.INCORRECT_ACCOUNT_OR_PASSWORD);
        }
        return R.ok(oauth2TokenVo);
    }
}
