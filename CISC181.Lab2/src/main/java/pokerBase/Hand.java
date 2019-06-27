package pokerBase;

import java.util.ArrayList;
import java.util.Collections;

import pokerEnums.eCardNo;
import pokerEnums.eHandStrength;
import pokerEnums.eRank;

public class Hand {

	private ArrayList<Card> Hand;

	public Hand() {
		ArrayList<Card> CardsInHand = new ArrayList<Card>();
		Deck cardDeck = new Deck();
		for (int counter = 1; counter <= 5; counter++) {
			CardsInHand.add(cardDeck.Draw());
		}
		Collections.sort(CardsInHand);
	}

	private ArrayList<Card> getHand() {
		return Hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.Hand = hand;
	}

	public static boolean isHandRoyalFlush(Hand h, HandScore hs) {
		boolean isRoyalFlush = false;
		//can only be royal flush if you have a flush, a straight, and your highest card is an ace
		if (isHandFlush(h, hs) && isHandStraight(h, hs) && h.getHand().get(0).geteRank() == eRank.ACE) {

			isRoyalFlush = true;

			hs.setHiHand(h.getHand().get(eCardNo.values()[0].getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			hs.setHandStrength(eHandStrength.RoyalFlush.getHandStrength());
		}
		return isRoyalFlush;
	}

	public static boolean isHandStraightFlush(Hand h, HandScore hs) {
		boolean isRoyalFlush = false;
		//can only have straight flush if you have a straight and a flush 
		if (isHandFlush(h, hs) && isHandStraight(h, hs)) {

			isRoyalFlush = true;

			hs.setHiHand(h.getHand().get(eCardNo.values()[0].getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			hs.setHandStrength(eHandStrength.StraightFlush.getHandStrength());
		}
		return isRoyalFlush;
	}
	
	public static boolean isHandFiveOfAKind(Hand h, HandScore hs) {
		boolean isFiveOfAKind = false;

		if (h.getHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getHand().get(eCardNo.FifthCard.getCardNo())
				.geteRank()) {

			hs.setHandStrength(eHandStrength.FiveOfAKind.getHandStrength());
			hs.setHiHand(h.getHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);

		}
		return isFiveOfAKind; 
	}
	

	public static boolean isHandFourOfAKind(Hand h, HandScore hs) {
		boolean bHandCheck = false;

		if (h.getHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getHand().get(eCardNo.FourthCard.getCardNo())
				.geteRank()) {

			bHandCheck = true;

			hs.setHandStrength(eHandStrength.FourOfAKind.getHandStrength());
			hs.setHiHand(h.getHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);

			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);

		} else if (h.getHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getHand()
				.get(eCardNo.FifthCard.getCardNo()).geteRank()) {

			bHandCheck = true;

			hs.setHandStrength(eHandStrength.FourOfAKind.getHandStrength());
			hs.setHiHand(h.getHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);

			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getHand().get(eCardNo.FirstCard.getCardNo()));
			hs.setKickers(kickers);
		}

		return bHandCheck;
	}

	public static boolean isHandFullHouse(Hand h, HandScore hs) {
		boolean isFullHouse = false;
		//checks to see if you have three of a kind as your highest three cards and a pair as your lowest two
		if ((h.getHand().get(0).geteRank() == h.getHand().get(2).geteRank())
				&& (h.getHand().get(3).geteRank() == h.getHand().get(4).geteRank())) {

			isFullHouse = true;

			hs.setHandStrength(eHandStrength.FullHouse.getHandStrength());
			hs.setHiHand(h.getHand().get(0).geteRank().getiRankNbr());
			hs.setLoHand(h.getHand().get(4).geteRank().getiRankNbr());

			//checks to see if you have a pair as your highest two cards and three of a kind as your lowest three
		} else if ((h.getHand().get(0).geteRank() == h.getHand().get(1).geteRank())
				&& (h.getHand().get(2).geteRank() == h.getHand().get(4).geteRank())) {

			isFullHouse = true;

			hs.setHandStrength(eHandStrength.FullHouse.getHandStrength());
			hs.setHiHand(h.getHand().get(4).geteRank().getiRankNbr());
			hs.setLoHand(h.getHand().get(1).geteRank().getiRankNbr());
		}

		return isFullHouse;
	}

	public static boolean isHandFlush(Hand h, HandScore hs) {

		boolean bIsFlush = false;
		//checks to make sure the suits of all five cards are the same
		if (h.getHand().get(0).geteSuit() == h.getHand().get(1).geteSuit()
				&& h.getHand().get(0).geteSuit() == h.getHand().get(2).geteSuit()
				&& h.getHand().get(0).geteSuit() == h.getHand().get(3).geteSuit()
				&& h.getHand().get(0).geteSuit() == h.getHand().get(4).geteSuit()) {

			bIsFlush = true;

			hs.setHiHand(h.getHand().get(eCardNo.values()[0].getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			hs.setHandStrength(eHandStrength.Flush.getHandStrength());
		}
		
		return bIsFlush;
	}

	public static boolean isHandStraight(Hand h, HandScore hs) {

		boolean bIsStraight = false;
		int FirstCardRank = h.getHand().get(0).geteRank().getiRankNbr();

		//checks to make sure the cards are consecutive ranks
		if ((h.getHand().get(1).geteRank().getiRankNbr() == FirstCardRank - 1)
				&& (h.getHand().get(2).geteRank().getiRankNbr() == FirstCardRank - 2)
				&& (h.getHand().get(3).geteRank().getiRankNbr() == FirstCardRank - 3)
				&& (h.getHand().get(4).geteRank().getiRankNbr() == FirstCardRank - 4)) {

			bIsStraight = true;

			hs.setHiHand(h.getHand().get(eCardNo.values()[0].getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			hs.setHandStrength(eHandStrength.Straight.getHandStrength());
		}
		return bIsStraight;
	}

	public static boolean isHandThreeOfAKind(Hand h, HandScore hs) {
		boolean isThreeOfAKind = false;
		int threeOfAKindRankNo = 0;
		ArrayList<Card> kickers = new ArrayList<Card>();

		//loop to check if there are any three cards with the same rank in the hand
		for (int counter = 0; counter < 3; counter++) {
			if (h.getHand().get(counter).geteRank() == h.getHand().get(counter + 1).geteRank()
					&& h.getHand().get(counter).geteRank() == h.getHand().get(counter + 1).geteRank()
					&& h.getHand().get(counter).geteRank() == h.getHand().get(counter + 2).geteRank()) {

				threeOfAKindRankNo = h.getHand().get(counter).geteRank().getiRankNbr();
				hs.setHiHand(h.getHand().get(eCardNo.values()[counter].getCardNo()).geteRank().getiRankNbr());
				hs.setLoHand(0);
				hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());

				isThreeOfAKind = true;
			}
		}
		if (isThreeOfAKind) {
			for (int counter = 0; counter < h.getHand().size(); counter++) {
				if (h.getHand().get(counter).geteRank().getiRankNbr() != threeOfAKindRankNo) {
					kickers.add(h.getHand().get(counter));
				}
			}
		}

		hs.setKickers(kickers);
		return isThreeOfAKind;
	}

	public static boolean isHandTwoPair(Hand h, HandScore hs) {

		boolean isTwoPair = false;
		int hiPairCardRankNo = 0;
		int loPairCardRankNo = 0;
		int pairCounter = 0;
		ArrayList<Card> kickers = new ArrayList<Card>();
		
		//checks the hand to see if there are two different cards with the same rank
		for (int counter1 = 0; counter1 < h.getHand().size(); counter1++) {
			for (int counter2 = counter1 + 1; counter2 < h.getHand().size(); counter2++) {
				if (h.getHand().get(counter1).geteRank() == h.getHand().get(counter2).geteRank()) {
					if (pairCounter == 0) {
						hiPairCardRankNo = h.getHand().get(counter1).geteRank().getiRankNbr();
						hs.setHiHand(h.getHand().get(eCardNo.values()[counter1].getCardNo()).geteRank().getiRankNbr());
					}

					if (pairCounter == 1) {
						loPairCardRankNo = h.getHand().get(counter1).geteRank().getiRankNbr();
						hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
						hs.setLoHand(h.getHand().get(eCardNo.values()[counter1].getCardNo()).geteRank().getiRankNbr());
						isTwoPair = true;
					}
					
					counter1 = counter2 + 1;
					counter2++;
					pairCounter++;
					continue;
				}
			}
		}

		if (isTwoPair) {
			for (int i = 0; i < h.getHand().size(); i++) {
				if (h.getHand().get(i).geteRank().getiRankNbr() != hiPairCardRankNo
						&& h.getHand().get(i).geteRank().getiRankNbr() != loPairCardRankNo) {
					kickers.add(h.getHand().get(i));
				}
			}
		}
		hs.setKickers(kickers);
		return isTwoPair;

	}

	public static boolean isHandPair(Hand h, HandScore hs) {
		boolean isPair = false;
		int pairCardRankNo = 0;
		ArrayList<Card> kickers = new ArrayList<Card>();

		//checks if there are two cards with the same rank in the hand
		for (int counter1 = 0; counter1 < h.getHand().size(); counter1++) {
			for (int counter2 = counter1 + 1; counter2 < h.getHand().size(); counter2++) {
				if (h.getHand().get(counter1).geteRank() == h.getHand().get(counter2).geteRank()) {
					pairCardRankNo = h.getHand().get(counter1).geteRank().getiRankNbr();
					hs.setHiHand(h.getHand().get(eCardNo.values()[counter1].getCardNo()).geteRank().getiRankNbr());
					hs.setHandStrength(eHandStrength.Pair.getHandStrength());

					isPair = true;
				}
			}
		}

		if (isPair) {
			for (int counter = 0; counter < h.getHand().size(); counter++) {
				if (h.getHand().get(counter).geteRank().getiRankNbr() != pairCardRankNo) {
					kickers.add(h.getHand().get(counter));
				}
			}
		}

		hs.setKickers(kickers);
		return isPair;
	}

	public static boolean isHandHighCard(Hand h, HandScore hs) {
		ArrayList<Card> kickers = new ArrayList<Card>();

		//sets high card to the first (highest ranked) card in your hand
		hs.setHandStrength(eHandStrength.HighCard.getHandStrength());
		hs.setHiHand(h.getHand().get(0).geteRank().getiRankNbr());
		hs.setLoHand(0);

		kickers.add(h.getHand().get(1));
		kickers.add(h.getHand().get(2));
		kickers.add(h.getHand().get(3));
		kickers.add(h.getHand().get(4));
		hs.setKickers(kickers);

		return true;
	}
	public static Hand PickBestHand(ArrayList<Hand> Hands) throws exHand{
		
	}
}
