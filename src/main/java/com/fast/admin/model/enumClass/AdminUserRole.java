package com.fast.admin.model.enumClass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AdminUserRole {

    SUPER_MANAGER(100, "슈퍼 관리자", "ADMIN 슈퍼 관리자"),
    MANAGER(200, "관리자", "ADMIN 관리자");

    private Integer id;

    private String title;

    private String description;
}
