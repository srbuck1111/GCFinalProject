package co.grandcircus.GCFinalProject.mappojos;

public class Viewport {

	private Southwest southwest;
	private Northeast northeast;

	public Viewport() {
		super();
	}

	public Viewport(Southwest sWest, Northeast nEast) {
		super();
		this.southwest = sWest;
		this.northeast = nEast;
	}

	public Southwest getsWest() {
		return southwest;
	}

	public void setsWest(Southwest sWest) {
		this.southwest = sWest;
	}

	public Northeast getnEast() {
		return northeast;
	}

	public void setnEast(Northeast nEast) {
		this.northeast = nEast;
	}

	@Override
	public String toString() {
		return "Viewport [sWest=" + southwest + ", nEast=" + northeast + "]";
	}

}
