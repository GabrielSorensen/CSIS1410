import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.*;


public class GameCharacter {

	private BufferedImage up;
	private BufferedImage down;
	private BufferedImage left;
	private BufferedImage right;
	private int moveDirection;
	private int x;
	private int y;
	private int iconSize;
	
	private Map map;
	
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	
	
	public GameCharacter(Map m){
		try{
			up = ImageIO.read(new File("Link_back.gif"));
			down = ImageIO.read(new File("Link_front.gif"));
			left = ImageIO.read(new File("Link_left.gif"));
			right = ImageIO.read(new File("Link_right.gif"));
		}
		catch(Exception e){
			System.err.println("Unable to read the file");
		}
		
		moveDirection = DOWN;
		iconSize = 32;
		map = m;
		x = 0;
		y = 3;
	}
	
	public void afterMove(){
		map.repaint();
	}
	
	public void checkMapForMove(int x, int y){
		if (map.isLegalMove(x, y)){
			
		}
		else{
			System.err.println("Illegal Move at " + x + " " + y);
		}
	}
	
	public void moveRight(){
		checkMapForMove(x+1, y);
		x += 1;
		moveDirection = RIGHT;
		afterMove();
	}
	
	public void moveLeft(){
		checkMapForMove(x-1, y);
		x -= 1;
		moveDirection = LEFT;
		afterMove();
	}
	
	public void moveDown(){
		checkMapForMove(x, y+1);
		y += 1;
		moveDirection = GameCharacter.DOWN;
		afterMove();
	}
	
	public void moveUp(){
		checkMapForMove(x, y-1);
		y -= 1;
		moveDirection = UP;
		afterMove();
	}
	
	public void draw(Graphics2D g){
		int drawX = x * iconSize;
		int drawY = y * iconSize+iconSize;
		if(moveDirection == UP){
			g.drawImage(up,drawX,drawY,null);
		}
		else if (moveDirection == DOWN){
			g.drawImage(down,drawX,drawY,null);
		}
		else if (moveDirection == LEFT){
			g.drawImage(left,drawX,drawY,null);
		}
		else if (moveDirection == RIGHT){
			g.drawImage(right,drawX,drawY,null);
		}

	}

	public int getX() {
		return x;
	}

//	public void setX(int x) {
//		this.x = x;
//	}

	public int getY() {
		return y;
	}

//	public void setY(int y) {
//		this.y = y;
//	}
	
	

}
