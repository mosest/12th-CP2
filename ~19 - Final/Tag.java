/*
	Victoria Antley, August 22, 2013;
	Final Game;
	I'm probably going to update this at some point;
	OBJECT VERSION
*/

import java.util.Scanner;
public class Tag
{
	Tag()
	{
		int i = 0;
	}
	//key functions for the player turtle
	public static void goLeft(Turtle t)
	{
		t.setDirection(180);
		t.forward(25);
	}
	public static void goRight(Turtle t)
	{
		t.setDirection(0);
		t.forward(25);
	}
	public static void goUp(Turtle t)
	{
		t.setDirection(90);
		t.forward(25);
	}
	public static void goDown(Turtle t)
	{
		t.setDirection(270);
		t.forward(25);
	}
	
	public void run()
	{
		Scanner sc=new Scanner(System.in);
	
		// explains the game
		System.out.println("The objective of this game is to catch the blue turtle with your red turtle.");
		System.out.println("Much like a game of tag.");
		System.out.println("\nWould you like this game to be multiplayer? (second player will be blue and uses w,a,s, and d keys)");
		String yesno = sc.next();
		System.out.println("Are you ready? ");
		//gives the user a chance to read instructions
		String go = sc.next();
		
		//make the turtles, and colors them correctly
		Turtle you = new Turtle();
		Turtle tag = new Turtle();
		you.setCanvasSize(400, 250);
		you.outlineColor("red");
		tag.outlineColor("blue");
		tag.speed(100);
		you.up();
		tag.up();
		you.setPosition(-150,75);
		tag.setPosition(150,-75);
		
		//have the player turtle move according to keys
		you.onKey("goLeft","left");
		you.onKey("goRight", "right");
		you.onKey("goUp", "up");
		you.onKey("goDown","down");
		//multiplayer option
		if (yesno.equals("yes")) {
			tag.onKey("goLeft","a");
			tag.onKey("goRight", "d");
			tag.onKey("goUp", "w");
			tag.onKey("goDown","s");
		}
		//have the other turtle run randomly
		//and the game runs until the blue turtle is tagged
		boolean run = true;
		while (run == true) 
		{
			//turns mutliplayer on and off
			if (!yesno.equals("yes"))
			{
			int number = (int)(Math.random()*5);
			if (number == 0) goLeft(tag);
			else if (number == 1) goRight(tag);
			else if (number == 2) goUp(tag);
			else if (number == 3) goDown(tag);
			}
			//make boundaries for both turtles
			if(you.getY() >= 125) goDown(you);
			if(tag.getY() >=125) goDown(tag);
			if(you.getY() <=-125) goUp(you);
			if(tag.getY() <=-125) goUp(tag);
			if(tag.getX() >= 200) goLeft(tag);
			if(you.getX() >= 200) goLeft(you);
			if(you.getX() <= -200) goRight(you);
			if(tag.getX() <= -200) goRight(tag);
			//Finds out if you've won or not
			if(you.distance(tag.getX(), tag.getY()) < 25) {
				run = false;
				System.out.println("YOU WIN!");
			}
		}
		

	}
}
