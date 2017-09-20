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
import javax.swing.JRadioButton;
import java.util.ArrayList;

public class QuestionFrame extends JFrame {

	ArrayList<Question> questions;
	private String currentQuestion;
	private String currentAnswer;
	private int questionNumber;

	JButton newQuestionButton;
	JButton submitButton;
	JLabel questionLabel;
	JLabel answerLabel;
	JTextField answerTextField;

	public QuestionFrame() {
		questions = new ArrayList<Question>();
		setDefaultQuestions();

		setQuestionNumber();
		currentQuestion = questions.get(questionNumber).getQuestion();
		currentAnswer = questions.get(questionNumber).getAnswer();

		JPanel buttonPanel = new JPanel();
		ButtonHandler buttonHandle = new ButtonHandler();

		newQuestionButton = new JButton("New Question");
		newQuestionButton.addActionListener(buttonHandle);
		buttonPanel.add(newQuestionButton);

		submitButton = new JButton("Check Answer");
		submitButton.addActionListener(buttonHandle);
		buttonPanel.add(submitButton);

		add(buttonPanel);

		questionLabel = new JLabel(currentQuestion);
		answerLabel = new JLabel(currentAnswer);

		add(questionLabel);
		add(answerLabel);

		answerTextField = new JTextField();
		add(answerTextField);

	}

	private void setQuestionNumber() {
		questionNumber = (int)(Math.random() * questions.size() + 1);
	}

	private void setDefaultQuestions() {
		for (int x = 0; x < 10; x++) {
			Question addedQuestion = new Question("number is " + x, "a");
			questions.add(addedQuestion);
		}
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == submitButton) {
				answerLabel.setText("The answer was: " + currentAnswer);
			}
			else {
				setQuestionNumber();
				

			}
		}
	}
}