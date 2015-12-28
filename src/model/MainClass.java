package model;
import java.io.FileNotFoundException;
import java.io.IOException;

import gui.PokedeckGUI;


public class MainClass {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Card.deserialize();
		
		Player trainer = new Player("Sasha");
		Energy feu = new Energy("Feu", "feu", 1);
		Energy eau = new Energy("Eau", "eau", 1);
		Energy elec = new Energy("elec", "elec", 1);
		
		Pokemon poke = new Pokemon("Pika", 100, "Electrique", "Power", "Eau", "Vent", 3, "Blabla", 2);
		Attack att = new Attack("test", "fsgdg", 50, eau);
		poke.addAttack(att);
		
		Pokemon poke1 = new Pokemon("Salameche", 200, "Feu", "Power", "Eau", "Vent", 3, "Blabla", 2);
		Attack att1 = new Attack("tesgft", "fsgdg", 50, feu);
		poke1.addAttack(att1);
		
		Pokemon poke2 = new Pokemon("gdfgdgd", 200, "Feu", "Power", "Eau", "Vent", 3, "Blabla", 2);
		Attack att2 = new Attack("testf", "fsggfdgdg", 150, elec);
		poke2.addAttack(att2);
		
		trainer.addCard(poke);
		trainer.addCard(poke1);
		
		PokedeckGUI gui = new PokedeckGUI();
		gui.ConstructGUI();

	}
}
