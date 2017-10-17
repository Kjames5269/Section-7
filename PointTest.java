import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void test() {
		Point p = new Point(5,3);
		assertEquals(p.x, 5);
		assertTrue(p.y == 3);
		assertFalse(false); // Success!
		
	}
	
	@Test
	public void eqTest() {
		Point p = new Point(3,3);
		Point p2 = new Point(3,3);
		Point p3 = new Point(3,4);
		
		assertTrue(p.eq(p2));
		assertFalse(p.eq(p3));
		assertTrue(p.ne(p3));
	}
	
	@Test
	public void isGreaterEq() {
		assertFalse(true);
		// TODO
	}
}
