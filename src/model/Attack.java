package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Attack implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String description;
	
	private int damage;
	
	//private ArrayList<Energy> cost;
	
	private Energy cost;
	
	/*public Attack(String attackName, String desc,  int dmg, ArrayList<Energy> list) {
		name = attackName;
		description = desc;
		damage = dmg;
		cost = new ArrayList<Energy>();
		cost.addAll(list);
	}*/
	
	public Attack(String attackName, String desc,  int dmg, Energy eng) {
		name = attackName;
		description = desc;
		damage = dmg;
		cost = eng;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String desc) {
		this.description = desc;
	}

	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int dmg) {
		this.damage = dmg;
	}

	/*public List<Energy> getCost() {
		return cost;
	}*/
	
	public Energy getCost() {
		return cost;
	}
}
