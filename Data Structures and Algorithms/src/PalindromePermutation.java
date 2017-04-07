import java.util.*;
public class PalindromePermutation 
{
	public static void main(String args[])
	{
		String str1="tatd";
	
		System.out.println(isPalindromePermutation(str1));	
	}
	
	public static int getCharNumber(Character c)
	{
		int a=Character.getNumericValue('a');
		int z=Character.getNumericValue('z');
		int val=Character.getNumericValue(c);
		
		if(val>=a&&val<=z)
		{
			return val-a;
		}
		return -1;
		
	}
	
	public static boolean isPalindromePermutation(String str)
	{
		int countOdd=0;
		
		int table[]=new int[Character.getNumericValue('z')-
		Character.getNumericValue('a')+1];
		
		for(char c:str.toCharArray())
		{
			int val=getCharNumber(c);
			
			if(val!=-1)
			{
				table[val]++;
			}
		}
		
		boolean found=false;
		
		for(int x:table)
		{
			if(x%2==1)
			{
				if(found)
				{
					return false;
				}
			}
			found=true;
		}
		
		return true;
			
	}

}