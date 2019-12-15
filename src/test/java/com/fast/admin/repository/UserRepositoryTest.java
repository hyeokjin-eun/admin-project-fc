package com.fast.admin.repository;

import com.fast.admin.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
public class UserRepositoryTest{

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setAccount("Test01");
        user.setPassword("Test01");
        user.setStatus("REGISTERED");
        user.setEmail("Test01@test.com");
        user.setPhoneNumber("010-0000-0001");
        user.setRegisteredAt(LocalDateTime.now());
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("ADMIN");

        // Builder 적용
        User u = User.builder()
                .account("Test01")
                .password("Test01")
                .status("REGISTERED")
                .email("Test01@test.com")
                .build();

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
    }

    @Test
    @Transactional
    public void read() {
        User user = userRepository.findFirstByPhoneNumberOrderById("010-0000-0001");
        if (user != null) {
            user.getOrderGroupList().stream().forEach(orderGroup -> {
                System.out.println("수령인" + orderGroup.getRevName());
                System.out.println("수령지" + orderGroup.getRevAddress());
                System.out.println("총금액" + orderGroup.getTotalPrice());
                System.out.println("총수량" + orderGroup.getTotalQuantity());
            });
        }
    }

}
