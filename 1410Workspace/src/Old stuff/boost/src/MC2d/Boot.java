package MC2d;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Boot {
	public static void main(String[] args) {
		try {
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setTitle("Minecraft 2D");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		Block grass = new Block(BlockType.GRASS, 10, 10);


		// Initialization code OpenGL
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 640, 480, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		while (!Display.isCloseRequested()) {
			// Render

			glClear(GL_COLOR_BUFFER_BIT);

			grass.draw();

			Display.update();
			Display.sync(60);
		}
		Display.destroy();
		System.exit(0);
	}
}
