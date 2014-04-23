import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {

	private static String[][] maze;

	public static void openMaze(String filename){
		Scanner in = null;
		int x=0;
		int y=0;
		int X=0;
		int Y=0;
		try {
			in = new Scanner(new File(filename)); 
			y = in.nextInt();
			x = in.nextInt();
			maze = new String [x][y];
			for (int i=0; i<maze.length; i++) {
				for (int j=0; j<maze[i].length; j++) {
					maze[i][j] = in.next();
					if (maze[i][j].equals("S")) {
						X=i;
						Y=j;
					}
				}
			}
			System.out.println("Maze formed, starting traversial. Starting at :"+X+" "+Y+"\n"+printMaze(maze));
			mazeTraversal(maze, X, Y);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  finally {
			in.close();
		}
	}
	public static boolean mazeTraversal(String [][] maze, int xPos, int yPos){
		//Note, you should not need any loops
		if (xPos <0 || xPos >=maze.length || yPos >=maze[xPos].length || yPos <0) { //check in-bounds
			return false;
		} else if (maze[xPos][yPos].equals("E")) { //check if solved
			maze[xPos][yPos] = "!";
			System.out.println("I WON!\n"+printMaze(maze));
			return true;
		} else if (maze[xPos][yPos].equals("#") || maze[xPos][yPos].equals("+")) { //check if valid move
			return false;
		} else {
			maze[xPos][yPos] = "+";
			if (mazeTraversal(maze, xPos-1, yPos)==true) {
				return true;
			} else if (mazeTraversal(maze, xPos+1, yPos)==true) {
				return true;
			} else if (mazeTraversal(maze, xPos, yPos+1)==true) {
				return true;
			} else if (mazeTraversal(maze, xPos, yPos-1)==true) {
				return true;
			} else {
				maze[xPos][yPos] = "#";
				return false;
			}
		}
	}
	public static String printMaze(String[][] maze) {  // get a string representation of the maze
		int x = maze.length;
		int y = maze[0].length;
		String M = "";
		for (int i=0; i<x; i++) {
			for (int j=0; j<y; j++) {
				M+=maze[i][j];
			}
			M+="\n";
		}
		M+="\n";
		return M;
	}
}