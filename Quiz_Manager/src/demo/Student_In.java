package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_In extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	
	/**
	 * Create the frame.
	 */
	public Student_In(String uname) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Quiz Manager");
		lblNewLabel.setBounds(137, 11, 222, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select a Topic and the Difficulty Level");
		lblNewLabel_1.setBounds(106, 36, 233, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Topic");
		lblNewLabel_2.setBounds(31, 80, 66, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(169, 77, 104, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Maths or Java");
		lblNewLabel_3.setBounds(186, 80, 98, 55);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Difficulty");
		lblNewLabel_4.setBounds(31, 149, 66, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(169, 146, 104, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Select from 1,2,3");
		lblNewLabel_5.setBounds(179, 149, 132, 52);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String topic = textField.getText();
				int diff = Integer.parseInt(textField_1.getText());
				new Student_Test(topic,diff,uname);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(144, 212, 89, 23);
		contentPane.add(btnNewButton);
	}

}
