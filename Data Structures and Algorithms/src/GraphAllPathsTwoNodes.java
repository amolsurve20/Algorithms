import java.io.*;
import java.util.*;
class GraphNew
{
    private Map<String, LinkedHashSet<String>> map = new HashMap<String, LinkedHashSet<String>>();

    public void addEdge(String node1, String node2) 
    {
    	LinkedHashSet<String> adjacent = map.get(node1);
        if(adjacent==null) {
            adjacent = new LinkedHashSet<String>();
            map.put(node1, adjacent);
        }
        adjacent.add(node2);
    }

    public LinkedList<String> adjacentNodes(String last) 
    {
        LinkedHashSet<String> adjacent = map.get(last);
        
        if(adjacent==null) 
        {
            return new LinkedList<String>();
        }
        return new LinkedList<String>(adjacent);
    }
}

public class GraphAllPathsTwoNodes
{
    public static void main(String[] args)
            throws FileNotFoundException, IOException 
    {
    	
        String filename = "/Users/amolsurve/Desktop/input.txt";
       
        if (args.length > 0)
        {
        	filename = args[0];
        }
        
        List<String> answer = parseFile(filename);
        System.out.println(answer);
    }
    
    static List<String> parseFile(String filename)
    		throws FileNotFoundException, IOException
    {
    	/*
    	 *  Don't modify this function
    	 */
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) 
        {
        	allLines.add(line);
        }
        input.close();

        return parseLines(allLines);    	
    }
    
    static List<String> parseLines(List<String> lines) 
    {
    	/*
    	 * 
    	 *  Your code goes here
    	 *  
    	 */
        GraphNew graph = new GraphNew();
  
        String firstLine = lines.get(0).replaceAll(" ", "");
        String start =  firstLine.substring(0,1);
        String  end =   firstLine.substring(1,2);
        //System.out.printf(" start = %s,  end = %s", start, end);
    	for (int i=1; i < lines.size(); i++) 
    	{
            String[] parts = lines.get(i).split(":");
            String p0 = parts[0].trim();
            if (parts.length > 1 ) 
            {
    			char[] points = parts[1].replaceAll(" ", "").toCharArray();  //B C D

        		for (char c : points) 
        		{
        			String p1 = String.valueOf(c);
        			graph.addEdge(p0, p1);
        		}
    		} 
            else 
    		{
    			graph.addEdge(p0, p0);
    		}
    	}
        
    	List<String> res =  new ArrayList<String>();
    	
        List<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
        
        String currentNode = start;
        
        List<String> visited = new ArrayList<String>();
        
        visited.add(start);
        
        GraphAllPathsTwoNodes obj=new GraphAllPathsTwoNodes();
        
        obj.dfs(graph, visited, paths, currentNode, end);
        String nodes = "";

        for(ArrayList<String> path : paths)
        {
        	res.add(list2str(path));
        }   
        
        return res;
    }
    
    private static String list2str(ArrayList<String> list) 
    {
    	String res = "";
    	for (String s: list) 
    	{
    		res += s;
    	}
    	return res;
    }
    
    private void dfs(GraphNew graph, List<String> visited, List<ArrayList<String>> paths, 
    		String currentNode,String end) 
    {  
    	
        if (currentNode.equals(end)) 
        { 
            paths.add(new ArrayList(Arrays.asList(visited.toArray())));
            return;
        }
        else 
        {
            LinkedList<String> nodes = graph.adjacentNodes(currentNode);    
            for (String node : nodes) 
            {
                if (visited.contains(node)) 
                {
                    continue;
                } 
                List<String> temp = new ArrayList<String>();
                temp.addAll(visited);
                temp.add(node);          
                dfs(graph, temp, paths, node, end);
            }
        }
    }
    
    
    private static void printPath(LinkedList<String> visited) 
    {
        for (String node : visited) 
        {
            System.out.print(node);
            System.out.print(" ");
        }
        System.out.println();
    }
    
}
    
    


    
    
    /*private  List<String> depthFirst(GraphNew graph, LinkedList<String> visited , String end) 
    {
           LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
           List<String> res = new ArrayList<String>();
           String points = "";
 
           // check adjacent nodes
           for (String node : nodes) 
           {
               if (visited.contains(node)) 
               {
                   continue;
               }
               if (node.equals(end)) 
               {
                   visited.add(node);
                   //printPath(visited);
                   for (String point : visited)
                   {
                	   points += point;
                   }
                   res.add(points);
                   visited.removeLast();
                   break;
               }
           }
           for (String node : nodes) 
           {
               if (visited.contains(node) || node.equals(end))
               {
                   continue;
               }
               visited.addLast(node);
               depthFirst(graph, visited, end);
               visited.removeLast();
           }
           //System.out.print(res);
           return res;
        
       }*/
       
       
