package com.fast.admin.controller.api;

import com.fast.admin.inter.CrudInterface;
import com.fast.admin.model.network.Header;
import com.fast.admin.model.network.request.ItemApiRequest;
import com.fast.admin.model.network.response.ItemApiResponse;
import com.fast.admin.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    /**
     * Item Create
     * @param request Item Info
     * @return New Item Info
     */
    @Override
    @PostMapping("")
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
        log.info("Create : {}", request);
        return itemApiLogicService.create(request);
    }

    /**
     * Item Read
     * @param id Item Id
     * @return Item Info
     */
    @Override
    @GetMapping("{id}")
    public Header<ItemApiResponse> read(@PathVariable Long id) {
        log.info("Read : {}", id);
        return itemApiLogicService.read(id);
    }

    /**
     * Item Update
     * @param request Item Info
     * @return Item Info
     */
    @Override
    @PutMapping("")
    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
        log.info("Update : {}", request);
        return itemApiLogicService.update(request);
    }

    /**
     * Item Delete
     * @param id Item Id
     * @return Header
     */
    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        log.info("Delete : {}", id);
        return itemApiLogicService.delete(id);
    }
}
