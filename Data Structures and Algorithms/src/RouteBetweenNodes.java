import java.util.*;

import org.w3c.dom.Node;


enum State{unvisited,visiting,visited;}
class Graph
{
	
}

	

boolean search(Graph g, Node start, Node end)
{
	if(start==end)
		return true;
	
	LinkedList<Node>queue=new LinkedList<Node>();
	
	for(Node u:g.getNodes())
	{
		u.state=State.unvisited;
	}
	
	start.state=State.visiting;
	
	queue.add(start);
	
	Node u;
	
	while(!queue.isEmpty())
	{
		u=queue.removeFirst();
		
		if(u!=null)
		{
			for(Node v:u.getadjacentNodes())
			{
				if(v.state==State.unvisited)
				{
				if(v==end)
					return true;
				else
				{
					v.state=State.visiting;
					queue.add(v);
				}
					
			}
		}
			
			u.state=State.visited;
			
	
		}
	
	}
	return false;
	
	
	
	
}
public class RouteBetweenNodes 
{
	

}

class Node
{
	int data;
	State state;
}


