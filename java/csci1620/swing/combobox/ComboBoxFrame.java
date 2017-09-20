import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ComboBoxFrame extends JFrame {
	// JComboBox uses a generic type, we want to populate
	// it with Strings
	private JComboBox<String> comboBox;
	private JTextField outField;
	// Array of Strings that will be the possible choices in combo box
	private String[] choices = { "Selection 1", "Selection 2", "Selection 3" };

	public ComboBoxFrame() {
		super("Combo Box Test");
		setLayout(new FlowLayout());
		// Set up output field, starts with default selection
		outField = new JTextField("Selection 1");
		outField.setEditable(false);
		add(outField);
		// Create JComboBox, give array of Strings for choices
		comboBox = new JComboBox<String>(choices);
		// Set number of rows in box for choices
		comboBox.setMaximumRowCount(3);
		comboBox.addItemListener(new ComboListener());
		add(comboBox);
	}

	private class ComboListener implements ItemListener {
		public void itemStateChanged(ItemEvent event) {
			// Was the event caused by the changing the choice in the box?
			if (event.getStateChange() == ItemEvent.SELECTED) {
				// getSelectedIndex returns an int corresponding to
				// the item selected, 0 based indexing
				// Set the output text to the correlating String in
				// the array of Strings
				outField.setText(choices[comboBox.getSelectedIndex()]);
			}
		}
	}
}