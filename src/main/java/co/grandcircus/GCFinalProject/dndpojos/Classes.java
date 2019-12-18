package co.grandcircus.GCFinalProject.dndpojos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Classes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("_id")
	private String id;
	private Integer index;
	private String name;
	@JsonProperty("hit_die")
	private Integer hitDie;
	
	public Classes() {
		super();
	}
	public Classes(String id, Integer index, String name, Integer hitDie) {
		super();
		this.id = id;
		this.index = index;
		this.name = name;
		this.hitDie = hitDie;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHitDie() {
		return hitDie;
	}
	public void setHitDie(Integer hitDie) {
		this.hitDie = hitDie;
	}
	@Override
	public String toString() {
		return "Classes [id=" + id + ", index=" + index + ", name=" + name + ", hitDie=" + hitDie + "]";
	}

}
