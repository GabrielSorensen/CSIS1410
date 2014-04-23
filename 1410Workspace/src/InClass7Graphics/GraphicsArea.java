import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

@SuppressWarnings("unused")
public class GraphicsArea
{

    private JFrame frame;
    private MyCanvas canvas;
    private Color backgroundColor;
    @SuppressWarnings("rawtypes")
	private Vector theShapes;

    /**
     * Create a Canvas.
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     * @param bgClour  the desired background colour of the canvas
     */
    @SuppressWarnings("rawtypes")
	public GraphicsArea(String title, int width, int height, Color bgColour)
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas = new MyCanvas();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColour;
        frame.pack();
        theShapes = new Vector();

        frame.setVisible(true);
    }


    /**
     * Draw a given shape onto the canvas.
     * @param  MyShape an object to define identity for this shape
     */
    @SuppressWarnings("unchecked")
	public void addMyShape(MyShape p)
    {
    	theShapes.remove(p);   // just in case it was already there
    	theShapes.add(p);      // add at the end
    	canvas.repaint();
    }
    
    /**
     * Erase a given shape's from the screen.
     * @param  referenceObject  the shape object to be erased 
     */
    public void erase(MyShape p)
    {
        theShapes.remove(p);   // just in case it was already there
    	canvas.repaint();
    }

    public void redraw(){
    	canvas.repaint();
    }
    
    /**
     * Set the background color of the Canvas.
     * @param  colorString   the new color for the foreground of the Canvas 
     */
    public void setBackgroundColor(String colorString)
    {
		if(colorString.equals("red"))
			backgroundColor = Color.red;
		else if(colorString.equals("black"))
			backgroundColor = Color.black;
		else if(colorString.equals("blue"))
			backgroundColor = Color.blue;
		else if(colorString.equals("yellow"))
			backgroundColor = Color.yellow;
		else if(colorString.equals("green"))
			backgroundColor = Color.green;
		else if(colorString.equals("magenta"))
			backgroundColor = Color.magenta;
		else if(colorString.equals("white"))
			backgroundColor = Color.white;
		else
			backgroundColor = Color.black;
    }


    @SuppressWarnings("serial")
	private class MyCanvas extends JPanel{
    	public void paint(Graphics g){
            erase((Graphics2D) g);
    		for (int i = 0; i < theShapes.size(); i++) {
                ((MyShape) theShapes.get(i)).draw((Graphics2D)g);
    		}
    		try{
    			Thread.sleep(100);
    		}
    		catch(InterruptedException e){
    			
    		}
    		repaint();
    	}
        private void erase(Graphics2D g)
        {
            g.setColor(backgroundColor);
            Dimension size = canvas.getSize();
            g.fill(new Rectangle(0, 0, size.width, size.height));
        }
    }
}
