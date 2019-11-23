package com.entity;

import java.util.Random;

import javax.swing.ImageIcon;

import com.util.Commons;

/**
 * Car.java 
 * using the parking space
 * 
 */
public class Car implements Runnable {
	private double fair;
	private String registration;
	private int parkingTime ;
	Ticket ticketObj = new Ticket();

	/**
	 * Default constructor for class
	 */
	public Car() {
		this.fair = 0.0;
		this.parkingTime = 0;
		this.registration = "";
	}

	/**
	 * Class constructor specifying input data.
	 * @param regNo Car Registration Number
	 */
	public Car(String regNo) {
		this.fair = 0.0;
		this.parkingTime = 0;
		this.registration = regNo;
	}

	@Override
	public String toString() {
		return "Registration Number: " + this.registration + " \nParking Time :"+this.parkingTime + "s";
	}

	/**
	 * Enters the Car to the parking space.
	 */
	private void enterCar(Ticket ticket) {
		Car newCar = new Car();
		newCar.setRegistration(ticket.getRegistration());
		newCar.setParkingTime(ticket.getParkingTimeInSecs());
		Commons.parkingSpaces[ticket.getAllocatedSpace()].fillParkingSpace(newCar);
	}

	public ImageIcon getFull() {
		return new ImageIcon("images/car.png");
	}

	/**
	 * Calculates the fair for car
	 * 
	 * @return car fair
	 */

	public double calculateFair(Ticket ticket) {
		this.fair = 0.75;
		this.fair = this.fair * ticket.getParkingTimeInSecs();
		return this.fair;
	}

	/**
	 * Overriding the run method enter the car in the space and exit the car 
	 * from the space.
	 * */
	@Override
	public void run() {
		try {
			String regNo = "c-p : '%1$s'";
			regNo = String.format(regNo, new Random().nextInt(10000 - 1000 + 1) + 1000);
			Ticket ticket = this.ticketObj.generateTicket(regNo);
			if (ticket != null) {
				try {
					enterCar(ticket);
					Thread.sleep(ticket.getParkingTimeInSecs() * 1000);
					System.out.println(
							"Fair of car with " + ticket.getRegistration() + " is :" + calculateFair(ticket) + ".");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Commons.parkingSpaces[ticket.getAllocatedSpace()]
							.emptySpace(Commons.parkingSpaces[ticket.getAllocatedSpace()]);
				}
			}
		} catch (Exception e) {

		}
	}

	/**
	 * 
	 * Sets the registration number of the car.
	 * 
	 * */
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	
	/**
	 * 
	 * Sets the parking time of the car.
	 * 
	 * */
	public void setParkingTime(int parkingTime) {
		this.parkingTime = parkingTime;
	}
}
