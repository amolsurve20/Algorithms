import java.util.*; 
abstract class Animal
 {
	 private String name;
	 private int order;
	 
	 public Animal(String name)
	 {
		 this.name=name;	 
	 }
	 
	 public String getName()
	 {
		 return name;
	 }
	 
	 public void setOrder(int order)
	 {
		 this.order=order;
	 }
	 
	 public int getOrder()
	 {
		 return order;
	 }
	 
	 public boolean compareOrder(Animal a)
	 {
		if(this.order<a.order)
			return true;
		else
			return false;
	 }
	 
 }

class Dog extends Animal
{
	String name;
	
	public Dog(String n)
	{
		super(n);
	}
}

class Cat extends Animal
{
	String name;
	
	public Cat(String n)
	{
		super(n);
	}
}
 
 class QueueAnimals
 {
	 LinkedList<Dog>doglist=new LinkedList<Dog>();
	 LinkedList<Cat>catlist=new LinkedList<Cat>();
	 int order=0;
	 
	 public void enqueue(Animal a)
	 {
		 a.setOrder(order);
		 order++;
		
		 if(a instanceof Dog)
		 {
			 doglist.add((Dog)a);	 
		 }
		 else if(a instanceof Cat)
			 {
				 catlist.add((Cat)a);
			 }
	
	 }
	 
	 public Animal dequeue()
	 {
		 if(doglist.size()==0)
			 return dequeueCat();
		 else
		 if(catlist.size()==0)
			 return dequeueDog(); 
		 
		 Dog dog=doglist.peek();
		 Cat cat=catlist.peek();
		 
		 if(dog.compareOrder(cat))
		 {
			 return dequeueDog();
		 }
		 else
		 {
			 return dequeueCat();
		 }
		 
	 }
	 
	 public Dog dequeueDog() 
	 {
		 
		 return doglist.poll();
	 }
	 
	 public Cat dequeueCat() 
	 {
		 
		 return catlist.poll();
	 }
	 
 }
public class AnimalQueue 
{
	public static void main(String args[])
	{
	
		Animal a=new Dog("A");
		Animal b=new Dog("B");
		Animal c=new Dog("C");
		Animal d=new Dog("D");
		
		Animal e=new Cat("E");
		Animal f=new Cat("F");
		Animal g=new Cat("G");
		Animal h=new Cat("H");
		
		QueueAnimals obj=new QueueAnimals();
		
		obj.enqueue(a);
		obj.enqueue(b);
		obj.enqueue(c);
		obj.enqueue(d);
		
		obj.enqueue(e);
		obj.enqueue(f);
		obj.enqueue(g);
		obj.enqueue(h);
		
		
		for(int i=0;i<8;i++)
			{
				Animal temp=obj.dequeue();
				System.out.println(temp.getName()+"   "+temp.getOrder());
			}

	}

}
