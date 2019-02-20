package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.epita.services.Configuration;

import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Student extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public Student() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(22, 11, 104, 25);
		contentPane.add(lblLogin);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setBounds(287, 16, 46, 14);
		contentPane.add(lblSignUp);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(22, 68, 69, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(22, 113, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(101, 65, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(222, 68, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setBounds(222, 113, 69, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(222, 156, 73, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(316, 65, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(101, 110, 86, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(316, 153, 86, 20);
		contentPane.add(passwordField_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(316, 110, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement stmt = null;
				Connection connection = null;
				try {
					connection = getConnection();
					stmt = connection.prepareStatement("select * from students where username=? and password=?");
					stmt.setString(1, textField.getText());
					stmt.setString(2, passwordField.getText());
					ResultSet res=stmt.executeQuery();
									
					if(res.next()!=false)
					{
						String uname=textField.getText();
						new Student_In(uname);
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
		btnLogin.setBounds(56, 173, 89, 23);
		contentPane.add(btnLogin);
		
		
		
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement stmt = null;
				Connection connection = null;
				try {
					connection = getConnection();
					stmt = connection.prepareStatement("INSERT INTO students (Name,Username,Password) VALUES ('"+textField_2.getText()+"','"+textField_1.getText()+"','"+passwordField_1.getText()+"') ");
					stmt.execute();
					JOptionPane.showMessageDialog(null, "Detailed Added");
					
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnSignUp.setBounds(287, 211, 89, 23);
		contentPane.add(btnSignUp);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				new Home();
				setVisible(false);
			}
			
		});
		btnNewButton.setBounds(143, 227, 89, 23);
		contentPane.add(btnNewButton);
	}
	private Connection getConnection() throws SQLException, FileNotFoundException, IOException {
		//	Configuration config = Configuration.getInstance();
			String url = "jdbc:h2:tcp://localhost//C:/db/h2DS;create=true";
			String username = "sa";
			String password = "";
			
			return DriverManager.getConnection(url, username, password);
		}
}
