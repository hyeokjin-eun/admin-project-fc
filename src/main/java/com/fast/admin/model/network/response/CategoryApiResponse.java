package com.fast.admin.model.network.response;

import com.fast.admin.model.enumClass.CategoryType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "CategoryApiResponse", description = "카테고리 응답 모델")
public class CategoryApiResponse {

    @ApiModelProperty(value = "카테고리 식별자")
    private Long id;

    @ApiModelProperty(value = "카테고리 유형")
    private CategoryType type;

    @ApiModelProperty(value = "카테고리 제목")
    private String title;
}
