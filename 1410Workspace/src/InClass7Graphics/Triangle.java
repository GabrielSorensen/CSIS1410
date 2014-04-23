import java.awt.*;

/**
 * A triangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author	Michael Kolling and David J. Barnes
 * @version 1.0  (15 July 2000)
 */

public class Triangle extends MyShape
{
    private int height;
    private int width;

    /**
     * Create a new triangle at default position with default color.
     */
    public Triangle()
    {
    	super();
    	height = 30;
		width = 40;
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newHeight, int newWidth)
    {
		height = newHeight;
		width = newWidth;
    }

	/**
	 * Draw the triangle with current specifications on screen.
	 */
	public void draw(Graphics2D g)
	{
		if(isVisible) {
			g.setColor(color);
			int[] xpoints = { xPosition, xPosition + (width/2), xPosition - (width/2) };
			int[] ypoints = { yPosition, yPosition + height, yPosition + height };
			g.fill(new Polygon(xpoints, ypoints, 3));
		}
	}
}
