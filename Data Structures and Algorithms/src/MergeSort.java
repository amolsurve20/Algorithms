import java.util.*;

public class MergeSort
{
	public static void main(String[] args)
	{
		int arr[] = {88,99,22,33,44,55};	
		mergesort(arr);
		
		for(int i=0;i<arr.length;i++)
		System.out.print(arr[i]+" ");
	}
	
	public static void mergesort(int arr[])
	{
		
		int size=arr.length;
		
		if(size<2)
			return;
		int mid=size/2;
		int leftsize=mid;
		int rightsize=size-mid;
		
		int left[]=new int[leftsize];
		int right[]=new int[rightsize];
		
		for(int i=0;i<mid;i++)
			left[i]=arr[i];
		
		for(int i=mid;i<size;i++)
			right[i-mid]=arr[i];//i-mid is important
		
		mergesort(left);
		mergesort(right);
		merge(left,right,arr);
		
	}
	
	public static void merge(int left[],int right[], int arr[])
	{
		int leftsize=left.length;
		int rightsize=right.length;
		int i=0,j=0,k=0;
		
		while(i<leftsize&&j<rightsize)
		{
			if(left[i]<right[j])
			{
				arr[k++]=left[i++];
			}
				else
				{
				arr[k++]=right[j++];
				}	
		}
		
		while(i<leftsize)
		{
			arr[k++]=left[i++];
		}
		
		while(j<rightsize)
		{
			arr[k++]=right[j++];
		}
		
	}
		
		
		
}

	