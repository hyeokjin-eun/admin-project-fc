package com.fast.admin.service.impl;

import com.fast.admin.model.entity.Item;
import com.fast.admin.model.network.Header;
import com.fast.admin.model.network.request.ItemApiRequest;
import com.fast.admin.model.network.response.ItemApiResponse;
import com.fast.admin.repository.PartnerRepository;
import com.fast.admin.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemApiLogicService extends BaseService<ItemApiRequest, ItemApiResponse, Item> {

    @Autowired
    private PartnerRepository partnerRepository;

    /**
     * Item Create
     *
     * @param request Item Info
     * @return New Item Info
     */
    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {
        ItemApiRequest itemApiRequest = request.getData();

        Item item = Item.builder()
                .status(itemApiRequest.getStatus())
                .name(itemApiRequest.getName())
                .title(itemApiRequest.getTitle())
                .content(itemApiRequest.getContent())
                .price(itemApiRequest.getPrice())
                .brandName(itemApiRequest.getBrandName())
                .registeredAt(LocalDateTime.now())
                .partner(partnerRepository.getOne(itemApiRequest.getPartnerId()))
                .build();

        Item newItem = baseRepository.save(item);

        return Header.OK(response(newItem));
    }

    /**
     * Item Read
     *
     * @param id Item Id
     * @return Item Info
     */
    @Override
    public Header<ItemApiResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(this::response)
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Item Update
     *
     * @param request Item Info
     * @return Item Info
     */
    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
        ItemApiRequest itemApiRequest = request.getData();

        return baseRepository.findById(itemApiRequest.getId())
                .map(entityItem -> {
                    entityItem
                            .setStatus(itemApiRequest.getStatus())
                            .setName(itemApiRequest.getName())
                            .setTitle(itemApiRequest.getTitle())
                            .setContent(itemApiRequest.getContent())
                            .setPrice(itemApiRequest.getPrice())
                            .setBrandName(itemApiRequest.getBrandName())
                            .setRegisteredAt(itemApiRequest.getRegisteredAt())
                            .setUnregisteredAt(itemApiRequest.getUnregisteredAt());

                    return entityItem;
                })
                .map(newEntityItem -> baseRepository.save(newEntityItem))
                .map(this::response)
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Item Delete
     *
     * @param id Item Id
     * @return Header
     */
    @Override
    public Header delete(Long id) {
        return baseRepository.findById(id)
                .map(item -> {
                    baseRepository.delete(item);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Item Search
     *
     * @param pageable Page Info
     * @return Item List
     */
    @Override
    public Header<List<ItemApiResponse>> search(Pageable pageable) {
        Page<Item> items = baseRepository.findAll(pageable);
        List<ItemApiResponse> itemApiResponseList = items.stream()
                .map(this::response)
                .collect(Collectors.toList());

        return Header.OK(itemApiResponseList);
    }

    /**
     * Item Api Response Create
     *
     * @param item Item Info
     * @return Item Api Response
     */
    public ItemApiResponse response(Item item) {
        return ItemApiResponse.builder()
                .id(item.getId())
                .status(item.getStatus())
                .name(item.getName())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .brandName(item.getBrandName())
                .registeredAt(item.getRegisteredAt())
                .unregisteredAt(item.getUnregisteredAt())
                .partnerId(item.getPartner().getId())
                .build();
    }
}
