package controller;

import gui.PokedeckGUI;
import model.Attack;
import model.Player;
import model.Pokemon;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;

public class EventListener implements ActionListener {
	private PokedeckGUI myView;
	
	public EventListener(PokedeckGUI view) {
		myView = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		Player trainer = new Player("Sasha");
		if (source instanceof JButton) {
		    JButton button = (JButton) source;
		    if (button.getText() == "Ajouter"){
		    	Attack pokeAttack = new Attack(myView.getAttackName(), myView.getAttackDesc(), myView.getAttackDamage(), myView.getAttackCost());
		    	Pokemon aPokemon = new Pokemon(myView.getPokeName(), 
		    			myView.getPokeHealth(), myView.getPokeType(), myView.getPokePower(), myView.getPokeWickness(), myView.getPokeResistance(),
		    			myView.getPokeRetirement(), myView.getPokeInfo(), myView.getPokeLevel());
		    	aPokemon.addAttack(pokeAttack);
		    	trainer.addCard(aPokemon);
		    	System.out.println("Add");
		    	System.out.println(myView.getPokeName());
		    }
		    else if (button.getText() == "Modifier"){
		    	Pokemon pokeSelect = myView.getCbxPokemonChoice();
		    	pokeSelect.setHealth(myView.getModifHealth());
		    	pokeSelect.setLevel(myView.getModifLevel());
		    	pokeSelect.setType(myView.getModifType());
		    	pokeSelect.setInfo(myView.getModifInfo());
		    	pokeSelect.setPower(myView.getModifPower());
		    	pokeSelect.setResistance(myView.getModifResistance());
		    	pokeSelect.setRetirementCost(myView.getModifRetirement());
		    	pokeSelect.setWickness(myView.getModifWickness());
		    	
		    	ArrayList<Attack> attackList = pokeSelect.getListAttack();
		    	
		    	Attack curAttack = null;
		    	
		    	for (Attack attack : attackList) {
		    		curAttack = attack;
		    		break;
				}
		    	
		    	curAttack.setDamage(myView.getModifAttackDamage());
		    	curAttack.setDescription(myView.getModifAttackDesc());
		    	curAttack.setName(myView.getModifAttackName());
		    	
		    	System.out.println("Modify");
		    }
		    else if (button.getText() == "Supprimer"){
		    	trainer.removeCard(myView.getCbxNamePoke());
		    	System.out.println("Delete");
		    }
		}
		
	}

}
