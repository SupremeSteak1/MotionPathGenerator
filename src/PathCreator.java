import java.util.ArrayList;
import java.util.List;

public class PathCreator {
	private List<Point> pathNodes;
	
	private double xOffSet;
	private double yOffSet;
	
	//Robot variables, all in inches or degrees
	private double wheelBase;
	private double wheelSpeedMax;
	private double heading;
	
	/*
	 * 
	 * R = center of rotation
	 * r = distance from center of robot to R
	 * w = wheel base
	 * h = heading = [cos(θ)]  |h| = 1
	 *               [sin(θ)]
	 * u = speed
	 * v = velocity = uh
	 * ω = angular velocity = u/r = uR/(r-w/2) = uL/(r+w/2)
	 * u = umax(r/(r+w/2))
	 * q = [x] = pose (position and rotation
	 *     [y]
	 *     [θ]
	 * 
	 */
	
	public PathCreator() {
		pathNodes = new ArrayList<Point>();
		xOffSet = 0;
		yOffSet = 0;
	}
	
	public void addNode(Point p) {
		pathNodes.add(p);
	}
	
	public void printPath() {
		xOffSet = pathNodes.get(0).getX();
		yOffSet = pathNodes.get(0).getY();
		String[] path = new String[pathNodes.size()];
		for(int i = 0; i < pathNodes.size(); i++) {
			Point p0 = pathNodes.get(i-1);
			Point p = pathNodes.get(i);
			Point p1 = pathNodes.get(i+1);
			path[i] = i+" X:"+(p.getX()-xOffSet)+" Y:"+(p.getY()-yOffSet);
		}
		FileWriter.writeToFile("robot-path-file-"+System.currentTimeMillis(), path);
	}
}
