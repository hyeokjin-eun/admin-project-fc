package com.fast.admin.model.network.request;

import com.fast.admin.model.enumClass.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryApiRequest {

    private Long id;

    private CategoryType type;

    private String title;
}
