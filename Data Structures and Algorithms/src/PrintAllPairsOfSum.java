import java.util.Arrays;

public class PrintAllPairsOfSum 
{
	public static void main(String args[])
	{
		int arr[]={2,6,4,5,5,3,7,9,1};
		
		String result=findPairs(arr,10);
		System.out.print(result);
		
	}
	
	public static String findPairs(int arr[], int sum)
	{
		int i=0;
		int j=arr.length-1;
		
		String res="";
		Arrays.sort(arr);
		
		while(i<j)
		{
			if(arr[i]+arr[j]==sum)
			{
				res=res+"Pair: "+arr[i]+" "+arr[j]+" ";
				
				i++;
				j--;
			}
			else
				if(arr[i]+arr[j]<sum)
				{
					i++;
				}
				else if(arr[i]+arr[j]>sum)
				{
					j--;
				}
				
		}
		return res;
		
		
	}

}
