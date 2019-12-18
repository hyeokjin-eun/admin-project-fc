package com.fast.admin.service;

import com.fast.admin.model.entity.OrderDetail;
import com.fast.admin.model.network.Header;
import com.fast.admin.model.network.request.OrderDetailApiRequest;
import com.fast.admin.model.network.response.OrderDetailApiResponse;
import com.fast.admin.repository.ItemRepository;
import com.fast.admin.repository.OrderGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailApiLogicService extends BaseService<OrderDetailApiRequest, OrderDetailApiResponse, OrderDetail> {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Autowired
    private ItemRepository itemRepository;

    /**
     * Order Detail Create
     * @param request Order Detail Info
     * @return New Order Detail Info
     */
    @Override
    public Header<OrderDetailApiResponse> create(Header<OrderDetailApiRequest> request) {
        OrderDetailApiRequest orderDetailApiRequest = request.getData();
        OrderDetail orderDetail = OrderDetail.builder()
                .id(orderDetailApiRequest.getId())
                .status(orderDetailApiRequest.getStatus())
                .arrivalDate(orderDetailApiRequest.getArrivalDate())
                .quantity(orderDetailApiRequest.getQuantity())
                .totalPrice(orderDetailApiRequest.getTotalPrice())
                .orderGroup(orderGroupRepository.getOne(orderDetailApiRequest.getOrderGroupId()))
                .item(itemRepository.getOne(orderDetailApiRequest.getItemId()))
                .build();

        OrderDetail newOrderDetail = baseRepository.save(orderDetail);
        return response(newOrderDetail);
    }

    /**
     * Order Detail Read
     * @param id Order Detail Id
     * @return Order Detail Info
     */
    @Override
    public Header<OrderDetailApiResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(this::response)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Order Detail Update
     * @param request Order Detail Info
     * @return Order Detail Info
     */
    @Override
    public Header<OrderDetailApiResponse> update(Header<OrderDetailApiRequest> request) {
        OrderDetailApiRequest orderDetailApiRequest = request.getData();
        return baseRepository.findById(orderDetailApiRequest.getId())
                .map(orderDetail -> {
                    orderDetail
                            .setStatus(orderDetailApiRequest.getStatus())
                            .setArrivalDate(orderDetailApiRequest.getArrivalDate())
                            .setQuantity(orderDetailApiRequest.getQuantity())
                            .setTotalPrice(orderDetailApiRequest.getTotalPrice());

                    return orderDetail;
                })
                .map(orderDetail -> baseRepository.save(orderDetail))
                .map(this::response)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Order Detail Delete
     * @param id Order Detail Id
     * @return Header
     */
    @Override
    public Header delete(Long id) {
        return baseRepository.findById(id)
                .map(orderDetail -> {
                    baseRepository.delete(orderDetail);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Header <Order Detail Api Response> Create
     * @param orderDetail Order Detail Info
     * @return Header <Order Detail Api Response>
     */
    private Header<OrderDetailApiResponse> response(OrderDetail orderDetail) {
        OrderDetailApiResponse orderDetailApiResponse = OrderDetailApiResponse.builder()
                .id(orderDetail.getId())
                .status(orderDetail.getStatus())
                .arrivalDate(orderDetail.getArrivalDate())
                .quantity(orderDetail.getQuantity())
                .totalPrice(orderDetail.getTotalPrice())
                .orderGroupId(orderDetail.getOrderGroup().getId())
                .itemId(orderDetail.getItem().getId())
                .build();

        return Header.OK(orderDetailApiResponse);
    }
}
