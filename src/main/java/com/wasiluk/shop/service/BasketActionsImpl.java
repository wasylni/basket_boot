package com.wasiluk.shop.service;

import com.wasiluk.shop.entity.Basket;
import com.wasiluk.shop.entity.BasketItem;
import com.wasiluk.shop.entity.Item;
import com.wasiluk.shop.persistance.ItemRepository;
import com.wasiluk.shop.persistance.BasketItemRepository;
import com.wasiluk.shop.persistance.BasketRepository;
import com.wasiluk.shop.util.BasketError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by marcin on 31-Mar-17.
 */
@Component
public class BasketActionsImpl implements BasketActions {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    BasketItemRepository basketItemRepository;

    @Override
    public Basket add(long basketId, long itemSku, int itemQuantity) {
        Optional<Item> item = itemRepository.findByItemSku(itemSku);
        if (!item.isPresent()) {
            return getBasketError("could not find itemSku: " + itemSku);
        }
        Basket basket = getBasket(basketId);
        BasketItem basketItem = new BasketItem(basket.getBasketId(), item.get(), itemQuantity);

        if (basket.getBasketItems().stream().anyMatch(i -> i.getItem().getItemSku() == itemSku)) {
            basket.getBasketItems().forEach(i -> {
                if (i.getItem().getItemSku() == itemSku) {
                    i.setQuantity(i.getQuantity() + itemQuantity);
                }
            });
        } else {
            basket.getBasketItems().add(basketItemRepository.save(basketItem));
        }

        return basketRepository.save(basket);
    }

    @Override
    public boolean delete(long basketId, long itemSku, int itemQuantity) {
        Optional<Basket> basket = basketRepository.findOneByBasketId(basketId);
        if (basket.isPresent()) {
            basket.get().getBasketItems().forEach(item -> {
                if (item.getItem().getItemSku() == itemSku && item.getQuantity() >= itemQuantity) {
                    basket.get().getBasketItems().remove(item);
                    basketItemRepository.delete(item.getBasketItemId());
                } else {
                    item.setQuantity(item.getQuantity() - itemQuantity);
                    basketItemRepository.save(item);
                }
            });
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Basket update(long basketId, long itemSku, int itemQuantity) {
        Optional<Basket> basket = basketRepository.findOneByBasketId(basketId);
        if (basket.isPresent()) {
            basket.get().getBasketItems().forEach(item -> {
                if (item.getItem().getItemSku() == itemSku) {
                    item.setQuantity(itemQuantity);
                }
            });
            basketRepository.save(basket.get());
        } else {
            Basket basketBlank = new Basket();
            basketBlank.setBasketError(new BasketError("could not find basket with ID " + basketId));
            return basketBlank;
        }
        return basket.get();
    }

    @Override
    public Basket getContent(long basketId) {
        return basketRepository.findOneByBasketId(basketId).get();
    }


    @Override
    public BigDecimal getTotal(long basketId, String currency) {
        Optional<Basket> basket = basketRepository.findOneByBasketId(basketId);
        return getBasketPrice(basket.get());
    }

    BigDecimal getBasketPrice(Basket basket) {
        List<BigDecimal> bigDecimalsValues = new ArrayList<>();
        basket.getBasketItems().forEach(bi -> bigDecimalsValues.add(bi.getItem().getPrice().multiply(new BigDecimal(bi.getQuantity()))));
        BigDecimal sumOfBigDecimals = bigDecimalsValues.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        return sumOfBigDecimals;
    }

    private Basket getBasket(long basketId) {
        Basket basket;
        Optional<Basket> basketFound = basketRepository.findOneByBasketId(basketId);
        if (!basketFound.isPresent()) {
            basket = new Basket();
            basket.setBasketId(basketId);
            basket = basketRepository.save(basket);
        } else {
            basket = basketFound.get();
        }
        return basket;
    }

    private Basket getBasketError(String errorMessage) {
        Basket basket = new Basket();
        basket.setBasketError(new BasketError(errorMessage));
        return basket;
    }
}
