import java.util.*;
public class WordFrequencyInABook 
{
	public static void main(String args[])
	{
		String book="I am Amol. My full name is Amol Sandeep SUrve. I am second year grad student in UW Seattle. I love Seattle";
		String word="Amol";
		
		int res1=findFrequencySingleQuery(book,word);
		
		int res2=getRepeatedWordCount(book,word);
		
		System.out.println("Count by First Method is"+res1);
		System.out.println("Count by Second Method is"+res2);
	}
	
	public static int findFrequencySingleQuery(String s, String word)
	{
		
		String[] words = s.split("\\s+");
		for (int i = 0; i < words.length; i++) 
		{
		    // You may want to check for a non-word character before blindly
		    // performing a replacement
		    // It may also be necessary to adjust the character class
		    words[i] = words[i].replaceAll("[^\\w]", "");
		}
		
		String wordLower=word.trim().toLowerCase();
		int count=0;
		
		for(String each:words)
		{
			
			if(each.trim().toLowerCase().equals(wordLower))
			{
				count++;
			}
				
		}
		
		return count;
	}
	
	public static HashMap<String,Integer>makeWordCountMap(String s)
	{
		String[] words = s.split("\\s+");
		for (int i = 0; i < words.length; i++) {
		    // You may want to check for a non-word character before blindly
		    // performing a replacement
		    // It may also be necessary to adjust the character class
		    words[i] = words[i].replaceAll("[^\\w]", "");
		}
		
		HashMap<String,Integer>map=new HashMap<String,Integer>();
		
		for(String temp:words)
		{
			String each=temp.trim().toLowerCase();
			
			if(map.containsKey(each))
			{
				map.put(each, map.get(each)+1);
			}
			else
			{
				map.put(each, 1);
			}
		}
		
		return map;
		
	}
	
	public static int getRepeatedWordCount(String book,String word)
	{
		HashMap<String,Integer>map=makeWordCountMap(book);
		
		String wordLower=word.toLowerCase();
		
		if(map.containsKey(wordLower))
			return map.get(wordLower);
		else
			return 0;
	}
	
	

}
