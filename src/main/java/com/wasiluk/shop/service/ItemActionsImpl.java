package com.wasiluk.shop.service;

import com.wasiluk.shop.entity.Item;
import com.wasiluk.shop.persistance.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by marcin on 06-Apr-17.
 */
public class ItemActionsImpl implements ItemActions {

    @Autowired
    ItemRepository itemRepository;

    //TODO: remove this
    @Override
    public void addItems() {
        Collection<Item> items = new ArrayList<>();
        items.add(new Item(10001, new BigDecimal(99), 100));
        items.add(new Item(10002, new BigDecimal(99), 100));
        items.add(new Item(10003, new BigDecimal(99), 100));
        items.add(new Item(10004, new BigDecimal(99), 100));
        items.add(new Item(10005, new BigDecimal(99), 100));
        items.add(new Item(10006, new BigDecimal(99), 100));
        itemRepository.save(items);
    }

    //TODO: remove this
    @Override
    public Collection<Item> listItems() {
        return itemRepository.findAll();
    }

}
