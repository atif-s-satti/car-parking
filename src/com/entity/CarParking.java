package com.entity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;

import com.userInterface.GUI;
import com.util.Commons;


/**
 * CarParking.java Main class to start the application.
 * create the main window 
 * builds the gui
 * and start the working of the application.
 * */

public class CarParking {
	public static void main(String[] args) {
		JFrame mainWindow = new JFrame(Commons.layoutHeader);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setResizable(false);

		GUI base = new GUI();
		base.buildGUI();
		mainWindow.add(base);

		mainWindow.pack();
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setVisible(true);

		ExecutorService executor = Executors.newFixedThreadPool(Commons.totalSpaces);
		for (int i = 0; i < Commons.totalCars; i++) {
			Car car =  new Car();
			executor.execute(car);
		}
		executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.exit(0);
	}
}
