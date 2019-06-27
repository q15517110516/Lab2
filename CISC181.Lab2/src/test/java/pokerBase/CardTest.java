package pokerBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eRank;
import pokerEnums.eSuit;

public class CardTest {
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
	public void geteSuitTest() {
		Card testCard = new Card(eSuit.CLUBS, eRank.ACE, 0);
		assertEquals(testCard.geteSuit(), eSuit.CLUBS);
	}

	@Test
	public void geteRankTest() {
		Card testCard = new Card(eSuit.DIAMONDS, eRank.KING, 0);
		assertEquals(testCard.geteRank(), eRank.KING);
	}

	@Test
	public void getiCardNbr() {
		Card testCard = new Card(eSuit.HEARTS, eRank.TWO, 1);
		assertEquals(testCard.getiCardNbr(), 1);
	}
}
