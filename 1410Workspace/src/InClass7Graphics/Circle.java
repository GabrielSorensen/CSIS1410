import java.awt.*;
import java.awt.geom.*;

/**
 * 
 * @author
 *
 */
public class Circle extends MyShape
{
    private int diameter;
    private int animationFrame;
	
    /**
     * Create a new circle at default position with default color.
     */
    public Circle()
    {
    	super();
		diameter = 30;
		animationFrame = 0;
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newDiameter)
    {
		diameter = newDiameter;
    }
    
    public int getAnimationFrame(){
    	return this.animationFrame;
    }

    private void animateLeftUpDown(Graphics2D g){
		g.fill(new Ellipse2D.Double(xPosition, yPosition, diameter, diameter));
		//This code gives a example of 1 way to do animations
		/*  
		if (animationFrame < 100){
			moveVertical(-1);
			moveLeft();
			changeSize(animationFrame/5 + 60);
		}
		else if(animationFrame < 200){
			move(-1, 1);
			changeSize((200 - animationFrame)/5 + 60);
		}
		else{
			//Stop
		}
		*/
    }
    
	public void draw(Graphics2D g)
	{
		//How would you differentiate movement between 2 different circles?
		if(isVisible) {
			g.setColor(color);
			
			animationFrame++;
			this.animateLeftUpDown(g);
		}
	}

}
