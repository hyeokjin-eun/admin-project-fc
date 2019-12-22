package com.fast.admin.model.network.response;

import com.fast.admin.model.enumClass.AdminUserRole;
import com.fast.admin.model.enumClass.AdminUserStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "AdminUserApiResponse", description = "어드민 유저 응답 모델")
public class AdminUserApiResponse {

    @ApiModelProperty(value = "어드민 유저 식별자")
    private Long id;

    @ApiModelProperty(value = "어드민 유저 계정")
    private String account;

    @ApiModelProperty(value = "어드민 유저 비밀번호")
    private String password;

    @ApiModelProperty(value = "어드민 유저 상태")
    private AdminUserStatus status;

    @ApiModelProperty(value = "어드민 유저 권한")
    private AdminUserRole role;

    @ApiModelProperty(value = "마지막 로그인 일자")
    private LocalDateTime lastLoginAt;

    @ApiModelProperty(value = "비밀번호 수정 일자")
    private LocalDateTime passwordUpdatedAt;

    @ApiModelProperty(value = "로그인 실패 수")
    private int loginFailCount;

    @ApiModelProperty(value = "등록 일자")
    private LocalDateTime registeredAt;

    @ApiModelProperty(value = "해지 일자")
    private LocalDateTime unregisteredAt;
}
