import java.util.*;
public class LongestSubstringWithoutrepeatingCharacters 
{
	static void longestSubstring(String inputString)
    {
        //Convert inputString to charArray    
        char[] charArray = inputString.toCharArray();
      
        
        //Initialization   
        String longestSubstring = null;
        int longestSubstringLength = 0;
        
       
        //Creating LinkedHashMap with characters as keys and their position as values.
         
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
         
        //Iterating through charArray
         
        for (int i = 0; i < charArray.length; i++) 
        {
            char ch = charArray[i];
         
            //If ch is not present in charPosMap, adding ch 
            //into charPosMap along with its position
             
            if(!map.containsKey(ch))
            {
                map.put(ch, i);
            }
             
            //If ch is already present in charPosMap, 
            //repositioning the cursor i to the position of ch and clearing the charPosMap
             
            else
            {    
                i = map.get(ch);
                 
                map.clear();
            }
             
            //Updating longestSubstring and longestSubstringLength
             
            if(map.size() > longestSubstringLength)
            {
                longestSubstringLength = map.size();
                 
                longestSubstring = map.keySet().toString();
            }
        } 
  
        System.out.println("The longest substring : "+longestSubstring);
         
        System.out.println("The longest Substring Length : "+longestSubstringLength);
    }
	/*
	 * Build a map of characters to the number of 
	 * times it occurs in the string
Create an array where the index of the array represents 
how many times that character occurred in the String
Iterate from the end of the array to the beginning, 
and at each index, append each character to the return string that number of times.
	 * 
	 * */
	 
	public static String frequencySort(String s) 
	{
	    if (s == null) 
	    {
	        return null;
	    }
	    
	    Map<Character, Integer> map = new HashMap();
	    char[] charArray = s.toCharArray();
	    int max = 0;
	    
	    for (Character c : charArray) 
	    {
	        if (!map.containsKey(c)) 
	        {
	            map.put(c, 0);
	        }
	        map.put(c, map.get(c) + 1);
	        max = Math.max(max, map.get(c));
	    }

	    List<Character>[] array = buildArray(map, max);

	    return buildString(array);
	}

	private static List<Character>[] buildArray(Map<Character, Integer> map, int maxCount) 
	{
	    List<Character>[] array = new List[maxCount + 1];
	    for (Character c : map.keySet())
	    {
	        int count = map.get(c);
	        
	        if (array[count] == null) {
	            array[count] = new ArrayList();
	        }
	        array[count].add(c);
	    }
	    return array;
	}

	private static String buildString(List<Character>[] array) 
	{
	    StringBuilder sb = new StringBuilder();
	    for (int i = array.length - 1; i > 0; i--)
	    {
	        List<Character> list = array[i];
	        if (list != null) 
	        {
	            for (Character c : list) {
	                for (int j = 0; j < i; j++) 
	                {
	                    sb.append(c);
	                }
	            }
	        }
	    }
	    return sb.toString();
	}


    public static void main(String[] args) 
    {    
        longestSubstring("javaconceptoftheday");
        String res=frequencySort("aaavvffftttpppbbbsddddgggee");
        System.out.println(res);        
    }
	
}
	
	/*public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}


}*/
