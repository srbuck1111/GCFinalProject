package co.grandcircus.GCFinalProject.mappojos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Results {

	private String adr_address;
	private String formatted_address;
	private String formatted_phone_number;
	private Geometry geometry;
	private String icon;
	private String id;
	private String name;
	private String place_id;
	private String reference;
	List<String> types;
	private String url;
	private String vicinity;

	public Results() {
		super();
	}

	public Results(String adr_address, String formatted_address, String formatted_phone_number, Geometry geometry,
			String icon, String id, String name, String place_id, String reference, List<String> types, String url,
			String vicinity) {
		super();
		this.adr_address = adr_address;
		this.formatted_address = formatted_address;
		this.formatted_phone_number = formatted_phone_number;
		this.geometry = geometry;
		this.icon = icon;
		this.id = id;
		this.name = name;
		this.place_id = place_id;
		this.reference = reference;
		this.types = types;
		this.url = url;
		this.vicinity = vicinity;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String getAdr_address() {
		return adr_address;
	}

	public void setAdr_address(String adr_address) {
		this.adr_address = adr_address;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public String getFormatted_phone_number() {
		return formatted_phone_number;
	}

	public void setFormatted_phone_number(String formatted_phone_number) {
		this.formatted_phone_number = formatted_phone_number;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVicinity() {
		return vicinity;
	}

	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
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

}
