package com.wasiluk.shop;

import com.wasiluk.shop.entity.Basket;
import com.wasiluk.shop.entity.Item;
import com.wasiluk.shop.entity.ItemRepository;
import com.wasiluk.shop.persistance.BasketRepository;
import com.wasiluk.shop.service.BasketActions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BasketApplicationTests {

	@Autowired
	private BasketActions basketActions;

	@Autowired
	private BasketRepository basketRepository;

	@Autowired
	private ItemRepository itemRepository;

	private List<Item> items = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		items.add(new Item(10001, new BigDecimal(99), 100));
		items.add(new Item(10002, new BigDecimal(99), 100));
		items.add(new Item(10003, new BigDecimal(99), 100));
		items.add(new Item(10004, new BigDecimal(99), 100));
		items.add(new Item(10005, new BigDecimal(99), 100));
		items.add(new Item(10006, new BigDecimal(99), 100));
		itemRepository.save(items);
	}

	@Test
	public void testFindByName() {
		List<Item> itemsFound = itemRepository.findAll();
		assertTrue(itemsFound.size()==items.size());
	}

	@Test
	public void testAddNewBasket() throws Exception {
		Basket basketCreated = basketActions.add(1, 10001, 10);
		assertEquals("basket shall have 10 items with sku 10001", 10, basketCreated.getBasketItems().iterator().next().getQuantity());
	}

	@Test
	public void updateBasketItemQuantity() throws Exception {
		basketActions.add(10, 10003, 10);
		Basket b2 = basketActions.update(10, 10003, 8);
		assertEquals("basket shall have 8 items with sku 10003", 8, b2.getBasketItems().iterator().next().getQuantity());
	}

	@Test
	public void calculateBasketPrice() throws Exception {
		basketActions.add(10, 10003, 10);
		BigDecimal bValue = basketActions.getTotal(10, "GBP");
		assertEquals("basket value should be 990", BigDecimal.valueOf(990), bValue);
	}

}
