import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author Dr B
 *
 */
@SuppressWarnings("unused")
public class ZW06_Grader {
	

	public static void main(String[] args) {
		int points = 0;
		points = W06_Grader.testBasicObject();
		System.out.println("Points " + points + "/35");
		System.out.println("Plus 10 more points if the picture draws correctly");

		points = W06_Grader.testAnimatedObject();
		System.out.println("Points " + points + "/45");
		System.out.println("Plus 10 more points if the picture draws correctly");

	}

}
