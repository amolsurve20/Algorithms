import java.util.Set;
import java.util.HashSet;
import java.util.Deque;
import java.util.ArrayDeque;
;

/**
 * Date 08/20/2014
 * @author Tushar Roy
 *
 * Given a directed acyclic graph, do a topological sort on this graph.
 *
 * Do DFS by keeping visited. Put the vertex which are completely explored into a stack.
 * Pop from stack to get sorted order.
 *
 * Space and time complexity is O(n).
 */
public class TopologicalSort<T> 
{

    public Deque<Vertex<T>>topoSort(Graph<T>graph)
    {
    	Deque<Vertex<T>>stack=new ArrayDeque<>();
    	Set<Vertex<T>>visited=new HashSet<>();
    	
    	for(Vertex<T>vertex:graph.getAllVertex())
    	{
    		if(visited.contains(vertex))
    		{
    			continue;
    		}
    	topoUtility(vertex,stack,visited);
    	} 	
    	return stack;
    }
    
    public void topoUtility(Vertex<T>vertex,Deque<Vertex<T>>stack,Set<Vertex<T>>visited)
    {
    	visited.add(vertex);
    	for(Vertex<T>children:vertex.getAdjacentVertexes())
    	{
    		if(visited.contains(children))
    		{
    			continue;
    		}
    	topoUtility(children,stack,visited);
    	}
    	
    	stack.offerFirst(vertex);
    	
    }
    
   
    public static void main(String args[])
    {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);
        
        TopologicalSort<Integer> obj=new TopologicalSort<Integer>();
        Deque<Vertex<Integer>>result=obj.topoSort(graph);
        System.out.println("Vertices in topologically sorted order are as follows");
        while(!result.isEmpty())
        	System.out.println(result.poll());
     }
    
}

