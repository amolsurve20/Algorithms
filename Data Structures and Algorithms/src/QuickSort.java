import java.util.*;
public class QuickSort 
{
	public static void main(String args[])
	{
		int arr[]={10,60,40,30,11,20,23};
		
		quickSort(arr,0,arr.length-1);
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public static int partition(int arr[],int left, int right)
	{
		Random rd=new Random();
		int i,j,temp;
		
		i=left;
		j=right;
		
		int pivot=arr[left+rd.nextInt(right-left)];
		
		while(i<=j)
		{
			while(arr[i]<pivot)
				i++;
			
			while(arr[j]>pivot)
				j--;
			
			if(i<=j)
			{
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i++;
				j--;
			}
		}
		
		return i;
	}
	
	public static void quickSort(int arr[],int left, int right)
	{
		int index=partition(arr,left,right);
		if(left<index-1)
			quickSort(arr,left,index-1);
		
		if(index<right)
			quickSort(arr,index,right);
	}

}
