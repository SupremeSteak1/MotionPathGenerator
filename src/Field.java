import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Field {
	
	private static List<DrawableLine> fieldComponents;
	private static Rectangle fieldCarpet = new Rectangle(10, 10, 600, 290);
	static int xOffSet = 40;
	static int yOffSet = 20;
	static int fieldX = 0 + xOffSet;
	static int fieldY = 0 + yOffSet;
	int fieldHeight = 270 + yOffSet;
	int fieldWidth = 540 + xOffSet;
	int pWidth = 2; //Perimeter Width
	
	public Field() {
		//Initialize fieldComponents
		fieldComponents = new ArrayList<DrawableLine>();
		
		//Field lines
		fieldComponents.add(new DrawableLine(fieldX+((fieldWidth-xOffSet)/2),fieldY,fieldX+((fieldWidth-xOffSet)/2),fieldY+fieldHeight-yOffSet,Color.WHITE,1)); //Center line
		fieldComponents.add(new DrawableLine(fieldX+((fieldWidth-xOffSet)/3),fieldY,fieldX+((fieldWidth-xOffSet)/3),fieldY+fieldHeight-yOffSet,Color.BLUE,1)); //Center line
		fieldComponents.add(new DrawableLine(fieldX+((fieldWidth-xOffSet)/3)*2,fieldY,fieldX+((fieldWidth-xOffSet)/3)*2,fieldY+fieldHeight-yOffSet,Color.RED,1)); //Center line
		
		//Field perimeter
		fieldComponents.add(new DrawableLine(fieldX,fieldY,fieldWidth,fieldY,Color.WHITE,4)); //Top line
		fieldComponents.add(new DrawableLine(fieldX,fieldHeight,fieldWidth,fieldHeight,Color.WHITE,4)); //Bottom line
		fieldComponents.add(new DrawableLine(fieldX,fieldY,fieldX,fieldHeight,Color.BLUE,4)); //Left line (blue)
		fieldComponents.add(new DrawableLine(fieldWidth,fieldY,fieldWidth,fieldHeight,Color.RED,4)); //Right line (red)
	}
	
	public static void drawField(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(fieldCarpet.x,fieldCarpet.y,fieldCarpet.width,fieldCarpet.height);
		for(DrawableLine l : fieldComponents) {
			l.draw(g);
		}
	}
	
}
