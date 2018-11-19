package Memory_Game;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


@SuppressWarnings("serial")
public 
	class Level extends JFrame implements ActionListener {
	private ImageIcon pabra= new ImageIcon("abra.png");
	private ImageIcon pkadabra= new ImageIcon("kadabra.png");
	private ImageIcon palakazam= new ImageIcon("alakazam.png");
	private JLabel labra, lkadabra, lalakazam;
	private ButtonGroup bg = new ButtonGroup();
	private JRadioButton abra = new JRadioButton("Abra 4x4");
	private JRadioButton kadabra = new JRadioButton("Kadabra 5x4");
	private JRadioButton alakazam = new JRadioButton("Alakazam 6x6");
	private JButton start = new JButton("Start");
	private JButton back = new JButton("Powrót do Menu");
	public static int rows;
	public static int columns;
	public Level(){
		elements();
		setTitle("Poziom Trudności");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void elements() {
		labra=new JLabel();
		labra.setIcon(pabra);
		lkadabra=new JLabel();
		lkadabra.setIcon(pkadabra);
		lalakazam=new JLabel();
		lalakazam.setIcon(palakazam);
		
		bg.add(abra);
		bg.add(kadabra);
		bg.add(alakazam);
	
		start.addActionListener(this);
		back.addActionListener(this);
		abra.addChangeListener(
				(e) -> {
					rows=4;
					columns=4;	
				}
			);
		kadabra.addChangeListener(
				(e) -> {
					rows=5;
					columns=4;	
				}
			);
		alakazam.addChangeListener(
				(e) -> {
					rows=6;
					columns=6;	
				}
			);
		
		setLayout(new GridLayout(4,2));
		add(abra);
		abra.setSelected(true);
		abra.setHorizontalAlignment(JLabel.CENTER);
		abra.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		labra.setHorizontalAlignment(JLabel.CENTER);
		add(labra);
		
		add(kadabra);
		kadabra.setHorizontalAlignment(JLabel.CENTER);
		kadabra.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lkadabra.setHorizontalAlignment(JLabel.CENTER);
		add(lkadabra);
		
		add(alakazam);
		alakazam.setHorizontalAlignment(JLabel.CENTER);
		alakazam.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		add(lalakazam);
		lalakazam.setHorizontalAlignment(JLabel.CENTER);
		
		add(back);
		back.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		add(start);
		start.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
	}


	public void actionPerformed(ActionEvent e) {
		if (start ==e.getSource()) {
			setVisible(false);
			new Game();	
		}
		if (back==e.getSource()) {
			setVisible(false);
			new MainMenu();		
		}
	}
}

