package fr.epita.services.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demo.Delete;
import demo.Update;
import fr.epita.datamodel.Question;
import fr.epita.services.Configuration;

public class QuestionJDBCDAO {

	private static final String INSERT_QUERY = "INSERT INTO QUESTIONS (QUESTION,DIFFICULTY,TOPICS) VALUES (?, ?, ?)";
	private static final String UPDATE_QUERY = "UPDATE QUESTIONS SET QUESTION=?,DIFFICULTY=?, TOPICS=? WHERE ID=?";
	private static final String DELETE_QUERY = "DELETE QUESTIONS WHERE ID=?";
	private static final String DELETE_QUERY_2 = "DELETE ANSWERS WHERE ID=?";
	private static final String SEARCH_QUERY = "SELECT QUESTION,ID,DIFFICULTY FROM QUESTIONS WHERE (? IS NOT NULL AND QUESTION LIKE ?) AND (? IS NOT NULL  AND DIFFICULTY = ?)";
	private static final String AINSERT_QUERY = "INSERT INTO ANSWERS (OPTA,OPTB,OPTC,OPTD,CA) VALUES (?, ?, ?,?,?)";
	
	
	public void create(Question question) {
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection
					.prepareStatement(INSERT_QUERY);
			stmt.setString(1, question.getQuestion());
			stmt.setInt(2, question.getDifficulty());
			stmt.setString(3, question.getTopics());
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int count;
	public int Acreate(String a,String b, String c, String d, String ca) {
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection
					.prepareStatement(AINSERT_QUERY);
			stmt.setString(1, a);
			stmt.setString(2, b);
			stmt.setString(3, c);
			stmt.setString(4, d);
			stmt.setString(5, ca);
			stmt.execute();
			stmt.close();
		
			String query = "select count(*) AS rowcount from QUESTIONS";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			//System.out.println(rs);
			while (rs.next())
		      {
		        count = rs.getInt("rowcount");
		      }
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public void update(Question question) {
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection
					.prepareStatement(UPDATE_QUERY);
			Update u = new Update();
			stmt.setString(1, question.getQuestion());
			stmt.setInt(2, question.getDifficulty());
			stmt.setString(3, question.getTopics());
			stmt.setInt(4, question.getId());
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(int i) {
		try {
			//Delete d= new Delete();
			Connection connection = getConnection();
			PreparedStatement stmt = connection
					.prepareStatement(DELETE_QUERY);
			stmt.setInt(1, i);
			stmt.execute();
			stmt.close();
			
			
			PreparedStatement stmt1 = connection
					.prepareStatement(DELETE_QUERY_2);
			stmt1.setInt(1, i);
			stmt1.execute();
			stmt1.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Question> search(Question question) {
		List<Question> questions = new ArrayList<>();
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection
					.prepareStatement(SEARCH_QUERY);
			stmt.setString(1, question.getQuestion());
			stmt.setString(2, "%" + question.getQuestion()+ "%");
			stmt.setInt(3, question.getDifficulty());
			stmt.setInt(4, question.getDifficulty());
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String questionLabel = rs.getString(1);
				int id = rs.getInt(2);
				int difficulty = rs.getInt(3);
				Question currentQuestion = new Question();
				currentQuestion.setId(id);
				currentQuestion.setQuestion(questionLabel);
				currentQuestion.setDifficulty(difficulty);
				questions.add(currentQuestion);
			}
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questions;
	}

	private Connection getConnection() throws SQLException, FileNotFoundException, IOException {
		//	Configuration config = Configuration.getInstance();
			String url = "jdbc:h2:tcp://localhost//C:/db/h2DS;create=true";
			String username = "sa";
			String password = "";
			
			return DriverManager.getConnection(url, username, password);
		}
}
