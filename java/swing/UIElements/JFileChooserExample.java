import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFileChooserExample {
	private JFrame mainFrame;
	private JLabel statusLabel;
	private JLabel headerLabel;
	private JPanel controlPanel;

	public JFileChooserExample() {
		prepareGUI();
	}

	public static void main(String[] args) {
		JFileChooserExample jfce = new JFileChooserExample();
		jfce.showFileChooserExample();
	}

	private void prepareGUI() {
		mainFrame = new JFrame("Java Swing Examples");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout());
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

	private void showFileChooserExample() {
		headerLabel.setText("Control in action: JFileChooser");
		final JFileChooser fileDialog = new JFileChooser();
		JButton showFileDialogButton = new JButton("Open File");

		showFileDialogButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal = fileDialog.showOpenDialog(mainFrame);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					java.io.File file = fileDialog.getSelectedFile();
					statusLabel.setText("File Selected: " + file.getName());
				}
				else {
					statusLabel.setText("Open command cancelled by user");
				}
			}
		});

		controlPanel.add(showFileDialogButton);
		mainFrame.setVisible(true);
	}
}