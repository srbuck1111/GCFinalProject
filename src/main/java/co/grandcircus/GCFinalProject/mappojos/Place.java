package co.grandcircus.GCFinalProject.mappojos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Place {
	
	private Integer id;
	List<Result> result;
	
	public Place() {
		super();
	}

	public Place(Integer id, List<Result> result) {
		super();
		this.id = id;
		this.result = result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Result> getResult() {
		return result;
	}

	public void setResult(List<Result> result) {
		this.result = result;
	}
	
}
