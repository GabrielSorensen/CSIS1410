import java.awt.*;

public class Square extends MyShape
{
    private int size;

    /**
     * Create a new square at default position with default color.
     */
    public Square()
    {
    	super();
    	size = 30;
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newSize)
    {
		size = newSize;
    }

	/**
	 * Draw the square with current specifications on screen.
	 */
	public void draw(Graphics2D g)
	{
		if(isVisible) {
			g.setColor(color);
			g.fill(new Rectangle(xPosition, yPosition, size, size));
		}
	}
}
