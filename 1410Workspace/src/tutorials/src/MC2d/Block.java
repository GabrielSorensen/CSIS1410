package MC2d;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Block {
	private BlockType type = BlockType.AIR;
	private Texture texture = null;
	private float x;
	private float y;
	public Block(BlockType type, float x2, float y2) {
		super();
		this.x = x2;
		this.y = y2;
		try {
			this.texture = TextureLoader.getTexture("PNG", new FileInputStream(new File(type.location)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void draw() {
		texture.bind();	
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(World.BLOCK_SIZE, 0);
		glTexCoord2f(1, 1);
		glVertex2f(World.BLOCK_SIZE, World.BLOCK_SIZE);
		glTexCoord2f(0, 1);
		glVertex2f(0, World.BLOCK_SIZE);
		glEnd();

	}
	public BlockType getType() {
		return type;
	}
	public void setType(BlockType type2) {
		this.type = type2;
	}
	public float getX() {
		return x;
	}
	public void setX(float x2) {
		this.x = x2;
	}
	public float getY() {
		return y;
	}
	public void setY(float y2) {
		this.y = y2;
	}

}
