import java.util.*;

class Point
{
	int row,col;
	
	public Point(int row, int col)
	{
		this.row=row;
		this.col=col;
	}
}

public class RobotGrid 
{
	public ArrayList<Point>getPath(boolean maze[][])
	{
		if(maze==null || maze.length==0)
		{
			return null;
		}
		
		ArrayList<Point>path=new ArrayList<Point>();
		
		HashSet<Point>failedPath=new HashSet<Point>();
		
		if(getPath(maze,maze.length-1,maze[0].length-1,failedPath,path))
		{
			return path;
		}
		
		return null;
		
	}
	
	public boolean getPath(boolean maze[][],int row,int col,HashSet failedPath,ArrayList<Point>path)
	{
		if(row<0 || col<0 || !maze[row][col])
			return false;
		
		Point p=new Point(row,col);
		
		if(failedPath.contains(p))
			return false;
		
		boolean isAtOrigin = (row == 0) || (col == 0);
		
		if(getPath(maze,row,col-1,failedPath,path)||getPath(maze,row-1,col,failedPath,path)||isAtOrigin)
		{
			path.add(p);
			return true;
		}
		
		return false;
	}

}
