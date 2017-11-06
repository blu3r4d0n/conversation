//********************************************************************
//  Ruler.java       Author: CSCI151
//
//  An individual ruler who can talk to others
//********************************************************************
import java.awt.*;
import javax.swing.*; 

public class Ruler extends JPanel
{	private String name, title, country, people, greeting;
	private int numConversations = 0;
	private Ruler talkedTo;
	private Color color;
	private ImageIcon rulerPic;
	private JLabel picLabel, idLabel, talkLabel, reportLabel, tbdLabel;
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
		
		setPreferredSize(new Dimension (500, 300));
		picLabel = new JLabel("Picture Area");
		setLayout(new BorderLayout());
		idLabel = new JLabel("ID Label", SwingConstants.CENTER);
		add(idLabel, BorderLayout.NORTH);	
			
	}
		
	public void identify() //I identify myself
	{
		System.out.println(greeting + ", I'm " + getIdentity() + " of the glorious " +people+ ".");
		setBackground(color);
		picLabel.setIcon(rulerPic);
		picLabel.setText("A noted " +title);
		add(picLabel, BorderLayout.WEST);
		idLabel.setText(getIdentity());		
	}
	public void sayHelloTo(Ruler otherRuler)//conversation between rulers
	{
		System.out.println(greeting + ", "+ otherRuler.getIdentityWithCountry() +". This is " + getIdentity() + " and I bring greetings from " + country + ".");
		numConversations++;
		talkedTo = otherRuler;
	}
	public void report()//report number of times I have spoken
	{
		if (numConversations > 1) //More than 1 conversation
		{System.out.println(greeting + ", this is " + getIdentityWithPeople() + " reporting. I have started " + numConversations +" conversations and the last was with " + talkedTo.getIdentity() + ".");
		}
		else if (numConversations == 1) //Only 1 conversation
		System.out.println("This is " + getIdentityWithPeople() + " reporting. I have started " + numConversations +" conversation and that was with " + talkedTo.getIdentity() + ".");
		else //0 conversations
		System.out.println("This is " + getIdentityWithPeople() + " reporting. I haven't started any conversations because I'm shy.");
	}

}
