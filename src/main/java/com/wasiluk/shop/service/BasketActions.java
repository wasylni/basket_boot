package com.wasiluk.shop.service;

import com.wasiluk.shop.entity.Basket;
import com.wasiluk.shop.entity.Item;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by marcin on 31-Mar-17.
 *
 • Add a quantity of an item to the basket
 *
 • Update the quantity of an item in the basket
 *
 • Delete the item from the basket
 *
 • Get the contents of the basket
 *
 • Get to total cost for the basket (an item should have a unit cost)
 */

public interface BasketActions {

    Basket add(final long basketId, final long itemSku, final int itemQuantity);

    boolean delete(final long basketId, final long itemSku, final int itemQuantity);

    Basket update(final long basketId, final long itemSku, final int itemQuantity);

    Basket getContent(final long basketId);

    BigDecimal getTotal(final long basketId, final String currency);

}
