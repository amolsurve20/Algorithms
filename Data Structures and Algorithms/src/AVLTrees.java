import java.util.*;
import java.util.Queue;



class ANode
{
	int key,height;
	ANode left,right;
	
	public ANode(int data)
	{
		key=data;
		height=1;
	}
}
public class AVLTrees 
{
	ANode node;
	public int height(ANode node)
	{
		if(node==null)
			return 0;
		
		return node.height;
	}
	
	public ANode rightRotate(ANode y)
	{
		ANode x=y.left;
		ANode t2=x.right;
		
		x.right=y;
		y.left=t2;
		
		
		y.height=Math.max(height(y.left), height(y.right))+1;
		x.height=Math.max(height(x.left), height(x.right))+1;
		
		return x;
		
	}
	
	public ANode leftRotate(ANode x)
	{
		ANode y=x.right;
		ANode t2=y.left;
		
		y.left=x;
		x.right=t2;
		
		x.height=Math.max(height(x.left), height(x.right))+1;
		y.height=Math.max(height(y.left), height(y.right))+1;
		
		return y;
		
		
	}
	
	public int heightDifference(ANode x)
	{
		if(x==null)
			return 0;
		
		return height(x.left)-height(x.right);
	}
	
	public ANode insert(ANode node, int key)
	{
		ANode newnode=new ANode(key);//Creating a new node to insert
		
		//Check for the null tree
		if(node==null)
			return newnode;
		
		//Perform Binary Tree Insertion
		if(key<node.key)
			node.left=insert(node.left,key);
		else
			if(key>node.key)
				node.right=insert(node.right,key);
			else
				return node;
		
		//Update height
		node.height=1+Math.max(height(node.left),height(node.right));
		
		//Get the height difference to perform further rotations if necessary
		
		int balance=heightDifference(node);
		
		//Following are the four cases to perform rotations based on the 
		//node positions and the difference value
		
		//Left-Left Case
		if(balance>1 && key<node.left.key)
		{
			return rightRotate(node);
		}
		
		//Right-right Case
		if(balance<-1 && key>node.right.key)
		{
			return leftRotate(node);
		}
		
		//Left-Right Case
		if(balance>1 && key>node.left.key)
		{
			node.left= leftRotate(node.left);
			return rightRotate(node.right);
		}
		
		//Left-Right Case
		if(balance<-1 && key<node.right.key)
		{
			node.right= rightRotate(node.right);
			return leftRotate(node.left);
		}
		return node;
	}
	
	public void preOrder(ANode root)
	{
		if(root==null)
			return;
		System.out.println(root.key);
		preOrder(root.left);
		preOrder(root.right);
		
	}
	
	public static void printLevels(ANode root)
	{
		if(root==null)
			return;
		
		Queue<ANode>queue=new LinkedList<ANode>();
		
		queue.add(root);
		
		int h=0,levelNodes;
		
		while(!queue.isEmpty())
		{
			h++;
			levelNodes=queue.size();
			
			while(levelNodes>0)
			{
				ANode t=queue.poll();
				System.out.print(t.key);
				if(t.left!=null)
					queue.add(t.left);
				if(t.right!=null)
					queue.add(t.right);
				levelNodes--;
			}
			
			System.out.println("----------");
			System.out.println("height is "+h);
			System.out.println("----------");
		}

		
	}
		
		public static void main(String args[])
		{
			
			
			AVLTrees tree=new AVLTrees();
			
			tree.node=tree.insert(tree.node,10);
			tree.node=tree.insert(tree.node,20);
			tree.node=tree.insert(tree.node,30);
			tree.node=tree.insert(tree.node,40);
			tree.node=tree.insert(tree.node,50);
			tree.node=tree.insert(tree.node,60);
			tree.node=tree.insert(tree.node,70);
			
			printLevels(tree.node);
			
			
		
		}

}
