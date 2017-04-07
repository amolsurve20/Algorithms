
public class CountingSort
{
	public static void main(String args[])
	{
		int arr[]={1,1,1,2,3,6,5,3,2,2,1,1,7,3,3,2,3,1};
		int res[]=new int[arr.length];
		int k=10;
		res=countSort(arr,500);
		for(int i=0;i<res.length;i++)
			System.out.println(res[i]);
	}
	
	static int[] countSort(int[] a, int k) 
	{
        int count[] = new int[k];
        
        for (int i = 0; i < a.length; i++)
            count[a[i]]++;
        
        for (int i = 1; i < k; i++)
            count[i] = count[i]+count[i-1];
        
        int b[] = new int[a.length];
        
        for (int i = a.length-1; i >= 0; i--)
            b[--count[a[i]]] = a[i];
        
        return b;
    }

}
