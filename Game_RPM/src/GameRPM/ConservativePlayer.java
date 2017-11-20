package GameRPM;

public class ConservativePlayer extends Player{

	
	public ConservativePlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public String strategic_play(String lastMoveOfRival) {
		
		move=lastMoveOfRival;
		return move;
	}
}
