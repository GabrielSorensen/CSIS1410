import java.awt.image.BufferedImage;


public class Projectile extends MovingTowerDefenceObject {

	private int damage;
	private double velocity;


	//Just for simplicity, we are going to have velocity be added to the x and y speeds of the parent class.
	public Projectile(double x, double y, BufferedImage image) {
		this(x, y, image, image.getWidth(), image.getHeight());
	}

	public Projectile(double x, double y, BufferedImage image, int imageWidth, int imageHeight) {
		this(x, y, image, imageWidth, imageHeight, 0, 0);
	}

	public Projectile(double x, double y, BufferedImage image, int imageWidth, int imageHeight, double Xspeed, double Yspeed) {
		this(x, y, image, imageWidth, imageHeight, 0, 1, Xspeed, Yspeed);
	}
	public Projectile(double x, double y, BufferedImage image, int imageWidth, int imageHeight,  int damage, double velocity, double Xspeed, double Yspeed){
		super(x, y, image, imageWidth, imageHeight, Xspeed, Yspeed);
		setVelocity(velocity);
		setDamage(damage);
	}
	public Projectile(Projectile p){
		super(p.getX(), p.getY(), p.getImage(), p.getImageWidth(), p.getImageHeight(), p.getDx()+p.velocity, p.getDy()+p.velocity);
		setVelocity(p.velocity);
		setDamage(p.damage);
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		if (damage>=0) {
			this.damage = damage;
		}
	}
	public double getVelocity() {
		return velocity;
	}
	public void setVelocity(double velocity) {
		if (velocity>0) {
			this.velocity = velocity;
		}
	}
	public void fireAtEnemy(Enemy e){
		double atX = 0;
		double atY = 0;
		boolean inverse = false;
		atY = e.getY()+40-this.getY();
		atX = e.getX()+40-this.getX();
		if (atY <= 0) {
			atY = atY*-1;
			atX = atX*-1;
			inverse = true;
		}
		while (atX > this.velocity || atY > this.velocity) {
			atX = atX/2;
			atY = atY/2;
		}
		if (inverse) {
			atY = atY*-1;
			atX = atX*-1;
		}
		this.setDx(atX);
		this.setDy(atY);
	}
}
