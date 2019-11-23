package com.userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import com.entity.ParkingSpace;
import com.util.Commons;


/**
 * ParkingGrid.java Class to display all the parking spaces 
 * in the car parking. A total of 50 spaces.
 */
public class ParkingSpacesGrid extends JPanel
{
	private static final long serialVersionUID = -6399606702050848906L;

    /**
     * Class constructor
     * 
     * @param parkingSpaces Array of type ParkingSpace
     */
    public ParkingSpacesGrid(ParkingSpace[] parkingSpaces)
    {
        buildGUI();
    }

    /**
     * Implements the core GUI logic for this class
     */        
    private void buildGUI()
    {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500, 600));    
        buildParkingSpaces();
    }


    /**
     * Builds the parking spaces by taking the 
     * elements from the array parkingSpaces
     */         
    private void buildParkingSpaces()
    {
        JPanel parkingSpaces = new JPanel(new GridLayout(10, 10));
        parkingSpaces.setPreferredSize(new Dimension(500, 600));
        parkingSpaces.setBackground(Color.white);
        
        int i = 0;
        for (int x = 0; x < 5; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                ParkingSpace space = Commons.parkingSpaces[i];
                parkingSpaces.add(space);
                i++;
            }    
        }        
        this.add(parkingSpaces, BorderLayout.SOUTH);
    }
}
