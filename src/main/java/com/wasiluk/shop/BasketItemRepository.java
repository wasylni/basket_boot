package com.wasiluk.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by marcin on 01-Apr-17.
 */
public interface BasketItemRepository extends JpaRepository<BasketItem, Long> {
    List<BasketItem>  findByBasketId(@Param("basketId") long basketId);
}
