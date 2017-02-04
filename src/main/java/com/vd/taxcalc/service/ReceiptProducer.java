package com.vd.taxcalc.service;

import com.vd.taxcalc.model.BasketEntry;
import com.vd.taxcalc.model.Receipt;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;


public class ReceiptProducer {

	public String produceReceipt(String itemsBought) {
		if(itemsBought == null) {
			throw new InvalidEntryException();
		}
		Stream<String> stream = Arrays.stream(itemsBought.split("\n"));

		Optional<Receipt> finalReceipt = stream
				.map(BasketEntry::parseEntry)
				.map(Receipt::buildReceipt)
				.reduce(Receipt::acculumulate);

		if (finalReceipt.isPresent()) {
			Receipt receipt = finalReceipt.get();
			return receipt.toString();
		}
		throw new InvalidEntryException();
	}
}
 