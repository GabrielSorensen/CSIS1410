

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glRectd;

import java.io.File;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import Entities.AbstractMoveableEntitty;


public class PongGame {

	public static final int WIDTH= 640;
	public static final int HEIGHT= 480;
	public static int s1;
	public static int s2;
	private static boolean isRunning= true;
	private static boolean paused = false;
	private static Ball ball;
	private static Bat OP;
	private static Bat bat;
	private static double Speed;
	private static double UP;
	private static double pau1;
	private static double pau2;



	public static void main(String[] args) {
//		System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + File.separator + "native" + File.separator + "os");
//		System.setProperty(org.lwjgl.opengl., true);
		new Thread().start();
		setupDisplay();
		setupOpenGL();
		setupEntities();
		setupTimer();
		getDelta();
		reset();
		while(isRunning){
			render();
			logic(getDelta());
			input();
			Display.update();
			Display.sync(60);
			if(Display.isCloseRequested()){
				isRunning = false;
			}
		}
		Display.destroy();
		System.exit(0);
	}

	private static void input() {
		if (Keyboard.isKeyDown(Keyboard.KEY_UP)){
			bat.setDY(-.2);
		} else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			bat.setDY(.2);
		} else {
			bat.setDY(0);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_P)) {
			if (!paused) {
				pau1= Speed;
				pau2= UP;
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ball.setDX(0);
				ball.setDY(0);
				paused= true;
			}else if (paused) {
				ball.setDX(pau1);
				ball.setDY(pau2);
				pau1= 0;
				pau2= 0;
				paused= false;
			}
			else {
				System.out.println("Not paused or attempted to pause");
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			reset();
			System.out.println("reset.");
		}


	}

	private static long lastFrame;

	private static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	private static int getDelta() {
		long currentTime = getTime();
		int delta = (int) (currentTime - lastFrame);
		lastFrame = getTime();
		return delta;
	}

	private static void setupDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle("Pong");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
	}

	private static void setupOpenGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 640, 480, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}

	private static void setupEntities() {
		bat = new Bat( 30, HEIGHT /2 - 80 / 2, 10, 80);
		OP = new Bat(WIDTH - 30, HEIGHT /2 - 80 / 2, 10, 80);
		ball = new Ball(WIDTH /2 - 5, HEIGHT / 2 - 10 / 2, 10, 10);

	}

	private static void setupTimer() {
		lastFrame = getTime();
	}

	private static void render(){
		glClear(GL_COLOR_BUFFER_BIT);
		ball.draw();
		bat.draw();
		OP.draw();
		GL11.glBegin(GL11.GL_LINES);
		GL11.glLineWidth(5.0f);
		GL11.glVertex2f(WIDTH /2 , 50);
		GL11.glVertex2f(WIDTH /2 , HEIGHT);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_LINES);
		GL11.glLineWidth(5.0f);
		GL11.glVertex2f(0 , 50);
		GL11.glVertex2f(WIDTH , 50);
		GL11.glEnd();
	}

	private static void logic(int delta){
		ball.update(delta);
		bat.update(delta);
		OP.update(delta);
		if (Speed>.8&&Speed>0){
			Speed = Speed -.1;
		}
		if (Speed<-.8&&Speed<0){
			Speed = Speed +.1;
		}
		if (ball.intersects(bat)){
			//double w = ball.getY()-bat.getY();
			Speed = (-1*(Speed)) +.05;
			ball.setDX(Speed);
			if (ball.getY()-bat.getY()<=9) {
				UP = -1*Math.abs(UP)-.1;
				ball.setDY(UP);
			}
			if (ball.getY()-bat.getY()>=60) {
				UP = (-1*Math.abs(UP))+.2;
				ball.setDY(UP);
			}
			//			System.out.println(+w);
		}
		if (ball.intersects(OP)){
			//double w = ball.getY()-OP.getY();
			Speed = (-1*(Speed))-.05;
			ball.setDX(Speed);
			if (ball.getY()-OP.getY()<=9) {
				UP = -1*UP-.2;
				ball.setDY(UP);
			}
			if (ball.getY()-OP.getY()>=60) {
				UP = (-1*Math.abs(UP))+.2;
				ball.setDY(UP);
			}
			//			System.out.println(+w);
		}
		//score system.
		if (ball.getX()<=0) {
			s2+=1;
			reset();
			System.out.println(+s1+"\t\t"+s2);
		}
		if (ball.getX()+ball.getWidth()>=WIDTH) {
			s1+=1;
			reset();
			System.out.println(+s1+"\t\t"+s2);
		}
		//top edge detection
		if (ball.getY()<=50) {
			UP = UP*-1;
			ball.setDY(UP);
		}
		//bottom edge bug(?) fix
		if (ball.getY()+ball.getHeight()>=HEIGHT-5) {
			UP = UP*-1;
			ball.setY(HEIGHT-14);
			ball.setDY(UP);
		}
		//OP AI
		if (Math.ceil(OP.getCenterY())>=Math.ceil(ball.getCenterY())){
			OP.setDY(-.2);
		} else if (Math.ceil(OP.getCenterY())<=Math.ceil(ball.getCenterY())) {
			OP.setDY(.2);
		} else {
			OP.setDY(0);
		}
	}

	private static void reset() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ball.setX(WIDTH /2 - 5);
		ball.setY(HEIGHT / 2 - 10);
		Speed = 0.1;
		UP = 0.1;
		ball.setDX(Speed);
		ball.setDY(0);
		bat.setY(HEIGHT / 2 - 5);
		OP.setY(HEIGHT / 2);
	}

	private static class Bat extends AbstractMoveableEntitty {

		public Bat(double x, double y, double width, double height) {
			super(x, y, width, height);
		}

		@Override
		public void draw() {
			glRectd(x, y, x + width, y + height);

		}

	}
	private static class Ball extends AbstractMoveableEntitty {

		public Ball(double x, double y, double width, double height) {
			super(x, y, width, height);
		}

		@Override
		public void draw() {
			glRectd(x, y, x + width, y + height);

		}
	}
}
