


/**
 * The class files are below.  Do not to modify this file
 * 
 */
































































import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Map extends JFrame{

	private BufferedImage overworld;
	@SuppressWarnings("rawtypes")
	private Vector characters;

	@SuppressWarnings("rawtypes")
	public Map(){
		super("Zelda");
		this.setSize(500,350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try{
			overworld = ImageIO.read(new File("overworld.gif"));
		}
		catch(IOException e){
			System.err.println("Unable to read the map");
		}

		this.setVisible(true);

		characters = new Vector();
		//Add the top, and bottom

	}

	@SuppressWarnings("unchecked")
	public void addCharacter(GameCharacter c){
		characters.add(c);
		this.repaint();
	}

	public void paint(Graphics g){
		//super.paint(g);
		g.drawImage(overworld,0,0,null);
		for (int i = 0; i < characters.size(); i++){
			((GameCharacter)characters.get(i)).draw((Graphics2D) g);
		}
		try {
			Thread.sleep(500);
		}
		catch (InterruptedException e) {
		
		}
		repaint();
	}

	public static void main(String[] args){
		Map m = new Map();
		m.addCharacter(new GameCharacter());
		m.addCharacter(new GameCharacter());
		m.addCharacter(new GameCharacter());
		m.addCharacter(new GameCharacter());
	}

}
