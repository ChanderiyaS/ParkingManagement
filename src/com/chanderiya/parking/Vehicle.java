/**
 * 
 */
package com.chanderiya.parking;

/**
 * @author saurabh
 *
 */
public abstract class Vehicle {
	protected String registrationNumber;
	protected String typeOfVehicle;
	
	Vehicle(String registrationNumber, String type){
		typeOfVehicle = type;
		this.registrationNumber = registrationNumber;
	}
	abstract String getType();
}
