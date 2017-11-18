//********************************************************************
//  Ruler.java       Author: CSCI151
//
//  An individual ruler who can talk to others
//********************************************************************
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Ruler extends JPanel
{	private String name, title, country, people, greeting;
	private int numConversations = 0;
	private Ruler talkedTo;
	private Color color;
	private ImageIcon rulerPic;
	private JLabel picLabel, idLabel, talkLabel, reportLabel, soundLabel;
	//----------------------------------------
	//Mirror Functions
	//----------------------------------------
	public String getName()//mirror function for name variable
	{return name;
	}
	public String getTitle()//mirror function for title variable
	{return title;
	}
	public String getCountry()//mirror function for country variable
	{return country;
	}
	public String getPeople()//mirror function for people variable
	{return people;
	}
	//---------------------
	//Convenience Functions
	//---------------------
	public String getIdentity()//convenience function for title and name
	{return title + " " + name;
	}
	public String getIdentityWithCountry()//convenience function for title, name, and country
	{return title + " " + name + " of " + country;
	}
	public String getIdentityWithPeople()//convenience function for title, name, and people
	{return title + " " + name + " of the " + people;
	}

	public Ruler( String nme, String ttl, String cntry, String ppl, String grtg, Color clr, ImageIcon pic)
		// Remember my info
	{	rulerPic = pic;
		picLabel = new JLabel(rulerPic);

		name = nme;
		title = ttl;
		country = cntry;
		people = ppl;
		greeting = grtg;
		color = clr;
		initGraphics();
	}

	public void initGraphics()//creates graphics
	{setBackground(color);
	setPreferredSize(new Dimension (500, 300));
	setLayout(new BorderLayout());
	setBorder(BorderFactory.createLineBorder( new Color(255, 106, 0),3));
	//picture initialization
	picLabel = new JLabel("Picture Area", SwingConstants.CENTER);
	picLabel.setHorizontalTextPosition (SwingConstants.CENTER);
	picLabel.setVerticalTextPosition (SwingConstants.BOTTOM);
	add(picLabel, BorderLayout.WEST);
	//identify
	idLabel = new JLabel("ID area", SwingConstants.CENTER);
	add(idLabel, BorderLayout.NORTH);
	//report
	reportLabel = new JLabel("Report Area", SwingConstants.CENTER);
	add(reportLabel, BorderLayout.SOUTH);
	//sound label
	soundLabel = new JLabel("Sound area", SwingConstants.CENTER);
	add(soundLabel, BorderLayout.EAST);
	//talking
	talkLabel = new JLabel("talk area", SwingConstants.CENTER);
	add(talkLabel, BorderLayout.CENTER);

	}
	public void identify() //I identify myself
	{

		picLabel.setIcon(rulerPic);
		picLabel.setText("A noted " + title);
		idLabel.setText("<html><h2>" + getIdentityWithCountry() + "</h2></html>");


	}
	public void sayHelloTo(Ruler otherRuler)//conversation between rulers
	{
		talkLabel.setText("<html>" + greeting + ", "+ otherRuler.getIdentityWithCountry() +". This is " + getIdentity() + " and I bring greetings from " + country + ".</html>");
		numConversations++;
		talkedTo = otherRuler;
	}
	public void report()//report number of times I have spoken
	{
		if (numConversations > 1) //More than 1 conversation
		 reportLabel.setText("<html>" + greeting + ", this is " + getIdentityWithPeople() + " reporting. I have started " + numConversations +" conversations and the last was with " + talkedTo.getIdentity() + ".</html>c");	
		else if (numConversations == 1) //Only 1 conversation
	    reportLabel.setText("<html>This is " + getIdentityWithPeople() + " reporting. I have started " + numConversations +" conversation and that was with " + talkedTo.getIdentity() + ".</html>");
		else //0 conversations
		reportLabel.setText("<html>This is " + getIdentityWithPeople() + " reporting. I haven't started any conversations because I'm shy.</html>");
	}

	}
