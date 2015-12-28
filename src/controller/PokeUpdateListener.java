package controller;

import java.awt.event.*;

import javax.swing.JComboBox;

import gui.PokedeckGUI;
import model.Attack;
import model.Card;
import model.Energy;
import model.Pokemon;


public class PokeUpdateListener implements ItemListener {
	private PokedeckGUI myView;
	
	public PokeUpdateListener(PokedeckGUI view) {
		myView = view;
	}
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() instanceof JComboBox) {
			 @SuppressWarnings("unchecked")
			JComboBox<Card> cbx = (JComboBox<Card>) e.getSource();
	         if (cbx.getSelectedItem() != null && (e.getStateChange() == ItemEvent.SELECTED)) {
	        	 Pokemon aPoke = (Pokemon) cbx.getSelectedItem();
	        	 myView.setModifLevel(aPoke.getLevel());
	        	 myView.setModifHealth(aPoke.getHealth());
	        	 myView.setModifType(aPoke.getType());
	        	 myView.setModifInfo(aPoke.getInfo());
	        	 myView.setModifPower(aPoke.getPower());
	        	 myView.setModifResistance(aPoke.getResistance());
	        	 myView.setModifRetirement(aPoke.getRetirementCost());
	        	 myView.setModifWickness(aPoke.getWickness());
	        	 
	        	 Attack attck = null;
	        	 
	        	 for (Attack anAttack : aPoke.getListAttack()) {
	        		 attck = anAttack;
	        		 break;
				 }
	        	 
	        	 myView.setModifAttackName(attck.getName());
	        	 myView.setModifAttackDesc(attck.getDescription());
	        	 myView.setModifAttackDamage(attck.getDamage());
	        	 myView.setModifAttackCost((Energy) attck.getCost());      	 
	         }
		}
	}
	
	/*@Override
	public String toString() {
		Pokemon aPoke = (Pokemon) cbx.getSelectedItem();
	    return aPoke.getName();
	}*/
}

