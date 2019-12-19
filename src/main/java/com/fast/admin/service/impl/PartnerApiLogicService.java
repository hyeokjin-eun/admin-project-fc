package com.fast.admin.service.impl;

import com.fast.admin.model.entity.Partner;
import com.fast.admin.model.network.Header;
import com.fast.admin.model.network.request.PartnerApiRequest;
import com.fast.admin.model.network.response.PartnerApiResponse;
import com.fast.admin.repository.CategoryRepository;
import com.fast.admin.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerApiLogicService extends BaseService<PartnerApiRequest, PartnerApiResponse, Partner> {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Partner Create
     * @param request Partner Info
     * @return New Partner Info
     */
    @Override
    public Header<PartnerApiResponse> create(Header<PartnerApiRequest> request) {
        PartnerApiRequest partnerApiRequest = request.getData();

        Partner partner = Partner.builder()
                .name(partnerApiRequest.getName())
                .status(partnerApiRequest.getStatus())
                .address(partnerApiRequest.getAddress())
                .callCenter(partnerApiRequest.getCallCenter())
                .partnerNumber(partnerApiRequest.getPartnerNumber())
                .businessNumber(partnerApiRequest.getBusinessNumber())
                .ceoName(partnerApiRequest.getCeoName())
                .registeredAt(partnerApiRequest.getRegisteredAt())
                .unregisteredAt(partnerApiRequest.getUnregisteredAt())
                .category(categoryRepository.getOne(partnerApiRequest.getCategoryId()))
                .build();

        Partner newPartner = baseRepository.save(partner);

        return response(newPartner);
    }

    /**
     * Partner Read
     * @param id Partner Id
     * @return Partner Info
     */
    @Override
    public Header<PartnerApiResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(this::response)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Partner Update
     * @param request Partner Info
     * @return Partner Info
     */
    @Override
    public Header<PartnerApiResponse> update(Header<PartnerApiRequest> request) {
        PartnerApiRequest partnerApiRequest = request.getData();

        return baseRepository.findById(partnerApiRequest.getId())
                .map(partner -> {
                    partner
                            .setName(partnerApiRequest.getName())
                            .setStatus(partnerApiRequest.getStatus())
                            .setAddress(partnerApiRequest.getAddress())
                            .setCallCenter(partnerApiRequest.getCallCenter())
                            .setPartnerNumber(partnerApiRequest.getPartnerNumber())
                            .setBusinessNumber(partnerApiRequest.getBusinessNumber())
                            .setCeoName(partnerApiRequest.getCeoName())
                            .setRegisteredAt(partnerApiRequest.getRegisteredAt())
                            .setUnregisteredAt(partnerApiRequest.getUnregisteredAt());

                    return partner;
                })
                .map(partner -> baseRepository.save(partner))
                .map(this::response)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Partner Delete
     * @param id Partner Id
     * @return Header
     */
    @Override
    public Header delete(Long id) {
        return baseRepository.findById(id)
                .map(partner -> {
                    baseRepository.delete(partner);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Header <Partner Api Response> Create
     * @param partner Partner Info
     * @return Header <Partner Api Response>
     */
    public Header<PartnerApiResponse> response(Partner partner) {
        PartnerApiResponse partnerApiResponse = PartnerApiResponse.builder()
                .id(partner.getId())
                .name(partner.getName())
                .status(partner.getStatus())
                .address(partner.getAddress())
                .callCenter(partner.getCallCenter())
                .partnerNumber(partner.getPartnerNumber())
                .businessNumber(partner.getBusinessNumber())
                .ceoName(partner.getCeoName())
                .registeredAt(partner.getRegisteredAt())
                .unregisteredAt(partner.getUnregisteredAt())
                .categoryId(partner.getCategory().getId())
                .build();

        return Header.OK(partnerApiResponse);
    }
}
