package com.vd.taxcalc.service;

import java.math.BigDecimal;

import com.vd.taxcalc.control.rule.DefaultCalculationRule;
import com.vd.taxcalc.control.rule.Registry;
import com.vd.taxcalc.control.rule.TaxCalculationRule;
import com.vd.taxcalc.model.BasketEntry;


public class TaxCalculation {

    public static BigDecimal getTaxAmount(BasketEntry basketEntry) {
        for(TaxCalculationRule taxCalculationRule: Registry.getListOfTaxCalculationRules()) {
            if(taxCalculationRule.isProductTypeIdentified(basketEntry.getProductText())) {
                return taxCalculationRule.getTaxAmount(basketEntry.getPrice());
            }
        }
        return DefaultCalculationRule.getTaxAmount(basketEntry);
    }

}
