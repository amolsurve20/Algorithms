import java.util.*;

//Method one --- where we are sorting entire array which is unnecessary
class AnagramComparator implements Comparator<String>
{
	private String sortChars(String s)
	{
		char arr[]=s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
	
	public int compare(String s1,String s2)
	{
		return sortChars(s1).compareTo(sortChars(s2));
	}
		
}

public class AnagramSort 
{
	//Method two --- using HashMap of String and ArrayList of Strings as key and value pair respectively
static void sort(String arr[])
{
	HashMap<String,ArrayList<String>>map=new HashMap<String,ArrayList<String>>();
	ArrayList<String>local;
	for(String s:arr)
	{
		//sort it to generate the unique character key combination
		String key=sortChars(s);
		
		//check if the key is already present in the map
		if(!map.containsKey(key))
		{
			//if the key is not present, then make new Arraylist with that key
			map.put(key,new ArrayList<String>());
		}
		//if the key is already present get that key to insert the value in the corresponding Arraylist
		map.get(key).add(s);	
	}
	
	int index=0;
	
	for(String s:map.keySet())
	{
		ArrayList<String>list=map.get(s);
		{
			for(String each:list)
			{
				arr[index++]=each;
			}
			
		}
			
	}

}

static String sortChars(String str)
{
	char arr[]=str.toCharArray();
	Arrays.sort(arr);
	return new String(arr);
}
	public static void main(String args[])
	{
		String arr[]={"amol","eric","loma","cat","tac","act"};
		
		/*Arrays.sort(arr,new AnagramComparator() );
		
		for(int i=0;i<arr.length;i++)
		{
		System.out.println(arr[i]);
		}*/
		
		sort(arr);
		
		for(int i=0;i<arr.length;i++)
		{
		System.out.println(arr[i]);
		}
	}

}


















