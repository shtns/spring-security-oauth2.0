package com.sh.api.organization.user.dto.save;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.sh.api.common.constant.UserInfoErrorConstants;
import com.sh.api.organization.user.entity.UserInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 用户保存dto
 *
 *
 * @author 盛浩
 * @date 2021/1/16 2:27
 */
@Getter
@Setter
@ApiModel(value = "UserSaveDto", description = "用户保存dto")
public class UserSaveDto {

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id", required = true)
    @NotNull(message = UserInfoErrorConstants.ForegroundPrompt.ROLE_ID_CANNOT_BE_EMPTY)
    private Long roleId;

    /**
     * 登入账号
     */
    @ApiModelProperty(value = "登入账号", required = true)
    @NotBlank(message = UserInfoErrorConstants.ForegroundPrompt.LOGIN_ACCOUNT_CANNOT_BE_EMPTY)
    private String loginAccount;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true)
    @NotBlank(message = UserInfoErrorConstants.ForegroundPrompt.PASSWORD_CANNOT_BE_EMPTY)
    private String password;

    /**
     * 名称中文
     */
    @ApiModelProperty(value = "名称中文")
    private String nameCn;

    /**
     * 名称英文
     */
    @ApiModelProperty(value = "名称英文")
    private String nameEn;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private String mobile;

    /**
     * 住址
     */
    @ApiModelProperty(value = "住址")
    private String address;

    /**
     * dto转entity
     *
     * @return 用户信息
     */
    public UserInfo changeSaveUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setRoleId(this.roleId);
        userInfo.setLoginAccount(this.loginAccount);
        userInfo.setPassword(this.password);
        userInfo.setStatus(StringPool.ZERO);
        userInfo.setNameCn(this.nameCn);
        userInfo.setNameEn(this.nameEn);
        userInfo.setMobile(this.mobile);
        userInfo.setAddress(this.address);
        return userInfo;
    }
}
