
class Node  
{ 
    int data; 
    Node left, right; 
   
    Node(int item)  
    { 
        data = item; 
        left = right = null; 
    } 
} 

public class LowestCommonAncestor 
{
	Node root;
	
	Node findLowestCommonAncestor(int x, int y)
	{
		return findLowestCommonAncestor(root, x, y);
	}
	
	Node findLowestCommonAncestor(Node node, int x, int y)
	{
		if(node == null) return null;
		if(node.data == x || node.data == y) return node;
		
		Node lowestCommonAncestorLeft = findLowestCommonAncestor(node.left, x, y);
		Node lowestCommonAncestorRight = findLowestCommonAncestor(node.right, x, y);
		
		if(lowestCommonAncestorLeft != null && lowestCommonAncestorRight != null) return node;
		else if(lowestCommonAncestorLeft != null) return lowestCommonAncestorLeft;
		else return lowestCommonAncestorRight;
	}

}
