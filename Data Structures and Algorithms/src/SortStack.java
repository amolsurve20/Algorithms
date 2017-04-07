import java.util.*;
public class SortStack extends Stack<Integer>
{
	Stack<Integer>temp;
	
	public SortStack()
	{
		temp=new Stack<Integer>();
	}
	
	public void stackSort(Stack<Integer>stack)
	{
		while(!stack.isEmpty())
		{
			int val=stack.pop();
			
			while(!temp.isEmpty()&&val<temp.peek())
			{
				stack.push(temp.pop());
			}
			
			temp.push(val);	
		}
		
		while(!temp.isEmpty())
		{
			stack.push(temp.pop());	
		}
		
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
	}
	
	
	public static void main(String args[])
	{
		Stack<Integer>stack=new Stack<Integer>();
		stack.push(10);
		stack.push(30);
		stack.push(45);
		stack.push(44);
		stack.push(32);
		
		SortStack onj=new SortStack();
		
		onj.stackSort(stack);
		
	}

}
