package com.fast.admin.service.impl;

import com.fast.admin.model.entity.Partner;
import com.fast.admin.model.network.Header;
import com.fast.admin.model.network.request.PartnerApiRequest;
import com.fast.admin.model.network.response.PartnerApiResponse;
import com.fast.admin.repository.CategoryRepository;
import com.fast.admin.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnerApiLogicService extends BaseService<PartnerApiRequest, PartnerApiResponse, Partner> {

    private final CategoryRepository categoryRepository;

    @Autowired
    public PartnerApiLogicService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

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

        return Header.OK(response(newPartner));
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
                .map(Header::OK)
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
                .map(Header::OK)
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
     * Partner Search
     * @param pageable Page Info
     * @return Partner List
     */
    @Override
    public Header<List<PartnerApiResponse>> search(Pageable pageable) {
        Page<Partner> partners = baseRepository.findAll(pageable);
        List<PartnerApiResponse> partnerApiResponseList = partners.stream()
                .map(this::response)
                .collect(Collectors.toList());
        return Header.OK(partnerApiResponseList);
    }

    /**
     * Partner Api Response Create
     * @param partner Partner Info
     * @return Partner Api Response
     */
    public PartnerApiResponse response(Partner partner) {
        return PartnerApiResponse.builder()
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
    }
}
