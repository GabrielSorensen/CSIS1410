import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class MyGraphics extends JPanel{

	public MyGraphics(){

		//setup a JFrame for the JPanel
		JFrame f = new JFrame("My Graphics Area");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,500);
		f.add(this);
		f.setVisible(true);
	}

	/**
	 * This method is overwriting the JPanel paintComponent method
	 */
	public void paintComponent(Graphics graphics){
		super.paintComponent(graphics);

		Graphics2D g = (Graphics2D) graphics;

		this.setBackground( Color.WHITE );
		g.setColor(Color.black);

		// set new drawing color using integers from 0 to 255
		Color myRed = new Color(255,0,0);
		g.setColor( myRed );
		g.fillRect( 15, 25, 100, 20 );
		g.drawString( "Current RGB: " + g.getColor(), 130, 40 );

		// set new drawing color using floats from 0 to 1
		//Do half red and 3/4 green
		Color unknown = new Color(0.5f,0.75f,0.0f);
		g.setColor( unknown );
		g.fillRect( 15, 50, 100, 20 );
		g.drawString( "Current RGB: " + g.getColor(), 130, 65 );

		// set new drawing color blue using static Color objects
		g.setColor(Color.BLUE);
		g.fillRect( 15, 75, 100, 20 );
		g.drawString( "Current RGB: " + g.getColor(), 130, 90 );



		// display individual RGB values - for information only
		Color color = Color.MAGENTA;
		g.setColor( color );
		g.fillRect( 15, 100, 100, 20 );
		g.drawString( "RGB values: " + color.getRed() + ", " +
				color.getGreen() + ", " + color.getBlue(), 130, 115 );


		paintPractice(g);
		polygonPractice(g);
		translateRotatePractice(g);

	}

	public void paintPractice(Graphics2D g){
		//Use the corner 50,200 and make it max 400 wide and 200 tall
		g.setColor(new Color(240,75,75));
		g.fillRect(50, 200, 400, 200);

	}

	@SuppressWarnings("unused")
	public void polygonPractice(Graphics2D g){
		//Create a star - the top half has been done for you
		g.setColor(Color.green);
		int x = 60;
		int y = 225;
		int lines = 5;
		int [] px = {x,x+4*lines,x+(int)(5.2*lines),x+(int)(6.5*lines),x+11*lines,x+7*lines};
		int [] py = {y,y,y-4*lines,y,y,y+(int)(2.5*lines)};
		Polygon p = new Polygon(px,py,px.length);
		//g.drawPolygon(p);


	}
	
	@SuppressWarnings("unused")
	public void translateRotatePractice(Graphics2D g){
		int xPoints[] = {55, 67, 109, 73, 83,55, 27, 37, 1, 43};
		int yPoints[] = {0, 36, 36, 54, 96, 72, 96, 54, 36, 36};
		
		Polygon p = new Polygon(xPoints, yPoints, xPoints.length);
		
		//Move the star to the middle of the flag and rotate it slightly
				
		//translate
		//g.translate(?, ?);
		
		//rotate
		//g.rotate(?);
		
		g.setColor(Color.DARK_GRAY);
		//g.fillPolygon(p);
		
	}

	public static void main(String[] args) {
		new MyGraphics();
	}

}
