package com.wasiluk.shop.service;

import com.wasiluk.shop.entity.Item;

import java.util.Collection;

/**
 * Created by marcin on 06-Apr-17.
 */
public interface ItemActions {

    void addItems();

    Collection<Item> listItems();


}
