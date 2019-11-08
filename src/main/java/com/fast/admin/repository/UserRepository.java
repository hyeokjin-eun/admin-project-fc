package com.fast.admin.repository;

import com.fast.admin.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByPhoneNumberOrderById(String phoneNumber);
}
