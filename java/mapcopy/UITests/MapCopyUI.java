import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;

public class MapCopyUI {
	private JFrame mainFrame;

	private JPanel sourcePanel;
	private JButton sourceButton;
	private JLabel sourceLabel;
	private String sourceActionCommand = "Get source";
	private JFileChooser sourceChooser;
	private File sourceFile;

	private JPanel destinationPanel;
	private JButton destinationButton;
	private JLabel destinationLabel;
	private String destinationActionCommand = "Get destination";
	private JFileChooser destinationChooser;
	private File destinationDirectory;

	private JButton copyButton;
	private String copyActionCommand = "Copy";

	// everything below here is for testing and should be removed in the final version

	public MapCopyUI() {
		prepareGUI();
		sourceFile = null;
		destinationDirectory = null;
	}

	public static void main(String args[]) {
		MapCopyUI mcui = new MapCopyUI();
	}

	public void prepareGUI() {
		// initialize the main frame
		mainFrame = new JFrame("MapCopyUI Test");
		mainFrame.setSize(800, 400);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new GridLayout(1, 2, 3, 3));

		// initialize everything on the source side, starting with the panel itself
		sourcePanel = new JPanel();
		sourcePanel.setLayout(new GridLayout(2, 1, 3, 3));

		// initialize the source button
		sourceButton = new JButton("Select source file");
		sourceButton.addActionListener(new MapCopyUIActionListener());
		sourceButton.setActionCommand(sourceActionCommand);
		sourcePanel.add(sourceButton);

		// initialize the source label
		sourceLabel = new JLabel("No source file chosen.");
		sourcePanel.add(sourceLabel);

		// initialize the source chooser
		sourceChooser = new JFileChooser();
		

		// initialize everything on the destination side starting with the panel
		destinationPanel = new JPanel();
		destinationPanel.setLayout(new GridLayout(2, 1, 3, 3));

		// initialize the destination button
		destinationButton = new JButton("Select destination directory");
		destinationButton.addActionListener(new MapCopyUIActionListener());
		destinationButton.setActionCommand(destinationActionCommand);
		destinationPanel.add(destinationButton);

		// initialize the destination label
		destinationLabel = new JLabel("No destination chosen.");
		destinationPanel.add(destinationLabel);

		// initialize the destination chooser
		destinationChooser = new JFileChooser();
		destinationChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		// add the two panels
		mainFrame.add(sourcePanel);
		mainFrame.add(destinationPanel);

		// initialize and add the copy button
		copyButton = new JButton("Copy your waypoints");
		copyButton.addActionListener(new MapCopyUIActionListener());
		copyButton.setActionCommand(copyActionCommand);
		mainFrame.add(copyButton);

		// don't remove this though
		mainFrame.setVisible(true);
	}

	private class MapCopyUIActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();

			if (command.equals(sourceActionCommand)) {

				int returnVal = sourceChooser.showOpenDialog(mainFrame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					sourceFile = sourceChooser.getSelectedFile();
					sourceLabel.setText("Source file: " + sourceFile.getAbsoluteFile());
				}

			}
			else if (command.equals(destinationActionCommand)){
				
				int returnVal = destinationChooser.showOpenDialog(mainFrame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					destinationDirectory = destinationChooser.getSelectedFile().getAbsoluteFile();
					destinationLabel.setText("Destination directory: " + destinationDirectory);
				}

			}
			else if (command.equals(copyActionCommand)) {
				if (sourceFile == null) {
					JOptionPane.showMessageDialog(mainFrame, "You need a source file.", "MapCopy Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (destinationDirectory == null) {
					JOptionPane.showMessageDialog(mainFrame, "You need a destination directory.", "MapCopy Error", JOptionPane.ERROR_MESSAGE);					
				}
				else {
					//JOptionPane.showMessageDialog(mainFrame, "This functionality coming soon!", "MapCopy", JOptionPane.INFORMATION_MESSAGE);
					MapCopy.runProgram();
				}
			}
			else {
				System.out.println("How the hell did you do that");
			}
		}
	}

	public File getSource() { return sourceFile; }
	public File getDestination() { return destinationDirectory; }
}