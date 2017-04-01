package com.wasiluk.shop;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcin on 31-Mar-17.
 */

@Entity
public class Basket {

    @Id
    private long basketId;

    @OneToMany
    private List<BasketItem> basketItems = new ArrayList<>();

    private BasketStatus basketStatus;

    private DateTime created;

    private BasketError basketError;

    public Basket() {
    }

    public Basket(List<BasketItem> basketItems) {
        this.basketItems.addAll(basketItems);
        this.basketStatus = BasketStatus.ACTIVE;
        this.created = DateTime.now();
    }

    public long getBasketId() {
        return basketId;
    }

    public void setBasketId(long basketId) {
        this.basketId = basketId;
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }

    public BasketStatus getBasketStatus() {
        return basketStatus;
    }

    public void setBasketStatus(BasketStatus basketStatus) {
        this.basketStatus = basketStatus;
    }

    public DateTime getCreated() {
        return created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public BasketError getBasketError() {
        return basketError;
    }

    public void setBasketError(BasketError basketError) {
        this.basketError = basketError;
    }
}
