package GameRPM;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class Game extends JPanel {
	
	Player p1 = null;
	Player p2 = null;
	FeededPlayer p3=null;
	FeededPlayer p4=null;
	static int counter=0;
	int flag=0;
	
   private static final int GAP = 8;
   private static final int ROWS = 5;
  

   public  Game (final int player, String string) {
	   counter++;
      setBackground(Color.LIGHT_GRAY);
      GridLayout Gridlay=new GridLayout(ROWS, 3, GAP, GAP); 
      setLayout(Gridlay);
      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));     
      JLabel labelName=new JLabel( "  Type name for " +player + ". player:" ); 
      add(labelName);
      final JTextArea textArea = new JTextArea(3, 20);
      add(textArea);
      JLabel labelGap=new JLabel("  "); 
      add(labelGap);
      
      JLabel label1=new JLabel("Select strategy for " +player + ". player:"); 
      add(label1);
      final JRadioButton conservativeRadio = new JRadioButton("Conservative Strategy"); 
      final JRadioButton aggresiveRadio = new JRadioButton("Aggresive Strategy");
      final JRadioButton defensiveRadio = new JRadioButton("Defensive Strategy");
      final JRadioButton feededRadio = new JRadioButton("Feeded Strategy");
      ButtonGroup groupStrategy = new ButtonGroup();
      groupStrategy.add(conservativeRadio);
      groupStrategy.add(aggresiveRadio);
      groupStrategy.add(defensiveRadio);
      groupStrategy.add(feededRadio);
      add(conservativeRadio);
      add(aggresiveRadio);
      add(defensiveRadio);
      add(feededRadio);
      final JButton buttonRegister=new JButton("Register");
      add(buttonRegister);
      
      buttonRegister.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
			if(flag==0 && !textArea.getText().toString().equals("")) {
			    flag=2;
			    switch(counter) {
			
			      case 1:
				    if(conservativeRadio.isSelected()) 
					p1= new ConservativePlayer(textArea.getText());	
				
				else if(aggresiveRadio.isSelected()) 
					p1= new AggresivePlayer(textArea.getText());	
				
				else if(defensiveRadio.isSelected()) 
					p1= new DefensivePlayer(textArea.getText());	
				
				else if(feededRadio.isSelected()) {
					p3= new FeededPlayer(textArea.getText());
					try {
						p3.readFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
		
					String message=String.format("Please select any strategy");
					JOptionPane.showMessageDialog(null, message);					
					
				}
				break;
				
			case 2:
				if(conservativeRadio.isSelected()) 
					p2= new ConservativePlayer(textArea.getText());	
				
				else if(aggresiveRadio.isSelected()) 
					p2= new AggresivePlayer(textArea.getText());	
				
				else if(defensiveRadio.isSelected()) 
					p2= new DefensivePlayer(textArea.getText());	
				
				else if(feededRadio.isSelected()) {
					p4= new FeededPlayer(textArea.getText());
					try {
						p4.readFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					String message=String.format("Please select any strategy");
					JOptionPane.showMessageDialog(null, message);
					
					
				}
				break;

			}
			
			    			    
			} else if(textArea.getText().toString().equals("")) {
				String message=String.format("Please type name");
				JOptionPane.showMessageDialog(null, message);
			}
		
		        if(p1!=null) {
		        buttonRegister.setEnabled(false);  	
		        JLabel firstMoveLabel=new JLabel("Select first move for "  + player+ ". player:"); 
		     	        
		        final JPanel panel = new JPanel();
		        panel.add(firstMoveLabel);
		        final JRadioButton radioRock = new JRadioButton("Rock");
		        final JRadioButton radioPaper = new JRadioButton("Paper");
		        final JRadioButton radioScissors = new JRadioButton("Scissors");
		        ButtonGroup group4 = new ButtonGroup();
		        group4.add(radioRock);
		        group4.add(radioPaper);
		        group4.add(radioScissors);
		        panel.add(radioRock);
		        panel.add(radioPaper);
		        panel.add(radioScissors);

		        JOptionPane.showMessageDialog(null, panel);
		        
		        
		        if(radioRock.isSelected())
		           p1.setFirstMove(radioRock.getText());
		        else if
		         (radioPaper.isSelected())
			           p1.setFirstMove(radioPaper.getText());
		        else
		        	p1.setFirstMove(radioScissors.getText());
		        
		        } else if(counter==1 && p3!=null )
			         p1=p3;
		        
		        
		        if(p2!=null) {
		        	buttonRegister.setEnabled(false); 
			        JLabel labelMove2=new JLabel("Select first move for "  + player+ ". player:"); 
			         
			        final JPanel panel = new JPanel();
			        panel.add(labelMove2);
			        final JRadioButton radioRock2 = new JRadioButton("Rock");
			        final JRadioButton radioPaper2 = new JRadioButton("Paper");
			        final JRadioButton radioScissors2 = new JRadioButton("Scissors");
			        ButtonGroup group2 = new ButtonGroup();
			        group2.add(radioRock2);
			        group2.add(radioPaper2);
			        group2.add(radioScissors2);
			        panel.add(radioRock2);
			        panel.add(radioPaper2);
			        panel.add(radioScissors2);

			        JOptionPane.showMessageDialog(null, panel);
			        			        
			        if(radioRock2.isSelected())
			           p2.setFirstMove(radioRock2.getText());
			        else if (radioPaper2.isSelected())
				           p2.setFirstMove(radioPaper2.getText());
			        else
			        	p2.setFirstMove(radioScissors2.getText());
			        
			        } else if(counter==2 && p4!=null )
				         p2=p4;
			
		}
	});
     
      
       
   }
   
   public Player getP1() {
   	   if(p1!=null)
	   return p1;
   	   else return null;
   }
   
   public Player getP2() {
   	   if(p2!=null)
	   return p2;
   	   else return null;
   }
   
  
