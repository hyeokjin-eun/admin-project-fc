package com.fast.admin.service;

import com.fast.admin.inter.CrudInterface;
import com.fast.admin.model.entity.User;
import com.fast.admin.model.network.Header;
import com.fast.admin.model.network.request.UserApiRequest;
import com.fast.admin.model.network.response.UserApiResponse;
import com.fast.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status("REGISTERED")
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();

        User newUser = userRepository.save(user);

        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        return userRepository.findById(id)
                .map(user -> response(user))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();
        return userRepository.findById(userApiRequest.getId())
                .map(user -> {
                    user.setAccount(userApiRequest.getAccount())
                            .setPassword(userApiRequest.getPassword())
                            .setStatus(userApiRequest.getStatus())
                            .setPhoneNumber(userApiRequest.getPhoneNumber())
                            .setEmail(userApiRequest.getEmail())
                            .setRegisteredAt(userApiRequest.getRegisteredAt())
                            .setUnregisteredAt(userApiRequest.getUnregisteredAt());

                    return user;
                })
                .map(user -> userRepository.save(user))
                .map(updateUser -> response(updateUser))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    private Header<UserApiResponse> response(User user) {
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        return Header.OK(userApiResponse);
    }
}
