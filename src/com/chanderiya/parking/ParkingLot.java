package com.chanderiya.parking;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ParkingLot {
	
	private static final ParkingLot instance = new ParkingLot();

	final Queue<Slot> emptySlotQueue = new PriorityQueue<>();
	final HashMap <String,DispenserCard> vehicleToCardMap= new HashMap<String,DispenserCard>();
	final LinkedList<Vehicle> vehicleList = new LinkedList<>();
	final LinkedList<Slot> slotList = new LinkedList<>();

	private ParkingLot() {
		// TODO Auto-generated constructor stub
	}
	
	public static ParkingLot getInstance(){
		return instance;
	}

	public synchronized Slot assignFreeSlot() {
		Slot slot = emptySlotQueue.poll();
		if(slot!=null){
			slot.setIsused(true);
			return slot;
		}
		return null;
	}

	public DispenserCard park(String vehicle, Date date, Slot emptySlot, int tokenNumber) {
		// TODO Auto-generated method stub
		Vehicle vehicleOb = new Car(vehicle);
		vehicleList.add(vehicleOb);
		DispenserCard card = new DispenserCard(vehicleOb, date, emptySlot, tokenNumber);
		
		vehicleToCardMap.put(vehicle, card);
		
		return card;
	}

}
