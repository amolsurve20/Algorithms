import java.util.Arrays;
import java.util.Comparator;

class Jobs
{
	int start;
	int end;
	int profit;
	
	public Jobs(int start,int end, int profit)
	{
		this.start=start;
		this.end=end;
		this.profit=profit;
	}
}
/*
class JComparator implements Comparator<Jobs>//Sorting by increasing order of end time
{
	public int compare(Jobs j1, Jobs j2)
	{
		if(j1.end<=j2.end)
			return -1;
		else
			return 1;
	}
}
*/
class JComparator implements Comparator<Jobs>//Sorting by increasing order of start time
{
public int compare(Jobs i1, Jobs i2){
    if(i1.start<=i2.start)
        return -1;
    else
        return 1;
    
    /*same as
     * if(i1.start!=i2.start)
                return i1.start-i2.start;
            else
                return i1.end-i2.end;
     */
}
}

public class WeightedJobScheduling 
{
	public int maxProfit(Jobs jobs[])
	{
		int t[]=new int[jobs.length];
		
		JComparator cmp=new JComparator();
		
		Arrays.sort(jobs,cmp);
		
		
	
		for(Jobs i:jobs)
		{
			System.out.println(i.start+"  "+i.end);
			
		}
		
		t[0]=jobs[0].profit;
		
		for(int i=1;i<jobs.length;i++)
		{
			t[i]=Math.max(jobs[i].profit, t[i-1]);
			for(int j=i-1;j>=0;j--)
			{
				if(jobs[j].end<=jobs[i].start)
				{
				t[i]=Math.max(t[i], jobs[i].profit+t[j]);
				break;
				}
			}
		}
		
		int max=Integer.MIN_VALUE;
		for(int val:t)
		{
			if(val>max)
			{
				max=val;
			}
		}
		return max;
		
		
	}
	
	public static void main(String args[])
	{
		Jobs arr[]=new Jobs[6];
		arr[0]=new Jobs(1,3,40);
		arr[1]=new Jobs(2,3,40);
		arr[2]=new Jobs(3,5,70);
		arr[3]=new Jobs(5,6,10);
		arr[4]=new Jobs(5,8,90);
		arr[5]=new Jobs(3,7,40);
		
		WeightedJobScheduling obj=new WeightedJobScheduling();
		
		System.out.print(obj.maxProfit(arr));
		
	}

}
