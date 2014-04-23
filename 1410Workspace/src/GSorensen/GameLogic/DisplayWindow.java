package GameLogic;

import java.awt.Dimension;
import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


public class DisplayWindow {

	private Prefs prefs = new Prefs("src/prefs.ini");
	private boolean isFullscreen = prefs.getIsFullscreen();
	private static Dimension canvasSize;
	private static DisplayMode [] availableModes;

	public static final Dimension minSize = new Dimension(800, 600);
	public static final Dimension prefSize = new Dimension(1024, 786);
	
	public DisplayWindow(boolean hasTitleBar) {
		System.setProperty("org.lwjgl.opengl.Window.undecorated", Boolean.toString(hasTitleBar));
	}
	public static void main(String[] args) {
		try {
			availableModes = Display.getAvailableDisplayModes();
			setCanvasSize(minSize);
			Display.setDisplayMode(new DisplayMode((int)canvasSize.getWidth(), (int)canvasSize.getHeight()));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}

	}
	public static Dimension getCanvasSize() {
		return canvasSize;
	}
	public static void setCanvasSize(Dimension canvasSize) {
		DisplayWindow.canvasSize = canvasSize;
	}
	public static DisplayMode [] getDisplayModes() {
		return availableModes;
	}
	public static void reGetDisplayModes() throws LWJGLException {
		availableModes = Display.getAvailableDisplayModes();
	}
	public void switchFullscreen() {
		System.out.println(isFullscreen);
		try {
			Display.setFullscreen(isFullscreen);
			isFullscreen = !isFullscreen;
		}
		catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	public String[] getAvailableModes(DisplayMode [] modes) {
		ArrayList<String> r =  new ArrayList<String>();
		for (DisplayMode m : modes) {
			r.add(m.toString());
			System.out.println(m.toString());
		}
		String [] result = new String [r.size()];
		for (int i=0; i<result.length; i++) {
			result[i] = r.get(i);
		}
		return result;
	}
}
