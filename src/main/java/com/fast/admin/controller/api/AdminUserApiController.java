package com.fast.admin.controller.api;

import com.fast.admin.inter.CrudInterface;
import com.fast.admin.model.network.Header;
import com.fast.admin.model.network.request.AdminUserApiRequest;
import com.fast.admin.model.network.response.AdminUserApiResponse;
import com.fast.admin.service.AdminUserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/adminUser")
public class AdminUserApiController implements CrudInterface<AdminUserApiRequest, AdminUserApiResponse> {

    @Autowired
    private AdminUserApiLogicService adminUserApiLogicService;

    /**
     * Admin User Create
     * @param request Admin User Info
     * @return New Admin User Info
     */
    @Override
    @PostMapping("")
    public Header<AdminUserApiResponse> create(@RequestBody Header<AdminUserApiRequest> request) {
        log.info("Create : {}", request);
        return adminUserApiLogicService.create(request);
    }

    /**
     * Admin User Read
     * @param id Admin User Id
     * @return Admin User Info
     */
    @Override
    @GetMapping("{id}")
    public Header<AdminUserApiResponse> read(@PathVariable Long id) {
        log.info("Read : {}", id);
        return adminUserApiLogicService.read(id);
    }

    /**
     * Admin User Update
     * @param request Admin User Info
     * @return Admin User Info
     */
    @Override
    @PutMapping("")
    public Header<AdminUserApiResponse> update(@RequestBody Header<AdminUserApiRequest> request) {
        log.info("Update : {}", request);
        return adminUserApiLogicService.update(request);
    }

    /**
     * Admin User Delete
     * @param id Admin User Id
     * @return Header
     */
    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        log.info("Delete : {}", id);
        return adminUserApiLogicService.delete(id);
    }
}
