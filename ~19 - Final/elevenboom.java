//OBJECT VERSION
import java.util.Scanner;

public class elevenboom
{
	public elevenboom()
	{
		int i = 0;
	}
	public static double[] xCoords;
	public static double[] yCoords;
	public static double[] radii;
	public static Turtle bob;
	public static int loop;
	public static void left()
	{
		bob.left(10);
	}
	public static void right()
	{
		bob.right(10);
	}
	public static boolean isTooClose()
	{
		for (int pp=0;pp<loop;pp++)
		{
			if (bob.distance(xCoords[pp],yCoords[pp])<=radii[pp])
			{
				return true;
			}
		}
		return false;
	}
	public void run() throws Exception
	{
		System.out.println("Use the left and right arrow keys to survive.\nImput any key to proceed.");
		Scanner sc=new Scanner(System.in);
		String key=sc.next();
		loop=100;	
		xCoords=new double[loop];
		yCoords=new double[loop];
		radii=new double[loop];
		Turtle ted=new Turtle();
		ted.clear();
		Turtle fred=new Turtle();
		Turtle mac=new Turtle();
		Turtle notbob=new Turtle();
		bob=new Turtle();
		notbob.hide();
		notbob.up();
		ted.up();
		fred.up();
		mac.up();
		bob.up();
		bob.hide();
		ted.setPosition(125,-220);
		ted.left(90);
		ted.speed(100);
		fred.setPosition(150,-220);
		fred.left(90);
		fred.speed(100);
		mac.setPosition(175,-220);
		mac.left(90);
		mac.speed(100);
		ted.penColor("blue");
		ted.forward(20);
		ted.down();
		ted.forward(30);
		fred.forward(20);
		fred.down();
		fred.forward(20);
		mac.penColor("red");
		mac.forward(20);
		mac.down();
		mac.right(35);
		mac.forward(18);
		ted.up();
		ted.setPosition(200,-190);
		ted.right(90);
		ted.down();
		ted.forward(10);
		fred.penColor("brown");
		fred.up();
		fred.setPosition(125,-200);
		fred.down();
		fred.right(90);
		fred.forward(15);
		mac.up();
		mac.setPosition(150,-171);
		mac.dot("blue",7);
		ted.penColor("purple");
		ted.up();
		ted.setPosition(227,-187);
		ted.setDirection(135);
		ted.down();
		ted.speed(40);
		ted.forward(2);
		ted.left(45);
		ted.forward(3);
		ted.left(45);
		ted.forward(3);
		ted.left(45);
		ted.forward(4);
		ted.left(45);
		ted.forward(2);
		ted.left(45);
		ted.forward(3);
		fred.up();
		fred.forward(35);
		fred.setDirection(125);
		fred.down();
		fred.forward(18);
		mac.penColor("orange");
		mac.up();
		mac.setPosition(210,-190);
		mac.speed(100);
		mac.down();
		mac.setDirection(135);
		mac.forward(5);
		mac.left(45);
		mac.forward(5);
		mac.left(45);
		mac.forward(5);
		mac.left(45);
		mac.forward(7);
		mac.left(45);
		mac.forward(5);
		mac.left(45);
		mac.forward(4);
		mac.left(35);
		mac.forward(2);
		mac.speed(100);
		ted.penColor("black");
		ted.right(45);
		ted.forward(2);
		ted.right(45);
		ted.forward(4);
		ted.right(45);
		ted.forward(3);
		ted.right(45);
		ted.forward(3);
		ted.right(45);
		ted.forward(3);
		ted.speed(100);
		ted.up();
		fred.up();
		mac.penColor("black");
		mac.up();
		mac.setPosition(124,-205);
		mac.down();
		mac.setDirection(0);
		mac.forward(150);
		mac.up();
		ted.setPosition(125,-220);
		ted.setDirection(90);
		fred.setPosition(150,-220);
		fred.setDirection(90);
		mac.setPosition(175,-220);
		mac.setDirection(90);
		int count=0;
		for(int i=0;i<7;i++)
		{
			double x=(Math.random()*501-250);
			double y=(Math.random()*501-250);
			double d=(Math.random()*50+50);
			notbob.setPosition(x,y);
			notbob.dot("black",(int)d);
			xCoords[i]=x;
			yCoords[i]=y;
			radii[i]=d/2;
		}
		int x=(int)(Math.random()*501-250);
		int y=(int)(Math.random()*501-250);
		bob.setPosition(x,y);
		if (isTooClose())
		{	
			x=(int)(Math.random()*501-250);
			y=(int)(Math.random()*501-250);
			bob.setPosition(x,y);
		}
		bob.down();
		bob.onKey("left","left",true,true);
		bob.onKey("right","right",true,true);
		int som=0;
		int xx=0;
		int yy=0;
		int diex=0;
		int diey=0;
		int dierec=0;
		long startTime=System.currentTimeMillis();
		while(true)
		{
			bob.forward(4);
			{
				double xxx= bob.canvasX(bob.getX());
				double yyy= bob.canvasY(bob.getY());
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
				if (System.currentTimeMillis()-startTime>=2500)
				{
					som+=1;
					x=(int)(Math.random()*501-250);
					y=(int)(Math.random()*501-250);
					int d=(int)(Math.random()*50+50);
					if (bob.distance(x,y)<=d)
					{
						x=(int)(Math.random()*501-250);
						y=(int)(Math.random()*501-250);
						d=(int)(Math.random()*50+50);
					}
					xCoords[8+som]=x;
					yCoords[8+som]=y;
					radii[8+som]=d/2;
					notbob.setPosition(x,y);
					notbob.dot("black",(int)d);
					startTime=System.currentTimeMillis();
				}
				if(isTooClose())
				{
					count+=1;
					diex=(int)bob.getX();
					diey=(int)bob.getY();
					dierec=(int)bob.getDirection();
					if (count==1) 
					{
						ted.setPosition(diex,diey);
						ted.setDirection(dierec);
						ted.left(180);
						bob.left(180);
						bob.penColor("green");
						bob.forward(5);
					}
					else if (count==2)
					{

						fred.setPosition(diex,diey);
						fred.setDirection(dierec);
						fred.left(180);
						bob.left(180);
						bob.penColor("blue");
						bob.forward(5);
						}
					else if (count==3)
					{
						mac.setPosition(diex,diey);
						mac.setDirection(dierec);
						mac.left(180);
						bob.left(180);
						bob.penColor("red");
						bob.forward(5);
					}
					else if (count==4)
					{
						bob.speed(1800);
						bob.dot("red",1500);
						fred.hide();
						mac.hide();
						ted.hide();
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
						break;
					}
				}
			}
		}
		System.out.println("Your score is " + som);
	}
}
