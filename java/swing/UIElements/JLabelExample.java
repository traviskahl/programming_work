import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JLabelExample {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

	public JLabelExample() {
		prepareGUI();
	}

	public static void main(String[] args) {
		JLabelExample jle = new JLabelExample();
		jle.showLabelDemo();
	}

	private void prepareGUI() {
		mainFrame = new JFrame("Java Swing Example");
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

	private void showLabelDemo() {
		headerLabel.setText("Control in action: Label");
		JLabel label = new JLabel("", JLabel.CENTER);
		label.setText("Welcome to TutorialsPoint Swing Tutorial.");
		label.setOpaque(true);
		label.setBackground(Color.GRAY);
		label.setForeground(Color.WHITE);
		controlPanel.add(label);

		mainFrame.setVisible(true);
	}
}