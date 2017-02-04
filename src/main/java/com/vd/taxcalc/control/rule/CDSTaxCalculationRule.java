package com.vd.taxcalc.control.rule;

import java.math.BigDecimal;

public class CDSTaxCalculationRule implements TaxCalculationRule {

	@Override
	public BigDecimal getTaxAmount(BigDecimal price) {
		return roundingToTheUpper0point05((new BigDecimal("1.25")).add(getBasicTax(price)));
	}

	@Override
	public boolean isProductTypeIdentified(String name) {
		return name.contains("CD");
	}

}
