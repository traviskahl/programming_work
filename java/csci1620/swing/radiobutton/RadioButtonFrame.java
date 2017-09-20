import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RadioButtonFrame extends JRadioButton {
	private JRadioButton button1;
	private JRadioButton button2;
	private JRadioButton button3;
	private ButtonGroup radioGroup;
	private JTextField outField;

	public RadioButtonFrame() {
		super("Radio Test");
		setLayout(new FlowLayout());

		outField = new JTextField("Button 1 On");
		outField.setEditable(false);
		add(outField);
		// create radio buttons, set starting values so one is selected (true)
		button1 = new JRadioButton("Button 1", true);
		button2 = new JRadioButton("Button 2", false);
		button3 = new JRadioButton("Button 3", false);

		add(button1);
		add(button2);
		add(button3);
		// Create ButtonGroup and add buttons to the group
		// creates a logical association between buttons
		radioGroup = new ButtonGroup();
		radioGroup.add(button1);
		radioGroup.add(button2);
		radioGroup.add(button3);
		// Create listener and add to buttons
		RadioListener handler = new RadioListener();
		button1.addItemListener(handler);
		button2.addItemListener(handler);
		button3.addItemListener(handler);
	}

	private class RadioListener implements ItemListener {
		public void itemStateChanged(ItemEvent event) {
			String outputText = "";

			// set output text based on button that was pressed
			if (event.getSource() == button1) {
				outputText = "Button 1 On";
			}
			else if (event.getSource() == button2) {
				outputText = "Button 2 On";
			}
			else {
				outputText = "Button 3 On";
			}

			outField.setText(outputText);
		}
	}
}