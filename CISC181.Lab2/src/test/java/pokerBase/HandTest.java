package pokerBase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pokerEnums.eRank;
import pokerEnums.eSuit;

public class HandTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestRoyalFlush() {
		Hand testHand = new Hand();
		HandScore testHS = new HandScore();
		ArrayList<Card> RoyalFlush = new ArrayList<Card>();
		boolean test;

		RoyalFlush.add(new Card(eSuit.SPADES, eRank.ACE, 0));
		RoyalFlush.add(new Card(eSuit.SPADES, eRank.KING, 1));
		RoyalFlush.add(new Card(eSuit.SPADES, eRank.QUEEN, 2));
		RoyalFlush.add(new Card(eSuit.SPADES, eRank.JACK, 3));
		RoyalFlush.add(new Card(eSuit.SPADES, eRank.TEN, 4));
		
		Collections.sort(RoyalFlush);
		testHand.setHand(RoyalFlush);
		test = Hand.isHandRoyalFlush(testHand, testHS);
		assertTrue(test);
	}
	
	@Test
	public void TestStraightFlush() {
		Hand testHand = new Hand();
		HandScore testHS = new HandScore();
		ArrayList<Card> StraightFlush = new ArrayList<Card>();
		boolean test;

		StraightFlush.add(new Card(eSuit.SPADES, eRank.SEVEN, 0));
		StraightFlush.add(new Card(eSuit.SPADES, eRank.SIX, 1));
		StraightFlush.add(new Card(eSuit.SPADES, eRank.FIVE, 2));
		StraightFlush.add(new Card(eSuit.SPADES, eRank.FOUR, 3));
		StraightFlush.add(new Card(eSuit.SPADES, eRank.THREE, 4));

		Collections.sort(StraightFlush);
		testHand.setHand(StraightFlush);
		test = Hand.isHandStraightFlush(testHand, testHS);
		assertTrue(test);
	}

	@Test
	public void TestFourOfAKind() {
		Hand testHand = new Hand();
		HandScore testHS = new HandScore();
		ArrayList<Card> FourOfAKind = new ArrayList<Card>();
		boolean test;

		FourOfAKind.add(new Card(eSuit.SPADES, eRank.ACE, 0));
		FourOfAKind.add(new Card(eSuit.CLUBS, eRank.ACE, 1));
		FourOfAKind.add(new Card(eSuit.HEARTS, eRank.ACE, 2));
		FourOfAKind.add(new Card(eSuit.DIAMONDS, eRank.ACE, 3));
		FourOfAKind.add(new Card(eSuit.CLUBS, eRank.TWO, 4));

		Collections.sort(FourOfAKind);
		testHand.setHand(FourOfAKind);
		test = Hand.isHandFourOfAKind(testHand, testHS);
		assertTrue(test);
	}
	
	@Test
	public void TestFullHouse() {
		Hand testHand = new Hand();
		HandScore testHS = new HandScore();
		ArrayList<Card> FullHouse = new ArrayList<Card>();
		boolean test;

		FullHouse.add(new Card(eSuit.CLUBS, eRank.THREE, 0));
		FullHouse.add(new Card(eSuit.SPADES, eRank.KING, 1));
		FullHouse.add(new Card(eSuit.DIAMONDS, eRank.THREE, 2));
		FullHouse.add(new Card(eSuit.HEARTS, eRank.KING, 3));
		FullHouse.add(new Card(eSuit.SPADES, eRank.THREE, 4));

		Collections.sort(FullHouse);
		testHand.setHand(FullHouse);
		test = Hand.isHandFullHouse(testHand, testHS);
		assertTrue(test);
	}
	
	@Test
	public void TestFlush() {
		Hand testHand = new Hand();
		HandScore testHS = new HandScore();
		ArrayList<Card> Flush = new ArrayList<Card>();
		boolean test;

		Flush.add(new Card(eSuit.SPADES, eRank.ACE, 0));
		Flush.add(new Card(eSuit.SPADES, eRank.JACK, 1));
		Flush.add(new Card(eSuit.SPADES, eRank.NINE, 2));
		Flush.add(new Card(eSuit.SPADES, eRank.SEVEN, 3));
		Flush.add(new Card(eSuit.SPADES, eRank.FOUR, 4));

		Collections.sort(Flush);
		testHand.setHand(Flush);
		test = Hand.isHandFlush(testHand, testHS);
		assertTrue(test);
	}
	
	@Test
	public void TestStraight() {
		Hand testHand = new Hand();
		HandScore testHS = new HandScore();
		ArrayList<Card> Straight = new ArrayList<Card>();
		boolean test;

		Straight.add(new Card(eSuit.HEARTS, eRank.SEVEN, 0));
		Straight.add(new Card(eSuit.SPADES, eRank.SIX, 1));
		Straight.add(new Card(eSuit.CLUBS, eRank.THREE, 2));
		Straight.add(new Card(eSuit.DIAMONDS, eRank.FIVE, 3));
		Straight.add(new Card(eSuit.CLUBS, eRank.FOUR, 4));

		Collections.sort(Straight);
		testHand.setHand(Straight);
		test = Hand.isHandStraight(testHand, testHS);
		assertTrue(test);
	}
	
	@Test
	public void TestThreeOfAKind() {
		Hand testHand = new Hand();
		HandScore testHS = new HandScore();
		ArrayList<Card> ThreeOfAKind = new ArrayList<Card>();
		boolean test;

		ThreeOfAKind.add(new Card(eSuit.SPADES, eRank.FIVE, 0));
		ThreeOfAKind.add(new Card(eSuit.CLUBS, eRank.FIVE, 1));
		ThreeOfAKind.add(new Card(eSuit.HEARTS, eRank.FIVE, 2));
		ThreeOfAKind.add(new Card(eSuit.DIAMONDS, eRank.THREE, 3));
		ThreeOfAKind.add(new Card(eSuit.SPADES, eRank.KING, 4));

		Collections.sort(ThreeOfAKind);
		testHand.setHand(ThreeOfAKind);
		test = Hand.isHandThreeOfAKind(testHand, testHS);
		assertTrue(test);
	}
	
	@Test
	public void TestTwoPair() {
		Hand testHand = new Hand();
		HandScore testHS = new HandScore();
		ArrayList<Card> TwoPair = new ArrayList<Card>();
		boolean test;

		TwoPair.add(new Card(eSuit.SPADES, eRank.ACE, 0));
		TwoPair.add(new Card(eSuit.CLUBS, eRank.ACE, 1));
		TwoPair.add(new Card(eSuit.SPADES, eRank.TWO, 2));
		TwoPair.add(new Card(eSuit.DIAMONDS, eRank.TWO, 3));
		TwoPair.add(new Card(eSuit.CLUBS, eRank.SEVEN, 4));

		Collections.sort(TwoPair);
		testHand.setHand(TwoPair);
		test = Hand.isHandTwoPair(testHand, testHS);
		assertTrue(test);
	}
	
	@Test
	public void TestOnePair() {
		Hand testHand = new Hand();
		HandScore testHS = new HandScore();
		ArrayList<Card> Pair = new ArrayList<Card>();
		boolean test;

		Pair.add(new Card(eSuit.SPADES, eRank.ACE, 0));
		Pair.add(new Card(eSuit.CLUBS, eRank.ACE, 1));
		Pair.add(new Card(eSuit.SPADES, eRank.SEVEN, 2));
		Pair.add(new Card(eSuit.DIAMONDS, eRank.FIVE, 3));
		Pair.add(new Card(eSuit.HEARTS, eRank.TWO, 4));

		Collections.sort(Pair);
		testHand.setHand(Pair);
		test = Hand.isHandPair(testHand, testHS);
		assertTrue(test);
	}
	
	@Test
	public void TestHighCard() {
		Hand testHand = new Hand();
		HandScore testHS = new HandScore();
		ArrayList<Card> HighCard = new ArrayList<Card>();
		boolean test;

		HighCard.add(new Card(eSuit.SPADES, eRank.ACE, 0));
		HighCard.add(new Card(eSuit.CLUBS, eRank.QUEEN, 1));
		HighCard.add(new Card(eSuit.DIAMONDS, eRank.TEN, 2));
		HighCard.add(new Card(eSuit.CLUBS, eRank.SEVEN, 3));
		HighCard.add(new Card(eSuit.SPADES, eRank.TWO, 4));

		Collections.sort(HighCard);
		testHand.setHand(HighCard);
		test = Hand.isHandHighCard(testHand, testHS);
		assertTrue(test);
	}
}