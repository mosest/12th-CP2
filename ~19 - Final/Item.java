//Tara Moses
//Class for CP2 Final: Rock, Paper, Scissors
//December 16, 2013

public class Item {
	String victim;
	String name;
	
	public Item(String str) {
		name=str;
		if (str.equals("Paper")) {
			victim="Rock";
		} else if (str.equals("Rock")) {
			victim="Scissors";		
		} else if (str.equals("Scissors")) {
			victim="Paper";
		} else {
			victim="nothing oops";
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String announceWinner(Item player1, Item player2) {
		if (player1.victim.equals(player2.name)) {
			return player1.name+" wins!";
		} else if (player2.victim.equals(player1.name)) {
			return player2.name+" wins!";
		}
		return "It's a draw!";
	}
}
