
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

public class LogParser 
{
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		String filename = "/Users/amolsurve/Desktop/log"
				+ ".txt";
		if (args.length > 0) 
		{
			filename = args[0];
		}

		String answer = parseFile(filename);
		System.out.println(answer);
	}

	static String parseFile(String filename) throws FileNotFoundException, IOException 
	{
		/*
		 * Don't modify this function
		 */
		BufferedReader input = new BufferedReader(new FileReader(filename));
		List<String> allLines = new ArrayList<String>();
		String line;
		while ((line = input.readLine()) != null) {
			allLines.add(line);
		}
		input.close();

		return parseLines(allLines.toArray(new String[allLines.size()]));
	}

	static String parseLines(String[] lines) 
	{
		/*
		 *
		 * Your code goes here
		 *
		 */
		Stack<Date> connectedPeriod = new Stack<Date>();
		Stack<Date> mainStack = new Stack<Date>();

		int totalTime = 0, connectedTime = 0;
		for (String line : lines) 
		{
			String[] parts = line.split("::");
			String timeStamp = parts[0].trim();
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("(MM/dd/yyyy-HH:mm:ss)");

			try 
			{
				date = format.parse(timeStamp);
				String key = parts[1].trim();

				if (key.equalsIgnoreCase("CONNECTED")) 
				{
					connectedPeriod.push(date);
				} else 
				{
					if (key.equalsIgnoreCase("DISCONNECTED")) 
					{
						Date top = connectedPeriod.pop();
						connectedTime += minutesDiff(top, date);
					}
				}
				if ( connectedPeriod.size() > 0 &&  key.equalsIgnoreCase("SHUTDOWN"))
				{
					Date top = connectedPeriod.pop();
					connectedTime += minutesDiff(top, date);
				}

				if (key.equalsIgnoreCase("START")) 
				{
					mainStack.push(date);
				} 
				else 
				{
					if (key.equalsIgnoreCase("SHUTDOWN")) 
					{
						Date top = mainStack.pop();
						totalTime += minutesDiff(top, date);
					}
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}

		float percentage = (float) connectedTime / totalTime * 100;
		return String.valueOf((int) percentage) + "%";
	}

	public static int minutesDiff(Date start, Date end) 
	{
        if (start == null || end == null)
            return 0;

        int endTime=(int)end.getTime() / 60000;
        int startTime=(int)start.getTime() / 60000;

        int result=endTime-startTime;


        return result;
}
}