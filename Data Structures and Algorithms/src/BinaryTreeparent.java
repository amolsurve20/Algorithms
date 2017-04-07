
public class BinaryTreeparent 
{
	public static class Node
	{
		int data;
		Node left;
		Node right;
		Node parent;
	
	
	public Node(int data)
	{
		this.data=data;
	}
	}
	


	public static Node nextBiggest(Node node)
	{
		if(node==null)
			return null;
		
		if(node.right!=null)
			return getLeftMost(node.right);
		
		Node parent=node.parent;
		
		
		while(parent!=null&&node==parent.right)
		{
			node=parent;
			parent=parent.parent;
		}
		
		return parent;
		
	}
	
	public static Node getLeftMost(Node node)
	{
		if(node==null)
			return null;
		
		while(node.left!=null)
		{
			node=node.left;
		}
		return node;
	}
	}
	


