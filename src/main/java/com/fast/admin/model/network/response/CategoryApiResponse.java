package com.fast.admin.model.network.response;

import com.fast.admin.model.enumClass.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryApiResponse {

    private Long id;

    private CategoryType type;

    private String title;
}
