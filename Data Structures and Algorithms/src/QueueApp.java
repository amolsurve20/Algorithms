//class Queue
{
	int queuearray[];
	int maxsize;
	int front;
	int rear;
	int nelems;
	
	public Queue(int s)
	{
		maxsize=s;
		queuearray=new int[maxsize];
		front=0;
		rear=-1;
		nelems=0;
	}
	
	public void insert(int value)
	{
		if(rear==maxsize-1)
			rear=-1;
		
		queuearray[++rear]=value;
		nelems++;
	}
	
	public void priorityInsert(int value)
	{
		if(nelems==0)
		{
			queuearray[++rear]=value;
		}
		else
		{
			int j;
			for(j=nelems-1;j>=0;j--)
			{
				if(queuearray[j]>value)
				{
					queuearray[j+1]=queuearray[j];
				}
				else break;
			}
			queuearray[j+1]=value;
		}
		nelems++;
	}
	
	public int remove()
	{
		int val=queuearray[front++];
		
		if(front==maxsize)
			front=0;
		nelems--;
		
		return val;
		
	}
	
	public int peekFront()
	{
		return queuearray[front];
	}
	
	public boolean isEmpty()
	{
		return (nelems==0);
	}
	
	public boolean isFull()
	{
		return (nelems==maxsize);
	}
	
	public int size()
	{
		return nelems;
	}
	
	public void display()
	{
		while(!isEmpty())
		{
			int val=remove();
			System.out.print(val+" ");
		}
	}
	
}
public class QueueApp 
{
	public static void main(String args[])
	{
		Queue queue=new Queue(5);
		
		queue.insert(10);
		queue.insert(20);
		queue.insert(60);
		queue.insert(30);
		queue.insert(110);
		
		//queue.display();
		
		int val=queue.remove();
		
		queue.display();
	}
	

}
