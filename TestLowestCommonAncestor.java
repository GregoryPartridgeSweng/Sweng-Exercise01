import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestLowestCommonAncestor {

	@Test
	public void testLowestCommonAncestor() {
		LowestCommonAncestor test = new LowestCommonAncestor();
		
	Graph dag = test.newGraph(7);
	dag.addEdge(0,1);
	dag.addEdge(0,3);
	dag.addEdge(1,2);
	dag.addEdge(1,5);
	dag.addEdge(3,4);
	dag.addEdge(4,5);
	dag.addEdge(5,6);
	
	assertEquals(test.findLowestCommonAncestor((Integer) 0, 0, dag).data, 0);
	assertEquals(test.findLowestCommonAncestor((Integer) 2, 4, dag).data, 0);
	assertEquals(test.findLowestCommonAncestor((Integer) 5, 6, dag).data, 5);
	assertEquals(test.findLowestCommonAncestor((Integer) 3, 4, dag).data, 3);
	assertEquals(test.findLowestCommonAncestor((Integer) 1, 2, dag).data, 1);
	}

}
