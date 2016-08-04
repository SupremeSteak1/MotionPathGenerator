import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DisplayPanel extends JPanel {
	
	public DisplayPanel() {
		this.addMouseListener(new MouseActionHandler());
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Field.drawField(g);
		double f[] = WaypointHandler.calculateLargrangePolynomial();
		if(f.length != 0) {
			SplineCalculator sc = new SplineCalculator(f);
			WaypointHandler.drawSpline(g, sc, 10, 600, 10, 290);
		}
		WaypointHandler.drawPoints(g);
	}
	
}
