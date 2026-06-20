package com.likelion.tomorrowrich.shop.repository;

import com.likelion.tomorrowrich.shop.entity.Item;
import com.likelion.tomorrowrich.shop.entity.UserItem;
import com.likelion.tomorrowrich.user.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserItemRepository extends JpaRepository<UserItem, Long> {

    boolean existsByUserAndItem(User user, Item item);

    Optional<UserItem> findByUserAndItem(User user, Item item);

    List<UserItem> findAllByUser(User user);
}