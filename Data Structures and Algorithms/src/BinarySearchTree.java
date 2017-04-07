import java.util.*;

public class BinarySearchTree 
{
	public static class TreeNode
	{
		TreeNode left;
		TreeNode right;
		int data;
	
	
		public TreeNode(int dd)
		{
			data=dd;
		}
	}
	
	public static void levelorder(TreeNode root)
	{
		if(root==null)
			return;
		
		Queue<TreeNode>queue=new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			TreeNode temp=queue.poll();
			System.out.println(temp.data);
			
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
			
		}
		
	}
	
	public static int getHeight(TreeNode root)
	{
		if(root==null)
			return 0;
		else
		{
			int left=getHeight(root.left);
			int right=getHeight(root.right);
			int height=Math.max(left, right);
			return height+1;
			
		}		
		
	}
	
	public static int sumTree(TreeNode root)
	{
		if(root==null)
			return 0;
		else
			return root.data+sumTree(root.left)+sumTree(root.right);
	}
	
	public static void trimTillHeight(TreeNode root, int h)
	{
		if(root==null)
			return;
		
			if(h==0)
			{
				root.data=sumTree(root);
				root.left=null;
				root.right=null;
			}
		trimTillHeight(root.left,h-1);
		trimTillHeight(root.right,h-1);
			
		
	}
	
	
	public static void printLevels(TreeNode root)
	{
		if(root==null)
			return;
		
		int levelNodes=0;
		int h=0;

		Queue<TreeNode>queue=new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			h++;
			levelNodes=queue.size();
			
			while(levelNodes>0)
			{
				TreeNode temp=queue.poll();
				System.out.print(temp.data+" ");
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
				levelNodes--;
			}
			System.out.println("");
			System.out.println("height="+h);
			System.out.println("-------------------");
		}
		
		
	}
	
	public static void depthFirst(TreeNode root)
	{
		if(root==null)
			return;
		
		Stack<TreeNode>stack=new Stack<TreeNode>();	
		stack.push(root);
		
		while(!stack.isEmpty())
		{
			TreeNode temp=stack.pop();
			System.out.println(temp.data);
			if(temp.left!=null)
				stack.push(temp.left);
			if(temp.right!=null)
				stack.push(temp.right);
			
		}
	}
	
	public static void zigZagTraversal(TreeNode root)
	{
		if(root==null)
			return;
		Stack<TreeNode>stackmain=new Stack<TreeNode>();
		stackmain.push(root);
		boolean directionflag=false;
		
		while(!stackmain.isEmpty())
		{
			Stack<TreeNode>stacktemp=new Stack<TreeNode>();
			while(!stackmain.isEmpty())
			{
				TreeNode temp=stackmain.pop();
				System.out.print(temp.data+" ");
				if(!directionflag)
				{
					if(temp.left!=null)
						stacktemp.push(temp.left);
					if(temp.right!=null)
						stacktemp.push(temp.right);
				}
				else
				{
					if(temp.right!=null)
						stacktemp.push(temp.right);
					if(temp.left!=null)
						stacktemp.push(temp.left);
				}
			}
					directionflag=!directionflag;
					stackmain=stacktemp;
					System.out.println("");
		}
	}
	
	public static void inorder(TreeNode root)
	{
		if(root==null)
			return;
		
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}
	
	public static void preorder(TreeNode root)
	{
		if(root==null)
			return;
		
		System.out.println(root.data);
		preorder(root.left);
		preorder(root.right);	
	}
	
	public static void postorder(TreeNode root)
	{
		if(root==null)
			return;
		
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.data);	
	}
	
	public static int countNodes(TreeNode root)
	{
		if(root==null)
			return 0;
		if(root.left==null&&root.right==null)
			return 1;
		else
			return countNodes(root.left)+countNodes(root.right);
	}
	
	public static int countLeaf(TreeNode root)
	{
		if(root==null)
			return 0;
		if(root.left==null&&root.right==null)
			return 1;
		else
			return 1+countLeaf(root.left)+countLeaf(root.right);
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root,int n1,int n2)
	{
		if(root==null)
			return null;
		
		while(root!=null)
		{
		
		if(n1<root.data&&n2<root.data)
			root=root.left;
		else
			if(n1>root.data&&n2>root.data)
				root=root.right;
			else
				break;
		}
		
		return root;		
	}

	public static void treeToSortedArray(TreeNode root, int arr[])
	{	
		int i=0;
		if(root==null)
			return;
		
		inorder(root.left);

		arr[i]=root.data;
		System.out.print(arr[i]);
		i++;
		System.out.println(" ");
		
		inorder(root.right);		
	}
	
	public static void printAllPathsOfSum(TreeNode root, int sum)
	{
		int tempSum=0;
		Stack<Integer>stack=new Stack<Integer>();
		
		if(root==null||sum==0)
			return;
		
			tempSum=tempSum+root.data;
			stack.push(root.data);
			
			if(tempSum==sum)
			{
				while(!stack.isEmpty())
				{
				       int res=stack.pop();	
				       System.out.println(res);
				}
			}
			
			if(root.left!=null)
				printAllPathsOfSum(root.left, sum);
			if(root.right!=null)
				printAllPathsOfSum(root.right, sum);	
			
		}
	
	

	public static void main(String[] args)  
	 {  
		
	 // BinarySearchTree bi=new BinarySearchTree();    
	  TreeNode rootNode=createBinaryTree(); 
	  
	  System.out.println("Level Order Queue:");  
	  printLevels(rootNode);
	  
	  System.out.println("Zig Zag Traversal:");  
	  zigZagTraversal(rootNode); 
	  
	  int size=countNodes(rootNode);
	  int arr[]=new int[size];
	  treeToSortedArray(rootNode,arr);
	  
	  TreeNode res=lowestCommonAncestor(rootNode,55,30);
	  System.out.println("Lowest Common Ancestor is "+res.data);
	  
	  printAllPathsOfSum(rootNode, 100);
	  
	  System.out.println(getHeight(rootNode));
	  
	  trimTillHeight(rootNode, 1);
	  
	 }
	
	TreeNode createMinimalBinaryTree(int arr[])
	{
		return createMinimalBinaryTree(arr,0,arr.length-1);
	}
	
	TreeNode createMinimalBinaryTree(int arr[],int start, int end)
	{
		if(end<start)
			return null;
		
		int mid=(start+end)/2;
		
		TreeNode n=new TreeNode(arr[mid]);
		
		n.left=createMinimalBinaryTree(arr,0, mid-1);
		n.right=createMinimalBinaryTree(arr,mid+1, end);
		
		return n;
		
	}
	
	ArrayList<LinkedList<TreeNode>> createLinkedListsEachLevel(TreeNode root)
	{
		ArrayList<LinkedList<TreeNode>>result=new ArrayList<LinkedList<TreeNode>>();
		
		LinkedList<TreeNode>current=new LinkedList<TreeNode>();
		
		if(root!=null)
			current.add(root);
		
		while(current.size()>0)
		{
			result.add(current);
			
			LinkedList<TreeNode>parents=current;
			current=new LinkedList<TreeNode>();
			
			for(TreeNode parent:parents)
			{
				if(parent.left!=null)
				{
					current.add(parent.left);
				}
				if(parent.right!=null)
				{
					current.add(parent.right);
				}
			}
		}
		return result;
		
	}
	
	static int getHeightOfTree(TreeNode root)
	{
		if(root==null)
			return -1;
		
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
	
	static boolean isBalanced(TreeNode root)
	{
		if(root==null)
			return true;
		
		int heightDiff=getHeightOfTree(root.left)-getHeightOfTree(root.right);
		
		if(Math.abs(heightDiff)>1)
		{
			return false;
		}
		else
		{
			return isBalanced(root.left)&&isBalanced(root.right);
		}
	}
	
	static int checkHeight(TreeNode root)
	{
		if(root==null)
			return -1;
		
		int leftHeight=checkHeight(root.left);
		
		if(leftHeight==Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		int rightHeight=checkHeight(root.right);
		
		if(rightHeight==Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		int diff=checkHeight(root.left)-checkHeight(root.right);
		
		if(Math.abs(diff)>1)
			return Integer.MIN_VALUE;
		else
			return Math.max(leftHeight, rightHeight)+1;			
		
	}
	
	boolean isBalance2(TreeNode root)
	{
		if(checkHeight(root)!=Integer.MIN_VALUE)
			return true;
		else
			return false;
	}
	
	boolean checkBST(TreeNode root)
	{
		return checkBST(root,null,null);
	}
	
	boolean checkBST(TreeNode root, Integer min, Integer max)
	{
		if(root==null)
			return true;
		
		if(root.data<=min||root.data>max)
			return false;
		
		if(!checkBST(root.left,min,root.data)||!checkBST(root.right,root.data,max))
			return false;
		
		return true;
	}

	
	 public static TreeNode createBinaryTree()  
	 {  
	    
	  TreeNode rootNode =new TreeNode(40);  
	  TreeNode node20=new TreeNode(20);  
	  TreeNode node10=new TreeNode(10);  
	  TreeNode node30=new TreeNode(30);  
	  TreeNode node60=new TreeNode(60);  
	  TreeNode node55=new TreeNode(55);  
	  TreeNode node100=new TreeNode(100);  
	 
	    
	  rootNode.left=node20;  
	  rootNode.right=node60;  
	    
	  node20.left=node10;  
	  node20.right=node30; 
	  
	  node60.left=node55;  
	  node60.right=node100; 
	   
	  return rootNode;  


	 }
	
}



