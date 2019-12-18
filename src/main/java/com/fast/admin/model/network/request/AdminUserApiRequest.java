package com.fast.admin.model.network.request;

import com.fast.admin.model.enumClass.AdminUserRole;
import com.fast.admin.model.enumClass.AdminUserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminUserApiRequest {

    private Long id;

    private String account;

    private String password;

    private AdminUserStatus status;

    private AdminUserRole role;

    private LocalDateTime lastLoginAt;

    private LocalDateTime passwordUpdatedAt;

    private int loginFailCount;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;
}
