import java.util.*;

class Link1
{
	Link1 next;
	Link1 previous;
	int key;
	int value;
	
	public Link1(int key,int value)
	{
		this.key=key;
		this.value=value;
	}
	
	public void displayLink()
	{
		System.out.println("KEY is"+key+"Value is"+value);
	}
}
public class LRUCache 
{
	
	int capacity;
	HashMap<Integer,Link1>map=new HashMap<Integer,Link1>();
	Link1 first=null;
	Link1 last=null;
	
	public LRUCache(int capacity)
	{
		this.capacity=capacity;
	}
	
	public void displayForward()
	{
		Link1 current=first;
		while(current!=null)
		{
			current.displayLink();
			current=current.next;
		}
	}
	
	
	public int get(int key)
	{
		if(map.containsKey(key))
		{
			Link1 n=map.get(key);
			delete(n);
			insertFirst(n);
			return n.value;
		}
		return -1;		
	}
	
	public void delete( Link1 current)
	{		
		if(current==first)
			first=current.next;
		else
			current.previous.next=current.next;
		
		if(current==last)
			last=current.previous;
		else
			current.next.previous=current.previous;
	}
	
	public void insertFirst(Link1 newlink)
	{
		if(first==null)
			last=newlink;
		else
		{
			first.previous=newlink;
			newlink.next=first;
		}
		first=newlink;
	}
	
	public void insert(int key, int value) 
	{
        if(map.containsKey(key))
        {
            Link1 old = map.get(key);
            old.value = value;
            delete(old);
            insertFirst(old);
        }
        else
        {
            Link1 created = new Link1(key, value);
            if(map.size()>=capacity)
            {
                map.remove(last.key);
                delete(last);
                insertFirst(created);
 
            }
            else
            {
                insertFirst(created);
            }    
 
            map.put(key, created);
        }
    }
	
	public static void main(String args[])
	{
		LRUCache obj=new LRUCache(4);
		
		Link1 l1=new Link1(1,10);
		Link1 l2=new Link1(2,20);
		Link1 l3=new Link1(3,30);
		Link1 l4=new Link1(4,40);
		Link1 l5=new Link1(5,50);
		
		obj.insert(1,10);
        obj.insert(2,20);
        obj.insert(3,30);
        obj.insert(4,40);
        obj.insert(5,50);
        
       // obj.displayForward();
       //obj.delete(l2);
       
        //obj.insert(2,30);
        
       // obj.displayForward();
        
        obj.insert(6, 60);
        
        obj.displayForward();
             
	}
	
}
