


/**
 * The class files are below.  Do not to modify this file
 * 
 */
































































import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.*;


public class GameCharacter {

	private BufferedImage up;
	private BufferedImage down;
	private BufferedImage left;
	private BufferedImage right;
	private BufferedImage lastImage;
	private int moveDirection;
	private int x;
	private int y;
	private int iconSize;
	private Move myMove;
	
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	public static final int STAY = 4;	
	
	public GameCharacter(){
		try{
			up = ImageIO.read(new File("Link_back.gif"));
			down = ImageIO.read(new File("Link_front.gif"));
			left = ImageIO.read(new File("Link_left.gif"));
			right = ImageIO.read(new File("Link_right.gif"));
			lastImage = down;
		}
		catch(Exception e){
			System.err.println("Unable to read the file");
			System.exit(0);
		}
		myMove = new Move();
		moveDirection = STAY;
		iconSize = 32;
		x = 1;
		y = 3;
	}
	
	public void draw(Graphics2D g){
		if(moveDirection == UP){
			y -= 1;
			g.drawImage(up,x * iconSize,y * iconSize+iconSize,null);
			lastImage = up;
		}
		else if (moveDirection == DOWN){
			y += 1;
			g.drawImage(down,x * iconSize,y * iconSize+iconSize,null);
			lastImage = down;
		}
		else if (moveDirection == LEFT){
			x -= 1;
			g.drawImage(left,x * iconSize,y * iconSize+iconSize,null);
			lastImage = left;
		}
		else if (moveDirection == RIGHT){
			x += 1;
			g.drawImage(right,x * iconSize,y * iconSize+iconSize,null);
			lastImage = right;
		}
		else if (moveDirection == STAY){
			g.drawImage(lastImage,x * iconSize,y * iconSize+iconSize,null);
		}
		moveDirection = myMove.getNextMove();
	}

}
