package com.userInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.entity.ParkingSpace;
import com.util.Commons;

/**
 * GUI.java extends JPanel and implements ActionListner and MouseListner,
 * contains the logic to create the GUI for the parking system application.
 */
public class GUI extends JPanel implements MouseListener {

	private static final long serialVersionUID = -559832426919174769L;

	/**
	 * Default Class constructor
	 * 
	 */
	public GUI() {
	}

	/**
	 * Initializes the array of type ParkingSpace with incrementing
	 * indexes
	 */
	private void createSpaces() {
		for (int i = 0; i < Commons.totalSpaces; i++) {
			Commons.parkingSpaces[i] = new ParkingSpace(i, this);
		}
	}

	/**
	 * Implements the core GUI logic for this class
	 * builds the gui
	 */
	public void buildGUI() {
		createSpaces();
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(500, 600));

		ParkingSpacesGrid grid = new ParkingSpacesGrid(Commons.parkingSpaces);
		this.add(grid, BorderLayout.EAST);
	}

	/**
	 * 
	 * Displays the message.
	 * 
	 * @param String message
	 * @param Sting message
	 * */
	public void showMessage(String mOne, String mTwo) {
		JOptionPane.showMessageDialog(this, mOne, mTwo, JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * overriding mouseClicked to handle the mouse click events left click will
	 * display the car details parked at the location right click and scroll button
	 * click will do nothing, 
	 * and for an empty space an information message is
	 * displayed informing that the current space is empty.
	 */

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof ParkingSpace) {
			ParkingSpace currentSelection = (ParkingSpace) e.getSource();
			if (!currentSelection.isEmpty()) {
				if (SwingUtilities.isRightMouseButton(e)) {
					// Do nothing
				} else if (SwingUtilities.isLeftMouseButton(e)) {
					new CarDetails(Commons.parkingSpaces[currentSelection.getIndex()].getCar());
				} else {
					// Do nothing
				}
			} else {
				JOptionPane.showMessageDialog(currentSelection, "This space is empty!", "Space Empty",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
