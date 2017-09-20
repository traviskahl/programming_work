import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JColorChooserExample {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

	public JColorChooserExample() {
		prepareGUI();
	}

	public static void main(String[] args) {
		JColorChooserExample jcce = new JColorChooserExample();
		jcce.showColorChooserExample();
	}

	private void prepareGUI() {
		mainFrame = new JFrame("Java Swing Examples");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 1));

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);
		statusLabel.setSize(350, 100);

		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}

	private void showColorChooserExample() {
		headerLabel.setText("Control in action: JColorChooser");
		JButton chooseButton = new JButton("Choose Background");

		chooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color backgroundColor = JColorChooser.showDialog(mainFrame, "Choose background color", Color.white);
				if (backgroundColor != null) {
					controlPanel.setBackground(backgroundColor);
					mainFrame.getContentPane().setBackground(backgroundColor);
				}
			}
		});

		controlPanel.add(chooseButton);
		mainFrame.setVisible(true);
	}
}