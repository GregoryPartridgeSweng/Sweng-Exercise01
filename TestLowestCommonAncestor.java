import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestLowestCommonAncestor {

	@Test
	public void testLowestCommonAncestor() {
		LowestCommonAncestor test = new LowestCommonAncestor();
		
		test.root = new Node(1); 
		test.root.left = new Node(2); 
		test.root.right = new Node(3); 
		test.root.left.left = new Node(4); 
		test.root.left.right = new Node(5); 
		test.root.right.left = new Node(6); 
		test.root.right.right = new Node(7);
        
		assertEquals(test.findLowestCommonAncestor(6, 7).data, 3);
		assertEquals(test.findLowestCommonAncestor(1, 7).data, 1);
		assertEquals(test.findLowestCommonAncestor(4, 5).data, 2);
		assertEquals(test.findLowestCommonAncestor(2, 5).data, 2);
	}

}
