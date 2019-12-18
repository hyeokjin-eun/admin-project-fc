package com.fast.admin.controller.api;

import com.fast.admin.controller.CrudController;
import com.fast.admin.model.entity.OrderGroup;
import com.fast.admin.model.network.request.OrderGroupApiRequest;
import com.fast.admin.model.network.response.OrderGroupApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {
}
