
public class SubsetSum 
{
	public static void main(String args[])
	{
		int input[]={2,3,7,8};
		
		int value=11;
		boolean res=isPresent(input,value);
		
		System.out.println(res);
		
	}
	
	public static boolean isPresent(int input[],int sum)
	{
		boolean t[][]=new boolean[input.length+1][sum+1];
		
		for(int i=0;i<=input.length;i++)
		{
			t[i][0]=true;
		}
		
		for(int i=1;i<=input.length;i++)
		{
			for(int j=0;j<=sum;j++)
			{
				if(input[i-1]<=j)
				{
					t[i][j]=t[i-1][j]||t[i-1][j-input[i-1]];
				}
				else
				{
					t[i][j]=t[i-1][j];
				}
			}
		}
		
		return t[input.length][sum];
		
		
	}

}
