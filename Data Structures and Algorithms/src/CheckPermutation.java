import java.util.*;
public class CheckPermutation 
{
	public static void main(String args[])
	{
		String str1="amol";
		String str2="loma";
		
		System.out.println(permutation(str1,str2));
		
	}
	
	public static String sort(String s)
	{
		char arr[]=s.toCharArray();
		
		Arrays.sort(arr);
		
		String result=new String(arr);//important to put array into string object
		
		return result;
	}
	
	static boolean permutation(String s,String t)
	{
		if(s.length()!=t.length())
		{
			return false;
		}
		
		return sort(s).equals(sort(t));

	}
	

}
