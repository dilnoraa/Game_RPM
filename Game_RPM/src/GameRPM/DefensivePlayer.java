package GameRPM;

public class DefensivePlayer extends Player{

	
	public DefensivePlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
public String strategic_play(String lastMoveOfRival) {
		
		if(lastMoveOfRival.equals("Scissors"))
			move= "Paper";
		else if(lastMoveOfRival.equals("Paper"))
			move="Rock";
		else
			move="Scissors";
		
		return move;
	}

}
