package co.grandcircus.GCFinalProject.mappojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.prism.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry {

	private Location location;
	private Viewport viewport;
	private Image icon;
	private String id;
	private String name;
	private String place_id;
	private String reference;

	public Geometry() {
		super();
	}

	public Geometry(Location location, Viewport viewport, Image icon, String id, String name, String place_id,
			String reference) {
		super();
		this.location = location;
		this.viewport = viewport;
		this.icon = icon;
		this.id = id;
		this.name = name;
		this.place_id = place_id;
		this.reference = reference;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Viewport getViewport() {
		return viewport;
	}

	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}

	public Image getIcon() {
		return icon;
	}

	public void setIcon(Image icon) {
		this.icon = icon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public String toString() {
		return "Geometry [location=" + location + ", viewport=" + viewport + ", icon=" + icon + ", id=" + id + ", name="
				+ name + ", place_id=" + place_id + ", reference=" + reference + "]";
	}

}
