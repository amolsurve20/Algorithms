
public class MAximumSumIncreasingSubsequence 
{
	public static void main(String args[])
	{
		  int arr[] = {1, 2, 10, 4, 3, 11, 20};
		
		int res=maxIncrSum(arr);
		
		System.out.println(res);
	}
	
	public static int maxIncrSum(int arr[])
	{
		int t[]=new int[arr.length];
		
		for(int i=0;i<arr.length;i++)
			t[i]=arr[i];
		
		int max=0;
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[j]<arr[i]&&t[i]<arr[i]+t[j])
				{
					t[i]=t[j]+arr[i];
					if(max<t[i])
						max=t[i];
				}
				
				
			}
		}
		
		return max;
	}
	
}