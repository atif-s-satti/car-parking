package com.userInterface;

import java.awt.Dialog;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.entity.Car;
import com.util.Commons;

/**
 * carDetails.java
 * Displays the details of a selected car to the user
 */
public class CarDetails extends JDialog
{
	private static final long serialVersionUID = 1881497567383260716L;
	Car data;
    
    public CarDetails(Car data)
    {     
        this.data = data;
        buildDetailsGUI();        
    }
    
    private void buildDetailsGUI()
    {
        this.setTitle(Commons.carDetailsHeader);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        JPanel padding = new JPanel();
        padding.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JLabel details = new JLabel(this.data.toString());
        padding.add(details);
        
        this.add(padding);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);        
    }

}
