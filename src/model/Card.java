package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Card implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//protected int id;
	protected String name;
	protected static ArrayList<Card> allCards = new ArrayList<Card>();

	public Card() {
	}
	
	public Card(String cardName) {
		name = cardName;
	}

	public String getName() {
		return name;
	}
	
	public static ArrayList<Card> getAllCards() {
		return allCards;
	}
	
	public static int serialize() {
		try
		{
			FileOutputStream fileOut = new FileOutputStream("dataAppli.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(allCards);
			out.close();
			fileOut.close();
		} 
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		return 3;
	}

	@SuppressWarnings("unchecked")
	public static void deserialize() {
		try
		{
			FileInputStream fileIn = new FileInputStream("dataAppli.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			allCards = (ArrayList<Card>) in.readObject();
			in.close();
			fileIn.close();
		} 
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			return;
		} 
		catch(ClassNotFoundException c)
		{
			System.out.println("Product class not found");
			c.printStackTrace();
			return;
		}
	}
	
	public static ArrayList<Card> search(String search) {
		ArrayList<Card> response = new ArrayList<Card>();
		int find;
		for(Card aCard : allCards) {
			find = search.compareToIgnoreCase(aCard.getName());
			if(find >= -5 && find <= 5)
				response.add(aCard);
		}
		
		return response.size() == 0 ? null : response;
	}
	
}
