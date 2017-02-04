package com.vd.taxcalc.model;

import com.vd.taxcalc.control.TextTranslator;
import com.vd.taxcalc.service.TaxCalculation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Receipt {

    private static final String RECEIPT_FORMAT = "%s\nSales Taxes: %s\nTotal: %s";
	private BigDecimal salesTaxes = BigDecimal.ZERO;
    private BigDecimal totalAmount = BigDecimal.ZERO;
    private List<String> itemList = new ArrayList<>();

    private Receipt() {}
    
    public Receipt accumulate(Receipt otherEntry) {
        salesTaxes = salesTaxes.add(otherEntry.salesTaxes);
        totalAmount = totalAmount.add(otherEntry.totalAmount);
        itemList.addAll(otherEntry.itemList);
        return this;
    }

   public static Receipt buildReceipt(BasketEntry basketEntry) {
       Receipt receipt = new Receipt();
       receipt.salesTaxes = TaxCalculation.getTaxAmount(basketEntry);
       receipt.totalAmount = basketEntry.getPrice().add(receipt.salesTaxes);

       receipt.itemList.add(TextTranslator.translate(basketEntry.getProductText()) +
               receipt.totalAmount);
       return receipt;
   }

    public BigDecimal getSalesTaxes() {
        return salesTaxes;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public List<String> getItemList() {
        return itemList;
    }

	@Override
	public String toString() {
		return String.format(RECEIPT_FORMAT, 
				String.join("\n", itemList), salesTaxes, totalAmount);
	}

}
