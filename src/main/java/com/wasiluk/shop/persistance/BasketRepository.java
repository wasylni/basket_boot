package com.wasiluk.shop.persistance;

import com.wasiluk.shop.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Created by marcin on 01-Apr-17.
 */
public interface BasketRepository extends JpaRepository<Basket, Long> {

    Optional<Basket> findOneByBasketId(@Param("basketId") long basketId);

}
