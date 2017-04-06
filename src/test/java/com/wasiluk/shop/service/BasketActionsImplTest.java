package com.wasiluk.shop.service;

import com.wasiluk.shop.entity.Basket;
import com.wasiluk.shop.entity.BasketItem;
import com.wasiluk.shop.entity.Item;
import com.wasiluk.shop.service.BasketActionsImpl;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by marcin on 01-Apr-17.
 */
public class BasketActionsImplTest {


    private Basket basket1 = new Basket();
    BasketActionsImpl basketActions = new BasketActionsImpl();

    @Before
    public void setUp() throws Exception {

        Item item1 = new Item();
        item1.setItemSku(123);
        item1.setQuantity(1000);
        item1.setPrice(new BigDecimal("24.99"));

        Item item2 = new Item();
        item2.setItemSku(124);
        item2.setQuantity(1000);
        item2.setPrice(new BigDecimal("99.98"));

        BasketItem bi1 = new BasketItem();
        bi1.setQuantity(5);
        bi1.setItem(item1);

        BasketItem bi2 = new BasketItem();
        bi2.setQuantity(300);
        bi2.setItem(item2);

        List<BasketItem> items = Lists.newArrayList();
        items.add(bi1);
        items.add(bi2);

        basket1 = new Basket(items);
        basket1.setBasketId(1L);
    }

    @Test
    public void getBasketPrice() throws Exception {
        BigDecimal basketPrice = basketActions.getBasketPrice(basket1);
        assertEquals("Basket price should equal 30118.95",1,new BigDecimal(30118.95).compareTo(basketPrice));
    }





}