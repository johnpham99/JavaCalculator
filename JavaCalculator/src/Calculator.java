import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] operationButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equalButton, delButton, clearButton;
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

        operationButtons[0] = addButton;
        operationButtons[1] = subButton;
        operationButtons[2] = mulButton;
        operationButtons[3] = divButton;
        operationButtons[4] = decButton;
        operationButtons[5] = equalButton;
        operationButtons[6] = clearButton;
        operationButtons[7] = delButton;

        for (int i = 0; i < 8; i++) {
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
        panel.add(numberButtons[2]);
        panel.add(mulButton);
        panel.add(numberButtons[0]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[4]);
        panel.add(divButton);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        frame.add(panel);
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

    }
}