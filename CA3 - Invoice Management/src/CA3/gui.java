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
	private JTable orderTable;
	private JTextField textFieldFirstNameUpdate;
	private JTextField textFieldLastNameUpdate;
	private JTextField textFieldAddressUpdate;
	private JTextField textFieldCountryUpdate;
	private JTextField textFieldCusIDUpdate;
	private JTextField textFieldProductIDUpdate;
	private JTextField textFieldOrderIDUpdate;
	private JTextField textFieldNameUpdate;
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
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		JMenu customerMenu = new JMenu("Customer Menu");
		customerMenu.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		customerMenu.setBackground(Color.BLACK);
		menuBar.add(customerMenu);
		
		JMenu createCusMenu = new JMenu("Create");
		customerMenu.add(createCusMenu);
		
		JTextArea txtrFirstName = new JTextArea();
		createCusMenu.add(txtrFirstName);
		txtrFirstName.setEditable(false);
		txtrFirstName.setText("First Name");
		txtrFirstName.setColumns(10);
		
		textFieldFirstName = new JTextField();
		createCusMenu.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		JTextArea txtrLastName = new JTextArea();
		createCusMenu.add(txtrLastName);
		txtrLastName.setText("Last Name");
		txtrLastName.setColumns(10);
		
		textFieldLastName = new JTextField();
		createCusMenu.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		JTextArea txtrAddress = new JTextArea();
		createCusMenu.add(txtrAddress);
		txtrAddress.setText("Address");
		txtrAddress.setColumns(10);
		
		textFieldAddress = new JTextField();
		createCusMenu.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		JTextArea txtrCountry = new JTextArea();
		createCusMenu.add(txtrCountry);
		txtrCountry.setText("Country");
		txtrCountry.setColumns(10);
		
		textFieldCountry = new JTextField();
		createCusMenu.add(textFieldCountry);
		textFieldCountry.setColumns(10);
		
		// customer button submiting to database 
		JButton btnSubmitCreateCustomer = new JButton("Submit");
		btnSubmitCreateCustomer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
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
					
					int customerID = 11;
					String address = textFieldAddress.getText();
					String firstName = textFieldFirstName.getText();
					String lastName = textFieldLastName.getText();	
					String country = textFieldCountry.getText();
					
					try {
						statement.executeUpdate("insert into customer value('"+customerID+"','"+firstName+"','"+lastName+"' , '"+address+"' , '"+country+"')");
						
					} catch (SQLException e1) {
						
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				     System.out.println("VALUES INSERTED SUCCESSFULLY");  
			}
		});
		createCusMenu.add(btnSubmitCreateCustomer);
		
		JMenu updateCusMenu = new JMenu("Update");
		customerMenu.add(updateCusMenu);
		
		JTextArea txtrCusIDUpdate = new JTextArea();
		txtrCusIDUpdate.setText("Enter Customer ID");
		txtrCusIDUpdate.setEditable(false);
		txtrCusIDUpdate.setColumns(10);
		updateCusMenu.add(txtrCusIDUpdate);
		
		textFieldCusIDUpdate = new JTextField();
		textFieldCusIDUpdate.setColumns(10);
		updateCusMenu.add(textFieldCusIDUpdate);
		
		JButton btnEnter = new JButton("Update");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
					
					String cusID = textFieldCusIDUpdate.getText();
					String address = textFieldAddress.getText();
					String firstName = textFieldFirstName.getText();
					String lastName = textFieldLastName.getText();	
					String country = textFieldCountry.getText();
					
					try {
						statement.executeUpdate("update customer set customerid='"+cusID+"','"+firstName+"','"+lastName+"' , '"+address+"' , '"+country+"' where customerid='"+cusID+"' " );
						
					} catch (SQLException e1) {
						
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				     System.out.println("VALUES Updated SUCCESSFULLY");  
			}
				
			}
		);
		updateCusMenu.add(btnEnter);
		
		JTextArea txtrFirstNameUpdate = new JTextArea();
		txtrFirstNameUpdate.setText("First Name");
		txtrFirstNameUpdate.setEditable(false);
		txtrFirstNameUpdate.setColumns(10);
		updateCusMenu.add(txtrFirstNameUpdate);
		
		textFieldFirstNameUpdate = new JTextField();
		textFieldFirstNameUpdate.setColumns(10);
		updateCusMenu.add(textFieldFirstNameUpdate);
		
		JTextArea txtrLastNametUpdate = new JTextArea();
		txtrLastNametUpdate.setText("Last Name");
		txtrLastNametUpdate.setColumns(10);
		updateCusMenu.add(txtrLastNametUpdate);
		
		textFieldLastNameUpdate = new JTextField();
		textFieldLastNameUpdate.setColumns(10);
		updateCusMenu.add(textFieldLastNameUpdate);
		
		JTextArea txtrAddressUpdate = new JTextArea();
		txtrAddressUpdate.setText("Address");
		txtrAddressUpdate.setColumns(10);
		updateCusMenu.add(txtrAddressUpdate);
		
		textFieldAddressUpdate = new JTextField();
		textFieldAddressUpdate.setColumns(10);
		updateCusMenu.add(textFieldAddressUpdate);
		
		JTextArea txtrCountryUpdate = new JTextArea();
		txtrCountryUpdate.setText("Country");
		txtrCountryUpdate.setColumns(10);
		updateCusMenu.add(txtrCountryUpdate);
		
		textFieldCountryUpdate = new JTextField();
		textFieldCountryUpdate.setColumns(10);
		updateCusMenu.add(textFieldCountryUpdate);
		
		// customer update submit button
		JButton btnSubmit_1_1_1_5 = new JButton("Submit");
		btnSubmit_1_1_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String country = textFieldCountryUpdate.getText();
				String address = textFieldAddressUpdate.getText();
				String firstName = textFieldFirstNameUpdate.getText();
				String lastName = textFieldLastNameUpdate.getText();
				
			}
		});
		btnSubmit_1_1_1_5.setAction(action);
		updateCusMenu.add(btnSubmit_1_1_1_5);
		
		JMenu deleteCusMenu = new JMenu("Delete");
		customerMenu.add(deleteCusMenu);
		
		JTextArea txtrCusDelete = new JTextArea();
		txtrCusDelete.setText("Enter Customer ID");
		txtrCusDelete.setEditable(false);
		txtrCusDelete.setColumns(10);
		deleteCusMenu.add(txtrCusDelete);
		
		textFieldCusDelete = new JTextField();
		textFieldCusDelete.setColumns(10);
		deleteCusMenu.add(textFieldCusDelete);
		
		JButton btnSubmitCusDelete = new JButton("Submit");
		btnSubmitCusDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
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
				
				String customerID = textFieldCusDelete.getText();
				String query = "DELETE FROM customer WHERE customerid = " + customerID;
				
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
		
		JMenu mnProductMenu = new JMenu("Product Menu");
		mnProductMenu.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		menuBar.add(mnProductMenu);
		
		JMenu createProductMenu = new JMenu("Create");
		mnProductMenu.add(createProductMenu);
		
		JTextArea txtrProductID = new JTextArea();
		txtrProductID.setText("Product ID");
		txtrProductID.setEditable(false);
		txtrProductID.setColumns(10);
		createProductMenu.add(txtrProductID);
		
		textFieldProductID = new JTextField();
		textFieldProductID.setColumns(10);
		createProductMenu.add(textFieldProductID);
		
		JTextArea txtrProductName = new JTextArea();
		txtrProductName.setText("Name");
		txtrProductName.setColumns(10);
		createProductMenu.add(txtrProductName);
		
		textFieldProductName = new JTextField();
		textFieldProductName.setColumns(10);
		createProductMenu.add(textFieldProductName);
		
		JTextArea txtrCost = new JTextArea();
		txtrCost.setText("Cost");
		txtrCost.setColumns(10);
		createProductMenu.add(txtrCost);
		
		textFieldCost = new JTextField();
		textFieldCost.setColumns(10);
		createProductMenu.add(textFieldCost);
		
		JTextArea txtrVat = new JTextArea();
		txtrVat.setText("Vat");
		txtrVat.setColumns(10);
		createProductMenu.add(txtrVat);
		
		textFieldVat = new JTextField();
		textFieldVat.setColumns(10);
		createProductMenu.add(textFieldVat);
		
		JButton btnSubmitCreateProduct = new JButton("Submit");
		
		btnSubmitCreateProduct.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				
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
				
				String productName = textFieldProductName.getText();
				String cost = textFieldCost.getText();
				String vat = textFieldVat.getText();
				String productID = textFieldProductID.getText();
				
				try {
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
		
		JMenu updateProductMenu = new JMenu("Update");
		mnProductMenu.add(updateProductMenu);
		
		JTextArea txtrProductIDUpdate = new JTextArea();
		txtrProductIDUpdate.setText("Enter Product ID");
		txtrProductIDUpdate.setEditable(false);
		txtrProductIDUpdate.setColumns(10);
		updateProductMenu.add(txtrProductIDUpdate);
		
		textFieldProductIDUpdate = new JTextField();
		textFieldProductIDUpdate.setColumns(10);
		updateProductMenu.add(textFieldProductIDUpdate);
		
		JTextArea txtrProductNameUpdate = new JTextArea();
		txtrProductNameUpdate.setText("Name");
		txtrProductNameUpdate.setColumns(10);
		updateProductMenu.add(txtrProductNameUpdate);
		
		textFieldNameUpdate = new JTextField();
		textFieldNameUpdate.setColumns(10);
		updateProductMenu.add(textFieldNameUpdate);
		
		JTextArea txtrProductCostUpdate = new JTextArea();
		txtrProductCostUpdate.setText("Cost");
		txtrProductCostUpdate.setColumns(10);
		updateProductMenu.add(txtrProductCostUpdate);
		
		textFieldProductCostUpdate = new JTextField();
		textFieldProductCostUpdate.setColumns(10);
		updateProductMenu.add(textFieldProductCostUpdate);
		
		JTextArea txtrProductVatUpdate = new JTextArea();
		txtrProductVatUpdate.setText("Vat");
		txtrProductVatUpdate.setColumns(10);
		updateProductMenu.add(txtrProductVatUpdate);
		
		textFieldProductVatUpdate = new JTextField();
		textFieldProductVatUpdate.setColumns(10);
		updateProductMenu.add(textFieldProductVatUpdate);
		
		JButton btnSubmitProductUpdate = new JButton("Submit");
		btnSubmitProductUpdate.setAction(action_3);
		updateProductMenu.add(btnSubmitProductUpdate);
		
		JMenu deleteProductMenu = new JMenu("Delete");
		mnProductMenu.add(deleteProductMenu);
		
		JTextArea txtrProductDelete = new JTextArea();
		txtrProductDelete.setText("Enter Product ID");
		txtrProductDelete.setEditable(false);
		txtrProductDelete.setColumns(10);
		deleteProductMenu.add(txtrProductDelete);
		
		textFieldProductDelete = new JTextField();
		textFieldProductDelete.setColumns(10);
		deleteProductMenu.add(textFieldProductDelete);
		
		JButton btnSubmitProductDelete = new JButton("Submit");
		btnSubmitProductDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				
				String productID = textFieldProductDelete.getText();
				String query = "DELETE FROM product WHERE productid = " + productID;
				
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
		
		JMenu mnOrderMenu = new JMenu("Order Menu");
		mnOrderMenu.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		menuBar.add(mnOrderMenu);
		
		JMenu createOrderMenu = new JMenu("Create");
		mnOrderMenu.add(createOrderMenu);
		
		JTextArea txtrOrderID = new JTextArea();
		txtrOrderID.setText("Order ID");
		txtrOrderID.setEditable(false);
		txtrOrderID.setColumns(10);
		createOrderMenu.add(txtrOrderID);
		
		textFieldOrderID = new JTextField();
		textFieldOrderID.setColumns(10);
		createOrderMenu.add(textFieldOrderID);
		
		JTextArea txtrQuantity = new JTextArea();
		txtrQuantity.setText("Quantity");
		txtrQuantity.setColumns(10);
		createOrderMenu.add(txtrQuantity);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setColumns(10);
		createOrderMenu.add(textFieldQuantity);
		
		JButton btnSubmitCreateOrder = new JButton("Submit");
		btnSubmitCreateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String quantity = textFieldOrderID.getText();
				String orderID = textFieldQuantity.getText();
		
			}
		});
		btnSubmitCreateOrder.setAction(action_5);
		createOrderMenu.add(btnSubmitCreateOrder);
		
		JMenu updateOrderMenu = new JMenu("Update");
		mnOrderMenu.add(updateOrderMenu);
		
		JTextArea txtrOrderIDUpdate = new JTextArea();
		txtrOrderIDUpdate.setText("Enter Order ID");
		txtrOrderIDUpdate.setEditable(false);
		txtrOrderIDUpdate.setColumns(10);
		updateOrderMenu.add(txtrOrderIDUpdate);
		
		textFieldOrderIDUpdate = new JTextField();
		textFieldOrderIDUpdate.setColumns(10);
		updateOrderMenu.add(textFieldOrderIDUpdate);
		
		JTextArea txtrQuantityUpdate = new JTextArea();
		txtrQuantityUpdate.setText("Quantity");
		txtrQuantityUpdate.setColumns(10);
		updateOrderMenu.add(txtrQuantityUpdate);
		
		JButton btnSubmitOrderUpdate = new JButton("Submit");
		btnSubmitOrderUpdate.setAction(action_6);
		updateOrderMenu.add(btnSubmitOrderUpdate);
		
		JMenu deleteOrderMenu = new JMenu("Delete");
		mnOrderMenu.add(deleteOrderMenu);
		
		JTextArea txtrEnterOrderID = new JTextArea();
		txtrEnterOrderID.setText("Enter Order ID");
		txtrEnterOrderID.setEditable(false);
		txtrEnterOrderID.setColumns(10);
		deleteOrderMenu.add(txtrEnterOrderID);
		
		textFieldEnterOrderID = new JTextField();
		textFieldEnterOrderID.setColumns(10);
		deleteOrderMenu.add(textFieldEnterOrderID);
		
		JButton btnSubmitDeleteOrder = new JButton("Submit");
		btnSubmitDeleteOrder.setAction(action_7);
		deleteOrderMenu.add(btnSubmitDeleteOrder);
		
		JMenu mnInvoiceMenu = new JMenu("Invoice Menu");
		mnInvoiceMenu.setFont(new Font("Yu Gothic Medium", Font.BOLD, 12));
		menuBar.add(mnInvoiceMenu);
		
		JMenu createInvoiceMenu = new JMenu("Create");
		mnInvoiceMenu.add(createInvoiceMenu);
		
		JTextArea txtrInvoice = new JTextArea();
		txtrInvoice.setText("Invoice ID");
		txtrInvoice.setEditable(false);
		txtrInvoice.setColumns(10);
		createInvoiceMenu.add(txtrInvoice);
		
		textFieldInvoiceID = new JTextField();
		textFieldInvoiceID.setColumns(10);
		createInvoiceMenu.add(textFieldInvoiceID);
		
		JTextArea txtrCustomerID = new JTextArea();
		txtrCustomerID.setText("Customer ID");
		txtrCustomerID.setColumns(10);
		createInvoiceMenu.add(txtrCustomerID);
		
		textFieldCustomerID = new JTextField();
		textFieldCustomerID.setColumns(10);
		createInvoiceMenu.add(textFieldCustomerID);
		
		JTextArea txtrDate = new JTextArea();
		txtrDate.setText("Date");
		txtrDate.setColumns(10);
		createInvoiceMenu.add(txtrDate);
		
		textFieldDate = new JTextField();
		textFieldDate.setColumns(10);
		createInvoiceMenu.add(textFieldDate);
		
		JButton btnSubmitCreateInvoice = new JButton("Submit");
		btnSubmitCreateInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
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
				
					String invoiceID = textFieldInvoiceID.getText();
					String customerID = textFieldCustomerID.getText();
					String date = textFieldDate.getText();
					
					try {                                                              // needs to be foreign key / from customer database
						statement.executeUpdate("insert into invoice value('"+invoiceID+"','"+customerID+"','"+date+"')");
					} catch (SQLException e1) {
						
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				     System.out.println("VALUES INSERTED SUCCESSFULLY");  
			}
		});
		btnSubmitCreateInvoice.setAction(action_8);
		createInvoiceMenu.add(btnSubmitCreateInvoice);
		
		JMenu updateInvoiceMenu = new JMenu("Update");
		mnInvoiceMenu.add(updateInvoiceMenu);
		
		JTextArea txtrInvoiceIDUpdate = new JTextArea();
		txtrInvoiceIDUpdate.setText("Enter Invoice ID");
		txtrInvoiceIDUpdate.setEditable(false);
		txtrInvoiceIDUpdate.setColumns(10);
		updateInvoiceMenu.add(txtrInvoiceIDUpdate);
		
		textFieldInvoiceIDUpdate = new JTextField();
		textFieldInvoiceIDUpdate.setColumns(10);
		updateInvoiceMenu.add(textFieldInvoiceIDUpdate);
		
		JTextArea txtrCustomerIDUpdate = new JTextArea();
		txtrCustomerIDUpdate.setText("Customer ID");
		txtrCustomerIDUpdate.setColumns(10);
		updateInvoiceMenu.add(txtrCustomerIDUpdate);
		
		textFieldCustomerIDUpdate = new JTextField();
		textFieldCustomerIDUpdate.setColumns(10);
		updateInvoiceMenu.add(textFieldCustomerIDUpdate);
		
		JTextArea txtrDateUpdate = new JTextArea();
		txtrDateUpdate.setText("Date");
		txtrDateUpdate.setColumns(10);
		updateInvoiceMenu.add(txtrDateUpdate);
		
		textFieldDateUpdate = new JTextField();
		textFieldDateUpdate.setColumns(10);
		updateInvoiceMenu.add(textFieldDateUpdate);
		
		JButton btnSubmit_1_1_1_3_1 = new JButton("Submit");
		btnSubmit_1_1_1_3_1.setAction(action_9);
		updateInvoiceMenu.add(btnSubmit_1_1_1_3_1);
		
		JMenu deleteInvoiceMenu = new JMenu("Delete");
		mnInvoiceMenu.add(deleteInvoiceMenu);
		
		JTextArea txtrInvoiceIDDelete = new JTextArea();
		txtrInvoiceIDDelete.setText("Enter Invoice ID");
		txtrInvoiceIDDelete.setEditable(false);
		txtrInvoiceIDDelete.setColumns(10);
		deleteInvoiceMenu.add(txtrInvoiceIDDelete);
		
		textFieldDateDelete = new JTextField();
		textFieldDateDelete.setColumns(10);
		deleteInvoiceMenu.add(textFieldDateDelete);
		
		JButton btnSubmitInvoiceDelete = new JButton("Submit");
		btnSubmitInvoiceDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				
				String invoiceID = textFieldDateDelete.getText();
				String query = "DELETE FROM invoice WHERE invoiceid = " + invoiceID;
				
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
		
		JPanel customerPanel = new JPanel();
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
	
		
		try {
			FillTable(customerTable, "SELECT * FROM customer;");
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		customerPanel.add(customerTable);
		
		JButton btnRefreash = new JButton("Refreash");
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
		
		invoiceTable = new JTable();
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
		try {
			FillTable(invoiceTable, "SELECT * FROM invoice;");
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		invoicePanel.add(invoiceTable);
		
		// invoice refresh button
		
		JButton btnRefreashInvoice = new JButton("Refreash");
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
		
		JPanel orderPanel = new JPanel();
		tabbedPane.addTab("Veiw Order Database", null, orderPanel, null);
		
		orderTable = new JTable();
		orderTable.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		orderTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		orderPanel.add(orderTable);
		

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
	 public void FillTable(JTable table, String Query) throws InstantiationException, IllegalAccessException
     {
		
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
             while(table.getRowCount() > 0) 
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
