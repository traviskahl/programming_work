import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KitTest {

	// kit types information, always the same regardless of order
	private class KitType {

		public String m_type;
		public int m_cost;

		public KitType(String type, int cost) {
			m_type = type;
			m_cost = cost;
		}

		public String toString() { return String.format("%s,%d\n", m_type, m_cost); }
	}

	private File TYPES_FILE = new File("types.txt");
	private ArrayList<KitType> kitTypes = new ArrayList<KitType>();

	private class Kit {

		public String m_company;
		public int m_stockNumber;
		public String m_name;
		public KitType m_kitType;
		public int m_quantity;

		public Kit(String company, int stockNumber, String name, KitType type, int quantity) {
			m_company = company;
			m_stockNumber = stockNumber;
			m_name = name;
			m_kitType = type;
			m_quantity = quantity;
		}

		// we need these two similar methods for different purposes
		// toString() is for storing the object in a file
		public String toString() {
			return String.format("%s,%d,%s,%s,%d\n", m_company, m_stockNumber, m_name, m_kitType.m_type, m_quantity);
		}

		// displayString() is for displaying the object in the GUI
		public String displayString() {
			return String.format("%s\t%d\t%s\t%s\t%d\n", m_company, m_stockNumber, m_name, m_kitType.m_type, m_quantity);
		}
	}

	// our specific order information: DO NOT LOSE
	private ArrayList<Kit> kits_list = new ArrayList<Kit>();
	private String orderName;
	private String mostRecentDate;

	// GUI Elements
	// ------------

	// action commands
	private String GET_TYPE_INFO	= "get type info";
	private String SAVE_TYPE_INFO	= "save type info";
	private String READ_ORDER		= "read order";
	private String SAVE_ORDER		= "save order";

 	// main frame
	private JFrame mainFrame;

	// display panel: show runtime data
	private JPanel displayPanel;
	private JTable displayTable;
	private JTextArea displayField;

	// DEBUG: testing elements
	private JLabel testLabel;
	private JButton testButton;

	// methods from here on out
	// ------------------------

	private void createGUI() {
		// initialize the main frame
		mainFrame = new JFrame("KitOrder test");
		mainFrame.setSize(800, 400);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new GridLayout(2, 2));

		// the display part of the window
		// this should show the order data thus far
		displayField = new JTextArea();
		for (int x = 0; x < kits_list.size(); ++x) {
			displayField.append(kits_list.get(x).displayString());
		}

		displayTable = new JTable();

		// don't delete this, it'll mess up everything
		// add all my panels
		mainFrame.add(displayField);
		mainFrame.add(displayTable);

		// DEBUG: add some random shit
		mainFrame.add(new JLabel("test label 1"));
		mainFrame.add(new JLabel("test label 2"));

		// don't remove this, it fucks up everything
		mainFrame.setVisible(true);
	}

	private void writeOrderToFile(String outputLocation) {
		try {
			// create out output objects
			File outputFile = new File(outputLocation);
			Formatter form = new Formatter(outputFile);

			// add the name of the order
			form.format("Order Name: Test Name\n");

			// create our date header
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			form.format(dateFormat.format(date));
			form.format("\n\n");

			// print the data
			for (int x = 0; x < kits_list.size(); ++x) {
				Kit currentKit = kits_list.get(x);
				String assembledData = currentKit.toString();
				form.format(assembledData);
			}

			form.close();
		}
		catch(Exception e) {
			System.out.println("Error when writing to file");
			e.printStackTrace();
		}
	}

	private void readOrderFromFile(String inputLocation) {
		try {
			BufferedReader inputData = new BufferedReader(new FileReader(new File(inputLocation))); // yeah it's messy, but it's the most consistent method

			// first line is title, but it's formatted oddly
			String title = inputData.readLine();
			String[] tempArray = title.split("\\s+");
			// now the actual title: breaks if we change the title formatting
			orderName = tempArray[2] + ' ' + tempArray[3];

			// second line is the date
			mostRecentDate = inputData.readLine();

			// third line is useless, skip it
			String throwaway = inputData.readLine();

			// fourth line is where the fun begins
			String line;
			while ((line = inputData.readLine()) != null) {
				String[] ld = line.split("\\,");

				// let's expand the process here, might simplify once it works
				String company = ld[0];
				int number = Integer.parseInt(ld[1]);
				String name = ld[2];
				String type = ld[3];
				int quantity = Integer.parseInt(ld[4]);

				int cost = -1;
				for (int x = 0; x < kitTypes.size(); ++x) {
					if (kitTypes.get(x).m_type.equals(type)) {
						cost = kitTypes.get(x).m_cost;
					}
				}

				kits_list.add(new Kit(company, number, name, new KitType(type, cost), quantity));
			}

			inputData.close();
		}
		catch (Exception e) {
			System.out.println("Error reading from file");
			e.printStackTrace();
		}
	}

	private void getTypeInfoFromFile() {
		try {
			BufferedReader inputData = new BufferedReader(new FileReader(TYPES_FILE));

			String line;
			while ((line = inputData.readLine()) != null) {
				String[] info = line.split("\\,");
				kitTypes.add(new KitType(info[0], Integer.parseInt(info[1])));
			}

			inputData.close();
		}
		catch (Exception e) {
			System.out.println("Error getting type info");
			e.printStackTrace();
		}

	}

	private void saveTypeInfoToFile() {
		try {
			Formatter form = new Formatter(TYPES_FILE);

			for (int x = 0; x < kitTypes.size(); ++x)
				form.format(kitTypes.get(x).toString());

			form.close();
		}
		catch (Exception e) {
			System.out.println("Error saving type info");
			e.printStackTrace();
		}
	}

	public KitTest() {
		getTypeInfoFromFile();
		readOrderFromFile("output.txt");
		createGUI();
	}

	public static void main(String[] args) {
		KitTest progDriver = new KitTest();
	}

	private class KitUIActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();

			if (command.equals(GET_TYPE_INFO)) {
				getTypeInfoFromFile();
			}
			else if (command.equals(SAVE_TYPE_INFO)) {
				saveTypeInfoToFile();
			}
			else if (command.equals(READ_ORDER)) {
				readOrderFromFile("output.txt");
			}
			else if (command.equals(SAVE_ORDER)) {
				writeOrderToFile("output.txt");
			}
		}
	}
}