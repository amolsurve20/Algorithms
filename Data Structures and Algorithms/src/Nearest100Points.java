import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.*;

/*
 * Exercise from http://programmingpraxis.com/2012/11/27/amazon-interview-question/
 * Given a million points (x, y), give an O(n) solution 
 * to find the 100 points closest to (0, 0).
 * Well, you have to read "a million" as "n"
 *  and "100" as "100".
 * Uses a heap of size 100. 
 * The complexity-theoretic trick is that 100 is a constant here.
 */

public class Nearest100Points 
{
	static int MAX_PRIORITY_QUEUE_SIZE = 100;

	public static void main(String[] args) 
	{
		try 
		{
			PriorityQueue<Point> pq = new PriorityQueue<Point>(MAX_PRIORITY_QUEUE_SIZE, 
					new ReversePointComparator());
			
			if(args.length == 0) 
			{
				System.out.println("Give me a filename");
				System.exit(0);
			}
			
			Scanner sc = new Scanner(new File(args[0]));
			int n = sc.nextInt();
			//read a million points from the file
			Point num;
			//Crate point instance
			
			//Add first 100 points to the priority queue
			for(int i=0; i<MAX_PRIORITY_QUEUE_SIZE && i<n; i++) 
			{
				num = new Point(sc.nextDouble(), sc.nextDouble());
				pq.add(num);
			}
			
			//For the remaining points, iterate from 100 to create till the millionth point
			//Get distances from the points to compare with the peek value of the queue
			//If the distance of any point is less than the max value in the queue which is at the top, 
			//poll the last point and add the new point in the queue
			//
			for(int i=MAX_PRIORITY_QUEUE_SIZE; i<n; i++)
			{
				num = new Point(sc.nextDouble(), sc.nextDouble());
				if(num.getDist() < pq.peek().getDist())
				{
					pq.poll();
					pq.add(num);
				}
			}
			
			//Create an array of type Point and assign queue elements to array
			Point [] pts = new Point[pq.size()];
			pts = pq.toArray(pts);
			
			//Print the 100 values in array to display the 100 nearest points from origin
			for(int i=0; i<pts.length; i++)
				System.out.print(pts[i] + " ");
			System.out.println();		
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Point
{
	double x,y;
	double dist;
	
	public Point(double x,double y)
	{
		this.x=x;
		this.y=y;
		dist=Math.sqrt(x*x+y*y);
	}
	
	public double getDist()
	{
		return dist;
	}
	
	public String toString() {
		return "(" + x +" ," + y +")";
	}

}
class ReversePointComparator implements Comparator<Point> {

	@Override
	public int compare(Point p1, Point p2) {
		return (int) (p2.getDist() - p1.getDist());
	}

}
