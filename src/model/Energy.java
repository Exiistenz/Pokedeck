package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Energy extends Card implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String element;
	
	private int number;
	
	public Energy(String cardName, String elt, int num) {
		super(cardName);
		element = elt;
		number = num;
		Card.allCards.add(this);
	}

	public String getElement() {
		return element;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String ToString() {
		return "Energie " + this.element + "[" + this.number +"]";
	}
	
	public static ArrayList<Energy> getEnergies() {
		ArrayList<Energy> energyList = new ArrayList<Energy>();
		for(Card aCard : Card.getAllCards())
	        if(aCard instanceof Energy) 
	        	energyList.add((Energy) aCard);

		return energyList;
	}
}
