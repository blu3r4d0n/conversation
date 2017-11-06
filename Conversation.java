//********************************************************************
//  Conversation.java       Author: CSCI151
//
//  Sets up a conversation among rulers
//********************************************************************
import java.util.Random;
import java.awt.*;
import javax.swing.*; 

public class Conversation extends JPanel
{

	private int numRulers;
	private Ruler rulerList[];
	private Random gen;
	private int speakerIndex, listenerIndex;
	
   //-----------------------------------------------------------------
   //  Initializes various rulers, gets them talking to each other.
   //-----------------------------------------------------------------
	public Conversation()
	{	numRulers = 6;
		rulerList = new Ruler[numRulers];
		gen = new Random();
		setBackground(Color.yellow);
		setPreferredSize(new Dimension(1100, 900));
		createRulers();
		identifyRulers();
		System.out.println();
		converse();
		System.out.println();
		report()
		addRulers();
	}
	public void createRulers() //adds each ruler to the array and creates rulers
	{
	 rulerList[0] = new Ruler( "Abraham Lincoln", "President", "America", "Americans", "Howdy", Color.blue,new ImageIcon("src/images/lincoln.jpeg") );
	 rulerList[1] = new Ruler("Cleopatra", "Pharoh", "Egypt", "Egyptians", "Marhaban", Color.green, new ImageIcon("src/images/cleo.jpeg"));
	 rulerList[2] = new Ruler("Hitler", "Fuhrer", "Germany", "Germans", "Guten Tag", Color.red, new ImageIcon("src/images/hitler.jpg"));
	 rulerList[3] = new Ruler("Napoleon", "Emperor", "France", "French", "Bonjour", Color.pink, new ImageIcon("src/images/napoleon.jpg"));
	 rulerList[4] = new Ruler("Churchhill", "Prime Minister", "Britain", "British", "Good day", Color.magenta, new ImageIcon("src/images/winston.jpg"));
	 rulerList[5] = new Ruler("Mao Zedong", "Chairman", "China", "Chinese", "Ni hao", Color.black, new ImageIcon("src/images/mao.jpeg"));
	}
	public void identifyRulers() //Tells rulers to identify themselves
	{
	for (int i=0; i < numRulers; i++)
		rulerList[i].identify();	
	}
	public void converse() //Allows the rulers to talk to each other
	{ 	
	for (int i = 0; i < 10; i++)// Generates 10 conversations between rulers randomly
			{	
				speakerIndex = gen.nextInt(numRulers);
				listenerIndex = gen.nextInt(numRulers);
				if (speakerIndex == listenerIndex) //prevents rulers from talking to each other
				{	if (speakerIndex > 0)		   //subtracts from speakerIndex
						speakerIndex--; 		   
					else				
						speakerIndex++; //adds to speakerIndex
				}
					rulerList[speakerIndex].sayHelloTo(rulerList[listenerIndex]);
			}
	}
	public void report() //tells the rulers to report
	{
	for (int i=0; i < numRulers; i++) //each ruler reports
		rulerList[i].report();
	}
	public void addRulers() //adds rulers to the graphics 
	{
	for (int i=0; i < numRulers; i++)
		{
		add(rulerList[i]);
		}
	}
}
