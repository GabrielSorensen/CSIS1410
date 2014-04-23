import java.awt.*;
import java.awt.geom.*;

/**
 * 
 * @author
 *
 */
@SuppressWarnings("unused")
public abstract class MyShape
{
	public int xPosition;
	public int yPosition;
	public Color color;
	public boolean isVisible;
	private int delta;
	
    /**
     * Create a new circle at default position with default color.
     */
    public MyShape()
    {
		xPosition = 0;
		yPosition = 0;
		color = Color.blue;
		isVisible = false;
		delta = 1;
    }

	/**
	 * Make this shape visible. If it was already visible, do nothing.
	 */
	public void makeVisible()
	{
		isVisible = true;
	}
	
	/**
	 * Make this shape invisible. If it was already invisible, do nothing.
	 */
	public void makeInvisible()
	{
		isVisible = false;
	}
	
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

    public abstract void draw(Graphics2D g);
    
}
