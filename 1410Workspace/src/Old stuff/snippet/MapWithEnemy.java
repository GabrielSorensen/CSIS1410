package snippet;
import Enemy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MapWithEnemy extends JFrame {
	BufferedImage enemyImage2;
	final Enemy e2;
	
	public MapWithEnemy(){
		try {
			enemyImage2  = ImageIO.read(new File("bug3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		e2  = new Enemy(50, 50, enemyImage2, 64, 64, 5, 5, 2);
	}

	@Override
	public void paint(Graphics g){
		super.paint(g);
		
		

			//Use this to test your first constructor
//			BufferedImage enemyImage1 = ImageIO.read(new File("bug1.png"));
//			Enemy e1 = new Enemy(50, 50, enemyImage1, 1);
//			e1.drawTheImage(g);
//			System.out.println(e1.getHp());
			
			//Use this to test your second constructor
			
			e2.drawTheImage(g);
			
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
	
		
	}
	
	
	
	
	public static void main (String [] args){
		MapWithEnemy m = new MapWithEnemy();
		m.setSize(600, 600);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
	}
}

