package com.fast.admin.controller.api;

import com.fast.admin.inter.CrudInterface;
import com.fast.admin.model.network.Header;
import com.fast.admin.model.network.request.PartnerApiRequest;
import com.fast.admin.model.network.response.PartnerApiResponse;
import com.fast.admin.service.PartnerApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/partner")
public class PartnerApiController implements CrudInterface<PartnerApiRequest, PartnerApiResponse> {

    @Autowired
    private PartnerApiLogicService partnerApiLogicService;

    /**
     * Partner Create
     * @param request Partner Info
     * @return New Partner Info
     */
    @Override
    @PostMapping("")
    public Header<PartnerApiResponse> create(@RequestBody Header<PartnerApiRequest> request) {
        log.info("Create : {}", request);
        return partnerApiLogicService.create(request);
    }

    /**
     * Partner Read
     * @param id Partner Id
     * @return Partner Info
     */
    @Override
    @GetMapping("{id}")
    public Header<PartnerApiResponse> read(@PathVariable Long id) {
        log.info("Read : {}", id);
        return partnerApiLogicService.read(id);
    }

    /**
     * Partner Update
     * @param request Partner Info
     * @return Partner Info
     */
    @Override
    @PutMapping("")
    public Header<PartnerApiResponse> update(@RequestBody Header<PartnerApiRequest> request) {
        log.info("Update : {}", request);
        return partnerApiLogicService.update(request);
    }

    /**
     * Partner Delete
     * @param id Partner Id
     * @return Header
     */
    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        log.info("Delete : {}", id);
        return partnerApiLogicService.delete(id);
    }
}
