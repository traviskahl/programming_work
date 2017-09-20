import javax.swing.JFrame;

public class AdditionActionDriver {
	public static void main(String[] args) {
		// create instance of frame
		AdditionFrame additionFrame = new AdditionFrame();
		additionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		additionFrame.setSize(350, 150);
		additionFrame.setVisible(true);
	}
}