package Memory_Game;

import static java.util.Collections.shuffle;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;


@SuppressWarnings("serial")
public class Game extends JFrame implements ActionListener {
	private int row=Level.rows;
    private int column=Level.columns;
	private JButton[] pokButton = new JButton[row*column];
	private JButton Bexit, Breturn, Breset;
	private ArrayList<ImageIcon> pok = new ArrayList<ImageIcon>();
	private int[] pokPlace= new int[2];
    private ImageIcon[] pokType = new ImageIcon[2];
    private int counter = 0;
    private int counter2=0;
    public static int move,time;
    public static Date data1;
    private JLabel label, moves;
    private Timer timer,cover, m;
    private ImageIcon logo, p1, p2, p3, p4 ,p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17,p18;
    
    
	public Game() {
		time=-3600000;
		move=0;
		pokeImage();
		elements();
		panel();
		timer();
		setPokeList();
		setTitle("ZŁAP JE WSZYSTKIE!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,600);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
	}
	
	public void elements() {
        for (int i = 0; i < pokButton.length; i++) {
        		pokButton[i] = new JButton(logo);  
        		pokButton[i].addActionListener(this);    
        }
        Bexit = new JButton ("Wyłącz");
        Bexit.addActionListener(this);
        Bexit.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        Breturn = new JButton ("Powrót do Menu");
        Breturn.addActionListener(this);
        Breturn.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        Breset = new JButton ("Reset");
        Breset.addActionListener(this);
        Breset.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        label = new JLabel("");
        data1 = new Date (time);
     	SimpleDateFormat formatter = new SimpleDateFormat("KK:mm:ss");
        	label.setText("Czas: " +formatter.format(data1));  
        	label.setFont(new Font("Serif", Font.BOLD, 24)); 
        	label.setHorizontalAlignment(JLabel.CENTER);
        	moves=new JLabel("");
        	moves.setText("Liczba ruchów: "+ move);
        	moves.setHorizontalAlignment(JLabel.CENTER);
        	moves.setFont(new Font("Serif", Font.BOLD, 24)); 
    }
	
	public void panel() {
		Panel PanelGame = new Panel();
		PanelGame.setLayout(new GridLayout(row,column));
		for (int i=0; i<pokButton.length; i++) {
			PanelGame.add(pokButton[i]);	
		}
		PanelGame.setBackground(Color.WHITE);
		Panel PanelButtons = new Panel();
		PanelButtons.add(Bexit);
		PanelButtons.add(Breset);
		PanelButtons.add(Breturn);
		
		PanelButtons.setBackground(Color.WHITE);
		add(PanelGame, BorderLayout.CENTER);
		add(PanelButtons,BorderLayout.SOUTH);
		Panel Timer = new Panel();
		Timer.add(label);
		Timer.setBackground(Color.WHITE);
		Timer.add(moves);
		Timer.setLayout(new GridLayout(1,2));
		add(Timer, BorderLayout.NORTH);
		
	}
	
	public void setPokeList() {
		for (int i = 0; i < 2; i++) {
			pok.add(p1);
	        pok.add(p2);
	        pok.add(p3);
	        pok.add(p4);
	        pok.add(p5);
	        pok.add(p6);
	        	pok.add(p7);
	        pok.add(p8);   
	        
            if(row>=5) {
	            pok.add(p9);
	            pok.add(p10);
	            
            }
            if(row==6){
            		pok.add(p11);
            		pok.add(p12);
	            	pok.add(p13);
	            	pok.add(p14);
	            	pok.add(p15);
	            	pok.add(p16);
	            	pok.add(p17);
	            	pok.add(p18);
            }
        }
		shuffle(pok);       
	}
	
	public boolean samePokemon() {

        if (pokType[0].equals(pokType[1])) {
            return true;
        }
        return false;
    } 
	
	public void actionPerformed(ActionEvent e) {
		timer.start();
		moves();
		m.start();
		for (int i=0; i<pokButton.length; i++) {
			
			if (pokButton[i]== e.getSource()){
				pokButton[i].setDisabledIcon(pok.get(i));
				pokButton[i].setEnabled(false);
				pokButton[i].setIcon(pok.get(i));
				counter++;
				if (counter == 3) {
					cover.stop();
					if (samePokemon()) {
						pokButton[pokPlace[0]].setEnabled(false);
						pokButton[pokPlace[1]].setEnabled(false);  
					} 
					else {
						pokButton[pokPlace[0]].setEnabled(true);
                    		pokButton[pokPlace[0]].setIcon(logo);
                     	pokButton[pokPlace[1]].setEnabled(true);
                     	pokButton[pokPlace[1]].setIcon(logo);
                     	counter2-=2;
                    }
                    counter = 1; 
                }
				if (counter == 1) {
              		pokPlace[0] = i;
              		pokType[0] = pok.get(i);
				}
				if (counter == 2) {
              		pokPlace[1] = i;
              		pokType[1] = pok.get(i);
              		cover();
              		cover.start();   
				}
                if(pokButton[i].isEnabled()== false) {
        				counter2++;
        			}	
        			if (counter2==row*column) {
        				timer.stop();
        				move++;
        				setVisible(false);
        				new Winner();
        				new Nick(); 
        				
        			}
			}	
		}
		if (Breset== e.getSource()) {
			setVisible(false);
			timer.stop();
			new Game();	
		}	
		if (Breturn== e.getSource()) {
			timer.stop();
			setVisible(false);
			new MainMenu();
		}
		if (Bexit== e.getSource()) {
			System.exit(0);
		}	
	}
			
    public void timer() {  
    		time+=1000;
    		timer = new Timer(1000, new ActionListener(){
             public void actionPerformed(ActionEvent e){
            	 	data1 = new Date (time);
            	 	SimpleDateFormat formatter = new SimpleDateFormat("KK:mm:ss");
            	 	label.setText("Czas: " +formatter.format(data1));  
            	 	time+=1000;	
            	 	
             }
         });   
    }
    
    public void moves() {
    		m = new Timer(0, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				move++;
				moves.setText("Liczba ruchów: "+ move);
			}
    			
    		});
    		m.setRepeats(false);
    }
    
    public void cover() {  
    		cover = new Timer(0, new ActionListener(){
             public void actionPerformed(ActionEvent e){
            	 	if(samePokemon()!=true) {
            	 		pokButton[pokPlace[0]].setEnabled(true);
            	 		pokButton[pokPlace[0]].setIcon(logo);
            	 		pokButton[pokPlace[1]].setEnabled(true);
            	 		pokButton[pokPlace[1]].setIcon(logo);
            		 	counter2-=2;
            		 	counter=0;    
            	 	}      	
             }
         }); 
    		cover.setInitialDelay(2000);
    	 	cover.setRepeats(false);
    }
    
    public void pokeImage() {
    		logo= new ImageIcon("logo.png");
	    p1= new ImageIcon("1.png");
	    p2= new ImageIcon("2.png");
	    p3= new ImageIcon("3.png");
	    p4= new ImageIcon("4.png");
	    p5= new ImageIcon("5.png");
	    p6= new ImageIcon("6.png");
	    p7= new ImageIcon("7.png");
	    p8= new ImageIcon("8.png");
	    p9= new ImageIcon("9.png");
	    p10= new ImageIcon("10.png");
	    p11= new ImageIcon("11.png");
	    p12= new ImageIcon("12.png");
	    p13= new ImageIcon("13.png");
	    p14= new ImageIcon("14.png");
	    p15= new ImageIcon("15.png");
	    p16= new ImageIcon("16.png");
	    p17= new ImageIcon("17.png");
	    p18= new ImageIcon("18.png");
    }
}	

















