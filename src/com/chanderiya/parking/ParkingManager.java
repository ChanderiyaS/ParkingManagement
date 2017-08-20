package com.chanderiya.parking;

import java.util.Date;

public class ParkingManager {
	
	static int tokenNo=0;
	public ParkingManager() {
	}

	public DispenserCard add(String vehicleNumber, Date date) {
		if(ParkingLot.getInstance().vehicleToCardMap.get(vehicleNumber) == null){
			Slot emptySlot = ParkingLot.getInstance().assignFreeSlot();
			if(emptySlot==null){
				System.out.println("Slots are full!!! Come back later!");
			}
			DispenserCard card = ParkingLot.getInstance().park(vehicleNumber,date,emptySlot,++tokenNo);
			return card;
		}
		return null;
	}


	public int exitVehicle(String vehicleNumber) {
		if(ParkingLot.getInstance().vehicleToCardMap.get(vehicleNumber) == null){
			return 0;
		}
		DispenserCard card = ParkingLot.getInstance().vehicleToCardMap.get(vehicleNumber);
		ParkingLot.getInstance().vehicleToCardMap.remove(vehicleNumber);
		
		int charge = calculatePayment(card);
		
		if(card!=null)
			ParkingLot.getInstance().emptySlotQueue.add(new Slot(card.slot.getSlotNumber(),"Car",false));
		

		return charge;
	}

	/**
	 * Not calculating seconds, means giving favor to subject to pay 10/- for 2 hours 59 seconds(example)
	 * @param card
	 * @return
	 */
	private int calculatePayment(DispenserCard card) {
		
		//System.out.println(card);
		Date date = new Date();
	    long diff = date.getTime() - card.date.getTime();
	    long diffSec = diff / 1000;
	    long min = diffSec / 60;
	    System.out.println("The difference is "+min+" minutes ");
	    
	    if(min<=120) return 10;
	    else if (min>120 && min<=360) return 50;
	    else return 100;
		
	}

	public int getSlot(String vehicleNumber) {
		// TODO Auto-generated method stub
		if(ParkingLot.getInstance().vehicleToCardMap.get(vehicleNumber) == null){
			return 0;
		}
		DispenserCard card = ParkingLot.getInstance().vehicleToCardMap.get(vehicleNumber);
		return card.slot.getSlotNumber();
	}

	public int getFreeSlotCount() {
		// TODO Auto-generated method stub
		return ParkingLot.getInstance().emptySlotQueue.size();
	}

	
}
