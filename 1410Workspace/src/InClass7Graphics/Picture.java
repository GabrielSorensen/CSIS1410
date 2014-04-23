import java.awt.Color;

/**
 * 
 * @author
 *
 */
public class Picture
{
	private	Circle sun;
	private GraphicsArea theCanvas;
	private House theHouse;
	
	public Picture()
	{
		theCanvas = new GraphicsArea("My Canvas", 300, 300, Color.WHITE);

		theHouse = new House(140,60);
		theCanvas.addMyShape(theHouse);

		sun = new Circle();
		sun.changeColor(Color.YELLOW);
		sun.moveHorizontal(200);
		sun.moveVertical(50);
		sun.changeSize(60);
		sun.makeVisible();
		theCanvas.addMyShape(sun);

		theCanvas.redraw();
	}

	public static void main(String[] args) {
		new Picture();
	}

}
