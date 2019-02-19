package fr.epita.datamodel;

import java.util.Arrays;

public class Question {

	// CREATE TABLE QUESTION (ID INT PRIMARY KEY, LABEL VARCHAR(255));

	private int id;

	private String question;

	private String topics;

	private int difficulty;

	public Question(String question, int difficulty, String topics) {
		
		this.question = question;
		this.topics = topics;
		this.difficulty = difficulty;
	}

	public Question() {
		super();
	}

	public Question(String question) {
		super();
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getTopics() {
		return topics;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getId() {
		return id;
	}

	public int setId(int id) {
		this.id = id;
		return id;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", topics=" +topics + ", difficulty="
				+ difficulty + "]";
	}

}
