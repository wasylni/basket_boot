package com.wasiluk.shop.entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by marcin on 31-Mar-17.
 */
@Entity
public class Item {

    @Id
    @GeneratedValue
    private long itemId;

    private long itemSku;

    private BigDecimal price;

    private String isoCurrency;

    private int quantity;

    public Item() {
    }

    public Item(long itemSku, BigDecimal price, int quantity) {
        this.itemSku = itemSku;
        this.price = price;
        this.isoCurrency = "GBP";
        this.quantity = quantity;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getItemSku() {
        return itemSku;
    }

    public void setItemSku(long itemSku) {
        this.itemSku = itemSku;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getIsoCurrency() {
        return isoCurrency;
    }

    public void setIsoCurrency(String isoCurrency) {
        this.isoCurrency = isoCurrency;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}