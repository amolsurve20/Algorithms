
public class LongestCommonSubstring 
{
	public static void main(String args[])
	{
		String str1="abcdedfgggg";
		String str2="ggg";
		
		int result=longest(str1.toCharArray(),str2.toCharArray());
		
		System.out.println(result);
	}
	
	public static int longest(char str1[], char str2[])
	{
		int temp[][]=new int[str1.length+1][str2.length+1];
		int max=0;
		
		for(int i=1;i<temp.length;i++)
		{
			for(int j=1;j<temp[0].length;j++)
			{
				if(str1[i-1]==str2[j-1])
				{
					temp[i][j]=temp[i-1][j-1]+1;
				}
				
				if(max<temp[i][j])
			max=temp[i][j];
			}		
		
	}
		return max;	
		

}
}
