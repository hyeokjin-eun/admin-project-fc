package com.fast.admin.controller;

import com.fast.admin.inter.CrudInterface;
import com.fast.admin.model.network.Header;
import com.fast.admin.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Component
public abstract class CrudController<Req, Res, Entity> implements CrudInterface<Req, Res> {

    @Autowired(required = false)
    protected BaseService<Req, Res, Entity> baseService;

    /**
     * Base Create
     * @param request Entity Info
     * @return New Entity
     */
    @Override
    @PostMapping("")
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
    public Header delete(@PathVariable Long id) {
        log.info("Delete : {}", id);
        return baseService.delete(id);
    }
}
