package Memory_Game;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;


@SuppressWarnings("serial")
public class Nick extends JFrame implements ActionListener{
	private JButton BOK, Bcancel; 
	private JLabel Nick;
	private JTextField Text;
	public static String nick;

	
	public Nick() {
		
		elements();
		setTitle("Zapis do Listy Wyników");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,150);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);	
	}
	
	public void elements () {
		 BOK = new JButton ("OK");
	     BOK.addActionListener(this);
	     BOK.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	     Bcancel = new JButton ("Anuluj");
	     Bcancel.addActionListener(this);
	     Bcancel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	     Nick=new JLabel("Podaj Swój Nick");
	     Nick.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	     Nick.setHorizontalAlignment(JLabel.CENTER);
	     Text = new JTextField();
	     Text.setSize(50,50);
	     
	     setLayout(new GridLayout(3,1));
	     add(Nick);
	     add(Text);
	     JPanel buttons= new JPanel();
	     buttons.setLayout(new GridLayout(1,2));
	     buttons.add(BOK);
	     buttons.add(Bcancel);
	     add(buttons);     
	}
	
	public void loadNick() {
		nick = Text.getText();	
	}
	
	public void actionPerformed(ActionEvent e) {
		if (BOK== e.getSource()) {
			setVisible(false);
			loadNick();
			try {
				ScoreList.addScore();
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}	
		}
		if (Bcancel== e.getSource()) {
			setVisible(false);
		}		
	}
}	