package com.fast.admin.controller.api;

import com.fast.admin.controller.CrudController;
import com.fast.admin.model.entity.User;
import com.fast.admin.model.network.request.UserApiRequest;
import com.fast.admin.model.network.response.UserApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, User> {
}
