
public class Knapsack 
{
	public static void main(String args[])
	{
		Knapsack k=new Knapsack();
		
		int val[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        int wt[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
       
        int result = k.knapsackDynamic(val, wt, 30);
        System.out.println(result);
	}
	
	public static int knapsackDynamic(int val[],int wt[],int W)
	{
		int t[][]=new int[val.length+1][W+1];
		
		for(int i=0;i<=val.length;i++)
		{
			for(int j=0;j<=W;j++)
			{
				if(i==0||j==0)
				{
					t[i][j]=0;
					continue;
				}
				if(wt[i-1]>j)
				{
					t[i][j]=t[i-1][j];
				}
				else
				{
					t[i][j]=Math.max(t[i-1][j], val[i-1]+t[i-1][j-wt[i-1]]);
				}
			}
		}
		
		return t[val.length][W];
		
	}

}
