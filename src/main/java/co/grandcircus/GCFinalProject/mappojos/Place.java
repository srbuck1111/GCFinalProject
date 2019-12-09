package co.grandcircus.GCFinalProject.mappojos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Place {
	
	@JsonProperty("results")
	List<Results> result;
	
	public Place() {
		super();
	}

	public Place(List<Results> result) {
		super();
		this.result = result;
	}


	public List<Results> getResult() {
		return result;
	}

	public void setResult(List<Results> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "result=" + result + "]";
	}
	
}
