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
import java.awt.Font;

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
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel.setBounds(23, 11, 411, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(44, 72, 95, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(44, 128, 95, 20);
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
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home();
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(275, 181, 89, 23);
		contentPane.add(btnNewButton_1);
	}
	
	private Connection getConnection() throws SQLException, FileNotFoundException, IOException {
	//	Configuration config = Configuration.getInstance();
		String url = "jdbc:h2:tcp://localhost//C:/db/h2DS;create=true";
		String username = "sa";
		String password = "";
		
		return DriverManager.getConnection(url, username, password);
	}

	   // JDBC driver name and database URL 
	   static final String JDBC_DRIVER = "org.h2.Driver";   
	   static final String DB_URL = "jdbc:h2:~/test";  
	   
	   //  Database credentials 
	   static final String USER = "sa"; 
	   static final String PASS = ""; 
}
