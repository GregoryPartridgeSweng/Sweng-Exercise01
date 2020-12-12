import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestLowestCommonAncestor {

	@Test
	public void testLowestCommonAncestor() {
		LowestCommonAncestor test = new LowestCommonAncestor(8);
		
	test.addEdge(0, 1);
	test.addEdge(0, 3);
	test.addEdge(1, 2);
	test.addEdge(1, 5);
	test.addEdge(3, 4);
	test.addEdge(4, 5);
	test.addEdge(5, 6);
	
	assertEquals(test.LCA(0, 0), 0);
	assertEquals(test.LCA(2, 4), 0);
	assertEquals(test.LCA(5, 6), 5);
	assertEquals(test.LCA(3, 4), 3);
	assertEquals(test.LCA(1, 2), 1);
	}

}