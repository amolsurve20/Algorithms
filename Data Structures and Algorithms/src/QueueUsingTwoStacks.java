import java.util.*;

class MyQueue<T>
{
	Stack<T>oldstack;
	Stack<T>newstack;
	
	public MyQueue()
	{
		oldstack=new Stack<T>();
		newstack=new Stack<T>();
	}
	
	public int size()
	{
		return oldstack.size()+newstack.size();
	}
	
	public void add(T value)
	{
		newstack.push(value);
	}
	
	public void shiftStacks()
	{
		if(oldstack.isEmpty())
		{
			while(!newstack.isEmpty())
			{
				oldstack.push(newstack.pop());
			}
		}
	}
	
	public T peek()
	{
		shiftStacks();//Checking whether oldstack contains value
		return oldstack.peek();
		
	}
	
	public  T remove()
	{
		shiftStacks();//Checking whether oldstack contains value
		return oldstack.pop();
		
	}
}
public class QueueUsingTwoStacks 
{
	public static void main(String args[])
	{
		MyQueue<Integer>queue=new MyQueue<Integer>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		
		
		System.out.println(queue.remove());
		
		System.out.println(queue.peek());
	}

}
