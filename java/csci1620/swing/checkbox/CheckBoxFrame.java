import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CheckBoxFrame extends JFrame {
	private JCheckBox check;
	private JTextField outField;

	public CheckBoxFrame() {
		super("Check Test");
		setLayout(new FlowLayout());

		// Create components
		check = new JCheckBox("Check Me");
		outField = new JTextField("Not Selected");
		outField.setEditable(false);
		// add components to frame
		add(check);
		add(outField);
		// add ItemListener to check box
		check.addItemListener(new CheckListener());
	}

	private class CheckListener implements ItemListener {
		public void itemStateChanged(ItemEvent event) {
			String outputText = "";
			// See if check box is selected
			if (check.isSelected()) {
				outputText = "Selected";
			}
			else {
				outputText = "Not Selected";
			}

			outField.setText(outputText);
		}
	}
}