package com.sh.oauth2.controller;

import com.sh.oauth2.service.KeyPairServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * RSA公钥管理
 *
 *
 * @author 盛浩
 * @date 2021/1/12 19:30
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rsa")
@Api(value = "rsa", tags = "RSA公钥管理")
public class KeyPairController {

    private final KeyPairServiceImpl keyPairService;

    @GetMapping("/public_key")
    @ApiOperation(value = "获取公钥", tags = "获取公钥")
    public Map<String, Object> getKey() {
        return this.keyPairService.gainKey();
    }
}
