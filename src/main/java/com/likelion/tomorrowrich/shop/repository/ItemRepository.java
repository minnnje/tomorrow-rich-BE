package com.likelion.tomorrowrich.shop.repository;

import com.likelion.tomorrowrich.shop.entity.Item;
import com.likelion.tomorrowrich.shop.entity.ItemType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByOrderByIdAsc();

    List<Item> findAllByItemTypeOrderByIdAsc(ItemType itemType);
}