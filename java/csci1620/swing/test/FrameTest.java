import javax.swing.JFrame;

public class FrameTest {
	public static void main(String[] args) {
		MyFrame test = new MyFrame();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setSize(200, 200);
		test.setVisible(true);
	}
}