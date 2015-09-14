//Tara, John Michael, Tyler, and Vic
//CP2 Final: 8 Games Menu. WITH GUI.
//December 2, 2013

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamesFinalMenu implements ActionListener
{
	JRadioButton tictactoe1, blackjack2, hangman3, maze4, turtletag5, tron6, turtlebombs7, tyler8;
	JButton playGame;
	boolean mazeVariable, turtleTagVariable, tronVariable, turtleBombsVariable, tylerVariable;
	
	public void addComponentToPane(Container pane)
	{
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		float buttonAlignment=(float)0.00;
		
		//create all 8 radio buttons for games
		tictactoe1=new JRadioButton("Tic-Tac-Toe (Tara)");
		tictactoe1.setAlignmentX(buttonAlignment);
		blackjack2=new JRadioButton("Blackjack (Tyler)");
		blackjack2.setAlignmentX(buttonAlignment);
		hangman3=new JRadioButton("Hangman (Vic)");
		hangman3.setAlignmentX(buttonAlignment);
		maze4=new JRadioButton("Maze (Tara)");
		maze4.setAlignmentX(buttonAlignment);
		turtletag5=new JRadioButton("Turtle Tag (Vic)");
		turtletag5.setAlignmentX(buttonAlignment);
		tron6=new JRadioButton("Tron (John Michael)");
		tron6.setAlignmentX(buttonAlignment);
		turtlebombs7=new JRadioButton("Turtle Bombs (John Michael)");
		turtlebombs7.setAlignmentX(buttonAlignment);
		tyler8=new JRadioButton("Rock/Paper/Scissors (Tara)");
		tyler8.setAlignmentX(buttonAlignment);
		
		//add all 8 radio buttons to button group so only one can be selected at a time
		ButtonGroup bg=new ButtonGroup();
		bg.add(tictactoe1);
		bg.add(blackjack2);
		bg.add(hangman3);
		bg.add(maze4);
		bg.add(turtletag5);
		bg.add(tron6);
		bg.add(turtlebombs7);
		bg.add(tyler8);
		
		//create select button and intro label
		playGame=new JButton("Play");
		playGame.setAlignmentX((float)0.3);
		playGame.addActionListener(this);
		JLabel introLabel=new JLabel("Choose a game to play:");
		
		//add things to pane
		pane.add(introLabel);
		pane.add(Box.createRigidArea(new Dimension(0,30)));
		pane.add(tictactoe1);
		pane.add(blackjack2);
		pane.add(hangman3);
		pane.add(maze4);
		pane.add(turtletag5);
		pane.add(tron6);
		pane.add(turtlebombs7);
		pane.add(tyler8);
		pane.add(Box.createRigidArea(new Dimension(0,30)));
		pane.add(playGame);
	}
	
	public void iShouldntNeedThisButIDo()
	{
		while (true) 
		{
			if(mazeVariable){
				mazeVariable = false;
				Dedjail MazeYeah = new Dedjail();
				try
				{
					MazeYeah.run();
				} catch (Exception e) {}
			}
			else if (turtleTagVariable)
			{
				turtleTagVariable = false;
				Tag TurtleTag = new Tag();
				TurtleTag.run();
			}
			else if (tronVariable)
			{
				tronVariable = false;
				Game TheGame = new Game();
				TheGame.run();
			}
			else if (turtleBombsVariable)
			{
				turtleBombsVariable = false;
				elevenboom boom11 = new elevenboom();
				try
				{
					boom11.run();
				} catch (Exception e) {
					System.out.println("11Boom is throwing an error!");
				}
			}
			else if (tylerVariable)
			{
				tylerVariable = false;
				RockPaperScissors RPS=new RockPaperScissors();
				RPS.run();
			}
			
			try
			{
				Thread.sleep(50);
			}
			catch(InterruptedException e)
			{
				System.out.println("NO!");
			}
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		Turtle nuke = new Turtle();
		nuke.setCanvasSize(500,500);
		nuke.init_again();
		nuke.bgpic("blank.png");
		if (tictactoe1.isSelected())
		{
			TicTacToeDriver TTT = new TicTacToeDriver();
			try
			{
				TTT.run();
			} catch (Exception e) {
				System.out.println("TTT is throwing an error!");
			}
		}
		else if (blackjack2.isSelected())
		{
			blackJackDriver BlackJack = new blackJackDriver();
			BlackJack.run();
		}
		else if (hangman3.isSelected())
		{
			hangman hang = new hangman();
			hang.run();
		}
		else if (maze4.isSelected())
		{
			mazeVariable = true;
		}
		else if (turtletag5.isSelected())
		{
			turtleTagVariable=true;
		}
		else if (tron6.isSelected())
		{
			tronVariable=true;
		}
		else if (turtlebombs7.isSelected())
		{
			turtleBombsVariable=true;
		}
		else if (tyler8.isSelected())
		{
			tylerVariable=true;
		}
		else
		{
			System.out.println("no game");
		}
		
	}
	static GamesFinalMenu menu = null;
	public static void createAndShowGUI()
	{
		JFrame frame=new JFrame("Choose a game, motherfunction.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menu=new GamesFinalMenu();
		menu.addComponentToPane(frame.getContentPane());
		
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
		while(menu == null){
			try{
				Thread.sleep(50);
			}catch(InterruptedException e){}
		}
		menu.iShouldntNeedThisButIDo();
	}
}
