package com.chanderiya.parking;

import java.util.Date;

public class DispenserCard {

	Slot slot;
	int tokenNumber;
	Vehicle vehicle;
	Date date;
	public DispenserCard() {
		// TODO Auto-generated constructor stub
	}
	public DispenserCard(Vehicle vehicleOb, Date date2, Slot slot, int tokenNumber2) {
		// TODO Auto-generated constructor stub
		this.slot = slot;
		this.tokenNumber = tokenNumber2;
		this.vehicle = vehicleOb;
		this.date = date2;
	}

	
}
