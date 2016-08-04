import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseActionHandler implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		/*
		System.out.println("Mouse click at time: " + System.currentTimeMillis());
		System.out.println("Mouse clicked at point: " + e.getPoint());
		System.out.println("Mouse button clicked: " + e.getButton());
		System.out.println("");
		*/
		
		Point p = new Point(e.getX(), e.getY());
		if(e.getButton()==1)
			WaypointHandler.addPoint(p);
		else if(e.getButton()==3) {
			System.out.println("removing");
			WaypointHandler.removePoint(p);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
