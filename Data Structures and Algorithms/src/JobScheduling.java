import java.util.Arrays;
import java.util.Comparator;
class Job
{
	int start;
	int end;
	int profit;
	
	public Job(int start,int end,int profit)
	{
		this.start=start;
		this.end=end;
		this.profit=profit;
	}
}

class Jobcomparator implements Comparator<Job>
{
	public int compare(Job arg1, Job arg2)
	{
		if(arg1.end<=arg2.end)
		{
			return -1;
		}
		else
		{
			return 1;
		}
			
	}
}

public class JobScheduling 
{
	public int maxProfit(Job jobs[])
	{
		int t[]=new int[jobs.length];
		Jobcomparator cmp=new Jobcomparator();
		Arrays.sort(jobs,cmp);
		
		t[0]=jobs[0].profit;
		
		for(int i=1;i<jobs.length;i++)
		{
			t[i]=Math.max(t[i], jobs[i].profit);
			
			for(int j=i-1;j>=0;j--)
			{
				if(jobs[j].end<=jobs[i].start)
				{
				t[i]=Math.max(t[i], t[j]+jobs[i].profit);
				break;
				}
			}
		}
		int maxVal = Integer.MIN_VALUE;
        for (int val : t) {
            if (maxVal < val) {
                maxVal = val;
            }
        }
        return maxVal;		
	}
	
	public static void main(String args[])
	{
		Job jobs[] = new Job[6];
        jobs[0] = new Job(1,3,5);
        jobs[1] = new Job(2,5,6);
        jobs[2] = new Job(4,6,5);
        jobs[3] = new Job(6,7,4);
        jobs[4] = new Job(5,8,11);
        jobs[5] = new Job(7,9,2);
      JobScheduling mp = new JobScheduling();
        System.out.println(mp.maxProfit(jobs));	
	}
}
