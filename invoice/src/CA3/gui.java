package CA3;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class gui extends JFrame {
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldAddress;
	private JTextField textFieldCountry;
	private JTextField textFieldProductID;
	private JTextField textFieldProductName;
	private JTextField textFieldCost;
	private JTextField textFieldVat;
	private JTextField textFieldOrderID;
	private JTextField textFieldQuantity;
	private JTextField textFieldInvoiceID;
	private JTextField textFieldCustomerID;
	private JTextField textFieldDate;
	private JTextField textFieldCusDelete;
	private JTextField textFieldProductDelete;
	private JTextField textFieldEnterOrderID;
	private JTextField textFieldDateDelete;
	private JTable productTable;
	private JTable customerTable;
	private JTable invoiceTable;
	private JTextField textFieldFirstNameUpdate;
	private JTextField textFieldLastNameUpdate;
	private JTextField textFieldAddressUpdate;
	private JTextField textFieldCountryUpdate;
	private JTextField textFieldCusIDUpdate;
	private JTextField textFieldProductIDUpdate;
	private JTextField textFieldOrderIDUpdate;
	private JTextField textFieldProductNameUpdate;
	private JTextField textFieldProductCostUpdate;
	private JTextField textFieldProductVatUpdate;
	private JTextField textFieldInvoiceIDUpdate;
	private JTextField textFieldCustomerIDUpdate;
	private JTextField textFieldDateUpdate;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private final Action action_6 = new SwingAction_6();
	private final Action action_7 = new SwingAction_7();
	private final Action action_8 = new SwingAction_8();
	private final Action action_9 = new SwingAction_9();
	private final Action action_10 = new SwingAction_10();
	private final Action action_11 = new SwingAction_11();
	int customerID = 0;
	
	
	   public static void main(String[] args) {
			
		   
		
		   EventQueue.invokeLater(new Runnable()
		   {
				public void run()
				{
					try
					{
						gui frame = new gui();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		   
		

	    }//end main


	public gui() {
		
		invoiceDriver don = new invoiceDriver();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300); // sets size of jframe
		
		JMenuBar menuBar = new JMenuBar(); // create new menu usede to select customer,invoice or product
		setJMenuBar(menuBar);
		
		
		JMenu customerMenu = new JMenu("Customer Menu"); //adds customer as a selection to the menu
		customerMenu.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		customerMenu.setBackground(Color.BLACK);
		menuBar.add(customerMenu); // sets size to 10 columns. Same for all text fields and areas
		
		JMenu createCusMenu = new JMenu("Create"); // create option in customer
		customerMenu.add(createCusMenu);
		
		JTextArea txtrFirstName = new JTextArea(); // used to display First name as an input into customer database
		createCusMenu.add(txtrFirstName);
		txtrFirstName.setEditable(false);
		txtrFirstName.setText("First Name");
		txtrFirstName.setColumns(10); // sets size to 10 columns. Same for all text fields and areas
		
		textFieldFirstName = new JTextField(); // input box for first name in create customer
		createCusMenu.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		JTextArea txtrLastName = new JTextArea(); // used to display last name as an input into customer database
		createCusMenu.add(txtrLastName);
		txtrLastName.setText("Last Name");
		txtrLastName.setColumns(10);
		
		textFieldLastName = new JTextField(); // input box for last name in create customer
		createCusMenu.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		JTextArea txtrAddress = new JTextArea(); // used to display address as an input into customer database
		createCusMenu.add(txtrAddress);
		txtrAddress.setText("Address");
		txtrAddress.setColumns(10);
		
		textFieldAddress = new JTextField(); // input box for address in create customer
		createCusMenu.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		JTextArea txtrCountry = new JTextArea();  // used to display country as an input into customer database
		createCusMenu.add(txtrCountry);
		txtrCountry.setText("Country");
		txtrCountry.setColumns(10);
		
		textFieldCountry = new JTextField();  // input box for country in create customer
		createCusMenu.add(textFieldCountry);
		textFieldCountry.setColumns(10);
		
		// customer button submiting to database 
		JButton btnSubmitCreateCustomer = new JButton("Submit");
		btnSubmitCreateCustomer.addActionListener(new ActionListener() { // add listner to button to detect a click
			
			public void actionPerformed(ActionEvent arg0) {
				
				 Connection conn = null; // create new connection
		
					try { // connects to our database if fail throws error
						conn = DriverManager.getConnection(invoiceDriver.DB_URL, invoiceDriver.USER, invoiceDriver.PASS);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    
				    Statement statement = null; // new statment to tell sql what to do
					try {
						statement = conn.createStatement();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					// create string to store what has been added to text fields
					String address = textFieldAddress.getText(); 
					String firstName = textFieldFirstName.getText();
					String lastName = textFieldLastName.getText();	
					String country = textFieldCountry.getText();
					
					try { // excutes inset statement which adds what was inputed in text fields to the database
						statement.executeUpdate("insert into customer value('"+customerID+"','"+firstName+"','"+lastName+"' , '"+address+"' , '"+country+"')");
						
					} catch (SQLException e1) {
						
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				     System.out.println("VALUES INSERTED SUCCESSFULLY");  
				     customerID++; // incremeants customer id as its the primary key and auto incremeants
			}
		});
		createCusMenu.add(btnSubmitCreateCustomer); // adds the submit button to menu panel
		
		JMenu updateCusMenu = new JMenu("Update"); // update option on customer selection
		customerMenu.add(updateCusMenu);
		
		JTextArea txtrCusIDUpdate = new JTextArea(); // used to display customer id as an input needed to select which customer will be updated
		txtrCusIDUpdate.setText("Enter Customer ID");
		txtrCusIDUpdate.setEditable(false);
		txtrCusIDUpdate.setColumns(10);
		updateCusMenu.add(txtrCusIDUpdate);
		
		textFieldCusIDUpdate = new JTextField(); // allows input for customer id
		textFieldCusIDUpdate.setColumns(10);
		updateCusMenu.add(textFieldCusIDUpdate);
	
		JTextArea txtrFirstNameUpdate = new JTextArea(); // used to display first name as an input change in customer database
		txtrFirstNameUpdate.setText("First Name");
		txtrFirstNameUpdate.setEditable(false);
		txtrFirstNameUpdate.setColumns(10);
		updateCusMenu.add(txtrFirstNameUpdate);
		
		textFieldFirstNameUpdate = new JTextField(); // allows input for first name
		textFieldFirstNameUpdate.setColumns(10);
		updateCusMenu.add(textFieldFirstNameUpdate);
		
		JTextArea txtrLastNametUpdate = new JTextArea(); // display last name as option to update cus table
		txtrLastNametUpdate.setText("Last Name");
		txtrLastNametUpdate.setColumns(10);
		updateCusMenu.add(txtrLastNametUpdate);
		
		textFieldLastNameUpdate = new JTextField(); // allows user to input new last name of customer
		textFieldLastNameUpdate.setColumns(10);
		updateCusMenu.add(textFieldLastNameUpdate);
		
		JTextArea txtrAddressUpdate = new JTextArea(); // display address as option to update customer table
		txtrAddressUpdate.setText("Address");
		txtrAddressUpdate.setColumns(10);
		updateCusMenu.add(txtrAddressUpdate);
		
		textFieldAddressUpdate = new JTextField(); // allows to user to input new address of customer
		textFieldAddressUpdate.setColumns(10);
		updateCusMenu.add(textFieldAddressUpdate);
		
		JTextArea txtrCountryUpdate = new JTextArea(); // displays country as an option to update customer
		txtrCountryUpdate.setText("Country");
		txtrCountryUpdate.setColumns(10);
		updateCusMenu.add(txtrCountryUpdate);
		
		textFieldCountryUpdate = new JTextField(); // allows user to input an update to customers country
		textFieldCountryUpdate.setColumns(10);
		updateCusMenu.add(textFieldCountryUpdate);
		
		// customer update submit button
		JButton btnSubmit_1_1_1_5 = new JButton("Submit");
		btnSubmit_1_1_1_5.addActionListener(new ActionListener() { // adds action listener to update screen
			public void actionPerformed(ActionEvent e) {
					
					 Connection conn = null; // creates connection
						
						try { // sets connection up to connect to our databse
							conn = DriverManager.getConnection(invoiceDriver.DB_URL, invoiceDriver.USER, invoiceDriver.PASS);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					    
					    Statement statement = null; // creates new empty statement query
						try {
							statement = conn.createStatement();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// set up strings to take from text fields for update
						String cusID = textFieldCusIDUpdate.getText();
						String address = textFieldAddressUpdate.getText();
						String firstName = textFieldFirstNameUpdate.getText();
						String lastName = textFieldLastNameUpdate.getText();	
						String country = textFieldCountryUpdate.getText();
						
						try { // query into database to update customer // throws error if fail
							statement.executeUpdate("UPDATE customer set firstname='"+firstName+"',lastname='"+lastName+"' ,address= '"+address+"' ,country= '"+country+"' where customerid='"+cusID+"' " );
							
						} catch (SQLException e1) {
							
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					     System.out.println("VALUES Updated SUCCESSFULLY");  
				}

		});
		btnSubmit_1_1_1_5.setAction(action);
		updateCusMenu.add(btnSubmit_1_1_1_5); 
		
		JMenu deleteCusMenu = new JMenu("Delete"); // displays delete as an option in customer
		customerMenu.add(deleteCusMenu);
		
		JTextArea txtrCusDelete = new JTextArea(); // displays enter cus id to user
		txtrCusDelete.setText("Enter Customer ID");
		txtrCusDelete.setEditable(false);
		txtrCusDelete.setColumns(10);
		deleteCusMenu.add(txtrCusDelete);
		
		textFieldCusDelete = new JTextField(); // takes customer id as customer to delete from database
		textFieldCusDelete.setColumns(10);
		deleteCusMenu.add(textFieldCusDelete);
		
		JButton btnSubmitCusDelete = new JButton("Submit");
		btnSubmitCusDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Connection conn = null; // creates new connection
				
				try { // sets up connection to our databse
					conn = DriverManager.getConnection(invoiceDriver.DB_URL, invoiceDriver.USER, invoiceDriver.PASS);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    // statement creation
			    Statement statement = null;
				try {
					statement = conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// set up string set to customer id textbox
				String customerID = textFieldCusDelete.getText();
				String query = "DELETE FROM customer WHERE customerid = " + customerID;
				// set up query into the database
				try {
					statement.executeUpdate(query);
					
				} catch (SQLException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			     System.out.println("VALUES DELETED SUCCESSFULLY");  
			}
		});
				
		btnSubmitCusDelete.setAction(action_1);
		deleteCusMenu.add(btnSubmitCusDelete);
		
		JMenu mnProductMenu = new JMenu("Product Menu"); // set up product menu as an option 
		mnProductMenu.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		menuBar.add(mnProductMenu);
		
		JMenu createProductMenu = new JMenu("Create"); // display create as an option in the product menu
		mnProductMenu.add(createProductMenu);
		
		JTextArea txtrProductID = new JTextArea(); // display product id as an option to input
		txtrProductID.setText("Product ID");
		txtrProductID.setEditable(false);
		txtrProductID.setColumns(10);
		createProductMenu.add(txtrProductID);
		
		textFieldProductID = new JTextField(); // gets product id as input
		textFieldProductID.setColumns(10);
		createProductMenu.add(textFieldProductID);
		
		JTextArea txtrProductName = new JTextArea(); // displays name as option
		txtrProductName.setText("Name");
		txtrProductName.setColumns(10);
		createProductMenu.add(txtrProductName);
		
		textFieldProductName = new JTextField(); // gets name input from user
		textFieldProductName.setColumns(10);
		createProductMenu.add(textFieldProductName);
		
		JTextArea txtrCost = new JTextArea(); // displays cost as option
		txtrCost.setText("Cost");
		txtrCost.setColumns(10);
		createProductMenu.add(txtrCost);
		
		textFieldCost = new JTextField(); // gets cost as input
		textFieldCost.setColumns(10);
		createProductMenu.add(textFieldCost);
		
		JTextArea txtrVat = new JTextArea(); // displays vat as option
		txtrVat.setText("Vat");
		txtrVat.setColumns(10);
		createProductMenu.add(txtrVat);
		
		textFieldVat = new JTextField(); // gets vat as input
		textFieldVat.setColumns(10);
		createProductMenu.add(textFieldVat);
		
		JButton btnSubmitCreateProduct = new JButton("Submit");
		
		btnSubmitCreateProduct.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				
				 Connection conn = null; // new connection
				
				try { // sets up connection to connect to our database
					conn = DriverManager.getConnection(invoiceDriver.DB_URL, invoiceDriver.USER, invoiceDriver.PASS);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    // new null statment
			    Statement statement = null;
				try { // set up statement
					statement = conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// set up strings to take input from text fields
				String productName = textFieldProductName.getText();
				String cost = textFieldCost.getText();
				String vat = textFieldVat.getText();
				String productID = textFieldProductID.getText();
				
				try { // insert query into product database
					statement.executeUpdate("insert into product value('"+productID+"','"+productName+"' , '"+cost+"' , '"+vat+"')");
				} catch (SQLException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			     System.out.println("VALUES INSERTED SUCCESSFULLY");  
			}
		});
		
		btnSubmitCreateProduct.setAction(action_2);
		createProductMenu.add(btnSubmitCreateProduct);
		
		JMenu updateProductMenu = new JMenu("Update"); // displays update as option in product menu
		mnProductMenu.add(updateProductMenu);
		
		JTextArea txtrProductIDUpdate = new JTextArea(); // adds enter product id as option 
		txtrProductIDUpdate.setText("Enter Product ID");
		txtrProductIDUpdate.setEditable(false);
		txtrProductIDUpdate.setColumns(10);
		updateProductMenu.add(txtrProductIDUpdate);
		
		textFieldProductIDUpdate = new JTextField(); // takes product id as input
		textFieldProductIDUpdate.setColumns(10);
		updateProductMenu.add(textFieldProductIDUpdate);
		
		JTextArea txtrProductNameUpdate = new JTextArea(); // displays name as option to input
		txtrProductNameUpdate.setText("Name");
		txtrProductNameUpdate.setColumns(10);
		updateProductMenu.add(txtrProductNameUpdate);
		
		textFieldProductNameUpdate = new JTextField(); // takes input for product name
		textFieldProductNameUpdate.setColumns(10);
		updateProductMenu.add(textFieldProductNameUpdate);
		
		JTextArea txtrProductCostUpdate = new JTextArea(); // displays cost as option
		txtrProductCostUpdate.setText("Cost");
		txtrProductCostUpdate.setColumns(10);
		updateProductMenu.add(txtrProductCostUpdate);
		
		textFieldProductCostUpdate = new JTextField(); // gets cost as input
		textFieldProductCostUpdate.setColumns(10);
		updateProductMenu.add(textFieldProductCostUpdate);
		
		JTextArea txtrProductVatUpdate = new JTextArea(); // displays vat as option
		txtrProductVatUpdate.setText("Vat");
		txtrProductVatUpdate.setColumns(10);
		updateProductMenu.add(txtrProductVatUpdate);
		
		textFieldProductVatUpdate = new JTextField(); // takes vat as input on update screen
		textFieldProductVatUpdate.setColumns(10);
		updateProductMenu.add(textFieldProductVatUpdate);
		
		JButton btnSubmitProductUpdate = new JButton("Submit");  // update product
		btnSubmitProductUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Connection conn = null; // creates new connection
					
					try { // sets up connection to our database
						conn = DriverManager.getConnection(invoiceDriver.DB_URL, invoiceDriver.USER, invoiceDriver.PASS);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    // new statement 
				    Statement statement = null;
					try {
						statement = conn.createStatement();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// sets up new strings to take input from update text fields
					String productName = textFieldProductNameUpdate.getText();
					String cost = textFieldProductCostUpdate.getText();
					String vat = textFieldProductVatUpdate.getText();
					String productID = textFieldProductIDUpdate.getText();
					
					try { // executes query
						statement.executeUpdate("UPDATE product set name='"+productName+"',cost='"+cost+"' ,vat= '"+vat+"'where productid='"+productID+"' " );
					} catch (SQLException e1) {
						
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				     System.out.println("Product VALUES Updated SUCCESSFULLY");  
			}
				
			
		});
		btnSubmitProductUpdate.setAction(action_3);
		updateProductMenu.add(btnSubmitProductUpdate);
		
		JMenu deleteProductMenu = new JMenu("Delete"); // displays delete as option on product menu
		mnProductMenu.add(deleteProductMenu);
		
		JTextArea txtrProductDelete = new JTextArea(); // displays product id as option
		txtrProductDelete.setText("Enter Product ID");
		txtrProductDelete.setEditable(false);
		txtrProductDelete.setColumns(10);
		deleteProductMenu.add(txtrProductDelete);
		
		textFieldProductDelete = new JTextField(); // takes product id as input
		textFieldProductDelete.setColumns(10);
		deleteProductMenu.add(textFieldProductDelete);
		
		JButton btnSubmitProductDelete = new JButton("Submit");
		btnSubmitProductDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			Connection conn = null; // new connection
				
				try { // sets up connection to our database
					conn = DriverManager.getConnection(invoiceDriver.DB_URL, invoiceDriver.USER, invoiceDriver.PASS);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    // sets up statement
			    Statement statement = null;
				try { // assigns statement
					statement = conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// set up string to get product id input
				String productID = textFieldProductDelete.getText();
				String query = "DELETE FROM product WHERE productid = " + productID;
				// set up query to delete from product database 
				try {
					statement.executeUpdate(query);
					
				} catch (SQLException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			     System.out.println("VALUES DELETED SUCCESSFULLY");  
			}
				
			
		});
		
		btnSubmitProductDelete.setAction(action_4);
		deleteProductMenu.add(btnSubmitProductDelete);
		
		JMenu mnInvoiceMenu = new JMenu("Invoice Menu"); // adds invoice to menu 
		mnInvoiceMenu.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		menuBar.add(mnInvoiceMenu);
		
		JMenu createInvoiceMenu = new JMenu("Create"); // adds create to invoice menu
		mnInvoiceMenu.add(createInvoiceMenu);
		
		JTextArea txtrInvoice = new JTextArea(); // adds invoice id as option in create menu
		txtrInvoice.setText("Invoice ID");
		txtrInvoice.setEditable(false);
		txtrInvoice.setColumns(10);
		createInvoiceMenu.add(txtrInvoice);
		
		textFieldInvoiceID = new JTextField(); // gets invoice id as input from text field
		textFieldInvoiceID.setColumns(10);
		createInvoiceMenu.add(textFieldInvoiceID);
		
		JTextArea txtrCustomerID = new JTextArea(); // displays customer id as option
		txtrCustomerID.setText("Customer ID");
		txtrCustomerID.setColumns(10);
		createInvoiceMenu.add(txtrCustomerID);
		
		textFieldCustomerID = new JTextField(); // gets customer id as input
		textFieldCustomerID.setColumns(10);
		createInvoiceMenu.add(textFieldCustomerID);
		
		JTextArea txtrDate = new JTextArea(); // displays data as option to input
		txtrDate.setText("Date");
		txtrDate.setColumns(10);
		createInvoiceMenu.add(txtrDate);
		
		textFieldDate = new JTextField(); // gets date as input from text field
		textFieldDate.setColumns(10);
		createInvoiceMenu.add(textFieldDate);
		
		JButton btnSubmitCreateInvoice = new JButton("Submit");
		btnSubmitCreateInvoice.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					
				 Connection conn = null; // new connection
					
					try { // assigns connection to connect to our database
						conn = DriverManager.getConnection(invoiceDriver.DB_URL, invoiceDriver.USER, invoiceDriver.PASS);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    // new statement
				    Statement statement = null;
					try { // assigns statement
						statement = conn.createStatement();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// sets up strings to store input from text fields
					String invoiceID = textFieldInvoiceID.getText();
					String customerID = textFieldCustomerID.getText();
					String date = textFieldDate.getText();
					
					try { // query into database to insert into invoice                                                             // needs to be foreign key / from customer database
						statement.executeUpdate("insert into invoice value('"+invoiceID+"','"+customerID+"','"+date+"')");
					} catch (SQLException e1) {
						// "insert into customer value('"+customerID+"','"+firstName+"','"+lastName+"' , '"+address+"' , '"+country+"')");
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				     System.out.println("Product VALUES INSERTED SUCCESSFULLY");  
			}
		});
		btnSubmitCreateInvoice.setAction(action_8);
		createInvoiceMenu.add(btnSubmitCreateInvoice);
		
		JMenu updateInvoiceMenu = new JMenu("Update"); // adds update as option to invoice menu
		mnInvoiceMenu.add(updateInvoiceMenu);
		
		JTextArea txtrInvoiceIDUpdate = new JTextArea(); // displays invoice id as option
		txtrInvoiceIDUpdate.setText("Enter Invoice ID");
		txtrInvoiceIDUpdate.setEditable(false);
		txtrInvoiceIDUpdate.setColumns(10);
		updateInvoiceMenu.add(txtrInvoiceIDUpdate);
		
		textFieldInvoiceIDUpdate = new JTextField(); // gets invoice id input from text field 
		textFieldInvoiceIDUpdate.setColumns(10);
		updateInvoiceMenu.add(textFieldInvoiceIDUpdate);
		
		JTextArea txtrCustomerIDUpdate = new JTextArea(); // displays customer id as option
		txtrCustomerIDUpdate.setText("Customer ID");
		txtrCustomerIDUpdate.setColumns(10);
		updateInvoiceMenu.add(txtrCustomerIDUpdate);
		
		textFieldCustomerIDUpdate = new JTextField(); // gets customer id as input from text field
		textFieldCustomerIDUpdate.setColumns(10);
		updateInvoiceMenu.add(textFieldCustomerIDUpdate);
		
		JTextArea txtrDateUpdate = new JTextArea(); // displays date as option
		txtrDateUpdate.setText("Date");
		txtrDateUpdate.setColumns(10);
		updateInvoiceMenu.add(txtrDateUpdate);
		
		textFieldDateUpdate = new JTextField(); // gets date as input from text field
		textFieldDateUpdate.setColumns(10);
		updateInvoiceMenu.add(textFieldDateUpdate);
		
		// update invoice button
		JButton btnSubmit_1_1_1_3_1 = new JButton("Submit");
		btnSubmit_1_1_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					 Connection conn = null; // creates new connection
						
						try { // sets up connection to our database
							conn = DriverManager.getConnection(invoiceDriver.DB_URL, invoiceDriver.USER, invoiceDriver.PASS);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					    // new statement 
					    Statement statement = null;
						try {
							statement = conn.createStatement();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// sets up new strings to take input from update text fields
						String invoiceID = textFieldInvoiceIDUpdate.getText();
						String customerID = textFieldCustomerIDUpdate.getText();
						String date = textFieldDateUpdate.getText();
						
						try { // executes query
							statement.executeUpdate("UPDATE invoice set customerid='"+customerID+"' ,date= '"+date+"'where invoiceid='"+invoiceID+"' " );
						} catch (SQLException e1) {
							
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					     System.out.println("Product VALUES Updated SUCCESSFULLY");  
				}
					
				
			
		});
		btnSubmit_1_1_1_3_1.setAction(action_9);
		updateInvoiceMenu.add(btnSubmit_1_1_1_3_1);
		
		JMenu deleteInvoiceMenu = new JMenu("Delete"); // adds delete as option in invoice menu
		mnInvoiceMenu.add(deleteInvoiceMenu);
		
		JTextArea txtrInvoiceIDDelete = new JTextArea(); // displays invoice id as option to delete invoice
		txtrInvoiceIDDelete.setText("Enter Invoice ID");
		txtrInvoiceIDDelete.setEditable(false);
		txtrInvoiceIDDelete.setColumns(10);
		deleteInvoiceMenu.add(txtrInvoiceIDDelete);
		
		textFieldDateDelete = new JTextField(); // gets invoice id to delete from invoice
		textFieldDateDelete.setColumns(10);
		deleteInvoiceMenu.add(textFieldDateDelete);
		
		JButton btnSubmitInvoiceDelete = new JButton("Submit");
		btnSubmitInvoiceDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = null; // new connection
				
				try { // assigns connection to connect to database
					conn = DriverManager.getConnection(invoiceDriver.DB_URL, invoiceDriver.USER, invoiceDriver.PASS);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    // new null statement
			    Statement statement = null;
				try { // assigns statement
					statement = conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// set up invoice id string to get text from textfeild when sumbit button is clicked
				String invoiceID = textFieldDateDelete.getText();
				String query = "DELETE FROM invoice WHERE invoiceid = " + invoiceID;
				// set up delete query to be executed
				try {
					statement.executeUpdate(query);
					
				} catch (SQLException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			     System.out.println("VALUES DELETED SUCCESSFULLY");  
			}
				
		});
		
		btnSubmitInvoiceDelete.setAction(action_11);
		deleteInvoiceMenu.add(btnSubmitInvoiceDelete);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 218);
		getContentPane().add(tabbedPane);
		
		JPanel customerPanel = new JPanel(); // displays ceiw customer to show customer database panel
		tabbedPane.addTab("Veiw Customer Database", null, customerPanel, null);
		
		customerTable = new JTable();
		customerTable.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		customerTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
	
		
		try { // calls fill table method to fill customer table
			FillTable(customerTable, "SELECT * FROM customer;");
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		customerPanel.add(customerTable); // adds customer table to panel
		
		JButton btnRefreash = new JButton("Refreash"); // allows user to refresh table to see new results
		btnRefreash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					FillTable(customerTable, "SELECT * FROM customer;");
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}

		});
		customerPanel.add(btnRefreash);
		
		JPanel invoicePanel = new JPanel(); 
		tabbedPane.addTab("Veiw Invoice Database", null, invoicePanel, null);
		
		invoiceTable = new JTable(); // creates new table for invoice
		invoiceTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		invoiceTable.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		// fills invoice table
		try { // calls fill table method to fill invoice table
			FillTable(invoiceTable, "SELECT * FROM invoice;");
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		invoicePanel.add(invoiceTable); // adds invoice table to panel
		
		// invoice refresh button
		
		JButton btnRefreashInvoice = new JButton("Refreash"); // allows user to refresh table
		btnRefreashInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					FillTable(invoiceTable, "SELECT * FROM invoice;");
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}

		});
		invoicePanel.add(btnRefreashInvoice);
		
	
		JPanel productPanel = new JPanel();
		tabbedPane.addTab("Veiw Product Database", null, productPanel, null);
		//
		// create and fill product table
		//
		productTable = new JTable();
		productTable.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		productTable.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"New column", "New column", "New column", "New column"
				}
			));
		
		try {
			FillTable(productTable, "SELECT * FROM product;");
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		productPanel.add(productTable);
		
		// refresh button for product
		
		JButton btnRefreashProduct = new JButton("Refreash");
		btnRefreashProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					FillTable(productTable, "SELECT * FROM product;");
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}

		});
		productPanel.add(btnRefreashProduct);
		

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_7 extends AbstractAction {
		public SwingAction_7() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_8 extends AbstractAction {
		public SwingAction_8() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_9 extends AbstractAction {
		public SwingAction_9() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_10 extends AbstractAction {
		public SwingAction_10() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_11 extends AbstractAction {
		public SwingAction_11() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	// fills any tabel given table name and select from table query
	 public void FillTable(JTable table, String Query) throws InstantiationException, IllegalAccessException
     {
		// set up database connection
         try
         {
        	 Connection conn = null;
        		
     		try {
     			conn = DriverManager.getConnection(invoiceDriver.DB_URL, invoiceDriver.USER, invoiceDriver.PASS);
     			
     		} catch (SQLException e1) {
     			// TODO Auto-generated catch block
     			e1.printStackTrace();
     		}
     	    
     	    Statement statement = null;
     		try {
     			statement = conn.createStatement();
     			
     		} catch (SQLException e1) {
     			// TODO Auto-generated catch block
     			e1.printStackTrace();
     		}
     		
     		 ResultSet rs = statement.executeQuery(Query);
             while(table.getRowCount() > 0) // while there is still more rows of the table
             {
            	
                 ((DefaultTableModel) table.getModel()).removeRow(0);
             }
             int columns = rs.getMetaData().getColumnCount();
             while(rs.next())
             {  
            	 
                 Object[] row = new Object[columns];
                 for (int i = 1; i <= columns; i++)
                 {  
                     row[i - 1] = rs.getObject(i);
                 }
                 ((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row);
             }
         
            rs.close();
             statement.close();
             conn.close();
         }
         catch(SQLException e)
         {
         }
     }   
}
