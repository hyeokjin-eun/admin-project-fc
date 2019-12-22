package com.fast.admin.controller.api;

import com.fast.admin.controller.CrudController;
import com.fast.admin.model.entity.Item;
import com.fast.admin.model.network.request.ItemApiRequest;
import com.fast.admin.model.network.response.ItemApiResponse;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/item")
@Api(description = "상품 API")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {
}
