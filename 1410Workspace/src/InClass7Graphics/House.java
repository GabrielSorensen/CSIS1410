import java.awt.Color;
import java.awt.Graphics2D;


public class House extends MyShape{
	private Square wall;
	private Square window;
	private Triangle roof;

	public House(int x, int y){
		
		wall = new Square();
		wall.moveHorizontal(y);
		wall.moveVertical(x);
		wall.changeColor(Color.RED);
		wall.changeSize(100);
		wall.makeVisible();

		window = new Square();
		window.changeColor(Color.BLACK);
		window.moveHorizontal(y+20);
		window.moveVertical(x+10);
		window.makeVisible();

		roof = new Triangle();	
		roof.changeColor(Color.GREEN);
		roof.changeSize(50, 140);
		roof.move(y+50, x-45);
		roof.makeVisible();
		
	}

	public void draw(Graphics2D g) {

		wall.draw(g);
		window.draw(g);
		roof.draw(g);
	}
	

}
