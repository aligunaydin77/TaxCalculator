package com.vd.taxcalc.control.rule;

import java.math.BigDecimal;
import java.math.RoundingMode;


public interface TaxCalculationRule {
    public BigDecimal getTaxAmount(BigDecimal price);
    public boolean isProductTypeIdentified(String productText);
    
    public default BigDecimal getBasicTax(BigDecimal price) {
        return price.multiply(new BigDecimal("0.175"));
    }

    public default BigDecimal roundingToTheUpper0point05(BigDecimal value) {
        BigDecimal zeroPointZeroFive = new BigDecimal("0.05");
        BigDecimal divided = value.divide(zeroPointZeroFive, 0, RoundingMode.UP);
        BigDecimal result = divided.multiply(zeroPointZeroFive);
        return result;
    }
}
