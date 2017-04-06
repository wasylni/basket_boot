package com.wasiluk.shop;

import com.wasiluk.shop.entity.Basket;
import com.wasiluk.shop.service.BasketActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class BasketApplication {

    @Autowired
    BasketActions basketActions;


    @RequestMapping(method = RequestMethod.POST, value = "/add/{basketId}/{itemSku}/{itemQuantity}")
    Basket add(@PathVariable int basketId, @PathVariable int itemSku, @PathVariable int itemQuantity) {
        return basketActions.add(basketId, itemSku, itemQuantity);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/remove/{basketId}/{itemSku}/{itemQuantity}")
    boolean delete(@PathVariable int basketId, @PathVariable int itemSku, @PathVariable int itemQuantity) {
        return basketActions.delete(basketId, itemSku, itemQuantity);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update/{basketId}/{itemSku}/{itemQuantity}")
    Basket update(@PathVariable int basketId, @PathVariable int itemSku, @PathVariable int itemQuantity) {
        return basketActions.update(basketId, itemSku, itemQuantity);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/content/{basketId}")
    Basket getContent(@PathVariable long basketId) {
        return basketActions.getContent(basketId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/total/{basketId}/{currencyCode}")
    BigDecimal getTotal(@PathVariable int basketId, @PathVariable String currencyCode) {
        return basketActions.getTotal(basketId, currencyCode);
    }

    public static void main(String[] args) {
        SpringApplication.run(BasketApplication.class, args);
    }

}
