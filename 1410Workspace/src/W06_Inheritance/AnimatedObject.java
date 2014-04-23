import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class AnimatedObject extends BasicObject {
	
	private BufferedImage [] imgs;
	private BufferedImage currentImg;
	private int frame = 0;
	
	public AnimatedObject(int x, int y, boolean isSolid) {
		super(x, y, isSolid);
	}
	public AnimatedObject(int x, int y, boolean isSolid, BufferedImage [] imgs) {
		super(x, y, isSolid);
		this.imgs = imgs;
		super.setCurrentImage(getCurrentImage());
		this.currentImg = this.imgs[0];
	}
	public int getFrame() {
		return frame;
	}
	public BufferedImage getCurrentImage() {
		return this.currentImg;
	}
	public void setCurrentImage(BufferedImage img) {
		this.currentImg = img;
	}
	public BufferedImage getAnims(){
		try {
		BufferedImage i = getCurrentImage();
		if (this.frame>=this.imgs.length - 1) {
			this.frame = 0;
		} else {
			this.frame++;
		}
		setCurrentImage(this.imgs[this.frame]);
		Thread.sleep(20);
		return i;
		} catch (Exception e) {
			System.err.println("Something happened trying to advance frames, most likely with the thread sleeping. See stack trace for details.");
			e.printStackTrace();
		}
		return this.currentImg;
	}
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(this.getAnims(), super.getX(), super.getY(), null);
	}

}
