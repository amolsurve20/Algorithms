import java.io.*;
import java.util.ArrayList;
import java.util.*;

//The program is a practice read file program based on program - "GraphAllPathsTwoNodes"
//Here, we are reading the text files and creating the graph represented as a hash map of
//String-keys and values as LinkedHashSet
//The output is the grah represented as the HashMap of keys as strings and values as LinkedHashSet

class FileRead 
{
  public static void main(String[] args)
	            throws FileNotFoundException, IOException 
	    {
	    	
	        String filename = "/Users/amolsurve/Desktop/input.txt";
	       
	        if (args.length > 0)
	        {
	        	filename = args[0];
	        }
	        
	        HashMap<String,LinkedHashSet> answer = parseFile(filename);
	        System.out.println(answer);
	    }
	    
	    static HashMap<String,LinkedHashSet> parseFile(String filename)
	    		throws FileNotFoundException, IOException
	    {
	
	        BufferedReader input = new BufferedReader(new FileReader(filename));
	        List<String> allLines = new ArrayList<String>();
	        String line;
	        while ((line = input.readLine()) != null) 
	        {
	        	allLines.add(line);
	        }
	        input.close();

	        return parseLines1(allLines);    	
	    }
	    
	    static HashMap<String,LinkedHashSet>parseLines1(List<String> lines) 
	    {
	    	
	        GraphNew graph = new GraphNew();
	       
	        
	        String sourceDest = lines.get(0).replaceAll(" ", "");
	        
	        String source=String.valueOf(sourceDest.charAt(0));
	        String destination=String.valueOf(sourceDest.charAt(1));
	        
	        System.out.println("Source is : "+source);
	        
	        System.out.println("Destination is : "+destination);
	        
	        HashMap<String,LinkedHashSet>hmap=new HashMap<String,LinkedHashSet>();
	        
	    	for (int i=1; i < lines.size(); i++) 
	    	{
	            String[] parts = lines.get(i).split(":");
	            String p0 = parts[0].trim();
	            LinkedHashSet<String>adj=new LinkedHashSet<String>();
	            //System.out.println(p0);
	            if (parts.length > 1 ) 
	            {
	    			char[] points = parts[1].replaceAll(" ", "").toCharArray();  //B C D

	        		for (char c : points) 
	        		{
	        			String p1 = String.valueOf(c);
	        			adj.add(p1);
	        		}
	        		
	        		hmap.put(p0, adj);
	 		
	    		} 
	            else 
	    		{
	    			hmap.put(p0,adj);
	    		}
	    	}
	    	
	    	return hmap;     
	    
	    }
}