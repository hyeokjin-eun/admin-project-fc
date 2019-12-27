package com.fast.admin.service.impl;

import com.fast.admin.model.entity.OrderGroup;
import com.fast.admin.model.network.Header;
import com.fast.admin.model.network.request.OrderGroupApiRequest;
import com.fast.admin.model.network.response.OrderGroupApiResponse;
import com.fast.admin.repository.UserRepository;
import com.fast.admin.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderGroupApiLogicService extends BaseService<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

    private final UserRepository userRepository;

    @Autowired
    public OrderGroupApiLogicService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Order Group Create
     * @param request Order Group Info
     * @return New Order Group Info
     */
    @Override
    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {
        OrderGroupApiRequest orderGroupApiRequest = request.getData();

        OrderGroup orderGroup = OrderGroup.builder()
                .status(orderGroupApiRequest.getStatus())
                .orderType(orderGroupApiRequest.getOrderType())
                .revAddress(orderGroupApiRequest.getRevAddress())
                .revName(orderGroupApiRequest.getRevName())
                .paymentType(orderGroupApiRequest.getPaymentType())
                .totalPrice(orderGroupApiRequest.getTotalPrice())
                .totalQuantity(orderGroupApiRequest.getTotalQuantity())
                .orderAt(orderGroupApiRequest.getOrderAt())
                .arrivalDate(orderGroupApiRequest.getArrivalDate())
                .user(userRepository.getOne(orderGroupApiRequest.getUserId()))
                .build();

        OrderGroup newOrderGroup = baseRepository.save(orderGroup);

        return Header.OK(response(newOrderGroup));
    }

    /**
     * Order Group Read
     * @param id Order Group Id
     * @return Order Group Info
     */
    @Override
    public Header<OrderGroupApiResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(this::response)
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Order Group Update
     * @param request Order Group Info
     * @return Order Group Info
     */
    @Override
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {
        OrderGroupApiRequest orderGroupApiRequest = request.getData();

        return baseRepository.findById(orderGroupApiRequest.getId())
                .map(orderGroup -> {
                    orderGroup
                            .setStatus(orderGroupApiRequest.getStatus())
                            .setOrderType(orderGroupApiRequest.getOrderType())
                            .setRevAddress(orderGroupApiRequest.getRevAddress())
                            .setRevName(orderGroupApiRequest.getRevName())
                            .setPaymentType(orderGroupApiRequest.getPaymentType())
                            .setTotalPrice(orderGroupApiRequest.getTotalPrice())
                            .setTotalQuantity(orderGroupApiRequest.getTotalQuantity())
                            .setOrderAt(orderGroupApiRequest.getOrderAt())
                            .setArrivalDate(orderGroupApiRequest.getArrivalDate());

                    return orderGroup;
                })
                .map(orderGroup -> baseRepository.save(orderGroup))
                .map(this::response)
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Order Group Delete
     * @param id Order Group Id
     * @return Header
     */
    @Override
    public Header delete(Long id) {
        return baseRepository.findById(id)
                .map(orderGroup -> {
                    baseRepository.delete(orderGroup);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터없음"));
    }

    /**
     * Order Group Search
     * @param pageable Page Info
     * @return Order Group List
     */
    @Override
    public Header<List<OrderGroupApiResponse>> search(Pageable pageable) {
        Page<OrderGroup> orderGroups = baseRepository.findAll(pageable);
        List<OrderGroupApiResponse> orderGroupApiResponseList = orderGroups.stream()
                .map(this::response)
                .collect(Collectors.toList());

        return Header.OK(orderGroupApiResponseList);
    }

    /**
     * Order Group Api Response Create
     *
     * @param orderGroup Order Group Info
     * @return Order Group Api Response
     */
    public OrderGroupApiResponse response(OrderGroup orderGroup) {
        return OrderGroupApiResponse.builder()
                .id(orderGroup.getId())
                .status(orderGroup.getStatus())
                .orderType(orderGroup.getOrderType())
                .revAddress(orderGroup.getRevAddress())
                .revName(orderGroup.getRevName())
                .paymentType(orderGroup.getPaymentType())
                .totalPrice(orderGroup.getTotalPrice())
                .totalQuantity(orderGroup.getTotalQuantity())
                .orderAt(orderGroup.getOrderAt())
                .arrivalDate(orderGroup.getArrivalDate())
                .userId(orderGroup.getUser().getId())
                .build();
    }
}
