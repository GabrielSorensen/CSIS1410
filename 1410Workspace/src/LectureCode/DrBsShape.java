import java.awt.*;

import javax.swing.JFrame;

/**
 * 
 * @author
 *
 */
public abstract class DrBsShape
{
	public int xPosition;
	public int yPosition;
	public Color color;
	private int delta;
	
    /**
     * Create a new object at default position with default color.
     */
    public DrBsShape()
    {
		xPosition = 0;
		yPosition = 0;
		color = Color.blue;
		delta = 1;
    }

    /**
     * 
     * Here is the abstract method.
     * As MyShape can be a triangle, square, line or circle,
     * there is really no way to write code for that here.
     */
    public abstract void draw(Graphics2D g);

    
	
    /**
     * Move the shape a few pixels to the right.
     */
    public void moveRight()
    {
		moveHorizontal(delta);
    }

    /**
     * Move the circle a few pixels to the left.
     */
    public void moveLeft()
    {
		moveHorizontal(-delta);
    }

    /**
     * Move the circle a few pixels up.
     */
    public void moveUp()
    {
		moveVertical(-delta);
    }

    /**
     * Move the circle a few pixels down.
     */
    public void moveDown()
    {
		moveVertical(delta);
    }

    /**
     * Move the shape horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
		xPosition += distance;
    }

    /**
     * Move the shape vertically by 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
		yPosition += distance;
    }

    /**
     * Move the shape horizontally by 'x' pixels and
     * vertically by 'y' pixels
     * 
     */
    public void move(int x, int y){
    	moveHorizontal(x);
    	moveVertical(y);
    }
    
    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
	 * "magenta" and "black".
     */
    public void changeColor(Color newColor)
    {
		color = newColor;
    }


	public int getXPosition() {
		return xPosition;
	}

	public void setXPosition(int position) {
		xPosition = position;
	}

	public int getYPosition() {
		return yPosition;
	}

	public void setYPosition(int position) {
		yPosition = position;
	}
    
    public static void main(String [] args){
    	new MyFrame();
    }
}

@SuppressWarnings("serial")
class MyFrame extends JFrame{
	public MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setVisible(true);
		
	}
	public void paint(Graphics g){
		g.setColor(Color.black);
		/*
		//D
    	MyOval o = new MyOval(50,50,50,150);
    	o.draw((Graphics2D) g);

    	//r
    	MyLine l = new MyLine(125,125,125,200);
    	l.draw((Graphics2D) g);
    	l = new MyLine(125,125,150,125);
    	l.draw((Graphics2D) g);

    	//B
    	o = new MyOval(175,50,50,150);
    	o.draw((Graphics2D) g);
    	l = new MyLine(175,125,225,125);
    	l.draw((Graphics2D) g);
		*/
	}
}