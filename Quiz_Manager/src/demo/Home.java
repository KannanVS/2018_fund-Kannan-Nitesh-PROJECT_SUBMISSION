package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * This is the Home page. 
	 * It has the Login for Admin and Student.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Quiz Manager");
		lblNewLabel.setBounds(100, 11, 293, 22);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select a category");
		lblNewLabel_1.setBounds(130, 44, 178, 22);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.setBounds(117, 165, 130, 23);
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Student();
				setVisible(false);
			}
		});
		btnStudent.setFont(new Font("Verdana", Font.ITALIC, 14));
		contentPane.add(btnStudent);
		
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.setBounds(117, 103, 130, 23);
		btnNewButton.setFont(new Font("Verdana", Font.ITALIC, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin();
				setVisible(false);
			}
		});
		contentPane.add(btnNewButton);
	}

}
