
import java.io.*; 
import java.util.*; 

class Node  
{ 
    static int data;
   
    Node(int data)  
    {  
        data = data;
    } 
} 

class Graph
{
	int length;
	ArrayList[] adj;
	Node[] listOfNodes;
	int currentNode;
	
	Graph(int length)
	{
		length = length;
		currentNode = 0;
		listOfNodes = new Node[length];
		adj = new ArrayList[length]; 
        for (int i=0; i < length; ++i) 
        {
            adj[i] = new ArrayList<Node>();
        }
	}
	
	void addNode(Node node)
	{
		listOfNodes[currentNode++] = node;
	}
	
	int getSize(int index)
	{
		return adj[index].size();
	}
	
	Node getEdge(int index, int edge)
	{
		return (Node) adj[index].get(edge);
	}
	
	void addEdge(int parentNode, int data) 
    { 
		if(parentNode >= data) {
			System.out.println("Error");
			return;
		}
        Node node = new Node(data); 
        adj[parentNode].add(node);
        addNode(node);
    }
}

public class LowestCommonAncestor 
{
	boolean[] foundXAndY;
	
	Node findLowestCommonAncestor(int x, int y, Graph adj)
	{
		return findLowestOneByOne(x, y, adj);
	}
	
	Node findLowestOneByOne(int x, int y, Graph adj)
	{
		
		Node currentAnswer = null;
		foundXAndY = new boolean[2];
		
		for(int i = 0; i <= x || i <= y ; i++)
		{
			Arrays.fill(foundXAndY, Boolean.FALSE);
			Node currNode = adj.listOfNodes[i];
			findLowestCommonAncestor(currNode, x, y, adj);
			if(foundXAndY[0] && foundXAndY[1]) currentAnswer = currNode;
		}
		
		return currentAnswer;
	}
	
	void findLowestCommonAncestor(Node node, int x, int y, Graph adj)
	{
		if(Node.data == x) foundXAndY[0] = true;
		if(Node.data == y) foundXAndY[1] = true;
		
		int size = adj.getSize(Node.data);
		
		if(size == 0) return;
		
		for(int i = 0; i < size; i++)
		{
			findLowestCommonAncestor(adj.getEdge(Node.data, i), x, y, adj);
		}
	}
	
	Graph newGraph(int number) 
    { 
        return new Graph(number); 
    } 

}
