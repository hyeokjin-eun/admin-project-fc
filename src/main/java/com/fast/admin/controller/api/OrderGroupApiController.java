package com.fast.admin.controller.api;

import com.fast.admin.inter.CrudInterface;
import com.fast.admin.model.network.Header;
import com.fast.admin.model.network.request.OrderGroupApiRequest;
import com.fast.admin.model.network.response.OrderGroupApiResponse;
import com.fast.admin.service.OrderGroupApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    /**
     * Order Group Create
     * @param request Order Group Info
     * @return New Order Group Info
     */
    @Override
    @PostMapping("")
    public Header<OrderGroupApiResponse> create(@RequestBody Header<OrderGroupApiRequest> request) {
        log.info("Create : {}", request);
        return orderGroupApiLogicService.create(request);
    }

    /**
     * Order Group Read
     * @param id Order Group Id
     * @return Order Group Info
     */
    @Override
    @GetMapping("{id}")
    public Header<OrderGroupApiResponse> read(@PathVariable Long id) {
        log.info("Read : {}", id);
        return orderGroupApiLogicService.read(id);
    }

    /**
     * Order Group Update
     * @param request Order Group Info
     * @return Order Group Info
     */
    @Override
    @PutMapping("")
    public Header<OrderGroupApiResponse> update(@RequestBody Header<OrderGroupApiRequest> request) {
        log.info("Update : {}", request);
        return orderGroupApiLogicService.update(request);
    }

    /**
     * Order Group Delete
     * @param id Order Group Id
     * @return Header
     */
    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        log.info("Delete : {}", id);
        return orderGroupApiLogicService.delete(id);
    }
}
