import static org.junit.Assert.*;

import org.junit.Test;


public class Uppg1Test {

	@Test
	public void testAddFirst() {
		Uppg1 u1 = new Uppg1();
		Uppg1 u2 = new Uppg1(2);
		
		u1.addFirst("test");
		
		assertTrue(u1.getFirst().equals("test"));
		
		u1.addFirst("test2");
		
		assertFalse(u1.getFirst().equals("test"));
		
		u2.addFirst("1");
		u2.addFirst("2");
		u2.addFirst("3");
		
		assertTrue(u2.getFirst().equals("3"));
		assertTrue(u2.getP(1).equals("2"));
		assertTrue(u2.getP(2).equals("1"));
	}

	@Test
	public void testEmpty() {
		Uppg1 u = new Uppg1();
		
		assertTrue(u.empty());
		
		u.addFirst("test");
		
		assertFalse(u.empty());
	}

	@Test
	public void testGetFirst() {
		Uppg1 u = new Uppg1();
		
		u.addFirst("test");
		
		assertTrue(u.getFirst().equals("test"));
	}

	@Test
	public void testRemoveFirst() {
		Uppg1 u = new Uppg1();
		
		u.addFirst("test");
		
		String test1 = u.getFirst();
		
		u.removeFirst();
		String test2 = u.getFirst();
		assertNotSame(test1, test2);
	}

	@Test
	public void testExistP() {
		Uppg1 u = new Uppg1();
		
		u.addFirst("test");
		
		assertTrue(u.existP("test"));
	}

	@Test
	public void testExistPset() {
		Uppg1 u = new Uppg1();
		
		u.addFirst("test");
		
		assertTrue(u.existP("test"));
		//TODO Add tests for where P is
	}

}
