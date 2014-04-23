import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class TowerDefenceObject {

	public static final BufferedImage PATH = getImage("path");
	public static final int PATHOBJECT = 1;
	public static final BufferedImage GRASS = getImage("grass");
	public static final int GRASSOBJECT = 2;
	public static final BufferedImage TOWER_1 = getImage("tower1");
	public static final int TOWER1OBJECT = 3;
	public static final BufferedImage TOWER_2 = getImage("tower2");
	public static final int TOWER2OBJECT = 4;
	public static final BufferedImage TOWER_3 = getImage("tower3");
	public static final int TOWER3OBJECT = 5;
	public static final BufferedImage TOWER_4 = getImage("tower4");
	public static final int TOWER4OBJECT = 6;
	public static final BufferedImage BUG_1 = getImage("bug1");
	public static final int BUG1OBJECT = 7;
	public static final BufferedImage BUG_2 = getImage("bug2");
	public static final int BUG2OBJECT = 8;
	public static final BufferedImage BUG_3 = getImage("bug3");
	public static final int BUG3OBJECT = 9;
	public static final BufferedImage BUG_4 = getImage("bug4");
	public static final int BUG4OBJECT = 10;
	public static final BufferedImage BUG_5 = getImage("bug5");
	public static final int BUG5OBJECT = 11;
	public static final BufferedImage BUG_6 = getImage("bug6");
	public static final int BUG6OBJECT = 12;
	public static final BufferedImage BULLET_1 = getImage("bullet1");
	public static final int BULLET1OBJECT = 13;
	public static final BufferedImage BULLET_2 = getImage("bullet2");
	public static final int BULLET2OBJECT = 14;
	public static final BufferedImage [] BUG1_ANIM = getImageArray(new String[] {"bug1", "bug2"});
	public static final BufferedImage [] BUG2_ANIM = getImageArray(new String[] {"bug3", "bug4"});
	public static final BufferedImage [] BUG3_ANIM = getImageArray(new String[] {"bug5", "bug6"});

	private double x;
	private double y;
	private BufferedImage image;
	private BufferedImage [] images;
	private int imageWidth;
	private int imageHeight;
	private final Rectangle hitbox = new Rectangle();
	private int currentFrame = 0;

	public TowerDefenceObject(double x, double y, BufferedImage image) {
		this(x,y,image,image.getWidth(),image.getHeight());
	}
	public TowerDefenceObject(double x, double y, BufferedImage image, int imageWidth, int imageHeight) {
		setX(x);
		setY(y);
		setImage(image);
		setImageWidth(imageWidth);
		setImageHeight(imageHeight);
		getDelta();
		resetDelta();
	}
	public TowerDefenceObject(double x, double y, BufferedImage [] images, int imageWidth, int imageHeight) {
		setX(x);
		setY(y);
		setImages(images);
		setImageWidth(imageWidth);
		setImageHeight(imageHeight);
		getDelta();
		resetDelta();
	}
	public static BufferedImage getImage(String name) {
		BufferedImage result = null;
		try {
			result = ImageIO.read(new File(name+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static BufferedImage [] getImageArray(String [] name) {
		BufferedImage [] result = new BufferedImage[name.length];
		try {
			for (int i=0; i<result.length; i++) {
				result[i] = ImageIO.read(new File(name[i]+".png"));
			}
			//			result = ImageIO.read(new File(name+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public BufferedImage [] getImages() {
		return images;
	}
	public void setImages(BufferedImage [] images) {
		this.images = images;
	}
	public int getImageWidth() {
		return imageWidth;
	}
	public void setImageWidth(int imageWidth) {
		if (imageWidth>=0) {
			this.imageWidth = imageWidth;
		}
	}
	public int getImageHeight() {
		return imageHeight;
	}
	public void setImageHeight(int imageHeight) {
		if (imageHeight>=0) {
			this.imageHeight = imageHeight;
		}
	}
	private long lastFrame;

	private long getTime() {
		return System.nanoTime() / 100000;
	}
	private int getDelta() {
		long currentTime = getTime();	
		int delta = (int) (currentTime - lastFrame);
		return delta;
	}
	private void resetDelta() {
		lastFrame = getTime();
	}
	public void drawTheImage(Graphics g) {
//		System.out.println(getDelta());
		if (this.image!=null&&g!=null) {
			g.drawImage(this.image, (int)this.x, (int)this.y, (int)this.imageWidth, (int)this.imageHeight, null);
			resetDelta();
		} else {
			try {
				g.drawImage(this.images[currentFrame], (int)this.x, (int)this.y, (int)this.imageWidth, (int)this.imageHeight, null);
				if (getDelta() >= 1000) {  //larger==slower 1000 approx 1 sec?
					if (currentFrame >= images.length-1) {
						currentFrame = 0;
						resetDelta();
					} else {
						currentFrame++;
						resetDelta();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public boolean intersects(TowerDefenceObject other) {
		hitbox.setBounds((int) x, (int) y, (int) imageWidth, (int) imageHeight);
		return hitbox.intersects(other.getX(), other.getY(), other.getImageWidth(), other.getImageHeight());
	}
	public double getIntersectsAt(TowerDefenceObject other, TowerDefenceObject primary) {
		double AT=0;
		if (primary.intersects(other)) {
			AT= other.getY() - primary.getY();
			return AT;
		}
		return AT;
	}
}
