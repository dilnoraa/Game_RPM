package GameRPM;

public class AggresivePlayer extends Player{

		public AggresivePlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public String strategic_play(String lastMoveOfRival) {
		
		if(lastMoveOfRival.equals("Scissors"))
			move= "Rock";
		else if(lastMoveOfRival.equals("Paper"))
			move="Scissors";
		else
			move="Paper";
		
		return move;
	}

}
