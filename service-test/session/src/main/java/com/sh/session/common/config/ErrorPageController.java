package com.sh.session.common.config;

import com.sh.api.common.constant.PageConstants;
import com.sh.api.common.util.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 错误页面管理
 *
 *
 * @author 盛浩
 * @date 2021/1/16 3:41
 */
@RestController
@RequestMapping(value = "/error")
public class ErrorPageController {

    @GetMapping(value = "/400")
    public R<String> errorPage400() { return R.failed(PageConstants.ForegroundPrompt.FOUR_HUNDRED); }

    @GetMapping(value = "/401")
    public R<String> errorPage401() {
        return R.failed(PageConstants.ForegroundPrompt.FOUR_ZERO_ONE);
    }

    @GetMapping(value = "/403")
    public R<String> errorPage403() { return R.failed(PageConstants.ForegroundPrompt.FOUR_ZERO_THREE); }

    @GetMapping(value = "/404")
    public R<String> errorPage404() { return R.failed(PageConstants.ForegroundPrompt.FOUR_ZERO_FOUR); }

    @GetMapping(value = "/500")
    public R<String> errorPage500() { return R.failed(PageConstants.ForegroundPrompt.FIVE_HUNDRED); }
}
