package com.wasiluk.shop.entity;

import com.wasiluk.shop.util.BasketError;
import com.wasiluk.shop.util.BasketStatus;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by marcin on 31-Mar-17.
 */

@Entity
public class Basket {

    @Id
    private long basketId;

    @OneToMany
    private Collection<BasketItem> basketItems = new ArrayList<>();

    private BasketStatus basketStatus;

    private DateTime created;

    private BasketError basketError;

    public Basket() {
    }

    public Basket(Collection<BasketItem> basketItems) {
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

    public Collection<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(Collection<BasketItem> basketItems) {
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
