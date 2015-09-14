//Tara Moses
//Assignment 15: Desktop App Publishing Conference
//November 18, 2013
//fbla competition page: http://www.fbla-pbl.org/data/files/docs/2013/1021/fbla/FBLA_competitiveevents%5B10-21-13%5D.pdf
//how to buttongroup: http://docs.oracle.com/javase/tutorial/uiswing/components/button.html#radiobutton

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegisterFBLAConf implements ItemListener
{
	JPanel tabPane;
	final static String instructionsPanel="Instructions";
	final static String chooseDatePanel="1: Conference Date";
	final static String chooseTypePanel="2: Participant Type";
	final static String inputNamePanel="3: Participant Name";
	final static String chooseWorkshopPanel="4: Preregister for Workshops";
	final static String submitPanel="5: Submit Responses";
	JButton submitButton;
	
	public void addComponentToPane(Container pane)
	{
		pane.setLayout(new BoxLayout(pane, BoxLayou.Y_AXIS)));
		JTabbedPane tabPane=new JTabbedPane();
		
		JPanel instructionsCard=new JPanel();
		instructionsCard.add(new JLabel("Please visit each tab and fill out the necessary information to register."));
		instructionsCard.add(new JLabel("\nGo to the 'Submit Responses' tab when you have finished."));
		
		JPanel card1=new JPanel();
		ButtonGroup bg1=new ButtonGroup();
		JRadioButton DCDate=new JRadioButton("Washington, DC, November 7-8");
		JRadioButton MNDate=new JRadioButton("Minneapolis, MN, November 14-15");
		JRadioButton LADate=new JRadioButton("New Orleans, LA, November 21-22");
		bg1.add(DCDate);
		bg1.add(MNDate);
		bg1.add(LADate);
		card1.add(new JLabel("Please choose your conference date: "));
		card1.add(DCDate);
		card1.add(MNDate);
		card1.add(LADate);
		
		JPanel card2=new JPanel();
		ButtonGroup bg2=new ButtonGroup();
		JRadioButton guestType=new JRadioButton("Guest");
		JRadioButton memberType=new JRadioButton("Member");
		JRadioButton adviserType=new JRadioButton("Adviser");
		bg2.add(guestType);
		bg2.add(memberType);
		bg2.add(adviserType);
		card2.add(new JLabel("Are you registering as a..."));
		card2.add(guestType);
		card2.add(memberType);
		card2.add(adviserType);
		
		JPanel card3=new JPanel();
		JTextField firstName=new JTextField(10);
		JTextField lastName=new JTextField(10);
		card3.add(new JLabel("Please enter your full name:"));
		card3.add(new JLabel("First:"));
		card3.add(firstName);
		card3.add(new JLabel("Last:"));
		card3.add(lastName);
		
		JPanel card4=new JPanel();
		ButtonGroup bg4=new ButtonGroup();
		JRadioButton workshop1=new JRadioButton("Workshop 1");
		JRadioButton workshop2=new JRadioButton("Workshop 2");
		JRadioButton workshop3=new JRadioButton("Workshop 3");
		bg4.add(workshop1);
		bg4.add(workshop2);
		bg4.add(workshop3);
		card4.add(new JLabel("Please choose what workshops, if any, you would like to preregister for:"), BorderLayout.PAGE_START);
		card4.add(workshop1, BorderLayout.CENTER);
		card4.add(workshop2, BorderLayout.CENTER);
		card4.add(workshop3, BorderLayout.CENTER);
		
		JPanel submitCard=new JPanel();
		submitButton=new JButton("Submit");
		submitCard.add(new JLabel("When you have finished filling out all of the information, click submit to finish registering."));
		submitCard.add(submitButton);
		
		tabPane.add(instructionsCard, instructionsPanel);
		tabPane.add(card1, chooseDatePanel);
		tabPane.add(card2, chooseTypePanel);
		tabPane.add(card3, inputNamePanel);
		tabPane.add(card4, chooseWorkshopPanel);
		tabPane.add(submitCard, submitPanel);
		
		pane.add(tabPane, BorderLayout.CENTER);
	}
	
	public void itemStateChanged(ItemEvent event)
	{
		BorderLayout bl=(BorderLayout)(tabPane.getLayout());
	}
	
	public static void createAndShowGUI()
	{
		JFrame frame=new JFrame("CardLayout Frame Whoo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		RegisterFBLAConf demo=new RegisterFBLAConf();
		demo.addComponentToPane(frame.getContentPane());
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				createAndShowGUI();
			}
		});
	}
}
