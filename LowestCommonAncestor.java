import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LowestCommonAncestor {

	int vertexTotal;
	int Y;
	ArrayList<Integer>[] adjacent;
	int[] edgesToVertex;
	boolean[] marked;
	boolean[] stack;
	boolean DAG; 

	public LowestCommonAncestor(int vertexTotal) 
	{ 
		this.vertexTotal = vertexTotal;
		this.Y = 0;
		
		edgesToVertex = new int[vertexTotal];
		adjacent = (ArrayList<Integer>[]) new ArrayList[vertexTotal];
		for (int v = 0; v < vertexTotal; v++) adjacent[v] = new ArrayList<Integer>();
		
		DAG = true;
		marked = new boolean[vertexTotal];
		stack = new boolean[vertexTotal];
	}

	public void addEdge(int vertex1, int vertex2) {
		if(vertex1 < 0 || vertex2 < 0 || vertex1 >= vertexTotal || vertex2 >= vertexTotal) return;
		adjacent[vertex1].add(vertex2);
		edgesToVertex[vertex2]++;
		Y++;
	}

	public void acyclic(int vertex) {
		stack[vertex] = true;
		marked[vertex] = true;

		for (int counter : adjacent[vertex]) 
		{
			if (!marked[counter]) acyclic(counter);
			else if (stack[counter])
			{
				DAG = false;
				return;
			}
		}
		stack[vertex] = false;
	}

	public void isAcyclic() {
		for (int i = 0; i < vertexTotal && DAG; i++) {
			stack = new boolean[vertexTotal];
			marked = new boolean[vertexTotal];
			acyclic(i);
		}
	}
	
	public LowestCommonAncestor reverse() {
		LowestCommonAncestor reverse = new LowestCommonAncestor(vertexTotal);
		for (int count = 0; count < vertexTotal; count++) for (int counter : adjacent[count]) reverse.addEdge(counter, count);
		return reverse;
	}

	public int LCA(int vertex1, int vertex2) {

		if (!DAG || Y == 0) return -1;
		
		boolean commonAncestor = false;

		LowestCommonAncestor reversed = this.reverse();
		ArrayList<Integer> commonAncestors = new ArrayList<Integer>();

		ArrayList<Integer> branch1 = reversed.BreadthFirstSearch(vertex1);
		ArrayList<Integer> branch2 = reversed.BreadthFirstSearch(vertex2);

		for (int i = 0; i < branch1.size(); i++) 
		{
			for (int t = 0; t < branch2.size(); t++) 
			{
				if (branch1.get(i) == branch2.get(t)) 
				{
					commonAncestors.add(branch1.get(i));
					commonAncestor = true;
				}
			}
		}
		if (commonAncestor) return commonAncestors.get(0);
		else return -1;
	}

	private ArrayList<Integer> BreadthFirstSearch(int vertex) {
		boolean isVisited[] = new boolean[vertexTotal];
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		ArrayList<Integer> finalResult = new ArrayList<Integer>();

		linkedList.add(vertex);
		isVisited[vertex] = true;

		while (linkedList.size() != 0) 
		{
			vertex = linkedList.poll();
			
			finalResult.add(vertex);
			Iterator<Integer> iterator = adjacent[vertex].listIterator();
			
			while (iterator.hasNext()) 
			{
				int n = iterator.next();
				if (!isVisited[n]) 
				{ 
					isVisited[n] = true;
					linkedList.add(n);
				}
			}
		}

		return finalResult;
	}

}