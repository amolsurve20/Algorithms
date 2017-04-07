import java.util.ArrayList;
import java.util.Scanner;

class TNode
{
	TNode left;
	TNode right;
	TNode middle;
	char data;
	boolean isEnd;
	
	public TNode(char data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
		this.middle=null;
		this.isEnd=false;
	}
}


 class TernarySearch 
{
	private TNode root;
	private ArrayList<String>al;
	
	public TernarySearch()
	{
		root=null;
	}
	
	public boolean isEmpty()
	{
		return (root==null);
	}
	
	public void makeEmpty()
	{
		root=null;
	}
	
	public void insert(String word)
	{
		root=insert(root,word.toCharArray(),0);
	}
	
	public TNode insert(TNode r, char word[],int ptr)
	{
		if(r==null)
			r=new TNode(word[ptr]);
		
		if(word[ptr]<r.data)
			r.left=insert(r.left,word,ptr);
		else
			if(word[ptr]>r.data)
				r.right=insert(r.right,word,ptr);
			else
			{
				if(ptr+1<word.length)
					r.middle=insert(r.middle,word,ptr+1);
				else
					r.isEnd=true;		
			}
		
		return r;
	}
	
	public void delete(String word)
	{
		delete(root,word.toCharArray(),0);
	}
	
	public void delete(TNode r, char word[],int ptr)
	{
		if(r==null)
			return;
		
		if(word[ptr]<r.data)
			delete(r.left,word,ptr);
		else
			if(word[ptr]>r.data)
				delete(r.right,word,ptr);
			else
			{
				if(r.isEnd&&ptr==word.length-1)
					r.isEnd=false;
				else
					if(ptr+1<word.length)
						delete(r.middle,word,ptr+1);
			}
		
	}
	
	public boolean search(String word)
	{
		return search(root,word.toCharArray(), 0);
				
	}
	
	public boolean search(TNode r, char word[], int ptr)
	{
		if(r==null)
			return false;
		
		if(word[ptr]<r.data)
			return search(root.left,word,ptr);
		else
			if(word[ptr]>r.data)
				return search(root.right,word,ptr);
			else
			{
				if(r.isEnd&&ptr==word.length-1)
					return true;
				else
					if(ptr==word.length-1)
						return false;
				else
					return search(r.middle,word,ptr+1);
			}
		
		
	}
	
	public String toString()
	{
		al=new ArrayList<String>();
		traverse(root,"");
		return "Ternary Search Tree is"+al;
	}
	
	private void traverse(TNode r,String str)
	{
		if(r!=null)
		{
			traverse(r.left,str);
		str=str+r.data;
		if(r.isEnd)
		{
			al.add(str);
		}
		
		traverse(r.middle,str);
		str=str.substring(0,str.length()-1);
		traverse(r.right,str);
		}
		
	}

}

public class TernarySearchTree
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		 
        TernarySearch tst = new TernarySearch();
        System.out.println("Ternary Search Tree Test\n");
        char ch;
 
        do
        {
            System.out.println("\nTernary Search Tree Operations\n");
            System.out.println("1. insert word");
            System.out.println("2. search word");
            System.out.println("3. delete word");
            System.out.println("4. check empty");
            System.out.println("5. make empty");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter word to insert");
                    tst.insert(scan.next());
                    break;
                case 2:
                    System.out.println("Enter word to search");
                    System.out.println("Search result : "
                            + tst.search(scan.next()));
                    break;
                case 3:
                    System.out.println("Enter word to delete");
                    tst.delete(scan.next());
                    break;
                case 4:
                    System.out.println("Empty Status : " + tst.isEmpty());
                    break;
                case 5:
                    System.out.println("Ternary Search Tree cleared");
                    tst.makeEmpty();
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            System.out.println(tst);
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
        scan.close();
    }
}
	

