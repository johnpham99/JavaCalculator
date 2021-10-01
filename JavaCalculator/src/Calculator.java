import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] operationButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equalButton, delButton, clearButton, negButton;
    JPanel panel;

    Font calculatorFont = new Font("Comic Sans MS", Font.PLAIN, 30);

    double num1 = 0, num2 = 2, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 425, 300, 50); //setLayout is null
        textField.setFont(calculatorFont);
        textField.setEditable(false);
        textField.setBackground(Color.yellow);
        textField.setForeground(Color.white);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        clearButton = new JButton("CLEAR");
        delButton = new JButton("DEL");
        negButton = new JButton("+/-");



        operationButtons[0] = addButton;
        operationButtons[1] = subButton;
        operationButtons[2] = mulButton;
        operationButtons[3] = divButton;
        operationButtons[4] = decButton;
        operationButtons[5] = equalButton;
        operationButtons[6] = clearButton;
        operationButtons[7] = delButton;
        operationButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            operationButtons[i].addActionListener(this);
            operationButtons[i].setFont(calculatorFont);
            operationButtons[i].setFocusable(false); //button outline
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(calculatorFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 475, 100, 40);
        clearButton.setBounds(50, 25, 145, 50);
        delButton.setBounds(205, 25, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[5]);
        numberButtons[5].setOpaque(true);
        numberButtons[5].setBorderPainted(false);
        numberButtons[5].setBackground(Color.red);
        numberButtons[5].setForeground(Color.orange);
        panel.add(numberButtons[7]);
        numberButtons[7].setOpaque(true);
        numberButtons[7].setBorderPainted(false);
        numberButtons[7].setBackground(Color.orange);
        numberButtons[7].setForeground(Color.green);
        panel.add(numberButtons[3]);
        numberButtons[3].setOpaque(true);
        numberButtons[3].setBorderPainted(false);
        numberButtons[3].setBackground(Color.yellow);
        numberButtons[3].setForeground(Color.white);
        panel.add(decButton);
        decButton.setOpaque(true);
        decButton.setBorderPainted(false);
        decButton.setBackground(Color.green);
        decButton.setForeground(Color.red);
        panel.add(addButton);
        addButton.setOpaque(true);
        addButton.setBorderPainted(false);
        addButton.setBackground(Color.blue);
        addButton.setForeground(Color.magenta);
        panel.add(numberButtons[1]);
        numberButtons[1].setOpaque(true);
        numberButtons[1].setBorderPainted(false);
        numberButtons[1].setBackground(Color.getHSBColor(97, 56, 142));
        numberButtons[1].setForeground(Color.pink);
        panel.add(equalButton);
        equalButton.setOpaque(true);
        equalButton.setBorderPainted(false);
        equalButton.setBackground(Color.magenta);
        equalButton.setForeground(Color.gray);
        panel.add(numberButtons[9]);
        numberButtons[9].setOpaque(true);
        numberButtons[9].setBorderPainted(false);
        numberButtons[9].setBackground(Color.green);
        numberButtons[9].setForeground(Color.cyan);
        panel.add(numberButtons[2]);
        numberButtons[2].setOpaque(true);
        numberButtons[2].setBorderPainted(false);
        numberButtons[2].setBackground(Color.red);
        numberButtons[2].setForeground(Color.green);
        panel.add(mulButton);
        mulButton.setOpaque(true);
        mulButton.setBorderPainted(false);
        mulButton.setBackground(Color.orange);
        mulButton.setForeground(Color.cyan);
        panel.add(numberButtons[0]);
        numberButtons[0].setOpaque(true);
        numberButtons[0].setBorderPainted(false);
        numberButtons[0].setBackground(Color.yellow);
        numberButtons[0].setForeground(Color.green);
        panel.add(numberButtons[8]);
        numberButtons[8].setOpaque(true);
        numberButtons[8].setBorderPainted(false);
        numberButtons[8].setBackground(Color.green);
        numberButtons[8].setForeground(Color.BLACK);
        panel.add(numberButtons[4]);
        numberButtons[4].setOpaque(true);
        numberButtons[4].setBorderPainted(false);
        numberButtons[4].setBackground(Color.cyan);
        numberButtons[4].setForeground(Color.pink);
        panel.add(divButton);
        divButton.setOpaque(true);
        divButton.setBorderPainted(false);
        divButton.setBackground(Color.magenta);
        divButton.setForeground(Color.green);
        panel.add(numberButtons[6]);
        numberButtons[6].setOpaque(true);
        numberButtons[6].setBorderPainted(false);
        numberButtons[6].setBackground(Color.black);
        numberButtons[6].setForeground(Color.darkGray);
        panel.add(subButton);
        subButton.setOpaque(true);
        subButton.setBorderPainted(false);
        subButton.setBackground(Color.gray);
        subButton.setForeground(Color.darkGray);

        frame.add(panel);
        frame.add(negButton);
        frame.add(clearButton);
        frame.add(delButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main (String[] args) {

        Calculator TexasInstrument = new Calculator();
    }

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
                    if (num1 == 9 && num2 == 10) {
                        result = 21;
                    } else {
                    result = num1 + num2;
                    }
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

        if (e.getSource() == negButton) {
            double enteredNumber = Double.parseDouble(textField.getText());
            enteredNumber *= -1;
            textField.setText(String.valueOf(enteredNumber));
        }

    }
}
