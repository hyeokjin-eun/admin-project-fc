package com.fast.admin.service;

import com.fast.admin.model.entity.AdminUser;
import com.fast.admin.model.network.Header;
import com.fast.admin.model.network.request.AdminUserApiRequest;
import com.fast.admin.model.network.response.AdminUserApiResponse;
import org.springframework.stereotype.Service;

@Service
public class AdminUserApiLogicService extends BaseService<AdminUserApiRequest, AdminUserApiResponse, AdminUser> {

    /**
     * Admin User Create
     * @param request Admin User Info
     * @return New Admin User Info
     */
    @Override
    public Header<AdminUserApiResponse> create(Header<AdminUserApiRequest> request) {
        AdminUserApiRequest adminUserApiRequest = request.getData();
        AdminUser adminUser = AdminUser.builder()
                .id(adminUserApiRequest.getId())
                .account(adminUserApiRequest.getAccount())
                .password(adminUserApiRequest.getPassword())
                .status(adminUserApiRequest.getStatus())
                .role(adminUserApiRequest.getRole())
                .lastLoginAt(adminUserApiRequest.getLastLoginAt())
                .passwordUpdatedAt(adminUserApiRequest.getPasswordUpdatedAt())
                .loginFailCount(adminUserApiRequest.getLoginFailCount())
                .registeredAt(adminUserApiRequest.getRegisteredAt())
                .unregisteredAt(adminUserApiRequest.getUnregisteredAt())
                .build();

        AdminUser newAdminUser = baseRepository.save(adminUser);

        return response(newAdminUser);
    }

    /**
     * Admin User Read
     * @param id Admin User Id
     * @return Admin User Info
     */
    @Override
    public Header<AdminUserApiResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(this::response)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Admin User Update
     * @param request Admin User Info
     * @return Admin User Info
     */
    @Override
    public Header<AdminUserApiResponse> update(Header<AdminUserApiRequest> request) {
        AdminUserApiRequest adminUserApiRequest = request.getData();
        return baseRepository.findById(adminUserApiRequest.getId())
                .map(adminUser -> {
                    adminUser
                            .setAccount(adminUserApiRequest.getAccount())
                            .setPassword(adminUserApiRequest.getPassword())
                            .setStatus(adminUserApiRequest.getStatus())
                            .setRole(adminUserApiRequest.getRole())
                            .setLastLoginAt(adminUserApiRequest.getLastLoginAt())
                            .setPasswordUpdatedAt(adminUserApiRequest.getPasswordUpdatedAt())
                            .setLoginFailCount(adminUserApiRequest.getLoginFailCount())
                            .setRegisteredAt(adminUserApiRequest.getRegisteredAt())
                            .setUnregisteredAt(adminUserApiRequest.getUnregisteredAt());

                    return adminUser;
                })
                .map(adminUser -> baseRepository.save(adminUser))
                .map(this::response)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Admin User Delete
     * @param id Admin User Id
     * @return Header
     */
    @Override
    public Header delete(Long id) {
        return baseRepository.findById(id)
                .map(adminUser -> {
                    baseRepository.delete(adminUser);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    /**
     * Header <Admin User Api Response> Create
     * @param adminUser Admin User Info
     * @return Header <Admin User Api Response>
     */
    private Header<AdminUserApiResponse> response(AdminUser adminUser) {
        AdminUserApiResponse adminUserApiResponse = AdminUserApiResponse.builder()
                .id(adminUser.getId())
                .account(adminUser.getAccount())
                .password(adminUser.getPassword())
                .status(adminUser.getStatus())
                .role(adminUser.getRole())
                .lastLoginAt(adminUser.getLastLoginAt())
                .passwordUpdatedAt(adminUser.getPasswordUpdatedAt())
                .loginFailCount(adminUser.getLoginFailCount())
                .registeredAt(adminUser.getRegisteredAt())
                .unregisteredAt(adminUser.getUnregisteredAt())
                .build();

        return Header.OK(adminUserApiResponse);
    }
}
