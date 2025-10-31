import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {

	GradeBook grade1;
	GradeBook grade2;
	
	@Before
	public void setUp() throws Exception {
		grade1 = new GradeBook(3);
		grade2 = new GradeBook(5);
	}

	@After
	public void tearDown() throws Exception {
		grade1 = null;
	}
	
	@Test
	public void addScoreTest() {
		assertEquals(true, grade1.addScore(90));
		assertEquals(true, grade1.addScore(89));
	}
	

	@Test
	public void sumTest() {
		grade1.addScore(90);
		grade1.addScore(89);
		assertEquals(179, grade1.sum(), 0);
	}
	
	@Test
	public void minimumTest() {
		grade1.addScore(90.9);
		grade1.addScore(89.3);
		assertEquals(89.3, grade1.minimum(), 0);
	}
	
	@Test
	public void finalScoreTest() {
		grade1.addScore(90.9);
		grade1.addScore(89.3);
		grade1.addScore(59.9);
		assertEquals(180.2, grade1.finalScore(), 0);
	}
	
	
	@Test
	public void getScoreSizeTest() {
		grade1.addScore(90.9);
		grade1.addScore(89.3);
		grade1.addScore(59.9);
		assertEquals(3, grade1.getScoreSize());
	}
	
	@Test
	public void toStringTest() {
		grade1.addScore(90.9);
		grade1.addScore(89.3);
		grade1.addScore(59.9);
		assertEquals("90.9 89.3 59.9 ", grade1.toString());
	}
}
