
public class MinimumInsertionsForPalindromes 
{
	public static void main(String args[])
	{
		String str="abcdd";
		int n=minInsert(str);
		System.out.println("Minimum number of characters to be inserted are "+n);
	}
	
	public static int minInsert(String str)
	{
		String rev="";
		for(int i=str.length()-1;i>=0;i--)
		{
			rev=rev+str.charAt(i);
		}
	
		
		int lcsLen=longestSub(str,rev);
		return str.length()-lcsLen;
	}
	
	public static int longestSub(String str1, String str2)
	{
		char arr1[]=str1.toCharArray();
		char arr2[]=str2.toCharArray();
		
		int t[][]=new int[arr1.length+1][arr2.length+1];
		
		for(int i=0;i<=arr1.length;i++)
		{
			for(int j=0;j<=arr2.length;j++)
			{
				if(i==0||j==0)
				{
					t[i][j]=0;
				}
				else
					if(arr1[i-1]==arr2[j-1])
					{
						t[i][j]=t[i-1][j-1]+1;
					}
					else
					{
						t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
					}
					
			}
		}
		
		return t[arr1.length][arr2.length];
	}

}
