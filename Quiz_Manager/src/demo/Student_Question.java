package demo;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.epita.services.Configuration;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Student_Question extends JFrame {

	private JPanel contentPane;
	/**
	public void SwingJRadioButtonDemo() {
       
		rdbtnNewRadioButton = new JRadioButton(opta);
		rdbtnNewRadioButton.setBounds(96, 72, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton(optb);
		rdbtnNewRadioButton_1.setBounds(96, 118, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton(optc);
		rdbtnNewRadioButton_2.setBounds(96, 160, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton(optd);
		rdbtnNewRadioButton_3.setBounds(96, 200, 109, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnNewRadioButton);
        group.add(rdbtnNewRadioButton_1);
        group.add(rdbtnNewRadioButton_2);
        group.add(rdbtnNewRadioButton_3);
 
        setLayout(new FlowLayout());
 
        add(rdbtnNewRadioButton);
        add(rdbtnNewRadioButton_1);
        add(rdbtnNewRadioButton_2);
        add(rdbtnNewRadioButton_3);
        
 
        pack();
    }**/
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	Student_Question frame = new Student_Question(String, int);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton_1;
	JRadioButton rdbtnNewRadioButton_2;
	JRadioButton rdbtnNewRadioButton_3;

	/**
	 * Create the frame.
	 * @param diff 
	 * @param topic 
	 */
	public String opta,optb,optc,optd;
	public String Question,ca;
	public int id,count=0;
	public Student_Question(String topic, int diff) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quiz");
		lblNewLabel.setBounds(184, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		
		
		
		try {
			Connection connection = getConnection();
			/**PreparedStatement stmt = connection
					.prepareStatement("select * from questions where topics=? and difficulty=?");
			stmt.setString(1, topic);
			stmt.setInt(2, diff);
			**/
		
			 String query = "SELECT * FROM questions t1,answers t2 WHERE t1.topics='"+topic+"' and difficulty="+diff+" and t1.ID=t2.ID ;";
			 Statement st = connection.createStatement();
			 ResultSet rs = st.executeQuery(query);
		       
							while(rs.next())
							  
							{
							
								id = rs.getInt("ID");
								Question = rs.getString("QUESTION");
							    opta = rs.getString("OPTA");
							    optb = rs.getString("OPTB");
							    optc = rs.getString("OPTC");
							    optd = rs.getString("OPTD");
							    ca = rs.getString("CA");
							
							System.out.format("%s, %s, %s, %s, %s, %s, %s\n", id, Question, opta, optb,optc,optd,ca);
							
							JLabel lblNewLabel_1 = new JLabel(Integer.toString(id));
							lblNewLabel_1.setBounds(30, 48, 22, 14);
							contentPane.add(lblNewLabel_1);
							
							JLabel lblNewLabel_2 = new JLabel(Question);
							lblNewLabel_2.setBounds(89, 47, 322, 14);
							contentPane.add(lblNewLabel_2);
							
							
							rdbtnNewRadioButton = new JRadioButton(opta);
							rdbtnNewRadioButton.setBounds(96, 72, 109, 23);
							contentPane.add(rdbtnNewRadioButton);
							
							rdbtnNewRadioButton_1 = new JRadioButton(optb);
							rdbtnNewRadioButton_1.setBounds(96, 118, 109, 23);
							contentPane.add(rdbtnNewRadioButton_1);
							
							rdbtnNewRadioButton_2 = new JRadioButton(optc);
							rdbtnNewRadioButton_2.setBounds(96, 160, 109, 23);
							contentPane.add(rdbtnNewRadioButton_2);
							
							rdbtnNewRadioButton_3 = new JRadioButton(optd);
							rdbtnNewRadioButton_3.setBounds(96, 200, 109, 23);
							contentPane.add(rdbtnNewRadioButton_3);
							
							ButtonGroup group = new ButtonGroup();
							group.add(rdbtnNewRadioButton);
							group.add(rdbtnNewRadioButton_1);
							group.add(rdbtnNewRadioButton_2);
							group.add(rdbtnNewRadioButton_3);
 
      // setLayout(new FlowLayout());
 
							getContentPane().add(rdbtnNewRadioButton);
							getContentPane().add(rdbtnNewRadioButton_1);
							getContentPane().add(rdbtnNewRadioButton_2);
							getContentPane().add(rdbtnNewRadioButton_3);

							}
						 System.out.println(rdbtnNewRadioButton.getText());
			
							JButton btnNewButton = new JButton("Submit");
							btnNewButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
									if(rdbtnNewRadioButton.isSelected()) {
										if(ca==rdbtnNewRadioButton.getText()) {
											count=count+1;
											System.out.println("Sample");
										}
									}
									
									if(rdbtnNewRadioButton_1.isSelected()) {
										if(ca==rdbtnNewRadioButton_1.getText()) {
											count=count+1;
											System.out.println("Sample1");
										}
									}
									
									if(rdbtnNewRadioButton_2.isSelected()) {
										if(ca==rdbtnNewRadioButton_2.getText()) {
											count=count+1;
											System.out.println("Sample2");
										}
									}
									
									if(rdbtnNewRadioButton_3.isSelected()) {
										if(ca==rdbtnNewRadioButton_3.getText()) {
											count=count+1;
											System.out.println("Sample3");
										}
									}
									
									JLabel lblNewLabel_3 = new JLabel(Integer.toString(count));
									lblNewLabel_3.setBounds(350, 345, 46, 14);
									contentPane.add(lblNewLabel_3);
								}
							});
							btnNewButton.setBounds(141, 324, 89, 23);
							contentPane.add(btnNewButton);
		    
			// }
			 
			//stmt.execute();
			//stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		//JOptionPane.showMessageDialog(null, "The topic is "+topic+" and the difficulty is"+diff);
	}
private Connection getConnection() throws SQLException, FileNotFoundException, IOException {
	Configuration config = Configuration.getInstance();
	String url = config.getPropertyValue("jdbc.url");
	String username = config.getPropertyValue("jdbc.username");
	String password = config.getPropertyValue("jdbc.password");
	
	return DriverManager.getConnection(url, username, password);
}
}
