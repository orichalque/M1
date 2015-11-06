package com.myjee;

import com.googlecode.objectify.annotation.*;

@Entity
@Index
public class Person {
	public int score;
	@Id public String name;
	
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
