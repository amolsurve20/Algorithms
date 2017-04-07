import java.util.HashSet;
import java.util.*;

public class StringToCharCount 
{
	private static final Set<String>dictionary=new HashSet<String>();
	static{
		dictionary.add("hello");
		dictionary.add("how");
		dictionary.add("are");
		dictionary.add("you");
		dictionary.add("foobar");
	}
	
	public static void main(String args[])
	{
		String str="aaabbbccffaaaaa";
		
		String str2="Hellllllloooooo, HHHHow AAArreee YYYYoooouuuuuu, foobar?";
		String temp=str2.replaceAll("[^a-zA-Z ]", "").toLowerCase();
		System.out.println("Temp string is"+temp);
		
		/*String res=charCount(str);
		System.out.println(res);*/
		
		String res1[];
		res1=charValidString(temp);
		
		System.out.println("Result of the array is");
		for(int i=0;i<res1.length;i++)
		System.out.println(res1[i]);
		
		System.out.println("Correction");
		String result[]=spellCheck(res1[1]);
		for(int i=0;i<result.length;i++)
			System.out.println(result[i]);
		
	}
	
	public static String charCount(String str)
	{
		if(str==null||str.isEmpty())
			return str;
		
		StringBuilder sb=new StringBuilder();
		int count=1;
		
		char current=str.charAt(0);
		for(int i=1;i<str.length();i++)
		{
			if(current==str.charAt(i))
			{
				count++;
			}
			else
			{
				sb.append(current).append(count);
				current=str.charAt(i);
				count=1;
			}
				
		}
		 sb.append(current).append(count);
	        return sb.toString();	
	}
	
	public static String[] charValidString(String str)
	{
		String arrFinal[]=new String[2];
		if(str==null||str.isEmpty())
			return arrFinal;
		
		StringBuilder sb=new StringBuilder();
		
		
		sb.append(str.charAt(0));
		
		for(int i=1;i<str.length();i++)
		{
			if(str.charAt(i) != str.charAt(i-1))
			{
				sb.append(str.charAt(i));
			}		
		}
		
		String result=sb.toString();
		String arr[]=result.split(" ");
		//String temp[]=new String[arr.length];
		
		StringBuilder inv=new StringBuilder();
		
		
		for(String i:arr)
		{	
			if(dictionary.contains(i.replaceAll("[^a-zA-Z ]", "").toLowerCase()))
			{
				System.out.println(i);
				continue;
			}
			else
			{
				inv.append(i);
				inv.append(" ");
				//temp[k]=i;
				//k++;
			}
		}
			System.out.println("Invalid words are");
		
			System.out.println(inv.toString());
			
			arrFinal[0]=sb.toString();
			arrFinal[1]=inv.toString();
		
		
		return arrFinal;
		
	}
	
	public static String[] spellCheck(String word)
	{ 
		int res=0;
		int max=Integer.MAX_VALUE;
		int l=0;
		
		String[] split = word.split("\\s+");
	
		String temp[]=new String[split.length];

		for(String i:split)
		{
			for(String j:dictionary)
			{
				
				res=dynamicEditDistance(split[0],j);
				if(res<max)
				{
					max=res;
					temp[l]=j;
					l++;	
				}		
			}
		}
			return temp;
	}
	
	
	public static void printActualEdits(int temp[][],String s1, String s2)
	{
		int i=temp.length-1;
		int j=temp[0].length-1;
		
		char str1[]=s1.toCharArray();
		char str2[]=s2.toCharArray();
		
		while(true)
		{
			if(i==0||j==0)
			{
				break;
			}
			
			if(str1[i=1]==str2[j-1])
			{
				i=i-1;
				j=j-1;
			}
			else
				if(temp[i][j]==temp[i-1][j-1]+1)
				{
					System.out.println("Edit "+str2[j-1]+"from string 2 to "+str1[i-1]+" from string 1");
					i=i-1;
					j=j-1;
				}
				else
					if(temp[i][j]==temp[i-1][j]+1)
					{
						System.out.println("Delete in string 1 "+str1[i-1]);
					}
					else
						if(temp[i][j]==temp[i][j-1]+1)
							if(temp[i][j]==temp[i-1][j]+1)
							{
								System.out.println("Delete in string 2"+str2[j-1]);
							}
							else
								System.out.println("Invalid operation");
			
		}
	}
	
	
	public static int dynamicEditDistance(String str1,String str2)
	{
		char arr1[]=str1.toCharArray();
		char arr2[]=str2.toCharArray();
		
		int temp[][]=new int[arr1.length+1][arr2.length+1];
		for(int i=0;i<temp[0].length;i++)
		{
			temp[0][i]=i;
		}
		
		for(int i=0;i<temp.length;i++)
		{
			temp[i][0]=i;
		}
		
		for(int i=1;i<=arr1.length;i++)
		{
			for(int j=1;j<=arr2.length;j++)
			{
				if(arr1[i-1]==arr2[j-1])
				{
					temp[i][j]=temp[i-1][j-1];
				}
				else
				{
					temp[i][j]=1+findMin(temp[i-1][j-1],temp[i-1][j],temp[i][j-1]);
				}
			}
		}
		//printActualEdits(temp, str1, str2);
		return temp[arr1.length][arr2.length];

	}
	
	public static 
	int findMin(int a,int b, int c)
	{
		if(a<=b&&a<=c)
			return a;
		else
			if(b<=a&&b<=c)
				return b;
			else
				return c;
	}
	
	/*
	  public static void spellCheck(String word)
	{
		
		
	}
	*/

}
