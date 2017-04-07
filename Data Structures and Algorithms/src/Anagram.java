import java.util.*;
public class Anagram 
{
 
	private static final Set<String>dictionary=new HashSet<String>();
	static
	{
		dictionary.add("tab");
		dictionary.add("bat");
	}
    int c=0;
    void AnagramString(String s1, String s2)
    {
        if(s2.length()<=1)
        {
            c++;
            //String res=(s1+""+s2).toLowerCase();
            //if(dictionary.contains(res))
            System.out.println(s1+""+s2);
            
        }
        else
        {
            for(int i=0;i<s2.length();i++)
            {
            String x=s2.substring(i,i+1);
            String y=s2.substring(0,i);
            String z=s2.substring(i+1);
            AnagramString(s1+x,y+z);
            }
        }
    }
    
    void input()
    {
        String word="BAT";
        System.out.println("Possible words are");
        AnagramString("",word);
        System.out.println("Total "+c+" words");
    }
    
    public static void main(String args[])
    {
        Anagram obj=new Anagram();
        obj.input();
    }
    
}

