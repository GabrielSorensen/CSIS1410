import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;



@SuppressWarnings("serial")
public class BallFrame extends JFrame{

	Graphics2D g;
	
	public BallFrame(){
		this.setSize(600,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyMouse m = new MyMouse();
		this.addMouseListener(m);

		this.setVisible(true);
		g = (Graphics2D) this.getGraphics();
		this.repaint();
	}
	public void paint(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(0, 0, 600, 300);
	}

	public static void main(String args[]){
		new BallFrame();
	}

	@SuppressWarnings("unused")
	public class MyMouse implements MouseListener{


		public void mouseClicked(MouseEvent m) {
			int userClickedX = m.getX()-25;
			int userClickedY = m.getY()+25;
			
			BouncingBall b = new BouncingBall(g, userClickedX, userClickedY);
			//Make a Thread using BouncingBall b
//			for (int i=0; i<101; i++) {
				Thread giantman = new Thread(b);
				giantman.start();
//			}
//			Thread giantman = new Thread(b);
			//Tell the Thread to start
//			giantman.start();

		}

		public void mouseEntered(MouseEvent m) {

		}

		public void mouseExited(MouseEvent m) {

		}

		public void mousePressed(MouseEvent m) {

		}

		public void mouseReleased(MouseEvent m) {

		}

	}
}
