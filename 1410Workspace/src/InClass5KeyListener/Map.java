import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.*;
import javax.swing.*;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

@SuppressWarnings("serial")
public class Map extends JFrame{

	private BufferedImage overworld;

	private GameCharacter character;
	@SuppressWarnings("rawtypes")
	private Vector illegalPoints;
	//For double buffering
	private Image offscreen;
	private Graphics bufferedImage;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map(){
		super("Zelda");
		GG g = new GG();
		addKeyListener(g);
		this.setSize(500,350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try{
			overworld = ImageIO.read(new File("overworld.gif"));
		}
		catch(IOException e){
			System.err.println("Unable to read the map");
		}

		this.setVisible(true);
		//Setup an area for double buffering

		offscreen = this.createImage(this.getWidth(),this.getHeight());
		bufferedImage = offscreen.getGraphics();

		illegalPoints = new Vector();
		//Add the top, and bottom
		for (int i = 0; i < 16; i++	){
			if (i != 7){
				illegalPoints.add(new Point(i,0));
			}
			illegalPoints.add(new Point(i,8));			
		}
		//add the middle points
		illegalPoints.add(new Point(14,7));
		illegalPoints.add(new Point(11,7));
		illegalPoints.add(new Point(10,7));
		illegalPoints.add(new Point(9,7));
		illegalPoints.add(new Point(8,7));
		illegalPoints.add(new Point(9,6));
		illegalPoints.add(new Point(10,6));
		illegalPoints.add(new Point(1,7));
		illegalPoints.add(new Point(1,1));
		illegalPoints.add(new Point(14,1));
		illegalPoints.add(new Point(8,1));
		illegalPoints.add(new Point(9,1));
		illegalPoints.add(new Point(10,1));
		illegalPoints.add(new Point(11,1));
		illegalPoints.add(new Point(9,2));
		illegalPoints.add(new Point(10,2));
		illegalPoints.add(new Point(4,3));
		illegalPoints.add(new Point(4,5));
		illegalPoints.add(new Point(12,5));
		illegalPoints.add(new Point(12,3));
		illegalPoints.add(new Point(0,7));
		illegalPoints.add(new Point(0,6));
		illegalPoints.add(new Point(0,1));
		illegalPoints.add(new Point(0,2));
		
	}
	public boolean isLegalMove(int x, int y){
		if (x < 0 || x >  14 || y < 0 || y > 14 ){
			return false;
		}
		else if (illegalPoints.contains(new Point(x,y))){
			return false;
		}
		return true;
	}

	public void setCharacter(GameCharacter c){
		character = c;
		this.repaint();
	}

	public void paint(Graphics g){
		//super.paint(g);
		if(bufferedImage != null){
			//Draw everything on the bufferedImage
			bufferedImage.drawImage(overworld,0,0,null);
			if (character != null){
				character.draw((Graphics2D) bufferedImage);
			}
			//Now draw the offscreen, as it contains bufferedImage
			g.drawImage(offscreen,0,0,this);
		}
	}

	public static void main(String[] args){
		Map m = new Map();
		GameCharacter c = new GameCharacter(m);
		m.setCharacter(c);
	}
	private class GG implements KeyListener {
		@Override
		public void keyPressed(KeyEvent g) {
			if (g.getExtendedKeyCode()==KeyEvent.VK_UP) {
				if (isLegalMove(character.getX(), character.getY()-1)) {
					character.moveUp();
				}
			}
			if (g.getExtendedKeyCode()==KeyEvent.VK_DOWN) {
				if (isLegalMove(character.getX(), character.getY()+1)) {
					character.moveDown();
				}
			}
			if (g.getExtendedKeyCode()==KeyEvent.VK_LEFT) {
				if (isLegalMove(character.getX()-1, character.getY())) {
					character.moveLeft();
				}
			}
			if (g.getExtendedKeyCode()==KeyEvent.VK_RIGHT) {
				if (isLegalMove(character.getX()+1, character.getY())) {
					character.moveRight();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent g) {
		}

		@Override
		public void keyTyped(KeyEvent g) {
		}
		
	}
}
