import java.io.*;
import java.util.*;

class Graph 
{
    private Map<String, LinkedHashSet<String>> map = new HashMap<String, LinkedHashSet<String>>();

    public void addEdge(String node1, String node2) 
    {
    	LinkedHashSet<String> adjacent = map.get(node1);
        if(adjacent==null) 
        {
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

public class PathFinder 
{
    public static void main(String[] args)
            throws FileNotFoundException, IOException 
    {
        //String filename = "input.txt";
        String filename="/Users/amolsurve/Desktop/input.txt";
        if (args.length > 0) 
        {
        	filename = args[0];
        }
        
        List<String> answer = parseFile(filename);
        System.out.println(answer);
    }
    
    static List<String> parseFile(String input)
    		throws FileNotFoundException, IOException
    {
    	/*
    	 *  Don't modify this function
    	 */
        BufferedReader br = new BufferedReader(new FileReader(input));
        List<String> arrlst = new ArrayList<String>();
        String each;
        while ((each = br.readLine()) != null) 
        {
        	arrlst.add(each);
        }
        br.close();

        return parseLines(arrlst);    	
    }
    
    static List<String> parseLines(List<String> lines) 
    
    {
    	/*
    	 * 
    	 *  Your code goes here
    	 *  
    	 */
        Graph graph = new Graph();
  
        String firstLine = lines.get(0).replaceAll(" ", "");
         String source =  firstLine.substring(0,1);
        String  dest =   firstLine.substring(1,2);
        //System.out.printf(" start = %s,  end = %s", start, end);
    	for (int i=1; i < lines.size(); i++)
    	{
            String[]linearr = lines.get(i).split(":");
            String sourcePoint = linearr[0].trim();
            
            if (linearr.length > 1 ) 
            {
    			char[] connectedPoints = linearr[1].replaceAll(" ", "").toCharArray();  //B C D

        		for (char pt : connectedPoints) 
        		{
        			String destinationPoint = String.valueOf(pt);
        			graph.addEdge(sourcePoint, destinationPoint);
        		}
    		} 
            else
            {
    			graph.addEdge(sourcePoint, sourcePoint);
    		}
    	}
        
    	List<String> result =  new ArrayList<String>();
    	
        List<ArrayList<String>> pathArr = new ArrayList<ArrayList<String>>();
        
        String currentNode = source;
        
        List<String> visited = new ArrayList<String>();
        
        visited.add(source);
        
        new PathFinder().dfs(graph, visited, pathArr, currentNode, dest);
        
        String nodes = "";

        for(ArrayList<String> path : pathArr)
        {
        	result.add(list2str(path));
        }   
        
        return result;
    }
    
    private static String list2str(ArrayList<String> list)
    {
    	String temp = "";
    	for (String s: list) 
    	{
    		temp += s;
    	}
    	return temp;
    }
    
    private void dfs(Graph graph, List<String> visited, List<ArrayList<String>> paths, 
    		String currentNode,String end) 
    {        
        if (currentNode.equals(end))
        { 
            paths.add(new ArrayList(Arrays.asList(visited.toArray())));
            return;
        }
        
        else 
        
        {
            LinkedList<String> nodeList = graph.adjacentNodes(currentNode);    
            for (String node : nodeList) 
            {
                if (visited.contains(node)) 
                {
                    continue;
                } 
                List<String> tempList = new ArrayList<String>();
                tempList.addAll(visited);
                tempList.add(node);          
                dfs(graph, tempList, paths, node, end);
            }
        }
    }
    
    
    private  List<String> depthFirst(Graph graph, LinkedList<String> visited , String end) 
    {
           LinkedList<String> nodeList = graph.adjacentNodes(visited.getLast());
           List<String> result = new ArrayList<String>();
           String points = "";
 
           // check adjacent nodes
           for (String node : nodeList) 
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
                   result.add(points);
                   visited.removeLast();
                   break;
               }
           }
           for (String node : nodeList) 
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
           return result;
        
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