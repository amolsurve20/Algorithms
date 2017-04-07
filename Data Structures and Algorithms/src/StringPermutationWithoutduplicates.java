import java.util.*;
public class StringPermutationWithoutduplicates 
{
	public static ArrayList<String> getPerms(String string)
	{
		ArrayList<String> result=new ArrayList<String>();
		getPerms("",string,result);
		return result;
	}
	
	public static void getPerms(String prefix,String remainder,ArrayList<String>result)
	{
		if(remainder.length()==0)
			result.add(prefix);
		
		for(int i=0;i<remainder.length();i++)
		{
			String begin=remainder.substring(0, i);
			String end=remainder.substring(i+1);
			char c=remainder.charAt(i);
			getPerms(prefix+c,begin+end,result);
		}	
		
	}
	
	public static  ArrayList<String> getPermutationsDuplicates(String str)
	{
		ArrayList<String>res=new ArrayList<String>();
		HashMap<Character,Integer>hm=buildTable(str);
		printPerms(hm,"",str.length(),res);
		return res;
	}
	
	public static HashMap<Character,Integer>buildTable(String str)
	{
		HashMap<Character,Integer>hm=new HashMap<Character,Integer>();
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			if(hm.containsKey(c))
			{
				hm.put(c,hm.get(c)+1);
			}
			else
			{
				hm.put(c, 1);
			}
		}
		
		return hm;
	}
	
	public static void printPerms(HashMap<Character,Integer>hm,String prefix,int remainder,ArrayList<String>result)
	{
		if(remainder==0)
		{
			result.add(prefix);
			return;
		}
		
		for(Character ch:hm.keySet())
		{
			int count=hm.get(ch);
			
			if(count>0)
			{
				hm.put(ch, count-1);
				printPerms(hm,prefix+ch,remainder-1,result);
				hm.put(ch, count);
			}
			
		}
		
	}
	
	
	public static void main(String args[])
	{
		String t="AMCM";
		ArrayList<String>res=new ArrayList<String>();
		res=getPerms(t);
		
		System.out.println(res);
		
		ArrayList<String>res1=new ArrayList<String>();
	
		
		res1=getPermutationsDuplicates(t);
		System.out.println(res1);
		
	}

}
