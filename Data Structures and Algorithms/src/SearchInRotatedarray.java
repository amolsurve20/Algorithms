import java.util.*;
public class SearchInRotatedarray 
{
	static int search(int a[],int left, int right, int x)
	{
		int mid=(left+right)/2;
		if(x==a[mid])
			return mid;
		
		if(right<left)
			return -1;
		
		if(a[left]<a[mid])
		{
			if(x>=a[left] && x<a[mid])
			{
				return search(a,left,mid-1,x);
			}else
			{
				return search(a,mid+1,right,x);
			}
		}
		else
			if(a[mid]<a[left])
			{
				if(x>a[mid]&&x<=a[right])
				{
					return search(a,mid+1,right,x);
				}
				else
				{
					return search(a,left,mid-1,x);
				}
			}
			else
				if(a[left]==a[mid])
				{
					if(a[mid]!=a[right])
					{
						return search(a,mid+1,right,x);
					}
					else
					{
						int result=search(a,left,mid-1,x);
						if(result==-1)
						{
							return search(a,mid+1,right,x);
						}
						else
						{
							return result;
						}
					}
				}
		
		return -1;	
	}
	
	public static void main(String args[])
	{
		int arr[]={15,16,19,20,25,1,4,6,7,8};
		int res=search(arr,0,arr.length-1,4);
		System.out.println(res);
	}
}
