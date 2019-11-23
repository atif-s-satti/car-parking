package com.util;

import com.entity.ParkingSpace;

/**
 * commons class for shared resources.
 * 
 * */

public final class Commons {
	public static final int  totalSpaces = 50;
	public static final int totalCars = 100;
	public static final int minDuration = 20;
	public static final int maxDuration = 75;
	public static final String layoutHeader = "Car Parking System";
	public static final String carDetailsHeader = "Car Details";
	public static final ParkingSpace [] parkingSpaces = new ParkingSpace[totalSpaces];
}
