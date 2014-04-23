import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Tower extends TowerDefenceObject {

	private double radius;
	private double shootingSpeed;
	private int reload;
	private Projectile bullet;


	public Tower(double x, double y, BufferedImage image) {
		this(x, y, image, image.getWidth(), image.getHeight());
	}
	public Tower(Tower t) {
		this(t.getX(), t.getY(), t.getImage(), 64, 64, t.radius, t.getTimeUntilNextShot(), t.getBullet());
	}
	public Tower(double x, double y, BufferedImage image, int imageWidth, int imageHeight) {
		this(x, y, image, imageWidth, imageHeight, 0);
	}
	public Tower(double x, double y, BufferedImage image, int imageWidth, int imageHeight, double radius) {
		this(x, y, image, imageWidth, imageHeight, radius, 1);
	}
	public Tower(double x, double y, BufferedImage image, int imageWidth, int imageHeight, double radius, double shootingSpeed) {
		this(x, y, image, imageWidth, imageHeight, 0, 0, null);
	}
	public Tower(double x, double y, BufferedImage image, int imageWidth, int imageHeight, double radius, double shootingSpeed, Projectile bullet) {
		super(x, y, image, imageWidth, imageHeight);
		if (radius>=0) {
			this.radius = radius;
		}
		if (shootingSpeed>=0) {
			this.shootingSpeed = shootingSpeed;
		}
		if (bullet!=null){
			this.bullet = bullet;
		} else {
			bullet = new Projectile(x, y, null);
		}
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		if (radius>=0) {
			this.radius = radius;
		}
	}
	public double getTimeUntilNextShot() {
		return shootingSpeed;
	}
	public void setTimeUntilNextShot(double timeUntilNextShot) {
		if (timeUntilNextShot>=0) {
			this.shootingSpeed = timeUntilNextShot; 
		}
	}
	public int getTimeUntilReload() {
		return reload;
	}
	public void setReload(int reload) {
		if (reload>=0) {
			this.reload = reload;
		}
	}
	public Projectile getBullet() {
		return bullet;
	}
	public void setBullet(Projectile bullet) {
		this.bullet = bullet;
	}
	public void drawTheImage(Graphics g) {
		if (this.getImage()!=null) {
			g.drawImage(this.getImage(), (int)this.getX(), (int)this.getY(), (int)this.getImageWidth(), (int)this.getImageHeight(), null);
			if (reload>0) {
				reload--;
			}
		}
	}
	public Projectile fireAtEnemy(Enemy e){
		if (this.reload!=0) {
			return null;
		} else {
			//			Ellipse2D range = new Ellipse2D.Double(this.getX()+this.getImageWidth(), this.getY()+this.getImageHeight(), this.radius, this.radius);
			//			if (e.intersects(range)) {
			this.reload = (int)this.shootingSpeed;
			Projectile p = new Projectile(this.getX(), this.getY(), TowerDefenceObject.BULLET_1, 20, 20, 1, 15, 0, 0);
			p.fireAtEnemy(e);
			return p;
			//			}
		}
		//		return null;
	}
}
