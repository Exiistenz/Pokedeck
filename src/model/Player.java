package model;
import java.util.*;

public class Player {
	private String name;
	
	private List<Card> pokedeck;
	
	private int victory;
	
	private int defeat;

	public Player() {
	}
	
	public Player(String playerName) {
		name = playerName;
		victory = 0;
		defeat = 0;
		pokedeck = new ArrayList<Card>();
	}
	
	public String getName() {
		return name;
	}

	public List<Card> getPokedeck() {
		return pokedeck;
	}

	public int getVictory() {
		return victory;
	}

	public int getDefeat() {
		return defeat;
	}
	
	public boolean addCard(Card aCard) {
		return pokedeck.add(aCard);
	}
	
	public boolean removeCard(Card aCard) {
		return pokedeck.remove(aCard);
	}
	
}
