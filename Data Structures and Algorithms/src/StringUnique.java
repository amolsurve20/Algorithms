import java.util.*;
public class StringUnique 
{
	public static void main(String args[])
	{
		String str="abcd";
		
		System.out.println(isUnique(str));
	}
	
	public static boolean isUnique(String str)
	{
		if(str.length()>128)
			return false;
		
		boolean values[]=new boolean[128];
		
		for(int i=0;i<str.length();i++)
		{
			int val=str.charAt(i);
			System.out.println(val);
			
			if(values[val])
			{
				return false;
			}
			
			values[val]=true;
		}
		
		return true;
	}

}
