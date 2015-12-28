package model;
import java.io.Serializable;
import java.util.*;

public class Pokemon extends Card implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int health;
	
	private String type;
	
	private String power;
	
	private String wickness;
	
	private String resistance;
	
	private int retirementCost;
	
	private String info;
	
	private int level;
	
	private ArrayList<Attack> listAttack;
	
	public Pokemon() {
	}
	
	/**
	 * 
	 * @param cardName
	 * @param hp
	 * @param pokeType
	 * @param pokePower
	 * @param wick
	 * @param resist
	 * @param rtmtCost
	 * @param pokeInfo
	 * @param pokeLevel
	 */
	public Pokemon(String cardName, int hp, String pokeType, String pokePower, String wick, String resist, int rtmtCost, String pokeInfo, int pokeLevel) {
		super(cardName);
		health = hp;
		type = pokeType;
		power = pokePower;
		wickness = wick;
		resistance = resist;
		retirementCost = rtmtCost;
		info = pokeInfo;
		level = pokeLevel;
		listAttack = new ArrayList<Attack>();
		Card.allCards.add(this);
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int hp) {
		this.health = hp;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}
	
	public String getWickness() {
		return wickness;
	}
	
	public void setWickness(String wick) {
		this.wickness = wick;
	}

	public String getResistance() {
		return resistance;
	}

	public void setResistance(String resi) {
		this.resistance = resi;
	}
	
	public int getRetirementCost() {
		return retirementCost;
	}
	
	public void setRetirementCost(int retir) {
		this.retirementCost = retir;
	}

	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}

	public int getLevel() {
		return level;
	}
	
	public void setLevel(int lvl) {
		this.level = lvl;
	}
	
	public String ToString() {
		return super.name + "Pokemon de type " + this.type + "[HP " + this.health +"]";
	}

	public boolean addAttack(Attack a) {
		return listAttack.add(a);
	}
	
	public boolean removeAttack(Attack a) {
		return listAttack.remove(a);
	}
	
	public ArrayList<Attack> getListAttack() {
		return listAttack;
	}
	
	public static ArrayList<Pokemon> getPokemons() {
		ArrayList<Pokemon> pokeList = new ArrayList<Pokemon>();
		for(Card aCard : Card.getAllCards())
	        if(aCard instanceof Pokemon) 
	        	pokeList.add((Pokemon) aCard);

		return pokeList;
	}
}
