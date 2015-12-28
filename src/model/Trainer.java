package model;

import java.io.Serializable;

public class Trainer extends Card implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String description;

	public String getDescription() {
		return description;
	}
	
	public Trainer(String cardName) {
		super(cardName);
		Card.allCards.add(this);
	}
	
	public Trainer(String cardName, String desc) {
		super(cardName);
		description = desc;
	}
	
	public String ToString() {
		return "Carte Dresseur " + super.name + "[" + this.description +"]";
	}
}
