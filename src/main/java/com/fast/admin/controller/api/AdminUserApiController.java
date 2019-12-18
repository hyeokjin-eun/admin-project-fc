package com.fast.admin.controller.api;

import com.fast.admin.controller.CrudController;
import com.fast.admin.model.entity.AdminUser;
import com.fast.admin.model.network.request.AdminUserApiRequest;
import com.fast.admin.model.network.response.AdminUserApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/adminUser")
public class AdminUserApiController extends CrudController<AdminUserApiRequest, AdminUserApiResponse, AdminUser> {
}
