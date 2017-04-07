import java.util.*;
public class ArraySumUsingSet 
{
	public static void main(String args[])
	{
		int arr[]={2,6,3,5,4,5,99,34};
		
		String res=printPairs(arr,9);
		
		System.out.println(res);
	}
	
	public static String printPairs(int arr[],int sum)
	{
		Set <Integer>set=new HashSet<Integer>();
		String res="";
		
		
		for(int value:arr)
		{
			int temp=sum-value;
			
			if(!set.contains(temp))
				set.add(value);
			else
				res=res+"Pair "+value+"  "+temp+"\n";
				
		}
		
		return res;
		
		
	}
	

}
