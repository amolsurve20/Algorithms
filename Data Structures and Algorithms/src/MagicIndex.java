import java.util.*;
public class MagicIndex 
{
	public static ArrayList<Integer> magicSlow(int arr[])
	{
		ArrayList<Integer>res=new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==i)
			{
				res.add(i);
			}	
		}
		
		return res;
	}
	
	public static int magicFast(int arr[])
	{
		return magicFast(arr,0, arr.length-1);
	}
	
	public static int magicFast(int arr[],int start, int end)
	{
		if(end<start)
			return -1;
		
		int midIndex=(start+end)/2;
		
		int midValue=arr[midIndex];
		
		if(midValue==midIndex)
		{
			return midIndex;
		}
		
		int leftIndex=Math.min(midIndex-1, midValue);
		int left=magicFast(arr,0,leftIndex);
		if(left>=0)
			return left;
		
		int rightIndex=Math.max(midIndex+1, midValue);
		int right=magicFast(arr,rightIndex,end);
		return right;
	
	}
	
	/*public static ArrayList<Integer> magicAll(int arr[])
	{
		return magicAll(arr,0, arr.length-1);
	}*/
	
	/*public static ArrayList<Integer> magicAll(int arr[],int start, int end)
	{
		ArrayList<Integer>res=new ArrayList<Integer>();
		
		if(end<start)
			return null;
		
		int midIndex=(start+end)/2;
		
		int midValue=arr[midIndex];
		
		if(midValue==midIndex)
		{
			res.add(midIndex);
		}
		
		ArrayList<Integer>left=new ArrayList<Integer>();
		ArrayList<Integer>right=new ArrayList<Integer>();
		int leftIndex=Math.min(midIndex-1, midValue);
		left=magicAll(arr,0,leftIndex);
		
			
		
		int rightIndex=Math.max(midIndex+1, midValue);
		right=magicAll(arr,rightIndex,end);
		
		return res;

	}
	*/
	
	public static void main(String args[])
	{
		int arr[]={1,2,3,4,4,5,5,6,6,6,9,12,12,12};
		
		ArrayList<Integer>res=new ArrayList<Integer>();
		
		res=magicSlow(arr);
		
		System.out.println(res);
		
		
		/*
		 ArrayList<Integer>res1=new ArrayList<Integer>();
		 
		
		res1=magicAll(arr);
		
		System.out.println(res1);
		
		*/
	}

}
