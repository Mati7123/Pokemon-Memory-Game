package Memory_Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MainMenu extends JFrame implements ActionListener{

	private JButton Bexit, Bgame, Bscore; 
	private JLabel label, logo, s;
	private ImageIcon poke= new ImageIcon("poke.png");
	public MainMenu() {
		elements();
		setTitle("POKEMON - THE MEMORY GAME");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,600);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
	
	public void elements () {
		 Bexit = new JButton ("Wyłącz");
	     Bexit.addActionListener(this);
	     Bexit.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	     Bgame= new JButton ("Rozpocznij Grę");
	     Bgame.addActionListener(this);
	     Bgame.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	     Bscore = new JButton ("Tablica Wyników");
	     Bscore.addActionListener(this);
	     Bscore.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	     label=new JLabel("Pokemon - MEMORY GAME");
	     label.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
	     label.setHorizontalAlignment(JLabel.CENTER);
	     s=new JLabel("s17489");
	     s.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	     s.setHorizontalAlignment(JLabel.CENTER);
	     Panel Plabel = new Panel();
	     Plabel.setLayout(new GridLayout (1,1));
	     Plabel.add(label,BorderLayout.CENTER);
	     Plabel.add(s,BorderLayout.NORTH);
	     logo=new JLabel();
	     logo.setIcon(poke);
	     logo.setHorizontalAlignment(JLabel.CENTER);
	     setLayout(new GridLayout(6,1));
	     add(logo);
	     add(label);
	     add(s);
	     add(Bgame);
	     add(Bscore);
	     add(Bexit);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (Bgame== e.getSource()) {
			setVisible(false);
			new Level();
		}
		if (Bexit== e.getSource()) {
			System.exit(0);
		}	
		if (Bscore== e.getSource()) {
			new ScoreList();
		}		
	}
}	
