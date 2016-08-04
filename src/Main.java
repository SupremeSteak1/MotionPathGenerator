import java.awt.Dimension;


public class Main {
	
	private static DisplayFrame frame;
	
	public static void main(String[] args) {
		frame = new DisplayFrame();
		
		//Ensure all the static things have been initialized
		new Field();
		new WaypointHandler();
		
		frame = new DisplayFrame();
		frame.setSize(new Dimension(630,720));
	}
	
	public static void redraw() {
		frame.revalidate();
		frame.validate();
		frame.repaint();
	}
}
