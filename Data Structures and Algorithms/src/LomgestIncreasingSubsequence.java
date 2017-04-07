
public class LomgestIncreasingSubsequence 
{
	public static void main(String args[])
	{
		int arr[]={3,4,-1,0,6,2,3,5,6,7,8,9,11};
		
		int res=longestIncrSeq(arr);
		System.out.print(res);
	}
	
	public static int longestIncrSeq(int arr[])
	{
		int t[]=new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			t[i]=1;
		}
		int max=1;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j])
				{
					if(t[i]<t[j]+1)
					{
						t[i]=t[j]+1;
						
					}
					if(max<t[i])
						max=t[i];
				}
			}
		}
		return max;
		
	}

}
