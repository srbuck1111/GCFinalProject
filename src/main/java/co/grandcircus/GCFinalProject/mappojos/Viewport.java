package co.grandcircus.GCFinalProject.mappojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Viewport {

	private Southwest sWest;
	private Northeast nEast;

	public Viewport() {
		super();
	}

	public Viewport(Southwest sWest, Northeast nEast) {
		super();
		this.sWest = sWest;
		this.nEast = nEast;
	}

	public Southwest getsWest() {
		return sWest;
	}

	public void setsWest(Southwest sWest) {
		this.sWest = sWest;
	}

	public Northeast getnEast() {
		return nEast;
	}

	public void setnEast(Northeast nEast) {
		this.nEast = nEast;
	}

	@Override
	public String toString() {
		return "Viewport [sWest=" + sWest + ", nEast=" + nEast + "]";
	}

}
