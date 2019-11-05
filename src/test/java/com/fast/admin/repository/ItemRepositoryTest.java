package com.fast.admin.repository;

import com.fast.admin.model.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = new Item();
        item.setName("휴대폰");
        item.setPrice(800000);
        item.setContent("삼성");

        Item newItem = itemRepository.save(item);
    }

    @Test
    @Transactional
    public void read(){
        Long id = 3L;

        Optional<Item> item = itemRepository.findById(id);
        item.ifPresent(selectItem -> {
            selectItem.getOrderDetailList().stream().forEach(System.out::println);
        });

    }
}
