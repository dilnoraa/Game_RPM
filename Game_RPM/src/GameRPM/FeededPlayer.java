package GameRPM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FeededPlayer extends Player{

	int index=0;
	private String text;
	
	public FeededPlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	
	public void readFile() throws IOException {
	     FileReader fileReader = new FileReader("sample_input.txt");
	     String line;
	     char letter;
	     
			BufferedReader br = new BufferedReader(fileReader);

			while ((line = br.readLine()) != null) {

				text=line;
			  

			}
			
	       
			letter=text.charAt(0);
	        if (letter=='P')
	        	move="Paper";
			  else if(letter=='S')
				  move="Scissors";
			  else move="Rock";
	        
	        
			br.close();
		}
	

	@Override
	
	public String strategic_play(String str) {
		  index++;
		  
		  char letter=text.charAt(index);
		
		  if (letter=='P')
			  move="Paper";
		  else if(letter=='S')
			  move="Scissors";
		  else move="Rock";
		  
		return move;
	
	}
	

}


