package com.vd.taxcalc.model;

import java.math.BigDecimal;
import com.vd.taxcalc.service.InvalidEntryException;

public class BasketEntry {
    private String productText;
    private BigDecimal price;

    private BasketEntry() {}
    
    public String getProductText() {
        return productText;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static BasketEntry parseEntry(String lineInTheBasket) {
        BasketEntry basketEntry = new BasketEntry();
        String[] parts = lineInTheBasket.split("at ");
        if(parts.length == 2) {
            basketEntry.setProductText(parts[0]);
            basketEntry.setPrice(new BigDecimal(parts[1]));
        } else {
            throw new InvalidEntryException();
        }
        return basketEntry;
    }

    private void setProductText(String name) {
        this.productText = name;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }
}
