/**
 * 
 */
package com.chanderiya.parking;

/**
 * @author saurabh
 *
 */
public class Car extends Vehicle {

	/* (non-Javadoc)
	 * @see com.chanderiya.parking.Vehicle#getType()
	 */
	@Override
	String getType() {
		// TODO Auto-generated method stub
		return this.typeOfVehicle;
	}
	
	Car(String vehicle){
		super(vehicle,"Car");
	}

}
