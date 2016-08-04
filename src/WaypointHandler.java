import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class WaypointHandler {
	
	private static List<Point> points;
	private static int deadzone = 5;
	
	public WaypointHandler() {
		points = new ArrayList<Point>();
	}
	
	public static void addPoint(Point p) {
		if(!rotatePointJob(p)) {
			points.add(p);
		}
		Main.redraw();
	}
	
	public static void removePoint(Point p) {
		try {
			for(Point p2 : points) {
				if(Math.abs(p2.getX() - p.getX()) < 5 && Math.abs(p2.getY() - p.getY()) < 5) {
					points.remove(p2);
					System.out.println("Matched");
				}
			}
		} catch(Exception e) {
			System.out.println("Something happened... whatever");
		}
		Main.redraw();
	}
	
	public static boolean rotatePointJob(Point p) {
		for(Point p2 : points) {
			if(Math.abs(p2.getX() - p.getX()) < 5 && Math.abs(p2.getY() - p.getY()) < 5) {
				return p2.rotateColor();
			}
		}
		return false;
	}
	
	public static double[] calculateLargrangePolynomial() {
		double[] x = new double[points.size()];
		double[] y = new double[points.size()];
		for(int i = 0; i < points.size(); i++) {
			x[i] = points.get(i).getX();
			y[i] = points.get(i).getY();
		}
		double[] f = LagrangeInterpolation.findPolynomialFactors(x, y);
		DisplayFrame.updateSplineEquationText(LagrangeInterpolation.getPrintableForm(f));
		return f;
	}
	
	public static void drawPoints(Graphics g) {
		for(Point p : points) {
			g.setColor(p.getColor());
			g.fillOval((int) p.getX()-3, (int) p.getY()-3, 6, 6);
		}
	}
	
	public static void drawSpline(Graphics g, SplineCalculator sc, int x1, int x2, int y1, int y2) {
		g.setColor(Color.GREEN);
		for(int i = x1; i < x2; i++) {
			double y = sc.solveAtX(i);
			if(y1 < y && y < y2) {
				g.fillOval((int) i-2, (int) y-2, 4, 4);
			}
		}
	}
	
	public static Point getStartPoint() {
		for(Point p : points) {
			if(p.getColor()==Color.CYAN)
				return p;
		}
		return null;
	}
	
	public static Point getEndPoint() {
		for(Point p : points) {
			if(p.getColor()==Color.ORANGE)
				return p;
		}
		return null;
	}
	
	public static void generateWaypointList() {
		Point start = getStartPoint();
		Point end = getEndPoint();
		if(start==null || end==null) {
			JOptionPane.showMessageDialog(null,"Missing either a start or end point.");
			return;
		}
		double f[] = WaypointHandler.calculateLargrangePolynomial();
		if(f.length == 0) {
			JOptionPane.showMessageDialog(null, "No points detected");
			return;
		}
		SplineCalculator sc = new SplineCalculator(f);
		PathCreator pc = new PathCreator();
		if(start.getX() < end.getX()) {
			for(int i = (int) start.getX(); i < end.getX(); i++) {
				double x = i;
				double y = sc.solveAtX(i);
				x-=Field.fieldX;
				y-=Field.fieldY;
				x/=10; //Convert from px to ft
				y/=10;
				DecimalFormat df = new DecimalFormat("#.##");
				x = Double.parseDouble(df.format(x));
				y = Double.parseDouble(df.format(y));
				Point p = new Point(x,y);
				pc.addNode(p);
			}
		} else {
			for(int i = (int) start.getX(); i > end.getX(); i--) {
				double x = i;
				double y = sc.solveAtX(i);
				x-=Field.fieldX;
				y-=Field.fieldY;
				x/=10; //Convert from px to ft
				y/=10;
				DecimalFormat df = new DecimalFormat("#.##");
				x = Double.parseDouble(df.format(x));
				y = Double.parseDouble(df.format(y));
				Point p = new Point(x,y);
				pc.addNode(p);
			}
		}
		pc.printPath();
	}
}
