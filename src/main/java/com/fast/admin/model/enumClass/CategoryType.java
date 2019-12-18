package com.fast.admin.model.enumClass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryType {

    COMPUTER(0, "컴퓨터", "카테고리 타입 컴퓨터");

    private Integer id;

    private String title;

    private String description;
}
