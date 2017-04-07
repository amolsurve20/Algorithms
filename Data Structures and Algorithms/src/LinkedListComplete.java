import java.util.*;

class Link
{
	public long dData;
	public Link next;
	public Link previous;
	
	public Link(long dd)
	{
		dData=dd;
	}
	
	public void displayLink()
	{
		System.out.println(dData);
	}
}

class DoublyLinkedList
{
	Link first;
	Link last;
	
	public DoublyLinkedList()
	{
		first=null;
		last=null;
	}
	
	public boolean isEmpty()
	{
		return (first==null);
	}
	
	public void insertFirst(long n)
	{
		Link newlink=new Link(n);
		
		if(isEmpty())
			last=newlink;
		else
		{
			first.previous=newlink;
			newlink.next=first;
		}
		first=newlink;
	}
	
	public void insertLast(long n)
	{
		Link newlink=new Link(n);
		
		if(isEmpty())
			first=newlink;
		else
		{
			last.next=newlink;
			newlink.previous=last;
		}
		last=newlink;
	}
	
	public boolean insertAfter(long n)
	{
		Link newlink=new Link(n);
		Link current=first;
		
		while(current.dData!=n)
		{
			current=current.next;
			if(current==null)
				return false; 
		}
		
		if(current==last)
		{
			newlink.next=null;
			last=newlink;
		}
		else
		{
			newlink.next=current.next;
			current.next.previous=newlink;
		}
		
		newlink.previous=current;
		current.next=newlink;
		return true;
		
	}
	
	public void reverseList()
	{
		first=last;
		last=first;
		
		Link current=first;
		Link p=first;
		
		while(p!=null)
		{
			current=p.next;
			p.next=p.previous;
			p.previous=current;
			p=p.next;
		}
	}
	
	public boolean isLoop()
	{
		Link slow=first;
		Link fast=first;
		
		while(slow!=null&&fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			
			if(slow==fast)
				return true;
		}
		return false;
	}
	
	public Link deleteFirst()
	{
		Link temp=first;
		
		if(first.next==null)
			first=null;
		else
			first.next.previous=null;
		first=first.next;
		
		return temp;
	}
	
	public Link deleteLast()
	{
		Link temp=last;
		
		if(first.next==null)
			first=null;
		else
			last.previous.next=null;
		last=last.previous;
		
		return temp;
	}
	
	public Link deleteK(long n)
	{
		Link current=first;
		
		while(current.dData!=n)
		{
			current=current.next;
			if(current==null)
				return null;
		}
		
		if(current==first)
			first=current.next;
		else
			current.previous.next=current.next;
		
		if(current==last)
			last=current.previous;
		else
			current.next.previous=current.previous;
		
		return current;	
	}
	
	public void findNthLast(int n)
	{
		Link current1=first;
		Link current2=first;
		
		for(int i=0;i<n;i++)
		{
			current1=current1.next;
		}
		
		while(current1!=null)
		{
			current2=current2.next;
			current1=current1.next;
		}
		
		current2.displayLink();
	}
	
	public void findMiddle()
	{
		Link current1=first;
		Link current2=first;
		int count=0;
		
		while(current1!=null)
		{
			current1=current1.next;
			count++;
		}
		
		for(int i=0;i<count/2;i++)
		{
		current2=current2.next;	
		}
		current2.displayLink();
	}
	
	public int getCount(DoublyLinkedList l1)
	{
		Link current=first;
		int count=0;
		while(current!=null)
		{
			current=current.next;
			count++;
		}
		return count;
	}
	
	public long getNode(DoublyLinkedList l1, DoublyLinkedList l2)
	{
		int c1=getCount(l1);
		int c2=getCount(l2);
		
		if(c1>c2)
		{
			int d=c1-c2;
			return getIntersectionNode(d,l1,l2);
		}
		else
		{
			int d=c2-c1;
			return getIntersectionNode(d,l2,l1);
		}
				
	}
	
	public long getIntersectionNode(int d,DoublyLinkedList l1, DoublyLinkedList l2)
	{
		Link current1=l1.first;
		Link current2=l2.first;
		
		for(int i=0;i<d;i++)
		{
			if(current1==null)
				return -1;
			
			current1=current1.next;
		}
		
		while(current1!=null&&current2!=null)
		{	
			if(current1.dData==current2.dData)
			{
				return current1.dData;
			}
				
				current1=current1.next;
				current2=current2.next;
		}
		return -1;
	}
	
	public void deleteDuplicates()
	{
		Link current=first;
		HashSet<Long>hs=new HashSet<Long>();
		
		while(current!=null)
		{
			if(hs.contains(current.dData))
			{
				current.previous.next=current.next;
			}
			else
			{
				hs.add(current.dData);
				
			}
			current=current.next;
		}
	}
	
	public void deleteDupWithoutBuffer()
	{
		Link current=first;
		
		while(current!=null)
		{
			Link runner=current;
			
			while(runner.next!=null)
			{
				if(runner.next.dData==current.dData)
				{
					runner.next=runner.next.next;
				}
				else
				{
					runner=runner.next;
				}
					
			}
			current=current.next;
		}
		
		
	}
	
	
	
	public void displayForward()
	{
		Link current=first;
		while(current!=null)
		{
			current.displayLink();
			current=current.next;
		}
	}
	
	public void displayBackward()
	{
		Link current=last;
		while(current!=null)
		{
			current.displayLink();
			current=current.previous;
		}
	}
	
	public boolean isPalindrome()
	{
		Link fast=first;
		Link slow=first;
		
		Stack<Long>stack=new Stack<Long>();
		
		while(fast!=null&fast.next!=null)
		{
			long data=slow.dData;
			stack.push(data);
			slow=slow.next;
			fast=fast.next.next;
		}
		
		if(fast!=null)
		{
			slow=slow.next;
		}
		
		while(slow!=null)
		{
			long data=stack.pop();
			if(data!=slow.dData)
			{	
				return false;		
			}
			
				slow=slow.next;
		}
		return true;

	}
}

public class LinkedListComplete 
{
	/*public static long sumLists(DoublyLinkedList l_1,DoublyLinkedList l_2,long carry)
	{
		Link l1=l_1.first;
		Link l2=l_2.first;
		if(l1==null&&l2==null&carry==0)
			return 0;
		
		
		long value=carry;
		
		if(l1!=null)
			value=value+l1.dData;
		
		if(l2!=null)
			value=value+l2.dData;
		
		Link result=new Link(value%10);
		
		
		
		
		return result.dData;
		*/
	
	    public static void main(String args[])
	    {
	        DoublyLinkedList obj=new DoublyLinkedList();
	       // DoublyLinkedList obj1=new DoublyLinkedList();
	        
	        obj.insertFirst(7);
	        obj.insertFirst(7);
	        obj.insertFirst(6);
	       
	        obj.insertLast(5);
	        obj.insertLast(7);
	        obj.insertLast(7);
	        obj.insertLast(6);
	        
	       
	        
	        //obj.findnLast(4);
	        
	        //System.out.println("Middle element");
	        //obj.findMiddle();
	        
	        //obj.reverseList();
	        obj.displayForward();      
	        //obj.deleteDuplicates();
	        //obj.deleteDupWithoutBuffer();
	       // System.out.println("List after removing duplicates");
	        //obj.displayForward();
	        //System.out.println("After Partition");
	        
	        //System.out.println(head.dData);
	        //obj.displayForward();
	        //long res=sumLists(obj1,obj,0);
	        
	        System.out.println(obj.isPalindrome());
	        
	        
	        		
	        
	    }

}
