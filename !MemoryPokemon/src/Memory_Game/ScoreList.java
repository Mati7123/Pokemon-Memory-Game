package Memory_Game;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.*;


@SuppressWarnings("serial")
public class ScoreList extends JFrame{
	private JTextArea scorelist;
	private static File file = new File("list.txt");
	private Scanner skaner;
	public ScoreList(){
		try {
			sort();
			showScore();
		} 
		catch (IOException e) { 
			e.printStackTrace();
		}
		
		setTitle("LISTA WYNIKÓW");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(500,600);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void showScore() throws IOException {
		scorelist = new JTextArea();
		scorelist.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(scorelist);
		skaner = new Scanner(file);
		while (skaner.hasNext())
			scorelist.append(skaner.nextLine()+ "\n");
		add(scrollPane);
	}
	
	public static void addScore() throws IOException{
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
        	PrintWriter save = new PrintWriter(out);
        	SimpleDateFormat formatter = new SimpleDateFormat("KK:mm:ss");
        	String time=formatter.format(Game.data1);
        	String tekst ="Punkty: "+Integer.toString(Winner.score) +" Czas :"+time+ " Ruchy: " + Game.move+ " Rozmiar: "+Level.rows+"x"+Level.columns+ " Nick: "+ Nick.nick+ "\n" ;
        	save.write(tekst);
        	save.close();
	}
	
	public void sort() throws IOException {
		ArrayList<String> rows = new ArrayList<String>();
	    BufferedReader reader = new BufferedReader(new FileReader(file));
	    String s;
	    while((s = reader.readLine())!=null)
	        rows.add(s);
	    Collections.sort(rows);
	    Collections.reverse(rows);
	    reader.close();
	    FileWriter writer = new FileWriter(file);
	    for(String line: rows) {
	        writer.write(line+"\n");
	    } 
	    writer.close();
	}
}



