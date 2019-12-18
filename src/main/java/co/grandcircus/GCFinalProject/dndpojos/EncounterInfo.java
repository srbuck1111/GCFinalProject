package co.grandcircus.GCFinalProject.dndpojos;

import java.io.Serializable;

public class EncounterInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private int userTurn;
	
	public EncounterInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EncounterInfo(String text, int userTurn) {
		super();
		this.text = text;
		this.userTurn = userTurn;
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
	
}
