package com.chanderiya.parking;

import java.util.Date;
import java.util.Scanner;

/**
 * @author saurabh
 *
 */
public class ParkingMain {

	public static void main(String[] args) {
		
		int i=1;

		//Creating slots and adding in priority queue, keepin the scope to only cars here.
		while(i<=100){
			Slot s = new Slot(i,"Car",false);
			ParkingLot.getInstance().emptySlotQueue.add(s);
			ParkingLot.getInstance().slotList.add(s);
			i++;
		}


		String vehicle;
		int charges;
		int option;
		ParkingManager parkManager = new ParkingManager();
		boolean mallOpen = true;
		DispenserCard card = new DispenserCard();
		String vehicleNumber;
		Scanner in = new Scanner(System.in);
		int slotNumber = -1;
		while(mallOpen){
			System.out.println("Enter your Option");
			System.out.println("1 : Entry");
			System.out.println("2 : Exit");
			System.out.println("3 : Get Slot assigned to any Vehicle");
			System.out.println("4 : Get total free Slots available");
			System.out.println("5 : Exit");
			
			option = in.nextInt();
			
			if(option ==1){
				System.out.println("Enter your Vehicle number");
				
				vehicle = in.next();
				
				card = parkManager.add(vehicle, new Date());
				if(card!=null){	
					System.out.println("-------- Here is your Card --------");
					System.out.println("Token no.      : "+card.tokenNumber +"\nVehicle Number : "+card.vehicle.registrationNumber+"\nEntry Time      :  "+card.date+"\nSlot Alloted   : "+card.slot.getSlotNumber());
					System.out.println("-----------------------------------");
				}else{
					System.out.println("Unable to process your request!");
				}
			}else if(option == 2){
				System.out.println("Enter your Vehicle number");
				vehicleNumber = in.next();
				charges = parkManager.exitVehicle(vehicleNumber);
				if(charges!=0)
					System.out.println("You are suppose to pay "+ charges+"/-");
				else
					System.out.println("Unable to process your request!");
			}else if(option ==3){
				System.out.println("Enter your Vehicle number");
				vehicleNumber = in.next();
				slotNumber = parkManager.getSlot(vehicleNumber);
				if(slotNumber>0)
					System.out.println("Your Slot number is : "+ parkManager.getSlot(vehicleNumber));
				else
					System.out.println("Invalid VehicleNumber!!!");
			}else if (option ==4){
				System.out.println("Free Spaces Count is now : "+parkManager.getFreeSlotCount());

			}else if(option ==5){
				mallOpen = false;
			}
			else{ 
				System.out.println("Invalid Input");
			}

		}
		in.close();
	}

}
