package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.epita.services.dao.QuestionJDBCDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
public int id;
	/**
	 * Create the frame.
	 */
	public Delete() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delet a Question");
		lblNewLabel.setBounds(149, 11, 229, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(176, 49, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(40, 52, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id= Integer.parseInt(textField.getText());
				QuestionJDBCDAO q = new QuestionJDBCDAO();
				q.delete(id);
				textField.setText(null);
				JOptionPane.showMessageDialog(null, "The Question is Deleted Successfully");
			}
		});
		btnNewButton.setBounds(144, 140, 89, 23);
		contentPane.add(btnNewButton);
	}

}
