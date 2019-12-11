package co.grandcircus.GCFinalProject.mappojos;

public class UserPlace {

	Location location;
	int accuracy;
	
	public UserPlace(Location location, int accuracy) {
		super();
		this.location = location;
		this.accuracy = accuracy;
	}

	public UserPlace() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	
	
}
