import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonListening {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

	public ButtonListening() {
		prepareGUI();
	}

	public static void main(String[] args) {
		ButtonListening buttonListening = new ButtonListening();
		buttonListening.showEventDemo();
	}

	private void prepareGUI() {
		mainFrame = new JFrame("Java Swing Examples");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 1));

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
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

	private void showEventDemo() {
		headerLabel.setText("Control in action: Button");

		JButton okButton = new JButton("OK");
		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");

		okButton.setActionCommand("OK");
		submitButton.setActionCommand("Submit");
		submitButton.setActionCommand("Cancel");

		okButton.addActionListener(new ButtonClickListener());
		submitButton.addActionListener(new ButtonClickListener());
		cancelButton.addActionListener(new ButtonClickListener());

		controlPanel.add(okButton);
		controlPanel.add(submitButton);
		controlPanel.add(cancelButton);

		mainFrame.setVisible(true);
	}

	private class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();

			if (command.equals("OK")) {
				statusLabel.setText("OK button clicked");
			}
			else if (command.equals("Submit")) {
				statusLabel.setText("Submit button clicked");
			}
			else if (command.equals("Cancel")) {
				statusLabel.setText("Cancel button clicked");
			}
		}
	}
}