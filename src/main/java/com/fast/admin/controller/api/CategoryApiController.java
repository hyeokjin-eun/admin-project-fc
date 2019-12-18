package com.fast.admin.controller.api;

import com.fast.admin.controller.CrudController;
import com.fast.admin.model.entity.Category;
import com.fast.admin.model.network.request.CategoryApiRequest;
import com.fast.admin.model.network.response.CategoryApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/category")
public class CategoryApiController extends CrudController<CategoryApiRequest, CategoryApiResponse, Category> {
}
