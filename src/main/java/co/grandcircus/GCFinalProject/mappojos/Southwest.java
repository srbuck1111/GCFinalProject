package co.grandcircus.GCFinalProject.mappojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Southwest {

	private double lat;
	private double lng;

	public Southwest() {
		super();
	}

	public Southwest(double lat, double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "Southwest [lat=" + lat + ", lng=" + lng + "]";
	}

}
