import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class BasicObject extends MapObject {

	public BasicObject(int x, int y, boolean isSolid) {
		super(x, y, isSolid);
	}
	public BasicObject(int x, int y, boolean isSolid, BufferedImage img) {
		super(x, y, isSolid, img);
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(super.getCurrentImage(), super.getX(), super.getY(), null);
	}

}
