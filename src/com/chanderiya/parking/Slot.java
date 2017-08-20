package com.chanderiya.parking;

public class Slot implements Comparable<Slot>{

	private int slotNumber;
	private String typeOfSlot;
	private boolean isUsed;
	
	public boolean isIsused() {
		return isUsed;
	}

	public void setIsused(boolean isUsed) {
		this.isUsed = isUsed;
	}

	/**
	 * @return the typeOfSlot
	 */
	public String getTypeOfSlot() {
		return typeOfSlot;
	}

	/**
	 * @param typeOfSlot the typeOfSlot to set
	 */
	public void setTypeOfSlot(String typeOfSlot) {
		this.typeOfSlot = typeOfSlot;
	}

	/**
	 * @return the slotNumber
	 */
	public int getSlotNumber() {
		return slotNumber;
	}

	/**
	 * @param slotNumber the slotNumber to set
	 */
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public Slot() {
		// TODO Auto-generated constructor stub
	}
	
	public Slot(int i, String type, boolean b) {
		slotNumber = i;
		typeOfSlot = type;
		isUsed = b;
	}
	public boolean equals(Slot slot){
		return slotNumber == slot.slotNumber;
	}
	@Override
	/*
	 * Assuming smaller slot no. is closer to parking Dispenser.
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Slot slot){
		if(this.equals(slot))
			return 0;
		else if(getSlotNumber() > slot.getSlotNumber())
			return 1;
		else
			return -1;
	}
}
