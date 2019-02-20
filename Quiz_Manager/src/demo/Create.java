package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.epita.datamodel.Question;
import fr.epita.services.dao.QuestionJDBCDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Create extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtMathsorJava;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the frame.
	 */
	public Create() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add a Question");
		lblNewLabel.setBounds(149, 11, 196, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Question");
		lblNewLabel_1.setBounds(32, 49, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Topic");
		lblNewLabel_2.setBounds(32, 86, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Difficulty");
		lblNewLabel_3.setBounds(32, 144, 76, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(142, 46, 267, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtMathsorJava = new JTextField();
		txtMathsorJava.setToolTipText("");
		txtMathsorJava.setBounds(142, 83, 267, 20);
		contentPane.add(txtMathsorJava);
		txtMathsorJava.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(142, 141, 267, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			Question ques = new Question(textField.getText(),Integer.parseInt(textField_2.getText()),txtMathsorJava.getText());
			QuestionJDBCDAO q = new QuestionJDBCDAO();
					q.create(ques);
					textField.setText(null);
					txtMathsorJava.setText(null);
					textField_2.setText(null);
			
					int count=q.Acreate(textField_3.getText(),textField_4.getText(), textField_5.getText(), textField_6.getText(), textField_7.getText());
					textField_3.setText(null);
					textField_4.setText(null);
					textField_5.setText(null);
					textField_6.setText(null);
					textField_7.setText(null);
					JOptionPane.showMessageDialog(null, "The Question is Created Successfully \n The question number is "+count);
			}
		});
		btnNewButton.setBounds(149, 550, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Add Options");
		lblNewLabel_4.setBounds(149, 223, 133, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Opt A");
		lblNewLabel_5.setBounds(32, 284, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Opt B");
		lblNewLabel_6.setBounds(32, 331, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Opt C");
		lblNewLabel_7.setBounds(32, 379, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Opt D");
		lblNewLabel_8.setBounds(32, 428, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		textField_3 = new JTextField();
		textField_3.setBounds(149, 281, 260, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(149, 328, 260, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(149, 376, 260, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(149, 425, 260, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Correct Answer");
		lblNewLabel_9.setBounds(32, 477, 89, 14);
		contentPane.add(lblNewLabel_9);
		
		textField_7 = new JTextField();
		textField_7.setBounds(149, 474, 260, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Give the topic as 'Java' or 'Maths'");
		lblNewLabel_10.setBounds(152, 97, 236, 31);
		contentPane.add(lblNewLabel_10);
	}
}
