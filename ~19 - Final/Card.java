public class Card extends Object 
{
	private String faceValue;
	private String suit;
	private int points;
	
	Card(String f, String s)
	{
		faceValue = f;
		suit = s;
		if(f.equals("Ace"))
		points = 11;
		else
		
		if((f.equals("King"))||(f.equals("Queen"))||(f.equals("Jack"))||(f.equals("10")))
		points=10;
		else
		points = Integer.parseInt(f);
	}
	public String getFaceValue()
	{
		return faceValue;
	}
	public String getSuit()
	{
		return suit;
	}
	public int getPoints()
	{
		return points;
	}
	public void setFaceValue(String f)
	{
		faceValue=f;
	}
	public void setSuit(String s)
	{
		suit=s;
	}
	public void setPoints(int p)
	{
		points=p;
	}
	public static String figureName(int i)
	{
		switch(i)
		{
			case 1:
			return "Ace";
			case 11:
			return "Jack";
			case 12: 
			return "Queen";
			case 13:
			return "King";
			default:
			if(i<=0||i>=14)
			return "error";
			else return "" +i;
		}
	}
	public static String figureSuit(int i)
	{
		switch(i)
		{
			case 1:
			return "Hearts";
			case 2:
			return "Diamonds";
			case 3:
			return "Spades";
			case 4:
			return "Clubs";
			default:
			return "error";
		}
	}
	public String toString()
	{
		return "The "+faceValue+" of "+suit;
	}
}
