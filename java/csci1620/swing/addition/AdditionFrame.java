import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class AdditionFrame extends JFrame {
	// fields for operand inputs
	private JTextField op1;
	private JTextField op2;
	// field for sum output
	private JTextField sum;
	// button to perform addition
	private JButton compute;
	// button to reset fields
	private JButton reset;

	public AdditionFrame() {
		super("Simple Adder");
		setLayout(new FlowLayout());

		// create input fields, width of 10
		op1 = new JTextField("Operand 1", 10);
		add(op1);

		op2 = new JTextField("Operand 2", 10);
		add(op2);

		// create field for output
		sum = new JTextField("Sum", 10);
		// user can't change text
		sum.setEditable(false);
		add(sum);

		AdditionFrameHandler handler = new AdditionFrameHandler();

		// button to perform action
		compute = new JButton("ADD");
		compute.addActionListener(handler);
		add(compute);

		reset = new JButton("RESET");
		reset.addActionListener(handler);
		add(reset);
	}
	// nested class - listener to handle events
	private class AdditionFrameHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String out = "";
			// check which component caused the current event
			if (event.getSource() == compute) {
				try {
					// get values of operands, add them and convert into String
					out = String.format("%d", Integer.parseInt(op1.getText()) + Integer.parseInt(op2.getText()));
				}
				catch (NumberFormatException NFE) {
					// if either operand is not a valid integer
					out = "ERROR";
				}
				sum.setText(out);
			}
			else if (event.getSource() == reset) {
				// set text fields to their original values
				op1.setText("Operator 1");
				op2.setText("Operator 2");
				sum.setText("Sum");
			}
		}
	}

}