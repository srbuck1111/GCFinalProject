package co.grandcircus.GCFinalProject.dndpojos;

public class EncounterInfo {

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
