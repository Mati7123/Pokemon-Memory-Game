package Memory_Game;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.*;

@SuppressWarnings("serial")
public class Winner extends JFrame implements ActionListener {
	private JButton Bexit, Breturn, Breplay, Bscore; 
	private JLabel label, time, points, moves;
	public static int score;
	public Winner() {
		score = (Level.rows*Level.columns*100)/(Game.move);
		System.out.println(score);
		System.out.println(Game.move);
		System.out.println((Game.time+3600000)/1000);
		
		elements();
		setTitle("WYGRANA");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,600);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);	
	}
	
	public void elements () {
		 Bexit = new JButton ("Wyłącz");
	     Bexit.addActionListener(this);
	     Bexit.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	     Breturn = new JButton ("Powrót do Menu");
	     Breturn.addActionListener(this);
	     Breturn.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	     Breplay = new JButton ("Zagraj jeszcze raz");
	     Breplay.addActionListener(this);
	     Breplay.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	     Bscore = new JButton ("Tablica Wyników");
	     Bscore.addActionListener(this);
	     Bscore.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	     SimpleDateFormat formatter = new SimpleDateFormat("KK:mm:ss");
       	
	     label=new JLabel("GRATULACJE! TWÓJ WYNIK TO:");
	     label.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
	     label.setHorizontalAlignment(JLabel.CENTER);
	     time=new JLabel("Czas: " +formatter.format(Game.data1));
	     time.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
	     time.setHorizontalAlignment(JLabel.CENTER);
	     moves=new JLabel("Liczba ruchów: " + Game.move);
	     moves.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
	     moves.setHorizontalAlignment(JLabel.CENTER);
	     points=new JLabel(""+Winner.score);
	     points.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
	     points.setHorizontalAlignment(JLabel.CENTER);
	     
	     Panel panel=new Panel();
	     panel.setLayout(new GridLayout(1,2));
	     panel.add(time);
	     panel.add(moves);
	     setLayout(new GridLayout(7,1));
	     add(label);
	     add(points);
	     add(panel);
	     add(Breplay);
	     add(Breturn);
	     add(Bscore);
	     add(Bexit);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (Breplay== e.getSource()) {
			setVisible(false);
			new Level();	
		}	
		if (Breturn== e.getSource()) {
			setVisible(false);
			new MainMenu();
		}
		if (Bexit== e.getSource()) {
			System.exit(0);
		}	
		if (Bscore== e.getSource()) {
			new ScoreList();
		}	
	}
}	

