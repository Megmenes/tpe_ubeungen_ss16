package de.hsmannheim.tpe.ss16.gruppe13.uebung1_b_baum_final;
import org.junit.*;
import static org.junit.Assert.*;

public class testTree {

	public BTreeImpl tree;
	
	@Before
	public void setUp() {
		tree = new BTreeImpl(3);
	}
	
	@Test
	public void isEmpty() {
		assertEquals(tree.isEmpty(), true);
	}
	
	@Test
	public void insertIsEmpty() {
		tree.insert(new Integer(3));
		assertEquals(tree.isEmpty(), false);
	}
}
