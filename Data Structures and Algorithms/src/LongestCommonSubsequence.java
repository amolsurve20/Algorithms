
public class LongestCommonSubsequence 
{
	public static void main(String args[])
	{
		String str1="abcdrfgte";
		String str2="abcdfff";
		
		int result=lcsDynamic(str1,str2);
		System.out.println(result);
	}
	
	public static int lcsDynamic(String s1,String s2)
	{
		char arr1[]=s1.toCharArray();
		char arr2[]=s2.toCharArray();
		
		int max=0;
		
		int temp[][]=new int[arr1.length+1][arr2.length+1];
		
		for(int i=1;i<arr1.length;i++)
		{
			for(int j=1;j<arr2.length;j++)
			{
				if(arr1[i-1]==arr2[j-1])
				{
					temp[i][j]=temp[i-1][j-1]+1;
				}
				else
				{
					temp[i][j]=Math.max(temp[i-1][j],temp[i][j-1]);
				}
				
				if(temp[i][j]>max)
				{
					max=temp[i][j];
				}
			}
		}
		return max;
		
		
	}

}
