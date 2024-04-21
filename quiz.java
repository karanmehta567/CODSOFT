import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class quiz extends JFrame {
    private JLabel questionLabel;
    private JToggleButton[] options;
    private JButton submitButton;
    private Timer timer;
    private int timeLeft = 30;
    private int currentQuestion = 0;
    private String[][] quizData = {
            {"Question 1: What is capital city of Japan?", "Tokyo", "Berlin", "Kyoto", "Hiroshima"},
            {"Question 2: How many planets are there in solar system?", "8", "7", "10", "5"},
            {"Question 3: What is the chemical symbol for water?", "H2O", "CO2", "NaCl", "O2"},
            {"Question 4: Which team won 2011 cricket world cup?", "India", "Australia", "Pakistan", "Sri Lanka"},
            {"Question 5: What was Java originally known as?", "Oak", "Coffee", "Sugar", "Beans"}
    };

    public quiz() {
        setTitle("Quiz Application");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        questionLabel = new JLabel();
        questionLabel.setBounds(20, 20, 360, 30);
        add(questionLabel);

        options = new JToggleButton[4];
        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JToggleButton();
            options[i].setBounds(20, 60 + (i * 30), 360, 30);
            buttonGroup.add(options[i]);
            add(options[i]);
        }

        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 200, 100, 30);
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });

        startTimer();
        displayNextQuestion();
    }

    private void displayNextQuestion() {
        if (currentQuestion < quizData.length) {
            questionLabel.setText(quizData[currentQuestion][0]);
            for (int i = 0; i < 4; i++) {
                options[i].setText(quizData[currentQuestion][i + 1]);
                options[i].setSelected(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Quiz completed!");
            timer.stop();
        }
    }

    private void checkAnswer() {
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected() && options[i].getText().equals(quizData[currentQuestion][1])) {
                JOptionPane.showMessageDialog(this, "Correct!");
                break;
            }
        }
        currentQuestion++;
        displayNextQuestion();
    }

    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                if (timeLeft == 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(quiz.this, "Time's Over");
                    
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new quiz().setVisible(true);
            }
        });
    }
}
