package com.fast.admin.service.impl;

import com.fast.admin.model.entity.Category;
import com.fast.admin.model.network.Header;
import com.fast.admin.model.network.request.CategoryApiRequest;
import com.fast.admin.model.network.response.CategoryApiResponse;
import com.fast.admin.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CategoryApiLogicService extends BaseService<CategoryApiRequest, CategoryApiResponse, Category> {

    /**
     * Category Create
     * @param request Category Info
     * @return New Category Info
     */
    @Override
    public Header<CategoryApiResponse> create(Header<CategoryApiRequest> request) {
        CategoryApiRequest categoryApiRequest = request.getData();

        Category category = Category.builder()
                .id(categoryApiRequest.getId())
                .type(categoryApiRequest.getType())
                .title(categoryApiRequest.getTitle())
                .build();

        Category newCategory = baseRepository.save(category);
        return response(newCategory);
    }

    /**
     * Category Read
     * @param id Category Id
     * @return Category Info
     */
    @Override
    public Header<CategoryApiResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(this::response)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Category Update
     * @param request Category Info
     * @return Category Info
     */
    @Override
    public Header<CategoryApiResponse> update(Header<CategoryApiRequest> request) {
        CategoryApiRequest categoryApiRequest = request.getData();

        return baseRepository.findById(categoryApiRequest.getId())
                .map(category -> {
                    category
                            .setType(category.getType())
                            .setTitle(category.getTitle());

                    return category;
                })
                .map(category -> baseRepository.save(category))
                .map(this::response)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Category Delete
     * @param id Category Id
     * @return Header
     */
    @Override
    public Header delete(Long id) {
        return baseRepository.findById(id)
                .map(category -> {
                    baseRepository.delete(category);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Header <Category Api Response> Create
     * @param category Category Info
     * @return Header <Category Api Response>
     */
    private Header<CategoryApiResponse> response(Category category) {
        CategoryApiResponse categoryApiResponse = CategoryApiResponse.builder()
                .id(category.getId())
                .type(category.getType())
                .title(category.getTitle())
                .build();

        return Header.OK(categoryApiResponse);
    }
}
