import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class MyFrame extends JFrame {

	private JButton aButton;
	private JButton bButton;
	private JLabel testLabel;

	public MyFrame() {
		super("testing the frame");
		setLayout(new FlowLayout());

		JPanel buttonPanel = new JPanel();
		ButtonHandler handle = new ButtonHandler();

		aButton = new JButton("make it A");
		aButton.addActionListener(handle);
		buttonPanel.add(aButton);

		bButton = new JButton("make it B");
		bButton.addActionListener(handle);
		buttonPanel.add(bButton);

		add(buttonPanel);

		testLabel = new JLabel("");
		add(testLabel);

	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == aButton) {
				testLabel.setText("A");
			}
			else {
				testLabel.setText("B");
			}
		}
	}

}