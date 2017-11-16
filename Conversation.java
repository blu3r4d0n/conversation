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
	private JButton reportButton, startButton, stopButton;
	private JPanel rulerPanel, buttonPanel;

	
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
		initButtonPanel();
		initRulerPanel();
		identifyRulers();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
	}
	public void initRulerPanel()
	{   
		rulerPanel = new JPanel();
		add(rulerPanel);
		rulerPanel.setLayout(new GridLayout(3,2));
		createRulers();
		addRulers();
	}
	
	public void initButtonPanel()
	{
		buttonPanel = new JPanel();
		add(buttonPanel);
		reportButton = new JButton("Report");
		buttonPanel.add(reportButton);
		reportButton.addActionListener(new ReportButtonListener());
		startButton = new JButton("Start");
		buttonPanel.add(startButton);
		startButton.addActionListener(new StartButtonListener());
		stopButton = new JButton("Stop");
		buttonPanel.add(stopButton);
		stopButton.addActionListener(new StopButtonListener());
	}
	public void createRulers() //adds each ruler to the array and creates rulers
	{
	 rulerList[0] = new Ruler( "Abraham Lincoln", "President", "America", "Americans", "Howdy", Color.blue,new ImageIcon("src/images/incoln.jpeg"));
	 rulerList[1] = new Ruler("Cleopatra", "Queen", "Egypt", "Egyptians", "Marhaban", Color.green, new ImageIcon("src/images/cleo.jpeg"));
	 rulerList[2] = new Ruler("Hitler", "Fuhrer", "Germany", "Germans", "Guten Tag", Color.red, new ImageIcon("src/images/hitler.jpg"));
	 rulerList[3] = new Ruler("Napoleon", "Emperor", "France", "French", "Bonjour", Color.pink, new ImageIcon("src/images/napoleon.jpg"));
	 rulerList[4] = new Ruler("Churchhill", "Prime Minister", "Britain", "British", "Good day", new Color(142, 27, 137), new ImageIcon("src/images/winston.jpg"));
	 rulerList[5] = new Ruler("Mao Zedong", "Chairman", "China", "Chinese", "Ni hao", new Color(65,198,181), new ImageIcon("src/images/mao.jpeg"));
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
		rulerPanel.add(rulerList[i]);
		
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
private class StartButtonListener implements ActionListener
	// This starts the conversation when the button is pushed
{
	public void actionPerformed(ActionEvent evt) //starts the conversation timer
	{
		conversationTimer.start();
	}
}
private class StopButtonListener implements ActionListener
	// This stops the conversation when the button is pushed
{
	public void actionPerformed(ActionEvent evt) //stops the conversation timer
	{
		conversationTimer.stop();
	}
}
}

