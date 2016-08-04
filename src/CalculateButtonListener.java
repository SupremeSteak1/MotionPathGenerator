import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateButtonListener implements ActionListener {
	
	public CalculateButtonListener() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		WaypointHandler.generateWaypointList();
	}

}
