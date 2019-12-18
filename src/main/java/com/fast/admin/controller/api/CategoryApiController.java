package com.fast.admin.controller.api;

import com.fast.admin.inter.CrudInterface;
import com.fast.admin.model.network.Header;
import com.fast.admin.model.network.request.CategoryApiRequest;
import com.fast.admin.model.network.response.CategoryApiResponse;
import com.fast.admin.service.CategoryApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/category")
public class CategoryApiController implements CrudInterface<CategoryApiRequest, CategoryApiResponse> {

    @Autowired
    private CategoryApiLogicService categoryApiLogicService;

    /**
     * Category Create
     * @param request Category Info
     * @return New Category Info
     */
    @Override
    @PostMapping("")
    public Header<CategoryApiResponse> create(@RequestBody Header<CategoryApiRequest> request) {
        log.info("Create : {}", request);
        return categoryApiLogicService.create(request);
    }

    /**
     * Category Read
     * @param id Category Id
     * @return Category Info
     */
    @Override
    @GetMapping("{id}")
    public Header<CategoryApiResponse> read(@PathVariable Long id) {
        log.info("Read : {}", id);
        return categoryApiLogicService.read(id);
    }

    /**
     * Category Update
     * @param request Category Info
     * @return Category Info
     */
    @Override
    @PutMapping("")
    public Header<CategoryApiResponse> update(@RequestBody Header<CategoryApiRequest> request) {
        log.info("Update : {}", request);
        return categoryApiLogicService.update(request);
    }

    /**
     * Category Delete
     * @param id Category Id
     * @return Header
     */
    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        log.info("Delete : {}", id);
        return categoryApiLogicService.delete(id);
    }
}
