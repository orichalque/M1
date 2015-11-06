package com.myjee;

public class Person {
	protected String name;
	protected int score;
	
	public Person() {
		name = "";
		score = 0;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * @return string containing datas
	 */
	public String toString() {
		return "Nom: "+name+"; score: "+score;
	}
}
