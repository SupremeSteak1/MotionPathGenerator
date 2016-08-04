import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class DisplayFrame extends JFrame {
	
	private JPanel container;
	private DisplayPanel panel;
	
	private JPanel controls;
	private JButton calculateButton;
	private static JLabel equation;
	
	public DisplayFrame() {
		panel = new DisplayPanel();
		controls = new JPanel();
		calculateButton = new JButton("Print path");
		equation = new JLabel();
		
		container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel.setBounds(0,0,610,300);
		calculateButton.setBounds(10,300,20,330);
		calculateButton.addActionListener(new CalculateButtonListener());
		
		equation.setText("No spline equation yet!");
		controls.add(calculateButton);
		controls.setLayout(new BoxLayout(controls, BoxLayout.Y_AXIS));
		controls.add(equation);
		controls.add(new JLabel("-----------------------------------------------"));
		controls.add(new JLabel("Click a point to change its color."));
		controls.add(new JLabel("Red points are transfer points."));
		controls.add(new JLabel("Cyan points are the start (should only be one)."));
		controls.add(new JLabel("Orange points are the end (should only be one)."));
		
		container.add(panel);
		container.add(controls);
		this.add(container);
		this.setVisible(true);
	}
	
	
	public static void updateSplineEquationText(String s) {
		equation.setText(s);
	}
}
