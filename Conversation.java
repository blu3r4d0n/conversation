//********************************************************************
//  Conversation.java       Author: CSCI151
//
//  Sets up a conversation among rulers
//********************************************************************
import java.util.Random;
import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;

public class Conversation extends JPanel
{

	private int numRulers;
	private Ruler rulerList[];
	private Timer conversationTimer;
	private Random gen;
	private int speakerIndex, listenerIndex;
	private JButton reportButton;
	
   //-----------------------------------------------------------------
   //  Initializes various rulers, gets them talking to each other.
   //-----------------------------------------------------------------
	public Conversation()
	{
		numRulers = 6;
		rulerList = new Ruler[numRulers];
		gen = new Random();
		setBackground(Color.yellow);
		conversationTimer = new Timer(1000, new ConversationTimerListener());
		reportButton = new JButton("Report");
		add(reportButton);
		reportButton.addActionListener(new ReportButtonListener());
		setPreferredSize(new Dimension(1100, 900));
		setLayout(new GridLayout(3,2));
		createRulers();
		identifyRulers();
		System.out.println();
		conversationTimer.start();
		System.out.println();
		addRulers();
		
	}
	public void createRulers() //adds each ruler to the array and creates rulers
	{
	 rulerList[0] = new Ruler( "Abraham Lincoln", "President", "America", "Americans", "Howdy", Color.blue,new ImageIcon("lincoln.jpeg") );
	 rulerList[1] = new Ruler("Cleopatra", "Queen", "Egypt", "Egyptians", "Marhaban", Color.green, new ImageIcon("cleo.jpeg"));
	 rulerList[2] = new Ruler("Hitler", "Fuhrer", "Germany", "Germans", "Guten Tag", Color.red, new ImageIcon("hitler.jpg"));
	 rulerList[3] = new Ruler("Napoleon", "Emperor", "France", "French", "Bonjour", Color.pink, new ImageIcon("napoleon.jpg"));
	 rulerList[4] = new Ruler("Churchhill", "Prime Minister", "Britain", "British", "Good day", new Color(142, 27, 137), new ImageIcon("winston.jpg"));
	 rulerList[5] = new Ruler("Mao Zedong", "Chairman", "China", "Chinese", "Ni hao", new Color(65,198,181), new ImageIcon("mao.jpeg"));
	}
	public void identifyRulers() //Tells rulers to identify themselves
	{
	for (int i=0; i < numRulers; i++)
		rulerList[i].identify();	
	}
	public void converse() //Allows the rulers to talk to each other
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
private class ConversationTimerListener implements ActionListener
	// Has one ruler say hello when timer expires
{
	public void actionPerformed(ActionEvent evt) //calles the coverse method  every 1000 milliseconds
	{
		converse();
	}
}
private class ReportButtonListener implements ActionListener
	// has the rulers report when the button is clicked
{
	public void actionPerformed(ActionEvent evt) //when the report button is clicked, it calls the report method
	{
		report();
	}
}
}

