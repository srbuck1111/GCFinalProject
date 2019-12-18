package co.grandcircus.GCFinalProject.dndpojos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Level implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _id;
	private int level;
	private int ability_score_bonuses;
	private  int prof_bonus;
	//private List<Feature> feature_choices;
	//private List<Feature> features;
	//private ClassSpecific class_specific;
	@JsonProperty("class")
	private Classes clss;
	
	public Level() {
		super();
	}

	public Level(String _id, int level, int ability_score_bonuses, int prof_bonus, Classes clss) {
		super();
		this._id = _id;
		this.level = level;
		this.ability_score_bonuses = ability_score_bonuses;
		this.prof_bonus = prof_bonus;
		this.clss = clss;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAbility_score_bonuses() {
		return ability_score_bonuses;
	}

	public void setAbility_score_bonuses(int ability_score_bonuses) {
		this.ability_score_bonuses = ability_score_bonuses;
	}

	public int getProf_bonus() {
		return prof_bonus;
	}

	public void setProf_bonus(int prof_bonus) {
		this.prof_bonus = prof_bonus;
	}

	public Classes getClss() {
		return clss;
	}

	public void setClss(Classes clss) {
		this.clss = clss;
	}
	
}
