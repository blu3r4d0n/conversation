//********************************************************************
//  MainConversation.java       Author: CSCI151
//
//  Sets up a conversation amongst dead people, once leaders of the land
//********************************************************************
import java.awt.*;
import javax.swing.*;

public class MainConversation
{
   //-----------------------------------------------------------------
   //  Just initializes the conversation object.
   //-----------------------------------------------------------------
	public static void main (String[] args)
	{
		Conversation c;
		c = new Conversation();

		JFrame frame = new JFrame ("Talking With Rulers of the Past");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add( c );
		frame.pack();
		frame.setVisible(true);

	}
}



