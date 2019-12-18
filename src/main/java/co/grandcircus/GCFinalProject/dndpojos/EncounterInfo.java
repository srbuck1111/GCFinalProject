package co.grandcircus.GCFinalProject.dndpojos;

import java.io.Serializable;

public class EncounterInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private int userTurn;
	private int potions;
	
	public EncounterInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EncounterInfo(String text, int userTurn) {
		super();
		this.text = text;
		this.userTurn = userTurn;
		this.potions = 0;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getUserTurn() {
		return userTurn;
	}

	public void setUserTurn(int userTurn) {
		this.userTurn = userTurn;
	}

	public int getPotions() {
		return potions;
	}

	public void setPotions(int potions) {
		this.potions = potions;
	}
	
}
