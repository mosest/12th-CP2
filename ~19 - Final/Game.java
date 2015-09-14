import java.util.Scanner;

public class Game
{
	Game()
	{
		int i = 0;
	}
	public static double[] xCoords;
	public static double[] yCoords;
	public static double[] radii;
	public static int loop;
	public static Turtle bob;
	public static Turtle notbob;
	public static Turtle greg;
	public static boolean isTooCloseBob()
	{
		for (int pp=0; pp<loop-100000; pp++)
		{
			if (bob.distance(xCoords[pp],yCoords[pp])<=radii[pp])
			{
				return true;
			}
		}
		return false;
	}
	public static boolean isTooCloseBobBomb()
	{
		for (int pp=400000; pp<loop; pp++)
		{
			if (bob.distance(xCoords[pp],yCoords[pp])<=radii[pp])
			{
				return true;
			}
		}
		return false;
	}
	public static boolean isTooCloseGreg()
	{
		for (int pp=0;pp<loop-100000;pp++)
		{
			if (greg.distance(xCoords[pp],yCoords[pp])<=radii[pp])
			{
				return true;
			}
		}
		return false;
	}
	public static boolean isTooCloseGregBomb()
	{
		for (int pp=400000;pp<loop;pp++)
		{
			if (greg.distance(xCoords[pp],yCoords[pp])<=radii[pp])
			{
				return true;
			}
		}
		return false;
	}
	public static void leftb()
	{
		bob.setDirection(180);
	}
	public static void rightb()
	{
		bob.setDirection(0);
	}
	public static void upb()
	{
		bob.setDirection(90);
	}
	public static void downb()
	{
		bob.setDirection(270);
	}
	public static void leftg()
	{
		greg.setDirection(180);
	}
	public static void rightg()
	{
		greg.setDirection(0);
	}
	public static void downg()
	{
		greg.setDirection(270);
	}
	public static void upg()
	{
		greg.setDirection(90);
	}
	public void run()
	{
		loop=500000;	
		xCoords=new double[loop];
		yCoords=new double[loop];
		radii=new double[loop];
		System.out.println("This is a game. A two player game.\n\nThe first player will be the BLUE turtle. He will control his turtle by using   the arrow keys.\n\nThe second player will be the RED turtle, and his keys will be the 'ASWD' keys\n\nThe goal of this game is to not die.\nYou die by either running into a turtle's line or hitting the dots.\n**Warning, do not TURN AROUND into your OWN line.**\n\nGOOD LUCK! *Enter any character to start*");
		Scanner sc=new Scanner(System.in);
		String key=sc.next();
		try
		{
			Thread.sleep(4000);
		}
		catch(InterruptedException ie)
		{
			
		}
		bob=new Turtle();
		bob.clear();
		bob.fillColor("blue");
		bob.speed(13);
		bob.penColor("blue");
		bob.width(1);
		bob.up();
		bob.setPosition(125,0);
		bob.setDirection(90);
		bob.down();
		greg=new Turtle();
		greg.fillColor("red");
		greg.speed(13);
		greg.penColor("red");
		greg.width(1);
		greg.up();
		greg.setPosition(-125,0);
		greg.setDirection(270);
		greg.down();
		notbob=new Turtle();
		notbob.hide();
		notbob.up();
		notbob.bgcolor("black");
		notbob.speed(0);
		for(int i=0;i<7;i++)
		{
			double x=(Math.random()*501-250);
			double y=(Math.random()*501-250);
			double d=(Math.random()*20);
			notbob.setPosition(x,y);
			notbob.dot("white",(int)d);
			xCoords[i+400000]=x;
			yCoords[i+400000]=y;
			radii[i+400000]=d/2;
		}
		bob.onKey("leftb","left",true);
		bob.onKey("rightb","right",true);
		bob.onKey("upb","up",true);
		bob.onKey("downb","down",true);
		greg.onKey("leftg","a",true);
		greg.onKey("rightg","d",true);
		greg.onKey("upg","w",true);
		greg.onKey("downg","s",true);
		int som=7;
		int bombcount=0;
		int x;
		int y;
		int xx;
		int yy;
		int dierec;
		long startTime=System.currentTimeMillis();
		while (true)
		{
			double xxx= bob.canvasX(bob.getX());
			double yyy= bob.canvasY(bob.getY());
			if (isTooCloseBob())
			{
				System.out.println();
				System.out.println("The Blue turtle lost for hitting a line.\nVictory to the Red turtle!");
				System.out.println();
				break;
			}
			if (isTooCloseBobBomb())
			{
				System.out.println();
				System.out.println("The Blue turtle lost for hitting a circle.\nVictory to The Red turtle!");
				System.out.println();
				break;
			}
			double qx=bob.getX();
			double qy=bob.getY();
			som+=1;
			xCoords[som]=qx;
			yCoords[som]=qy;
			radii[som]=1;
			if (xxx>0)
			{
				bob.up();
				yy=(int)(bob.getY());
				bob.setPosition(-250,yy);
				bob.down();
			}
			if (yyy>500)
			{
				bob.up();
				xx=(int)(bob.getX());
				bob.setPosition(xx,250);
				bob.down();
			}
			if (xxx<-500)
			{
				bob.up();
				yy=(int)(bob.getY());
				bob.setPosition(250,yy);
				bob.down();
			}
			if (yyy<0) 
			{
				bob.up();
				xx=(int)(bob.getX());
				bob.setPosition(xx,-250);
				bob.down();
			}
			double xxxg= greg.canvasX(greg.getX());
			double yyyg= greg.canvasY(greg.getY());
			if (isTooCloseGreg())
			{
				System.out.println();
				System.out.println("The Red turtle lost for hitting a line.\nVictory to the Blue turtle!");
				System.out.println();
				break;
			}
			if (isTooCloseGregBomb())
			{
				System.out.println();
				System.out.println("The Red turtle lost for hitting a circle.\nVictory to The Blue turtle!");
				System.out.println();
				break;
			}
			double qgx= greg.getX();
			double qgy= greg.getY();
			som+=1;
			xCoords[som]=qgx;
			yCoords[som]=qgy;
			radii[som]=1;
			if (xxxg>0)
			{
				greg.up();
				yy=(int)(greg.getY());
				greg.setPosition(-250,yy);
				greg.down();
			}
			if (yyyg>500)
			{
				greg.up();
				xx=(int)(greg.getX());
				greg.setPosition(xx,250);
				greg.down();
			}
			if (xxxg<-500)
			{
				greg.up();
				yy=(int)(greg.getY());
				greg.setPosition(250,yy);
				greg.down();
			}
			if (yyyg<0) 
			{
				greg.up();
				xx=(int)(greg.getX());
				greg.setPosition(xx,-250);
				greg.down();
			}
			if (System.currentTimeMillis()-startTime>=1000)
			{
				bombcount+=1;
				x=(int)(Math.random()*501-250);
				y=(int)(Math.random()*501-250);
				int d=(int)(Math.random()*20);
				if (bob.distance(x,y)<=d)
				{
					x=(int)(Math.random()*501-250);
					y=(int)(Math.random()*501-250);
					d=(int)(Math.random()*20);
				}
				if (greg.distance(x,y)<=d)
				{
					x=(int)(Math.random()*501-250);
					y=(int)(Math.random()*501-250);
					d=(int)(Math.random()*20);
				}
				xCoords[bombcount+400008]=x;
				yCoords[bombcount+400008]=y;
				radii[bombcount+400008]=d/2;
				notbob.setPosition(x,y);
				notbob.dot("white",(int)d);
				startTime=System.currentTimeMillis();
			}
			bob.forward(2);
			greg.forward(2);
		}
		notbob.speed(800);
		notbob.dot("red",1500);
		bob.hide();
		greg.hide();
		notbob.hide();
		notbob.up();
		notbob.speed(3);
		notbob.setPosition(-150,0);
		notbob.setDirection(0);
		notbob.down();
		notbob.forward(15);
		notbob.right(90);
		notbob.forward(10);
		notbob.right(90);
		notbob.forward(20);
		notbob.right(90);
		notbob.forward(30);
		notbob.right(90);
		notbob.forward(20);
		notbob.right(90);
		notbob.forward(4);
		notbob.up();
		notbob.setPosition(-128,0);
		notbob.setDirection(0);
		notbob.down();
		notbob.forward(12);
		notbob.right(69);
		notbob.forward(12);
		notbob.right(180);
		notbob.forward(27);
		notbob.left(140);
		notbob.forward(27);
		notbob.up();
		notbob.setPosition(-105,20);
		notbob.down();
		notbob.setDirection(270);
		notbob.forward(30);
		notbob.up();
		notbob.setPosition(-105,20);
		notbob.down();
		notbob.setDirection(320);
		notbob.forward(20);
		notbob.setDirection(40);
		notbob.forward(20);
		notbob.setDirection(270);
		notbob.forward(30);
		notbob.up();
		notbob.setPosition(-66,20);
		notbob.setDirection(0);
		notbob.down();
		notbob.forward(22);
		notbob.right(180);
		notbob.up();
		notbob.forward(22);
		notbob.down();
		notbob.left(90);
		notbob.forward(15);
		notbob.left(90);
		notbob.forward(16);
		notbob.up();
		notbob.right(180);
		notbob.forward(16);
		notbob.down();
		notbob.left(90);
		notbob.forward(15);
		notbob.left(90);
		notbob.forward(22);
		notbob.up();
		notbob.setPosition(0,20);
		notbob.down();
		for (int ww=0;ww<25;ww++)
		{
			notbob.forward(100/25);
			notbob.right(360/25);
		}
		notbob.forward(2);
		notbob.up();
		notbob.setPosition(23,16);
		notbob.down();
		notbob.setDirection(295);
		notbob.forward(30);
		notbob.setDirection(55);
		notbob.forward(30);
		notbob.up();
		notbob.setPosition(60,18);
		notbob.setDirection(0);
		notbob.down();
		notbob.forward(22);
		notbob.right(180);
		notbob.up();
		notbob.forward(22);
		notbob.down();
		notbob.left(90);
		notbob.forward(15);
		notbob.left(90);
		notbob.forward(16);
		notbob.up();
		notbob.right(180);
		
		notbob.forward(16);
		notbob.down();
		notbob.left(90);
		notbob.forward(15);
		notbob.left(90);
		notbob.forward(22);
		notbob.up();
		notbob.setPosition(92,18);
		notbob.down();
		for (int ss=0;ss<25;ss++)
		{
			notbob.forward(50/50);
			notbob.right(360/50);
		}
		notbob.forward(2);
		int asd=(int) notbob.getX();
		int jkl=(int) notbob.getY();
		notbob.up();
		notbob.setPosition(92,18);
		notbob.down();
		notbob.setDirection(270);
		notbob.forward(30);
		notbob.up();
		notbob.setPosition(asd,jkl);
		notbob.setDirection(310);
		notbob.down();
		notbob.forward(19);
	}
}
