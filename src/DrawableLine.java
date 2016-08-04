import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;


public class DrawableLine {
	
	private Point p1;
	private Point p2;
	private Color c;
	private int width;
	
	public DrawableLine(int x1, int y1, int x2, int y2, Color c, int width) {
		p1 = new Point(x1, y1);
		p2 = new Point(x2, y2);
		this.c = c;
		this.width = width;
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(width));
		g2d.setColor(c);
		g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
	}
	
}
