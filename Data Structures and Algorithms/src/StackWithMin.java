import java.util.*;
class StackWithMin1 extends Stack<NodeWithMin> //Using Single Stack
{
	
	public void push(int value)
	{
		int newMin=Math.min(value,min());//Comparing the new value with the existing minimum
		
		NodeWithMin newnode=new NodeWithMin(value,newMin);//updating the minimum if new value to be pushed is less than the current min 
		
		super.push(newnode); //pushing it onto the stack
	
	}
	
	public int min()
	{
		if(this.isEmpty())
			return Integer.MAX_VALUE;//Since we are comparing the value returned by the min()
		                             //method while pushing, when the stack it is initially empty, we returned the integer.max value
		else
		{
			return peek().min;
		}
	
	}
	
	public void display()
	{
		while(!this.isEmpty())
		{
			NodeWithMin temp=this.pop();
			System.out.println(temp.value+"Minimum is "+temp.min);
		}
	}

}

//Class to store node with it's value and the current minimum value 
class NodeWithMin
{
	int value;
	int min;
	
	public NodeWithMin(int value,int min)
	{
		this.value=value;
		this.min=min;	
	}

}

class StackWithMin2 extends Stack<Integer>
{
	Stack<Integer>stack2;
	
	public StackWithMin2()
	{
		stack2=new Stack<Integer>();
	}
	
	public void push(int value)
	{
		if(value<=min())
			stack2.push(value);
		
		super.push(value);
	
	}
	
	public Integer pop()
	{
		int value=super.pop();
		
		if(value==min())
			stack2.pop();
		
		return value;
	}
	
	public int min()
	{
		if(stack2.isEmpty())
			return Integer.MAX_VALUE;
		else
			return stack2.peek();
	}
}

public class StackWithMin
{
	public static void main(String args[])
	{
		StackWithMin1 obj=new StackWithMin1();
		obj.push(10);
		obj.push(20);
		obj.push(30);
		obj.push(5);
		obj.push(2);
		obj.push(22);
		obj.push(45);
		
		obj.display();
		
		
		
		
	}
}
