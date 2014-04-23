import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class MovingTowerDefenceObject extends TowerDefenceObject {

	private double dx;
	private double dy;

	public MovingTowerDefenceObject(double x, double y, BufferedImage image) {
		this(x, y, image, image.getWidth(), image.getHeight());
	}
	//Creates a moving object that has no initial speed in any direction. Most likely you will want this one.
	public MovingTowerDefenceObject(double x, double y, BufferedImage image, int imageWidth, int imageHeight) {
		this(x, y, image, imageWidth, imageHeight, 0, 0);
	}
	public MovingTowerDefenceObject(double x, double y, BufferedImage image, int imageWidth, int imageHeight, double Xspeed, double Yspeed) {
		super(x, y, image, imageWidth, imageHeight);
		setDx(Xspeed);
		setDy(Yspeed);
	}
	public MovingTowerDefenceObject(double x, double y, BufferedImage [] images, int imageWidth, int imageHeight, double Xspeed, double Yspeed) {
		super(x, y, images, imageWidth, imageHeight);
		setDx(Xspeed);
		setDy(Yspeed);
	}
	public double getDx() {
		return dx;
	}
	public void setDx(double dx) {
		this.dx = dx;
	}
	public double getDy() {
		return dy;
	}
	public void setDy(double dy) {
		this.dy = dy;
	}
	public void update() {
		this.setX(this.getX()+(int)Math.floor(this.dx));
		this.setY(this.getY()+(int)Math.floor(this.dy));
	}
	public void drawTheImage(Graphics g) {
		super.drawTheImage(g);
		//		System.out.println("x: "+getX()+" \t y: "+getY());
		update();
	}

}
