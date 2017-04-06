package com.wasiluk.shop.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Created by marcin on 01-Apr-17.
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByItemSku(@Param("itemSku") long itemSku);

}
