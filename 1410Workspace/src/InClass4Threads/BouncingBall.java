import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;


public class BouncingBall implements Runnable{
	private static Graphics2D g;
	Color c;
	double x;
	double y;
	double xSpeed;
	double ySpeed;
	Random r = new Random();


	public BouncingBall(Graphics2D g, int mX, int mY){
		if (g == null){
			System.out.println("Error, g == null");
		}

		this.g = g;
		c = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());

		x = mX;
		y = mY;
		xSpeed = r.nextDouble()*2-1;
		ySpeed = r.nextDouble()*3-2;

	}

	public void updatePosition(){
		x = x + xSpeed;
		y = y + ySpeed;

		ySpeed += 0.01;
	}

	public void run() {
		//This code draws a ball moving across the screen 600 'pixels'
		boolean stillInFrame = true;
		while(stillInFrame == true){
			updatePosition();

			//Draw the ball at the current position
			synchronized (g) {
				g.setColor(Color.DARK_GRAY);
				g.fillOval((int)x, 275, 50, 25);


				g.setColor(c);
				g.fillOval((int)x, (int)y, 50, 50);


			}

			//sleep for just a tad
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			//erase just the old ball
			synchronized (g) {
				g.setColor(Color.gray);
				g.fillOval((int)x, (int)y, 50, 50);
				g.fillOval((int)x, 275, 50, 25);
			}

			//End the thread when the ball is outside the frame
			if (x > 550){
				//				stillInFrame = false;
				x = 550;
//				c = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
				xSpeed = xSpeed* -1;
			}
			if (x < 0) {
				x = 0;
//				c = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
				xSpeed = xSpeed* -1;
			}
			if (y < 0) {
				y = 0;
				//				c = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
				ySpeed = ySpeed * -1;
			}
			if (y > 250) {
				y = 250;
				//				c = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
				ySpeed = ySpeed * -1;
				ySpeed = ySpeed * 0.8;
			}
			if (y == 250) {
				y = 250;
				xSpeed = xSpeed * 0.8;
			}
		}
	}
}
