import java.util.*;
public class GroupAnagramsTogether
{
	public static void main(String args[])
	{
		String arr[]={"eat", "tea", "tan", "ate", "nat", "bat"};
		
		ArrayList<List<String>> result = new ArrayList<List<String>>();
		
		result=(ArrayList<List<String>>) groupAnagrams1(arr); 
		
		System.out.println(result);
	}
	
	//solution with alphabetical order inside the list
	public static List<List<String>> groupAnagrams1(String[] strs) 
	{
		//create a list of lists containing anagram strings to print the final result
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0)
            return res;
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        //Iterate over the input string array
        for(int i=0;i<strs.length;i++)
        {
        	//convert each string from the input array to char array
        	//sort it and make the new string out of the sorted characters which will
        	//eventually be used as the key for the hashmap to access the list of words
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String str = new String(charArr);
            
            //Check if the map contains the key
            //If so, add the word into the hashmap at that key. To be more specific, the
            //word will be added in the arraylist which can be accessed by this key in the hashmap.
            //The key field is str and value field is Arraylist
            
            if(map.containsKey(str))
            {
                map.get(str).add(strs[i]);
            }
            
            //If map doesn't contain the key, 
            //1. Create new Arraylist
            //2. Add the word to the list
            //3. put that list inside the map along with the str as the key
            
            else
            {
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(str,list);
            }
        }//for i
        
        //Define an iterator on the map values
        //Iterate over the arraylist and sort it to store the values alphabetically
        //Add the arrraylist - item in the final arraylist - res
        
        Iterator iter = map.values().iterator();
        while(iter.hasNext())
        {
            ArrayList<String> item = (ArrayList<String>)iter.next();
            Collections.sort(item);
            res.add(item);
        }
        
        return res;
    }
}