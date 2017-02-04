package com.vd.taxcalc.control.rule;

import java.math.BigDecimal;

public class MedicalProductTaxCalculationRule implements TaxCalculationRule {

	@Override
	public BigDecimal getTaxAmount(BigDecimal price) {
		return BigDecimal.ZERO;
	}

	@Override
	public boolean isProductTypeIdentified(String name) {
		return name.contains("pills");
	}

}
