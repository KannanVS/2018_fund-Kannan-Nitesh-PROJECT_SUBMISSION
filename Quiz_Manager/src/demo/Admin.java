package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.epita.services.Configuration;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;


	/**
	 * Create the frame.
	 */
	public Admin() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter the username and password for login");
		lblNewLabel.setBounds(84, 11, 280, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(44, 75, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(44, 128, 77, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(180, 72, 141, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 125, 141, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement stmt = null;
				Connection connection = null;
				try {
					connection = getConnection();
					stmt = connection.prepareStatement("select * from ADMIN where username=? and password=?");
					stmt.setString(1, textField.getText());
					stmt.setString(2, passwordField.getText());
					ResultSet res=stmt.executeQuery();
									
					if(res.next()!=false)
					{
						new Admin_In();
						setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Username or Password is Wrong");
					}
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				finally {
					try {
						stmt.close();
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				
			}
		});
		btnNewButton.setBounds(127, 181, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	private Connection getConnection() throws SQLException, FileNotFoundException, IOException {
		Configuration config = Configuration.getInstance();
		String url = config.getPropertyValue("jdbc.url");
		String username = config.getPropertyValue("jdbc.username");
		String password = config.getPropertyValue("jdbc.password");
		
		return DriverManager.getConnection(url, username, password);
	}

	   // JDBC driver name and database URL 
	   static final String JDBC_DRIVER = "org.h2.Driver";   
	   static final String DB_URL = "jdbc:h2:~/test";  
	   
	   //  Database credentials 
	   static final String USER = "sa"; 
	   static final String PASS = ""; 
}
