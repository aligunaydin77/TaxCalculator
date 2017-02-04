package com.vd.taxcalc.service;

import com.vd.taxcalc.model.BasketEntry;
import com.vd.taxcalc.service.TaxCalculation;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;


public class TaxCalculationTest {

    @Test
    public void shouldReturnTheTaxForOrdinaryItem() throws Exception {
        assertEquals("shouldReturnTheTaxForValidEntry", new BigDecimal("5.20"),
                TaxCalculation.getTaxAmount(BasketEntry.parseEntry("one book at 29.49")));
    }
    
    @Test
    public void shouldReturnTheTaxForCDs() throws Exception {
        assertEquals("shouldReturnTheTaxForValidEntry", new BigDecimal("1.85"),
                TaxCalculation.getTaxAmount(BasketEntry.parseEntry("one CD at 3.29")));
    }
    
    @Test
    public void shouldReturnTheTaxForMedicalProduct() throws Exception {
        assertEquals("shouldReturnTheTaxForValidEntry",  BigDecimal.ZERO,
                TaxCalculation.getTaxAmount(BasketEntry.parseEntry("one box of headache pills at 1.10")));
    }

}