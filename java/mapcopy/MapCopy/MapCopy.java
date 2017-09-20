import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Formatter;

//import MapCopy.MapCopyUI;
//import MapCopy.Waypoint;

public class MapCopy {
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

	public MapCopy() {
		prepareGUI();
	}

	public static void main(String[] args) {
		MapCopy mapCopy = new MapCopy();
	}

	private void prepareGUI() {
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

	public void runProgram() {
		
		try {
			BufferedReader getInputData = new BufferedReader(new FileReader(sourceFile));

			// the first 3 lines are useless to us
			for (int line = 0; line < 3; ++line) {
				String useless = getInputData.readLine();
				//System.out.printf("Useless line #%d is %s\n", line+1, useless);
			}

			int counter = 0;
			while (true) {
				//System.out.printf("\nLine #%d\n", ++counter);
				String waypointData = getInputData.readLine(); // the useful line
				//System.out.println("Line is:\n" + waypointData);
				Waypoint way = new Waypoint(waypointData, destinationDirectory);
				way.getAndSetData();
				way.outputData();
			}
		}
		catch (NullPointerException NPE) {
			//System.out.println("Finished making .json files.");
            ;
		}
		catch (IOException IOE) {
			System.err.println("An IO exception occurred.");
			IOE.printStackTrace();
		}
		catch(Exception ex) {
			System.err.println("An unknown exception occurred.");
			ex.printStackTrace();
		}
        JOptionPane.showMessageDialog(mainFrame, "Your waypoints have successfully been copied over.", "MapCopy", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
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
                    // what we want to do is check the file extension to only be .points files
                    int dotIndex = sourceFile.getName().lastIndexOf(".");
                    String extension = sourceFile.getName().substring(dotIndex, sourceFile.getName().length());

                    if (!(extension.equals(".points"))) {
                        JOptionPane.showMessageDialog(mainFrame, "Your source file must be a .points file.", "MapCopy Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        runProgram();
                    }
                }
            }
            else {
                System.out.println("How the hell did you do that");
            }
        }
    }
}
