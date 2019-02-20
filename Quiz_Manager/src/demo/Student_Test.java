package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.BreakIterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.epita.services.Configuration;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_Test extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton_5;
	JRadioButton rdbtnNewRadioButton_6;
	JRadioButton rdbtnNewRadioButton_7;
	public int[] id= new int[50];
	public String[] Question= new String[50];
	public String[] opta= new String[50];
	public String[] optb= new String[50];
	public String[] optc= new String[50];
	public String[] optd= new String[50];
	public String[] ca= new String[50];
	public int i=0,count=0;
	
	public Student_Test(String topic, int diff,String uname) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quiz");
		lblNewLabel.setBounds(211, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		
		
		
		
	
		
		
		
		
		
		
		
		try {
			Connection connection = getConnection();
			String query = "SELECT * FROM questions t1,answers t2 WHERE t1.topics='"+topic+"' and difficulty="+diff+" and t1.ID=t2.ID ;";
			 Statement st = connection.createStatement();
			 ResultSet rs = st.executeQuery(query);
			 while(rs.next())
				  
				{
				 
				    id[i] = rs.getInt("ID");
					Question[i] = rs.getString("QUESTION");
				    opta[i] = rs.getString("OPTA");
				    optb[i] = rs.getString("OPTB");
				    optc[i] = rs.getString("OPTC");
				    optd[i] = rs.getString("OPTD");
				    ca[i] = rs.getString("CA");
				    i++;
				   // System.out.println("Printing "+i);
				// System.out.format("%s, %s, %s, %s, %s, %s, %s\n", id[i], Question[i], opta[i], optb[i],optc[i],optd[i],ca[i]);
				}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		i=0;
			
			JLabel lblNewLabel_2 = new JLabel(Question[i]);
			lblNewLabel_2.setBounds(86, 61, 325, 14);
			contentPane.add(lblNewLabel_2);
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton(opta[i]);
			rdbtnNewRadioButton.setBounds(100, 102, 364, 23);
			contentPane.add(rdbtnNewRadioButton);
			
			JRadioButton rdbtnNewRadioButton_5 = new JRadioButton(optb[i]);
			rdbtnNewRadioButton_5.setBounds(100, 155, 345, 23);
			contentPane.add(rdbtnNewRadioButton_5);
			
			JRadioButton rdbtnNewRadioButton_6 = new JRadioButton(optc[i]);
			rdbtnNewRadioButton_6.setBounds(100, 212, 333, 23);
			contentPane.add(rdbtnNewRadioButton_6);
			
			JRadioButton rdbtnNewRadioButton_7 = new JRadioButton(optd[i]);
			rdbtnNewRadioButton_7.setBounds(100, 274, 325, 23);
			contentPane.add(rdbtnNewRadioButton_7);
			
			ButtonGroup group = new ButtonGroup();
			group.add(rdbtnNewRadioButton);
			group.add(rdbtnNewRadioButton_5);
			group.add(rdbtnNewRadioButton_6);
			group.add(rdbtnNewRadioButton_7);


			getContentPane().add(rdbtnNewRadioButton);
			getContentPane().add(rdbtnNewRadioButton_5);
			getContentPane().add(rdbtnNewRadioButton_6);
			getContentPane().add(rdbtnNewRadioButton_7);
			
			JButton btnNewButton = new JButton("Validate");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(rdbtnNewRadioButton.isSelected()) {
						if(ca[i]==rdbtnNewRadioButton.getText()) {
							count=count+1;
				
						}
					}
					
					else if(rdbtnNewRadioButton_5.isSelected()) {
						if(ca[i]==rdbtnNewRadioButton_5.getText()) {
							count=count+1;
					
						}
					}
					
					else if(rdbtnNewRadioButton_6.isSelected()) {
						if(ca[i]==rdbtnNewRadioButton_6.getText()) {
							count=count+1;
					
						}
					}
					
					else if(rdbtnNewRadioButton_7.isSelected()) {
						if(ca[i]==rdbtnNewRadioButton_7.getText()) {
							count=count+1;
					
						}
					}
					i++;

					
				}
			});
			btnNewButton.setBounds(180, 372, 89, 23);
			contentPane.add(btnNewButton);

			
			
			JButton btnNewButton_1 = new JButton("Next");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//lblNewLabel_1.setText(Integer.toString(id[i]));
					if(Question[i]!=null)
					{
					lblNewLabel_2.setText(Question[i]);
					rdbtnNewRadioButton.setText(opta[i]);
					
					rdbtnNewRadioButton_5.setText(optb[i]);
					rdbtnNewRadioButton_6.setText(optc[i]);
					rdbtnNewRadioButton_7.setText(optd[i]);
					ButtonGroup group = new ButtonGroup();
					group.add(rdbtnNewRadioButton);
					group.add(rdbtnNewRadioButton_5);
					group.add(rdbtnNewRadioButton_6);
					group.add(rdbtnNewRadioButton_7);


					getContentPane().add(rdbtnNewRadioButton);
					getContentPane().add(rdbtnNewRadioButton_5);
					getContentPane().add(rdbtnNewRadioButton_6);
					getContentPane().add(rdbtnNewRadioButton_7);
					}
					else {
						JButton btnNewButton_2 = new JButton("End");
						btnNewButton_2.setEnabled(true);
						btnNewButton_2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JOptionPane.showMessageDialog(null, "The Quiz is Completed Successfully \n The Mark is "+count);
							}
						});
						btnNewButton_2.setBounds(180, 443, 89, 23);
						contentPane.add(btnNewButton_2);
					}
				}
			});
			btnNewButton_1.setBounds(295, 370, 89, 23);
			contentPane.add(btnNewButton_1);
			
			JButton btnNewButton_3 = new JButton("End");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "The Quiz is Completed Successfully \n The Mark is "+count);
					try {
						Connection connection = getConnection();
						Statement st = connection.createStatement();
						 ResultSet rs = st.executeQuery("select ID from Students where username='"+uname+"'");
						 int uid = 0;
						 while(rs.next())
							  
							{
							 
							    uid = rs.getInt("ID");
							}
						 System.out.println(uid);
						
						PreparedStatement stmt = connection.prepareStatement("UPDATE Students SET Mark="+count+"WHERE ID="+uid+";");
						
						
					}catch (Exception e1) {
						e1.printStackTrace();
					}
					new Home();
					setVisible(false);
					
				}
				
			});
			btnNewButton_3.setBounds(180, 435, 89, 23);
			contentPane.add(btnNewButton_3);
			
			
		}
				
	

	
	
	private Connection getConnection() throws SQLException, FileNotFoundException, IOException {
		//	Configuration config = Configuration.getInstance();
			String url = "jdbc:h2:tcp://localhost//C:/db/h2DS;create=true";
			String username = "sa";
			String password = "";
			
			return DriverManager.getConnection(url, username, password);
		}
}
