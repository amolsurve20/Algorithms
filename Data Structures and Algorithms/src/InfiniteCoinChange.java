
public class InfiniteCoinChange
{
	public static void main(String args[])
	{
		int v[]={1,2,3};
		int amount=5;
		int result=maxWays(v,amount);
		
		System.out.println(result);
	}
	
	public static int maxWays(int v[],int amount)
	{
		int t[][]=new int[v.length+1][amount+1];
		
		for(int i=0;i<=v.length;i++)
		{
			t[i][0]=1;
		}
		
		for(int j=1;j<=amount;j++)
		{
				t[0][j]=0;
		}
		
		for(int i=1;i<=v.length;i++)
		{
			for(int j=1;j<=amount;j++)
			{
				// check if the coin value is less than the amount needed
				
				if(v[i-1]<=j)
				{
					// reduce the amount by coin value and
					// use the subproblem solution (amount-v[i]) and
					// add the solution from the top to it
					
					t[i][j]=t[i-1][j]+t[i][j-v[i-1]];
				}
				else
				{
					// just copy the value from the top
					
					t[i][j]=t[i-1][j];
				}
			}
		
		}
		
		return t[v.length][amount];
	}

}
