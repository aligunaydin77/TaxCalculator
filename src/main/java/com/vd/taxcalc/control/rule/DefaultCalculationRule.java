package com.vd.taxcalc.control.rule;

import java.math.BigDecimal;

import com.vd.taxcalc.model.BasketEntry;

public class DefaultCalculationRule implements TaxCalculationRule {
	
	private static DefaultCalculationRule instance;
	
	public static DefaultCalculationRule getInstance() {
		if(instance == null) {
			instance = new DefaultCalculationRule();
		}		
		return instance;
	}
	
	
	public static BigDecimal getTaxAmount(BasketEntry basketEntry) {
		return getInstance().getTaxAmount(basketEntry.getPrice());
	}

	@Override
	public BigDecimal getTaxAmount(BigDecimal price) {
		return roundingToTheUpper0point05(getBasicTax(price));
	}

	@Override
	public boolean isProductTypeIdentified(String name) {
		return true;
	}

}
