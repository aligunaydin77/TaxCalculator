package com.vd.taxcalc.service;

import com.vd.taxcalc.service.InvalidEntryException;
import com.vd.taxcalc.service.ReceiptProducer;
import org.junit.Test;

import static org.junit.Assert.*;


public class ReceiptProducerTest {

    @Test
    public void shouldReturn1BookWithTaxAddedToPrice() {
        ReceiptProducer taxCalculator = new ReceiptProducer();
        assertEquals("shouldReturn1BookWithTaxAddedToPrice", "1 book: 34.69\n" +
                "Sales Taxes: 5.20\n" +
                "Total: 34.69", taxCalculator.produceReceipt("one book at 29.49"));
    }

    @Test
    public void shouldReturn9point40AsTaxFor3Items() {
        ReceiptProducer taxCalculator = new ReceiptProducer();
        assertEquals("shouldReturn1BookWithTaxAddedToPrice", "1 book: 34.69\n" +
                "1 music CD: 20.04\n" +
                "1 chocolate snack: 0.90\n" +
                "Sales Taxes: 9.40\n" +
                "Total: 55.63",
                taxCalculator.produceReceipt("one book at 29.49\n" +
                "one music CD at 15.99\n" +
                "one chocolate snack at 0.75"));
    }

    @Test
    public void shouldReturnTotalFor4Items() {
        ReceiptProducer taxCalculator = new ReceiptProducer();
        assertEquals("shouldReturn1BookWithTaxAddedToPrice", "1 bottle of wine: 24.69\n" +
                        "1 box of headache pills: 4.15\n" +
                        "1 box of pins: 13.25\n" +
                        "1 music CD: 18.89\n" +
                        "Sales Taxes: 9.60\n" +
                        "Total: 60.98",
                taxCalculator.produceReceipt("one bottle of wine at 20.99\n" +
                        "one box of headache pills at 4.15\n" +
                        "one box of pins at 11.25\n" +
                        "one music CD at 14.99"));
    }

    @Test(expected = InvalidEntryException.class)
    public void shouldErrorOnInvalidInput() {
        ReceiptProducer taxCalculator = new ReceiptProducer();
        assertEquals("shouldErrorOnInvalidInput", "",
                taxCalculator.produceReceipt(""));
    }

    @Test(expected = InvalidEntryException.class)
    public void shouldErrorOnNullInput() {
        ReceiptProducer taxCalculator = new ReceiptProducer();
        assertEquals("shouldErrorOnNullInput", "",
                taxCalculator.produceReceipt(null));
    }

}