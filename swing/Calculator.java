import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Calculator extends JFrame implements ActionListener {
    private double n1, n2, result;
    private char operator;
    private JTextField display;

    public Calculator() {
        // Set up the display area
        display = new JTextField();
        display.setEditable(false);  // Make the display non-editable
        display.setFont(new Font("Arial", Font.BOLD, 24));  // Set a readable font

        // Add the display area to the top of the frame
        add(display, BorderLayout.NORTH);

        // Set up the panel with buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));
        add(panel, BorderLayout.CENTER);

        // Button labels for the calculator
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        // Add buttons to the panel
        for (String s : buttonLabels) {
            JButton btn = new JButton(s);
            btn.addActionListener(this);
            panel.add(btn);
        }

        // Frame setup
        setTitle("Simple Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Action handler for button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // If the command is a number, append it to the display
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            display.setText(display.getText() + command);
        }
        // If the command is 'C', clear the display
        else if (command.equals("C")) {
            display.setText("");
        }
        // If the command is '=', perform the calculation
        else if (command.equals("=")) {
            try {
                n2 = Double.parseDouble(display.getText());  // Get the second number
                switch (operator) {
                    case '+':
                        result = n1 + n2;
                        break;
                    case '-':
                        result = n1 - n2;
                        break;
                    case '*':
                        result = n1 * n2;
                        break;
                    case '/':
                        if (n2 == 0) {
                            throw new ArithmeticException("Cannot divide by zero");
                        }
                        result = n1 / n2;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected operator: " + operator);
                }
                display.setText(String.valueOf(result));  // Display the result
            } catch (ArithmeticException ex) {
                display.setText("Error: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                display.setText("Invalid input");
            }
        }
        // For all other operators (+, -, *, /), save the operator and first number
        else {
            try {
                n1 = Double.parseDouble(display.getText());  // Get the first number
                operator = command.charAt(0);  // Set the operator
                display.setText("");  // Clear the display for the second number
            } catch (NumberFormatException ex) {
                display.setText("Invalid input");
            }
        }
    }

    public static void main(String[] args) {
        // Create the Calculator object on the Event Dispatch Thread
        SwingUtilities.invokeLater(Calculator::new);
    }
}
