package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import fr.epita.services.Configuration;
import fr.epita.datamodel.Question;
import fr.epita.services.dao.QuestionJDBCDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public Update() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update the question");
		lblNewLabel.setBounds(149, 11, 164, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(44, 50, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Question");
		lblNewLabel_2.setBounds(44, 94, 60, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Difficulty");
		lblNewLabel_3.setBounds(44, 144, 60, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Topics");
		lblNewLabel_4.setBounds(44, 194, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(188, 47, 193, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(188, 91, 193, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(188, 141, 193, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(188, 191, 193, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				final String UPDATE_QUERY = "UPDATE QUESTIONS SET QUESTION=?,DIFFICULTY=?, TOPICS=? WHERE ID=?";
				PreparedStatement stmt = null;
				Connection connection = null;
				try {
					connection = getConnection();
					stmt = connection
							.prepareStatement(UPDATE_QUERY);
					stmt.setString(1, textField_1.getText());
					stmt.setInt(2, Integer.parseInt(textField_2.getText()));
					stmt.setString(3, textField_3.getText());
					stmt.setInt(4, Integer.parseInt(textField.getText()));
					stmt.execute();
					stmt.close();
					connection.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "The Question is Updated Successfully");
				
			}
		});
		btnNewButton.setBounds(166, 246, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin_In();
				setVisible(false);
			}
			
		});
		btnNewButton_1.setBounds(336, 246, 89, 23);
		contentPane.add(btnNewButton_1);
		
	}
	private Connection getConnection() throws SQLException, FileNotFoundException, IOException {
		Configuration config = Configuration.getInstance();
		String url = config.getPropertyValue("jdbc.url");
		String username = config.getPropertyValue("jdbc.username");
		String password = config.getPropertyValue("jdbc.password");
		
		return DriverManager.getConnection(url, username, password);
	}

}
