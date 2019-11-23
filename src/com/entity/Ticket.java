package com.entity;

import java.util.Random;

import com.util.Commons;

/**
 * Ticket.java contains the logic to create the ticket for the car it contains
 * car registration number, time to park and allocated space location(index of the location).
 */
public class Ticket {

	private String registration;
	private int parkingTimeInSecs;
	private int allocatedSpace;

	ParkingSpace parkingSpace = new ParkingSpace();

	/**
	 * Class constructor
	 * 
	 */
	Ticket() {
		this.allocatedSpace = -1;
		this.parkingTimeInSecs = 0;
		this.registration = "";
	}

	/**
	 * generates a ticket with the allocated space and parking time against
	 * registration number of the car.
	 * 
	 * @param registration of car, parking time in seconds, allocated space
	 */
	public Ticket generateTicket(String registration) {
		Ticket ticket = new Ticket();
		ticket.setAllocatedSpace(this.parkingSpace.nextAvailableSpace());
		ticket.setParkingTimeInSecs(
				new Random().nextInt(Commons.maxDuration - Commons.minDuration + 1) + Commons.minDuration);
		ticket.setRegistration(registration);
		return ticket;
	}

	/**
	 * Gets registration of car.
	 * 
	 * @return registration of car
	 */
	public String getRegistration() {
		return this.registration;
	}

	/**
	 * Sets registration of car
	 * 
	 * @param regitration
	 */
	public void setRegistration(String registration) {
		this.registration = registration;
	}

	/**
	 * Gets parking time in seconds
	 * 
	 * @return Total seconds
	 */
	public int getParkingTimeInSecs() {
		return this.parkingTimeInSecs;
	}

	/**
	 * Sets parking time in seconds
	 * 
	 * @param time Number of seconds
	 */
	public void setParkingTimeInSecs(int parkingTimeInSecs) {
		this.parkingTimeInSecs = parkingTimeInSecs;
	}

	/**
	 * Gets allocated space
	 * 
	 * @return the allocated space
	 */
	public int getAllocatedSpace() {
		return this.allocatedSpace;
	}

	/**
	 * Sets allocated space
	 * 
	 * @param ParkingSpace object
	 */
	public void setAllocatedSpace(int allocatedSpace) {
		this.allocatedSpace = allocatedSpace;
	}
}