package pokerBase;

import java.util.ArrayList;
import java.util.Collections;

import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Deck {

	private ArrayList<Card> deckCards = new ArrayList<Card>();

	public Deck() {
		int iCardNbr = 1;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				deckCards.add(new Card(eSuit, eRank, iCardNbr++));
			}
		}
		Collections.shuffle(deckCards);
	}

	public Card Draw() {
		//creates a variable that holds the first card
		Card tempCard = deckCards.get(0);
		//removes the card from the deck
		deckCards.remove(0);
		//returns the removed card
		return tempCard;
	}

	public ArrayList<Card> getDeckCards() {
		return deckCards;
	}

	public int DeckSize() {
		return deckCards.size();
	}
}
