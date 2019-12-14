package com.fast.admin.repository;

import com.fast.admin.model.entity.Partner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class PartnerRepositoryTest {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create() {
        Partner partner = new Partner();
        partner.setName("Partner01");
        partner.setStatus("REGISTERED");
        partner.setCallCenter("070-1234-1234");
        partner.setPartnerNumber("010-1234-1234");
        partner.setBusinessNumber("1234123412");
        partner.setCeoName("홍길동");
        partner.setRegisteredAt(LocalDateTime.now());
        partner.setCreatedAt(LocalDateTime.now());
        partner.setCreatedBy("ADMIN");
        partner.setCategoryId(1L);

        Partner newPartner = partnerRepository.save(partner);
    }
}
