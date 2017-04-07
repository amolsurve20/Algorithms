import java.util.*;

class Box
{
	int height;
	int width;
	int length;
	
	public Box(int height,int width, int length)
	{
		this.height=height;
		this.width=width;
		this.length=length;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getwidth()
	{
		return width;
		
	}
	
	public int getLength()
	{
		return length;
	}
	
	public boolean canBeAbove(Box b)
	{
		return (this.height<b.height&&this.length<b.length&&this.width<b.width);
	}
}

class BoxComparator implements Comparator<Box>
{
	public int compare(Box x, Box y)
	{
		return y.height-x.height;
	}
}

public class StackBoxes 
{
	static int createStack(ArrayList<Box>boxes)
	{
		Collections.sort(boxes,new BoxComparator());
		int stack[]=new int[boxes.size()];
		return createStack(boxes,null,0,stack);
	}
	
	static int createStack(ArrayList<Box>boxes, Box bottom,int offset,int stack[])
	{
		if(offset>boxes.size())
			return 0;
		
		Box newBottom=boxes.get(offset);
		
		int heightWithBottom=0;
		
		if(newBottom==null||newBottom.canBeAbove(bottom))
		{
			if(stack[offset]==0)
			{
				stack[offset]=createStack(boxes,newBottom,offset+1,stack);
				stack[offset]=stack[offset]+newBottom.height;
			}
			heightWithBottom=stack[offset];
			
		}
		
		int heightWithoutBottom=createStack(boxes,bottom,offset+1,stack);
		
		return Math.max(heightWithBottom, heightWithoutBottom);
	}

}
