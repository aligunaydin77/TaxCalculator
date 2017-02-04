package com.vd.taxcalc.control.rule;

import java.util.ArrayList;
import java.util.List;

public class Registry {
	private static List<TaxCalculationRule> listOfTaxCalculationRules = new ArrayList<>();
	static {
		listOfTaxCalculationRules.add(new MedicalProductTaxCalculationRule());
		listOfTaxCalculationRules.add(new CDSTaxCalculationRule());
	}
	
	public static List<TaxCalculationRule> getListOfTaxCalculationRules() {
		return listOfTaxCalculationRules;
	}

}
