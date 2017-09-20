import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JButtonExample {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

	public JButtonExample() {
		prepareGUI();
	}

	public static void main(String[] args) {
		JButtonExample jbe = new JButtonExample();
		jbe.showButtonDemo();
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

	private static ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = JButtonExample.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		}
		else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	private void showButtonDemo() {
		headerLabel.setText("Control in action: Button");

		// resources folder should be inside this folder
		ImageIcon icon = createImageIcon("/resources/java_icon.png", "Java");

		JButton okButton = new JButton("OK");
		JButton javaButton = new JButton("Submit", icon);
		JButton cancelButton = new JButton("Cancel", icon);
		cancelButton.setHorizontalTextPosition(SwingConstants.LEFT);

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				statusLabel.setText("OK Button clicked");
			}
		});

		javaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				statusLabel.setText("Submit Button clicked");
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				statusLabel.setText("Cancel Button clicked");
			}
		});

		controlPanel.add(okButton);
		controlPanel.add(javaButton);
		controlPanel.add(cancelButton);
		mainFrame.setVisible(true);
	}
}