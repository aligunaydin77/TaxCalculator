package com.vd.taxcalc.service;

import java.math.BigDecimal;

import com.vd.taxcalc.control.rule.DefaultCalculationRule;
import com.vd.taxcalc.control.rule.Registry;
import com.vd.taxcalc.model.BasketEntry;


public class TaxCalculation {

    public static BigDecimal getTaxAmount(BasketEntry basketEntry) {
    	  return Registry.getListOfTaxCalculationRules()
                  .stream()
                  .filter(rule -> rule.isProductTypeIdentified(basketEntry.getProductText()))
                  .findFirst()
                  .map(rule -> rule.getTaxAmount(basketEntry.getPrice()))
                  .orElseGet(() -> DefaultCalculationRule.getTaxAmount(basketEntry));
    }

}
