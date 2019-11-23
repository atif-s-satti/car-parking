package com.entity;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.util.Commons;

/**
 * ParkingSpace.java extends JButton and implements Serializable
 * 
 * create the main layout for the space gui.
 */
public class ParkingSpace extends JButton implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Car car;
	private int index;
	private Queue<ParkingSpace> parkingSpaces = new LinkedList<ParkingSpace>();
	private final Semaphore availableSpaces = new Semaphore(Commons.totalSpaces, true);

	/**
	 * Default Class constructor
	 * 
	 */
	public ParkingSpace() {
	}

	/**
	 * Class constructor
	 * 
	 * @param index Any Index within an array of parking spaces
	 */
	public ParkingSpace(int index) {
		this.car = null;
		this.index = index;
	}

	/**
	 * Class constructor
	 * 
	 * @param index     Any Index within an array of parking spaces
	 * @param mListener MouseListener
	 */
	public ParkingSpace(int index, MouseListener mListener) {
		this.car = null;
		this.index = index;
		buildGUI(mListener);
	}

	/**
	 * Implements the core GUI logic for this class
	 * 
	 * @param mListener MouseListener from the parent class
	 */
	private void buildGUI(MouseListener mListener) {
		this.setBackground(null);
		this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.addMouseListener(mListener);
	}

	/**
	 * Tests whether the ParkingSpace is empty
	 * 
	 * @return boolean True if empty, false if not
	 */
	public boolean isEmpty() {
		if (this.car == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * returns the index of the current space
	 */
	public int getIndex() {
		return this.index;
	}

	/**
	 * returns car in the parking space
	 */
	public Car getCar() {
		return this.car;
	}

	/**
	 * Locates the first available empty space
	 * 
	 * Precondition is that isSpaceFull() is checked to prevent data being
	 * overwritten.
	 * 
	 * @return int Index of next available space
	 */
	public int nextAvailableSpace() {
		int space = -1;

		for (int i = 0; i < Commons.totalSpaces; i++) {
			if (Commons.parkingSpaces[i].isEmpty()) {
				space = i;
				break;
			}
		}

		return space;
	}

	/**
	 * Checks to see if the spaces are full
	 * 
	 * @return boolean True if full, false if not
	 */
	public boolean isSpaceFull() {
		for (int i = 0; i < Commons.totalSpaces; i++) {
			if (Commons.parkingSpaces[i].isEmpty())
				return false;
		}

		return true;
	}

	/**
	 * Fills the ParkingSpace to contain a car
	 * 
	 * @param car car object
	 */
	public void fillParkingSpace(Car car) {
		try {
			if (car != null) {
				System.out.println("Filling the space");
				this.car = car;
				this.setIcon(car.getFull());
				this.availableSpaces.acquireUninterruptibly();
				synchronized (this.parkingSpaces) {
					this.parkingSpaces.poll();
				}
			} else {
				System.err.println("empty object");
			}
		} catch (Exception e) {

		}
	}

	/**
	 * Frees the ParkingSpace
	 */
	public void emptySpace(ParkingSpace parkingSpace) {
		synchronized (this.parkingSpaces) {
			this.parkingSpaces.offer(parkingSpace);
		}
		this.availableSpaces.release();

		this.car = null;
		this.setIcon(null);
	}
}