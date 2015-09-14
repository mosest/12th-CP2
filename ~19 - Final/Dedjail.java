//Tara Moses
//Assignment 7: Escape from Dedjail 2: 2 Dead 2 Curious
//August 17, 2013
//OBJECT VERSION

import java.lang.String;

public class Dedjail
{
	Dedjail()
	{
		int i = 0;
	}
	
	public static void drawMaze(Turtle t)
	{
		t.bgcolor("light pink");
		t.width(10);
		
		t.up();
		t.setPosition(-125,-125);
		t.down();
		t.forward(250);
		t.left(90.0);
		t.forward(50);
		t.left(90.0);
		t.forward(50);
		t.right(90.0);
		t.forward(50);
		
		t.up();
		t.setPosition(125,-75);
		t.down();
		t.forward(150);
		t.left(90.0);
		t.forward(100);
		
		t.up();
		t.setPosition(125,125);
		t.down();
		t.forward(250);
		t.left(90.0);
		t.forward(200);
		t.left(90.0);
		t.forward(150);
		t.left(90.0);
		t.forward(50);
		
		t.up();
		t.setPosition(125,25);
		t.down();
		t.left(90.0);
		t.forward(150);
		t.left(90.0);
		t.forward(50);
		
		t.up();
		t.setPosition(-25,125);
		t.down();
		t.forward(50);
		t.right(90.0);
		t.forward(50);
		t.left(90.0);
		t.forward(100);
		
		t.up();
		t.setPosition(-125,-100);
	}
	
	public static void goEast(Turtle t)
	{
		double direction=t.getDirection();
		while (direction!=0.0)
		{
			t.left(90.0);
			direction=t.getDirection();
		}
		double x=t.getX()+25;
		double y=t.getY();		
		if (!isAWall(t,x,y))
		{
			t.forward(25);
		}
	}
	
	public static void goWest(Turtle t)
	{
		double direction=t.getDirection();
		while (direction!=180.0)
		{
			t.left(90.0);
			direction=t.getDirection();
		}
		double x=t.getX()-25;
		double y=t.getY();
		if (!isAWall(t,x,y))
		{
			t.forward(25);
		}
	}
	
	public static void goNorth(Turtle t)
	{
		double direction=t.getDirection();
		while (direction!=90.0)
		{
			t.left(90.0);
			direction=t.getDirection();
		}
		double x=t.getX();
		double y=t.getY()+25;
		if (!isAWall(t,x,y))
		{
			t.forward(25);
		}
	}
	
	public static void goSouth(Turtle t)
	{
		double direction=t.getDirection();
		while (direction!=270.0)
		{
			t.left(90.0);
			direction=t.getDirection();
		}
		double x=t.getX();
		double y=t.getY()-25;
		if (!isAWall(t,x,y))
		{
			t.forward(25);
		}
	}
	
	public static boolean isAWall(Turtle t,double x,double y)
	{
		double[] wallXs={-125,-100,-75,-50,-25,0,25,50,75,100,125,125,125,100,75,75,75,125,125,125,125,100,75,50,25,0,-25,-25,-25,125,125,100,75,50,25,125,100,75,50,25,0,-25,-50,-75,-100,-125,-125,-125,-125,-125,-125,-125,-125,-125,-100,-75,-50,-25,0,25,25,25,-25,-25,-50,-75,-75,-75,-75,-75,1000};
		double[] wallYs={-125,-125,-125,-125,-125,-125,-125,-125,-125,-125,-125,-100,-75,-75,-75,-50,-25,-50,-25,0,25,25,25,25,25,25,25,0,-25,50,75,75,75,75,75,125,125,125,125,125,125,125,125,125,125,125,100,75,50,25,0,-25,-50,-75,-75,-75,-75,-75,-75,-75,-50,-25,100,75,75,75,50,25,0,-25,1000};
		for (int i=0;i<wallXs.length-1;i++)
		{
			if (Math.sqrt((x-wallXs[i])*(x-wallXs[i])+(y-wallYs[i])*(y-wallYs[i]))<=5) return true;
		}
		return false;
	}
	
	public void run() throws Exception
	{
		System.out.println("Get the food and escape your pink prison!");
		
		Turtle player=new Turtle();
		Turtle friend1=new Turtle();
		Turtle friend2=new Turtle();
		
		player.clear();
		
		boolean friend1Hide=false;
		boolean friend2Hide=false;
				
		player.speed(0);
		friend1.speed(0);
		friend2.speed(0);
		
		player.shape("player.png");
		friend1.shape("friend1.png");
		friend2.shape("friend2.png");
		
		drawMaze(player);
		
		friend1.up();
		friend1.setPosition(-100,100);
		friend1.down();
		
		friend2.up();
		friend2.setPosition(100,-50);
		friend2.down();
				
		player.onKey("goEast","right");
		player.onKey("goWest","left");
		player.onKey("goNorth","up");
		player.onKey("goSouth","down");
		
		while (true)
		{
			Thread.sleep(0);
			if (player.distance(150,100)<=5 && friend1Hide && friend2Hide)
			{
				player.clear();
				player.bgpic("bgpic.png");
				player.home();
				player.shape("big win.png");
				System.out.println("YOU WIN");
				break;
			}
			if (player.distance(-100,100)<=5)
			{
				friend1Hide=true;
				friend1.hide();
			}
			if (player.distance(100,-50)<=5)
			{
				friend2Hide=true;
				friend2.hide();
			}
		}
	}
}
