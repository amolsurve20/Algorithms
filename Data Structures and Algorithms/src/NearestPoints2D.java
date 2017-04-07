import java.io.*;
import java.util.*;
public class NearestPoints2D 
{
	static int MAX_QUEUE_SIZE=100;
	
	public static void main(String args[]) throws FileNotFoundException
	{
		try{
		PriorityQueue<Point>que=new PriorityQueue<Point>(MAX_QUEUE_SIZE,new PointComparator());
		if(args.length==0)
		{
			System.out.println("Please input a file");
			System.exit(0);
		}
		
		Scanner sc=new Scanner(new File(args[0]));
		
		int n=sc.nextInt();//total number of points in a file
		
		Point num;
		
		for(int i=0;i<MAX_QUEUE_SIZE&&i<n;i++)
		{
			num=new Point(sc.nextDouble(), sc.nextDouble());
			que.add(num);
		}
		
		for(int i=MAX_QUEUE_SIZE;i<n;i++)
		{
			num=new Point(sc.nextDouble(), sc.nextDouble());
			if(num.getDist()<que.peek().getDist())
			{
				que.poll();
				que.add(num);
			}
		}
		
		Point arr[]=new Point[que.size()];
		arr=que.toArray(arr);
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
	}

}


class Point
{
	double x,y;
	double dist;
	
	public Point(double x, double y)
	{
		this.x=x;
		this.y=y;
		dist=Math.sqrt(x*x+y*y);
	}
	
	public double getDist()
	{
		return dist;
	}
	
	public String toString()
	{
		return "("+x+","+y+")";
	}
}

class PointComparator implements Comparator<Point>
{

@Override
public int compare(Point o1, Point o2) 
{
	// TODO Auto-generated method stub
	return (int)(o2.getDist() - o1.getDist());
}
}