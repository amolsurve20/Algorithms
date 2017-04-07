class Node1
{
	int data;
	Node1 left;
	Node1 right;
	Node1 parent;
	
	public Node1(int data)
	{
		this.data=data;
	}
	
}

public class BinaryTreeInorderSuccessorORNextBiggest 
{
	
	public static Node1 nextBiggest(Node1 root)
	{
		if(root==null)
			return null;
		
		if(root.right!=null)
			return getLeftMost(root.right);
		
		Node1 parent=root.parent;
		
		while(parent!=null&&root==parent.right)
		{
			root=parent;
			parent=parent.parent;
		}
		
		return parent;
	}
	
	public static Node1 getLeftMost(Node1 root)
	{
		if(root==null)
			return null;
		
		while(root.left!=null)
		{
			root=root.left;
		}
		
		return root;
	}
	
	public Node1 getFirstCommonANceston(Node1 root1, Node1 root2)
	{
		int diff=depth(root1)-depth(root2);
		
		Node1 first,second;
		if(diff<0)
		{
			first=root1;
			second=root2;
		}
		else
		{
			first=root2;
			second=root1;
		}
		
		second=goUpBy(second,Math.abs(diff));
		
		while(first!=null&&second!=null&&first!=second)
		{
			first=first.parent;
			second=second.parent;
		}
		
		if(first==null||second==null)
			return null;
		else
			return first;
		
	}
	
	public static int depth(Node1 root)
	{
		int d=0;
		while(root!=null)
		{
			root=root.parent;
			d++;
		}
		return d;
	}
	
	public static Node1 goUpBy(Node1 root, int delta)
	{
		while(delta>0&&root!=null)
		{
			root=root.parent;
			delta--;
		}
		return root;
	}
	
	public boolean containsTree(Node1 root1, Node1 root2)
	{
		StringBuilder string1=new StringBuilder();
		StringBuilder string2=new StringBuilder();
		
		getNewString(string1, root1);
		getNewString(string2, root2);
		
		String str1=string1.toString();	
		String str2=string2.toString();	
		
		if(str1.contains(str2))
			return true;
		else
			return false;
	
	}
	
	public void getNewString(StringBuilder sb,Node1 root)
	{
		if(root==null)
		{
			sb.append('X'+" ");
			return;
		}
		
		sb.append(root.data+"");
		getNewString(sb,root.left);
		getNewString(sb,root.right);
	
	}
	
}
