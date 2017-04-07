import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis 
{
	public static void main(String args[])
	{
		String input="(){}";
		boolean isval=isValid(input);
		System.out.println(isval);
	}
	
	public static boolean isValid(String input)
	{
		HashMap<Character,Character>hm=new HashMap<Character,Character>();
		Stack<Character>stack=new Stack<Character>();
		hm.put('(',')');
		hm.put('[',']');
		hm.put('{','}');
		
		for(int i=0;i<input.length();i++)
		{
			char x=input.charAt(i);
			if(hm.keySet().contains(x))
			{
				stack.push(x);
			}
			else
				if(hm.values().contains(x))
				{
					if(!stack.empty()&&hm.get(stack.peek())==x)
						{
							stack.pop();
						}
						else
						{
							return false;
						}

				}
		
		}
		return stack.empty();
		
	}

}
