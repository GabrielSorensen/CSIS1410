import java.awt.image.BufferedImage;


public class Enemy extends MovingTowerDefenceObject {

	private int hp;
	private int value;

	public Enemy(int x, int y, BufferedImage image) {
		this(x, y, image, 5);
	}
	public Enemy(int x, int y, BufferedImage image, int ImageWidth, int ImageHeight) {
		this(x, y, image, ImageWidth, ImageHeight, 0, 0, 5);
	}
	public Enemy(int x, int y, BufferedImage image, int health) {
		this(x, y, image, image.getWidth(), image.getHeight(), 0, 0, health);
	}
	public Enemy(int x, int y, BufferedImage image, int imageWidth, int imageHeight, int Xspeed, int Yspeed, int health) {
		super(x, y, image, imageWidth, imageHeight, Xspeed, Yspeed);
		setHp(health);
	}
	public Enemy(int x, int y, BufferedImage [] images, int imageWidth, int imageHeight, int Xspeed, int Yspeed, int health) {
		super(x, y, images, imageWidth, imageHeight, Xspeed, Yspeed);
		setHp(health);
	}
	public Enemy(int x, int y, BufferedImage image, int imageWidth, int imageHeight, int Xspeed, int Yspeed, int health, int value) {
		super(x, y, image, imageWidth, imageHeight, Xspeed, Yspeed);
		setHp(health);
		setValue(value);
	}
	public Enemy(int x, int y, BufferedImage [] images, int imageWidth, int imageHeight, int Xspeed, int Yspeed, int health, int value) {
		super(x, y, images, imageWidth, imageHeight, Xspeed, Yspeed);
		setHp(health);
		setValue(value);
	}
	public int getHp() {
		return hp;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		if (value <=0) {
		this.value = value;
		}
	}
	//hp must be positive, or is set to 5
	public void setHp(int hp) {
		if (hp>=0) {
			this.hp = hp;
		} else {
			this.hp = 5;
		}
	}
	//returns are for if method wants to return a boolean,figure me out later.
	public void isHitWithBullet(int damage){
		if (damage>0) {
			this.hp -= damage;
			//return true;
		} else {
			//return false;
		}
	}
}
