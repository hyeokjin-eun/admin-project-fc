package com.fast.admin.service.impl;

import com.fast.admin.model.entity.OrderDetail;
import com.fast.admin.model.entity.OrderGroup;
import com.fast.admin.model.entity.User;
import com.fast.admin.model.enumClass.UserStatus;
import com.fast.admin.model.network.Header;
import com.fast.admin.model.network.request.UserApiRequest;
import com.fast.admin.model.network.response.ItemApiResponse;
import com.fast.admin.model.network.response.OrderGroupApiResponse;
import com.fast.admin.model.network.response.UserApiResponse;
import com.fast.admin.model.network.response.UserOrderInfoApiResponse;
import com.fast.admin.repository.UserRepository;
import com.fast.admin.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserApiLogicService extends BaseService<UserApiRequest, UserApiResponse, User> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    /**
     * User Create
     *
     * @param request User Info
     * @return New User Info
     */
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();

        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status(UserStatus.REGISTERED)
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();

        User newUser = baseRepository.save(user);

        return Header.OK(response(newUser));
    }

    /**
     * User Read
     *
     * @param id User Id
     * @return User Info
     */
    @Override
    public Header<UserApiResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(this::response)
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * User Update
     *
     * @param request User Info
     * @return User Info
     */
    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();

        return baseRepository.findById(userApiRequest.getId())
                .map(user -> {
                    return user.setAccount(userApiRequest.getAccount())
                            .setPassword(userApiRequest.getPassword())
                            .setStatus(userApiRequest.getStatus())
                            .setPhoneNumber(userApiRequest.getPhoneNumber())
                            .setEmail(userApiRequest.getEmail())
                            .setRegisteredAt(userApiRequest.getRegisteredAt())
                            .setUnregisteredAt(userApiRequest.getUnregisteredAt());
                })
                .map(user -> baseRepository.save(user))
                .map(this::response)
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * User Delete
     *
     * @param id User Id
     * @return Header
     */
    @Override
    public Header delete(Long id) {
        return baseRepository.findById(id).map(user -> {
            baseRepository.delete(user);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * User Search
     *
     * @param pageable Page Info
     * @return User List
     */
    @Override
    public Header<List<UserApiResponse>> search(Pageable pageable) {
        Page<User> users = baseRepository.findAll(pageable);
        List<UserApiResponse> userApiResponseList = users.stream()
                .map(this::response)
                .collect(Collectors.toList());
        return Header.OK(userApiResponseList);
    }

    /**
     * User Order Info
     *
     * @param id User Id
     * @return User Order Info
     */
    public Header<UserOrderInfoApiResponse> orderInfo(Long id) {
        User user = userRepository.getOne(id);
        UserApiResponse userApiResponse = response(user);

        List<OrderGroup> orderGroupList = user.getOrderGroupList();
        List<OrderGroupApiResponse> orderGroupApiResponseList = orderGroupList.stream()
                .map(orderGroup -> {
                    OrderGroupApiResponse orderGroupApiResponse = orderGroupApiLogicService.response(orderGroup);
                    List<ItemApiResponse> itemApiResponseList = orderGroup.getOrderDetailList().stream()
                            .map(OrderDetail::getItem)
                            .map(item -> itemApiLogicService.response(item))
                            .collect(Collectors.toList());

                    orderGroupApiResponse.setItemApiResponseList(itemApiResponseList);
                    return orderGroupApiResponse;
                })
                .collect(Collectors.toList());

        userApiResponse.setOrderGroupApiResponseList(orderGroupApiResponseList);
        UserOrderInfoApiResponse userOrderInfoApiResponse = UserOrderInfoApiResponse.builder()
                .userApiResponse(userApiResponse)
                .build();

        return Header.OK(userOrderInfoApiResponse);
    }

    /**
     * User Api Response Create
     *
     * @param user User Info
     * @return User Api Response
     */
    private UserApiResponse response(User user) {
        return UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();
    }


}
