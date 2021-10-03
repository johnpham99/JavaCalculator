import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GoodCalculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] operationButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equalButton, delButton, clearButton, signButton;
    JPanel panel;

    Font calculatorFont = new Font("Comic Sans MS", Font.PLAIN, 30);

    double num1 = 0, num2 = 2, result = 0;
    char operator;

    GoodCalculator() {
        frame = new JFrame("Good Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        panel = new JPanel();
        panel.setBounds(50, 135, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50); //setLayout is null, so we set bounds
        textField.setFont(calculatorFont);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        clearButton = new JButton("CLEAR");
        delButton = new JButton("DEL");
        signButton = new JButton("+/-");

        operationButtons[0] = addButton;
        operationButtons[1] = subButton;
        operationButtons[2] = mulButton;
        operationButtons[3] = divButton;
        operationButtons[4] = decButton;
        operationButtons[5] = equalButton;
        operationButtons[6] = clearButton;
        operationButtons[7] = delButton;
        operationButtons[8] = signButton;

        for (int i = 0; i < 9; i++) {
            operationButtons[i].addActionListener(this);
            operationButtons[i].setFont(calculatorFont);
            operationButtons[i].setFocusable(true); //button outline
        }

        signButton.setBounds(50, 85, 100, 40);
        clearButton.setBounds(50, 450, 145, 50);
        delButton.setBounds(205, 450, 145, 50);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(calculatorFont);
            numberButtons[i].setFocusable(false);
        }

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(signButton);
        frame.add(clearButton);
        frame.add(delButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    //button functionalities
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat(String.valueOf(".")));
        }

        if (e.getSource() == addButton) {
            num1 =  Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 =  Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 =  Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 =  Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == equalButton) {
            num2 =  Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clearButton) {
            textField.setText("");
        }

        if (e.getSource() == delButton) {
            String numberText = textField.getText();
            textField.setText("");
            for (int i = 0; i < numberText.length() - 1; i++) {
                textField.setText(textField.getText() + numberText.charAt(i));
            }
        }

        if (e.getSource() == signButton) {
            double enteredNumber = Double.parseDouble(textField.getText());
            enteredNumber *= -1;
            textField.setText(String.valueOf(enteredNumber));
        }
    }

    public static void main (String[] args) {
        GoodCalculator TexasInstrument = new GoodCalculator();
    }
}

