import java.util.Arrays;

public class BinaryMinHeap 
{
	private int data[];
	private int heapsize;
	
	public BinaryMinHeap(int max)
	{
		heapsize=0 ;
		data=new int[max];
	}
	
	public void display()
	{
		for(int i=0;i<heapsize;i++)
			System.out.println(data[i]);
	}
	
	public void sort()
	{
		Arrays.sort(data);
	}
	
	
	public boolean isEmpty()
	{
		return (heapsize==0);
	}
	
	public boolean isFull()
	{
		return (heapsize == data.length);
	}
	
	public int getLeftChild(int i)
	{
		return i*2+1;
	}
	
	public int getRightChild(int i)
	{
		return i*2+2;
	}
	
	public int getParent(int i)
	{
		return (i-1)/2;
	}
	
	public void insert(int nodeIndex)
	{
		if(isFull())
		{
			System.out.println("Cannot Insert, Heap is completely filled");
		}
		else
		{
		heapsize++;
		data[heapsize-1]=nodeIndex;
		shiftUp(heapsize-1);
		}

	}
	
	public void shiftUp(int nodeIndex)
	{
        int parentIndex, tmp;
        if (nodeIndex != 0) 
        {
              parentIndex = getParent(nodeIndex);
              if (data[parentIndex] > data[nodeIndex]) 
              {
                    tmp = data[parentIndex];
                    data[parentIndex] = data[nodeIndex];
                    data[nodeIndex] = tmp;
                    shiftUp(parentIndex);
              }
        } 
	}

	
	public void deleteMin()
	{
		if(isEmpty())
		{
			System.out.println("Heap is empty, cannot remove any element");
		}
		
		int min=data[0];
		data[0]=data[heapsize];
		heapsize--;
		shiftDown(0);
	}
	
	

	public int getMax()
	{
		if(isEmpty())
		{
			System.out.println("Heap is empty, cannot remove any element");
		}
		
		int max=data[heapsize];
		return max;
		
	}
	

	
	public int getMin()
	{
		if(isEmpty())
		{
			System.out.println("Heap is empty, so no minimum");
		}
		
		int min=data[0];
		return min;
	}
	
	public void shiftDown(int nodeIndex)
	{
		int leftChild,rightChild,temp,minIndex;
		leftChild=getLeftChild(nodeIndex);
		rightChild=getRightChild(nodeIndex);
		
		if(rightChild>=heapsize)
		{
			if(leftChild>=heapsize)
			{
				return;
			}
			else
			{
				minIndex=leftChild;
			}
		}
		else
			if(data[leftChild]<=data[rightChild])
			{
				minIndex=leftChild;
			}
			else
			{
				minIndex=rightChild;
			}
		
		if(data[nodeIndex]>data[minIndex])
		{
			temp=data[nodeIndex];
			data[nodeIndex]=data[minIndex];
			data[minIndex]=temp;
			shiftDown(minIndex);
		}
		
	}
	
	public void topKElements(int arr[],int k)
	{
		
		for(int i=0;i<k;i++)
		{
			insert(arr[i]);
		}
	
		for(int i=k;i<arr.length;i++)
		{
			if(arr[i]>data[0])
			{
				data[0]=arr[i];
				shiftDown(0);
			}
		}
		sort();
		display();
	}
	
	public void smallestKElements(int arr[],int k)
	{
		
		for(int i=0;i<k;i++)
		{
			insert(arr[i]);
		}
	
		for(int i=k;i<arr.length;i++)
		{			
			if(arr[i]<data[0])
			{
				data[k]=arr[i];
				shiftUp(k);
			}
		}
		sort();
		display();
	}
	
	public static void main(String args[])
	{
		
		/*obj.insert(10);
		obj.insert(11);
		obj.insert(5);
		obj.insert(13);
		obj.insert(15);
		
		obj.display(); */
		int arr[]={1,2,3,4,5,10,9,8,1,2,3,4,5,6,7};
		int k=5;
		BinaryMinHeap obj=new BinaryMinHeap(k);
		
		System.out.println("Top K Elements are :");
		obj.topKElements(arr,k);
		
		//System.out.println("Smallest K Elements are :");
		//obj.smallestKElements(arr,k);
		
	}
	
}
