import java.util.*;
class Tower
{
	Stack<Integer>stack;
	int index;
	
	public Tower(int i)
	{
		index=i;
		stack=new Stack<Integer>();
	}
	
	public int getIndex()
	{
		return index;
	}
	
	public void add(int d)
	{
		if(!stack.isEmpty()&&stack.peek()<=d)
			System.out.println("Cannot insert element on the top");
		else
			stack.push(d);		
	}
	
	public void moveTopTo(Tower t)
	{
		int temp=stack.pop();
		t.add(temp);
	}
	
	public void moveDiskTo(int n, Tower destination, Tower buffer)
	{
		if(n>0)
		{
			moveDiskTo(n-1,buffer,destination);
			moveTopTo(destination);
			buffer.moveDiskTo(n-1,destination,this);
		}
	}

}

public class TowersOfHanoi 
{
	public static void main(String args[])
	{
		int n=3;
		Tower towers[]=new Tower[n];
		
		for(int i=0;i<n;i++)
		{
			towers[i]=new Tower(i);
		}
		
		for(int i=n-1;i>=0;i--)
		{
			towers[0].add(i);
		}
		
		
		
		System.out.println("Values after shifting");
		
		towers[0].moveDiskTo(n, towers[2], towers[1]);
		
		for(int i=0;i<n;i++)
		{
		int res=towers[2].stack.pop();
		System.out.println(res);
		}
		
	}

}
