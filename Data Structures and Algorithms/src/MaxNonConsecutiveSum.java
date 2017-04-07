
public class MaxNonConsecutiveSum
{
	public static void main(String args[])
	{
		int arr[]={5, 5, 10, 100, 10, 5};
		
		int res=printMaxNonConsecutive(arr);
		System.out.println(res);
	}
	
	public static int printMaxNonConsecutive(int arr[])
	{
		int incl=arr[0];
		int excl=0;
		int new_excl;
		
		for(int i=1;i<arr.length;i++)
		{
			new_excl=Math.max(incl, excl);
					
			incl=arr[i]+excl;
			
			excl=new_excl;
		}
		
		return Math.max(incl, excl);
		
	}

}
