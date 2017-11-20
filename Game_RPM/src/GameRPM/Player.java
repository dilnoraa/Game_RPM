package GameRPM;

public abstract class Player {

	private String name;
	public String move;
	public int score;
	
	public Player( String name) {
	 	this.name=name;
	 	score=0;
	}
	
	public void setFirstMove(String firstMove)
	{
		move=firstMove;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract String strategic_play(String lastMoveOfRival);
}
