import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

/**
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class MousePanel extends JPanel{

	private int x = 10;
	private int y = 10;
	private Color c = Color.red;

	
	public MousePanel(){
		super();
		GHK g = new GHK();
		addMouseMotionListener(g);
		addMouseListener(g);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		
		//Erase the old image
		g.setColor(Color.gray);
		g.fillRect(0, 0, 500, 500);
		
		g.setColor(c);
		g.fillOval(x, y, 50, 50);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Mouse Panel Example");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MousePanel p = new MousePanel();
		f.add(p);
		
		
		f.setSize(400,400);
		f.setVisible(true);
	}
	public class GHK implements MouseMotionListener, MouseInputListener{

		@Override
		public void mouseDragged(MouseEvent e) {
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			x = e.getX()-25;
			y = e.getY()-25;
			
			repaint();
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			c = new Color(2);
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
	}
}
