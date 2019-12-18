package com.fast.admin.controller.api;

import com.fast.admin.inter.CrudInterface;
import com.fast.admin.model.network.Header;
import com.fast.admin.model.network.request.OrderDetailApiRequest;
import com.fast.admin.model.network.response.OrderDetailApiResponse;
import com.fast.admin.service.OrderDetailApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailApiController implements CrudInterface<OrderDetailApiRequest, OrderDetailApiResponse> {

    @Autowired
    private OrderDetailApiLogicService orderDetailApiLogicService;

    /**
     * Order Detail Create
     * @param request Order Detail Info
     * @return New Order Detail Info
     */
    @Override
    @PostMapping("")
    public Header<OrderDetailApiResponse> create(@RequestBody Header<OrderDetailApiRequest> request) {
        log.info("Create : {}", request);
        return orderDetailApiLogicService.create(request);
    }

    /**
     * Order Detail Read
     * @param id Order Detail Id
     * @return Order Detail Info
     */
    @Override
    @GetMapping("{id}")
    public Header<OrderDetailApiResponse> read(@PathVariable Long id) {
        log.info("Read : {}", id);
        return orderDetailApiLogicService.read(id);
    }

    /**
     * Order Detail Update
     * @param request Order Detail Info
     * @return Order Detail Info
     */
    @Override
    @PutMapping("")
    public Header<OrderDetailApiResponse> update(@RequestBody Header<OrderDetailApiRequest> request) {
        log.info("Update : {}", request);
        return orderDetailApiLogicService.update(request);
    }

    /**
     * Order Detail Delete
     * @param id Order Detail Id
     * @return Header
     */
    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        log.info("Delete : {}", id);
        return orderDetailApiLogicService.delete(id);
    }
}
