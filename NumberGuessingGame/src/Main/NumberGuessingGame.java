package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGame extends JFrame implements ActionListener {

    private int randomNumber;
    private int attempts;
    private JTextField guessField;
    private JButton guessButton;
    private JLabel feedbackLabel;
    private JLabel attemptLabel;

    public NumberGuessingGame() {
        setTitle("Number Guessing Game");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        randomNumber = new Random().nextInt(100) + 1; // Random number between 1-100
        attempts = 0;

        JLabel instructionLabel = new JLabel("Guess a number between 1 and 100:");
        add(instructionLabel);

        guessField = new JTextField(10);
        add(guessField);

        guessButton = new JButton("Guess");
        guessButton.addActionListener(this);
        add(guessButton);

        feedbackLabel = new JLabel("");
        add(feedbackLabel);
        
        attemptLabel = new JLabel("Attempts: 0");
        add(attemptLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String guessText = guessField.getText();
        try {
            int guess = Integer.parseInt(guessText);
            attempts++;
            attemptLabel.setText("Attempts: " + attempts);

            if (guess < randomNumber) {
                feedbackLabel.setText("Too low! Try again.");
            } else if (guess > randomNumber) {
                feedbackLabel.setText("Too high! Try again.");
            } else {
                feedbackLabel.setText("Congratulations! You've guessed the number!");
                guessButton.setEnabled(false); // Disable button after correct guess
            }
        } catch (NumberFormatException ex) {
            feedbackLabel.setText("Please enter a valid number.");
        }

        guessField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NumberGuessingGame::new);
    }
}

