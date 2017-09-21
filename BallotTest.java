import static org.junit.Assert.*;

import org.junit.Test;

public class BallotTest {
	private Ballot ballot;
	
	
	@Test
	public void sizeCountedCorrectly() {
		ballot = new Ballot("elections/election0/ballot0");
		assertEquals(3, ballot.size());
	}
	@Test
	public void sizeCountedCorrectly2() {
		ballot = new Ballot("elections/election3/ballot7");
		assertEquals(5, ballot.size());
	}
	@Test
	public void sizeCountedCorrectly3() {
		ballot = new Ballot("elections/election1/ballot2");
		assertEquals(4, ballot.size());
	}
	@Test
	public void getCorrect() {
		ballot = new Ballot("elections/election0/ballot0");
		assertEquals("Akiko", ballot.get(0));
	}
	@Test
	public void getCorrect2() {
		ballot = new Ballot("elections/election3/ballot7");
		assertEquals("Danielle", ballot.get(0));
	}
	@Test
	public void getCorrect3() {
		ballot = new Ballot("elections/election1/ballot2");
		assertEquals("Akiko", ballot.get(0));
	}

}
