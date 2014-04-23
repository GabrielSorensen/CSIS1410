package snippet;
import Tower;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MapWithTowers extends JFrame {

	@Override
	public void paint(Graphics g){
		super.paint(g);
		try{

			//Feel free to use a different image, but I just stuck this here for kicks
			BufferedImage towerImage = ImageIO.read(new File("barker_nathan.jpg"));

			//Use this to test your first constructor that does NOT give an image width or height;
			//Assumes that x and y are first and at 100
			Tower t1 = new Tower(100, 100, towerImage);
			t1.drawTheImage(g);
			
			//Use this to test your second constructor that does give an image width and height
			Tower t2 = new Tower(300, 300, towerImage, 64, 64);
			t2.drawTheImage(g);
			
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public static void main (String [] args){
		MapWithTowers m = new MapWithTowers();
		m.setSize(600, 600);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
	}
}

