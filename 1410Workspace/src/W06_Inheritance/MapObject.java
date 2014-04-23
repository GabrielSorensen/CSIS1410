import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public abstract class MapObject {

	private int x;
	private int y;
	private boolean isSolid;
	private BufferedImage img;
	
	public MapObject(){
		this(0,0);
	}
	public MapObject(int x, int y) {
		this(x, y, false);
	}
	public MapObject(int x, int y, boolean isSolid) {
		this(x, y, isSolid, null);
	}
	public MapObject(int x, int y, boolean isSolid, BufferedImage img) {
		setX(x);
		setY(y);
		setSolidState(isSolid);
		setCurrentImage(img);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean getSolidState() {
		return isSolid;
	}
	public void setSolidState(boolean isSolid) {
		this.isSolid = isSolid;
	}
	public BufferedImage getCurrentImage() {
		return img;
	}
	public void setCurrentImage(BufferedImage img) {
		this.img = img;
	}
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public abstract void draw(Graphics2D g);
}
