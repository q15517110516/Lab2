package pokerBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeckTest {

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
	public void BuildDeckTest() {
		Deck d = new Deck();
		assertTrue(d.DeckSize() == 52);
	}

	@Test
	public void DeckDrawTest() {
		Deck d = new Deck();
		d.Draw();
		assertTrue(d.DeckSize() == 51);
	}
}