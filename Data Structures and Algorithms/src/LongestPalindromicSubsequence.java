
public class LongestPalindromicSubsequence
{
	public static void main(String args[])
	{
		String str="agbdba";
		char st[]=str.toCharArray();
		int res=longestPal(st);
		
		System.out.print(res);
		
	}
	
	public static int longestPal(char str[])
	{
		int t[][]=new int[str.length][str.length];
	
		for(int i=0;i<str.length;i++)
		{
			t[i][i]=1;
		}
		
		for(int l=2;l<=str.length;l++)
		{
			for(int i=0;i<str.length-l+1;i++)
			{
				int j=i+l-1;
				if((l==2)&&(str[i]==str[j]))
				{
					t[i][j]=2;
				}
				else
					if(str[i]==str[j])
					{
						t[i][j]=2+t[i+1][j-1];
					}
					else
					{
						t[i][j]=Math.max(t[i+1][j], t[i][j-1]);
					}
					
					
			}
		}
		
		return t[0][str.length-1];
		
		
		
	}
}
