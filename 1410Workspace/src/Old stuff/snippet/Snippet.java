package snippet;

public class Snippet {
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
}

