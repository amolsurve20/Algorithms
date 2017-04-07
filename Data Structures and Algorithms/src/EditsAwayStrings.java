
public class EditsAwayStrings
{
	public static void main(String args[])
	{
		String str1="amol";
		String str2="amik";
		
		System.out.println(oneEditAway(str1,str2));
		
	}
	
	public static boolean oneEditAway(String str1,String str2)
	{
		if(str1.length()==str2.length())
			return oneEditReplace(str1,str2);
		
		if(str1.length()+1==str2.length())
		{
			return oneEditInsert(str1,str2); 
		}
		else
			if(str1.length()==str2.length()+1)
			{
				return oneEditInsert(str2,str1); 
			}
		return false;	
	}
	
	public static boolean oneEditReplace(String str1,String str2)
	{
		boolean found=false;
		for(int i=0;i<str1.length();i++)
		{
			if(str1.charAt(i)!=str2.charAt(i))
			{
				if(found)
				{
					return false;
				}
			
			found=true;
			}
				
		}
		
		return true;
	}
	
	public static boolean oneEditInsert(String str1,String str2)
	{
		int index1=0;int index2=0;
		
		while(index1<str1.length()&&index2<str2.length())
		{
			if(str1.charAt(index1)!=str2.charAt(index2))
			{
				if(index1!=index2)
					return false;
				else
					index2++;
			}
			else
			{
				index1++;
				index2++;
			}
		}
		return true;
		
	}
	
	

}
