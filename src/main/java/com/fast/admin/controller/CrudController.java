package com.fast.admin.controller;

import com.fast.admin.inter.CrudInterface;
import com.fast.admin.model.network.Header;
import com.fast.admin.service.BaseService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Component
public abstract class CrudController<Req, Res, Entity> implements CrudInterface<Req, Res> {

    protected BaseService<Req, Res, Entity> baseService;

    @Autowired
    public void setBaseService (BaseService<Req, Res, Entity> baseService) {
        this.baseService = baseService;
    }

    /**
     * Base Create
     * @param request Entity Info
     * @return New Entity
     */
    @Override
    @PostMapping("")
    @ApiOperation(value = "생성 API")
    public Header<Res> create(@RequestBody Header<Req> request) {
        log.info("Create : {}", request);
        return baseService.create(request);
    }

    /**
     * Base Read
     * @param id Entity Id
     * @return Read Entity
     */
    @Override
    @GetMapping("{id}")
    @ApiOperation(value = "조회 API")
    public Header<Res> read(@PathVariable Long id) {
        log.info("Read : {}", id);
        return baseService.read(id);
    }

    /**
     * Base Update
     * @param request Entity Info
     * @return Update Entity
     */
    @Override
    @PutMapping("")
    @ApiOperation(value = "수정 API")
    public Header<Res> update(@RequestBody Header<Req> request) {
        log.info("Update : {}", request);
        return baseService.update(request);
    }

    /**
     * Base Delete
     * @param id Entity Id
     * @return Header
     */
    @Override
    @DeleteMapping("{id}")
    @ApiOperation(value = "삭제 API")
    public Header delete(@PathVariable Long id) {
        log.info("Delete : {}", id);
        return baseService.delete(id);
    }

    /**
     * Base Search
     * @param pageable Page Info
     * @return Search Info
     */
    @Override
    @GetMapping("")
    @ApiOperation(value = "검색 API")
    public Header<List<Res>> search(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 20) Pageable pageable) {
        log.info("Search : {}", pageable);
        return baseService.search(pageable);
    }
}
