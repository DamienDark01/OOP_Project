/*
 * Class Name : NewLaboratoryWindow
 * GUI class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : 
 * Author Reg No :
 */

// package
package project;

// imports
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

// class implementation
public class EditLaboratoryWindow {

	// properties
	private JFrame frmAddValues;
	private JTextField txtId, txtLocation, txtPurpose;
	private JLabel lblHeader, lblId, lblLocation, lblPurpose, lblName1, lblName2, lblName3;
	private JButton btnEnterDetails;
	private JTextArea txtResult;
	private JPanel panelLogo, panelLogo2;
	private JButton btnNext;
	private ArrayList<Laboratory> list;
	private int currentIndex;
	private JTextField txtFName;
	private JTextField txtLName;

	/**
	 * Create the application.
	 */
	public EditLaboratoryWindow(ArrayList<Laboratory> list) {
		this.list = list;
		this.currentIndex = 0;
		initialize();
		addDetails();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddValues = new JFrame();
		frmAddValues.setTitle("Add values");
		frmAddValues.setVisible(true);
		frmAddValues.setResizable(false);
		frmAddValues.setBounds(10, 10, 650, 700);
		frmAddValues.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddValues.getContentPane().setLayout(null);
		
		lblHeader = new JLabel("Edit values in Laboratory");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblHeader.setBounds(10, 11, 395, 50);
		frmAddValues.getContentPane().add(lblHeader);
		
		lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(69, 72, 106, 39);
		frmAddValues.getContentPane().add(lblId);
		
		lblPurpose = new JLabel("Purpose :");
		lblPurpose.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblPurpose.setBounds(69, 122, 106, 39);
		frmAddValues.getContentPane().add(lblPurpose);
		
		lblLocation = new JLabel("Location :");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLocation.setBounds(69, 172, 125, 39);
		frmAddValues.getContentPane().add(lblLocation);
		
		btnEnterDetails = new JButton("Enter Details");
		btnEnterDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String fName = txtFName.getText();
				String lName = txtLName.getText();
				String location = txtLocation.getText();
				String purpose = txtPurpose.getText();
				
				int editedEntries = LaboratoryDao.getEditConfirmation(id, purpose, location, fName, lName);
				
				txtResult.setText("Edited " + editedEntries + "...");
			}
		});
		btnEnterDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnterDetails.setBounds(115, 509, 138, 39);
		frmAddValues.getContentPane().add(btnEnterDetails);
		
		txtResult = new JTextArea();
		txtResult.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtResult.setText("Result...");
		txtResult.setBounds(115, 559, 407, 50);
		frmAddValues.getContentPane().add(txtResult);
		
		panelLogo = new JPanel();
		panelLogo.setLayout(null);
		panelLogo.setBackground(Color.BLACK);
		panelLogo.setBounds(534, 0, 100, 100);
		frmAddValues.getContentPane().add(panelLogo);
		
		panelLogo2 = new JPanel();
		panelLogo2.setLayout(null);
		panelLogo2.setBounds(15, 15, 65, 65);
		panelLogo.add(panelLogo2);
		
		lblName1 = new JLabel("Western");
		lblName1.setBounds(2, 0, 46, 14);
		panelLogo2.add(lblName1);
		
		lblName2 = new JLabel("High");
		lblName2.setBounds(2, 11, 46, 14);
		panelLogo2.add(lblName2);
		
		lblName3 = new JLabel("School");
		lblName3.setBounds(2, 25, 46, 14);
		panelLogo2.add(lblName3);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setColumns(10);
		txtId.setBounds(115, 77, 290, 34);
		frmAddValues.getContentPane().add(txtId);
		
		txtPurpose = new JTextField();
		txtPurpose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPurpose.setColumns(10);
		txtPurpose.setBounds(173, 127, 290, 34);
		frmAddValues.getContentPane().add(txtPurpose);
		
		txtLocation = new JTextField();
		txtLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLocation.setColumns(10);
		txtLocation.setBounds(173, 172, 290, 34);
		frmAddValues.getContentPane().add(txtLocation);
		
		btnNext = new JButton("Next Entry");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentIndex++;
				
				if (currentIndex < list.size()) {
					addDetails();
				} else {
					txtResult.setText("All entries are edited...");
				}				
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNext.setBounds(384, 509, 138, 39);
		frmAddValues.getContentPane().add(btnNext);
		
		JLabel lblFName = new JLabel("Teacher Name (First) :");
		lblFName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblFName.setBounds(69, 222, 243, 39);
		frmAddValues.getContentPane().add(lblFName);
		
		txtFName = new JTextField();
		txtFName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFName.setColumns(10);
		txtFName.setBounds(301, 227, 290, 34);
		frmAddValues.getContentPane().add(txtFName);
		
		JLabel lblLName = new JLabel("Teacher Name (Last) :");
		lblLName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLName.setBounds(69, 272, 243, 39);
		frmAddValues.getContentPane().add(lblLName);
		
		txtLName = new JTextField();
		txtLName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLName.setColumns(10);
		txtLName.setBounds(301, 277, 290, 34);
		frmAddValues.getContentPane().add(txtLName);
	}
	
	private void addDetails() {
        if (currentIndex >= 0 && currentIndex < list.size()) {
            Laboratory lab = list.get(currentIndex);
            
            txtId.setText(lab.getId());
            txtLocation.setText(lab.getLocation());
            txtPurpose.setText(lab.getPurpose());
            txtFName.setText(lab.getTeacher().getFirstName());
            txtLName.setText(lab.getTeacher().getLastName());
            
            txtResult.setText("Editing entry " + (currentIndex + 1) + " of " + list.size() + "...");
        }
    }
}