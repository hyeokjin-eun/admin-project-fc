package com.fast.admin.service.impl;

import com.fast.admin.model.entity.Category;
import com.fast.admin.model.network.Header;
import com.fast.admin.model.network.request.CategoryApiRequest;
import com.fast.admin.model.network.response.CategoryApiResponse;
import com.fast.admin.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryApiLogicService extends BaseService<CategoryApiRequest, CategoryApiResponse, Category> {

    /**
     * Category Create
     *
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
        return Header.OK(response(newCategory));
    }

    /**
     * Category Read
     *
     * @param id Category Id
     * @return Category Info
     */
    @Override
    public Header<CategoryApiResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(this::response)
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Category Update
     *
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
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Category Delete
     *
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
     * Category Search
     *
     * @param pageable Page Info
     * @return Category List
     */
    @Override
    public Header<List<CategoryApiResponse>> search(Pageable pageable) {
        Page<Category> categories = baseRepository.findAll(pageable);
        List<CategoryApiResponse> categoryApiResponseList = categories.stream()
                .map(this::response)
                .collect(Collectors.toList());

        return Header.OK(categoryApiResponseList);
    }

    /**
     * Category Api Response Create
     *
     * @param category Category Info
     * @return Category Api Response
     */
    private CategoryApiResponse response(Category category) {
        return CategoryApiResponse.builder()
                .id(category.getId())
                .type(category.getType())
                .title(category.getTitle())
                .build();
    }
}
