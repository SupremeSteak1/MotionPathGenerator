import java.awt.Color;

public class Point {
	private double x;
	private double y;
	private Color c; //Cyan = start, red = transfer, orange = end 
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		c = Color.RED;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public Color getColor() {
		return c;
	}
	
	public boolean rotateColor() {
		if(c.equals(Color.CYAN)) {
			c = Color.RED;
			return true;
		} else if(c.equals(Color.RED)) {
			c = Color.ORANGE;
			return true;
		} else if(c.equals(Color.ORANGE)) {
			c = Color.CYAN;
			return true;
		}
		return false;
	}
}