private static void createAndShowGui() {
	   
	
      final Game panelForPlayer1 = new Game(1,"gray");
     
      JFrame frame = new JFrame("GAME");
      final java.awt.Container content= frame.getContentPane();
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       frame.setLayout(new GridLayout(ROWS,1));
      content.add(panelForPlayer1);
      final JButton buttonAdd= new JButton("FOR SECOND PLAYER");
      buttonAdd.setSize(new Dimension(50, 50));
      content.add(buttonAdd);
     
      
      buttonAdd.addActionListener(new ActionListener() {
    	  
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			 
			final Game panelForPlayer2 =new Game(2,"red");
			   content.add(panelForPlayer2);
			   buttonAdd.setEnabled(false);
			
			 
			 
			  final Player p1;
		      p1=panelForPlayer1.getP1();
		      final JButton resultButton=new JButton(" Show Results ");
		      
		 
		      content.add(resultButton );
		      
		      resultButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					 JPanel roundPanel= new JPanel();
					 JLabel roundLabel=new JLabel("Number of rounds: ");
					 JTextArea roundText = new JTextArea(1, 12);
					 roundPanel.add(roundLabel);
					 roundPanel.add(roundText);
					 JOptionPane.showMessageDialog(null, roundPanel);
				 	 resultButton.setEnabled(false);
					   
					 final Player p2=panelForPlayer2.getP2();
					 int result=-1;					
					 int rnd=Integer.parseInt(roundText.getText());
					 if(p1!=null && p2!=null)
					   result=play(rnd, p1, p2);					
					  JLabel resultLabel=new JLabel();
					  if(result>0)
					  resultLabel.setText("  Score is " + p1.score+ ":" + p2.score+ ", so   " + result + ". Player wins");
					  else
						resultLabel.setText(" No one won ");
					  content.add(resultLabel);
					
				}
			});
			 
		}
	});
     
     
      frame.setSize(500, 700);
      frame.setLocation(200, 1);
      frame.setVisible(true);
   }



public static int play(int round, Player p1, Player p2) {
	
	String moveFor1, moveFor2;
	moveFor1=p1.move.toString();
	moveFor2=p2.move.toString();
		
	for(int i=0; i<round; i++) {
		
		if((moveFor1.equals("Rock") && moveFor2.equals("Scissors"))|| (moveFor1.equals("Scissors") && moveFor2.equals("Paper")) || (moveFor1.equals("Paper") && moveFor2.equals("Rock"))) 
		  p1.score++;
		 
		else if( (moveFor2.equals("Rock") && moveFor1.equals("Scissors"))|| (moveFor2.equals("Scissors") && moveFor1.equals("Paper")) || (moveFor2.equals("Paper") && moveFor1.equals("Rock")) )
		  p2.score++;
	
		p1.strategic_play(moveFor2);
		p2.strategic_play(moveFor1);
		System.out.println(" ");
			
		moveFor1=p1.move;
		moveFor2=p2.move;
  }
	
	
	if(p1.score>p2.score)
		return 1;
	else if(p2.score>p1.score)
		return 2;
	else
		return 0;
			  
}


   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
        	 
           createAndShowGui();
            
         }
      });
   }
}


		
			