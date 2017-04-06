package com.wasiluk.shop.entity;

import javax.persistence.*;

/**
 * Created by marcin on 01-Apr-17.
 */

@Entity
public class BasketItem {

    @Id
    @GeneratedValue
    private long basketItemId;

    private long basketId;

    @OneToOne
    private Item item;

    private int quantity;

    public BasketItem() {
    }

    public BasketItem(long basketId, Item item, int quantity) {
        this.basketId = basketId;
        this.item = item;
        this.quantity = quantity;
    }

    public long getBasketItemId() {
        return basketItemId;
    }

    public void setBasketItemId(long basketItemId) {
        this.basketItemId = basketItemId;
    }

    public long getBasketId() {
        return basketId;
    }

    public void setBasketId(long basketId) {
        this.basketId = basketId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
