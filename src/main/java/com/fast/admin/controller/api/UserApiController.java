package com.fast.admin.controller.api;

import com.fast.admin.inter.CrudInterface;
import com.fast.admin.model.network.Header;
import com.fast.admin.model.network.request.UserApiRequest;
import com.fast.admin.model.network.response.UserApiResponse;
import com.fast.admin.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    /**
     * User Create
     * @param request User Info
     * @return New User Info
     */
    @Override
    @PostMapping("")
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("Create : {}", request);
        return userApiLogicService.create(request);
    }

    /**
     * User Read
     * @param id User Id
     * @return User Info
     */
    @Override
    @GetMapping("{id}")
    public Header<UserApiResponse> read(@PathVariable("id") Long id) {
        log.info("Read : {}", id);
        return userApiLogicService.read(id);
    }

    /**
     * User Update
     * @param request User Info
     * @return User Info
     */
    @Override
    @PutMapping("")
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        log.info("Update : {}", request);
        return userApiLogicService.update(request);
    }

    /**
     * User Delete
     * @param id User Id
     * @return Header
     */
    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable("id") Long id) {
        log.info("Delete : {}", id);
        return userApiLogicService.delete(id);
    }
}
