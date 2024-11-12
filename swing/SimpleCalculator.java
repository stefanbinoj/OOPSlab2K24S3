import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SimpleCalculator extends JFrame implements ActionListener{
    double n1,n2,result;
    char op;
    JTextField field;

    public SimpleCalculator(){
        field = new JTextField();
        field.setEditable(false);

        add(field,BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4,5,5));
        add(panel,BorderLayout.CENTER);

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for(String l : buttonLabels){
            JButton btn = new JButton(l);
            btn.addActionListener(this);
            panel.add(btn);
        }

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
        @Override
        public void actionPerformed(ActionEvent e ){
            String command=e.getActionCommand();

            if(command.charAt(0)>='0' && command.charAt(0)<='9'){
                field.setText(field.getText()+command);
            }
            else if(command.charAt(0)=='C'){
                field.setText("");
            }
            else if(command.charAt(0)=='='){
                try{
                n2=Double.parseDouble(field.getText());
                switch(op){
                    case '+':
                        result=n1+n2;
                        break;
                    case '-':
                        result=n1-n2;
                        break;
                    case '*':
                        result=n1*n2;
                        break;
                    case '/':
                        if(n2==0){
                            throw new ArithmeticException("division by zero");
                        }
                        result=n1/n2;
                        break;
                    
                }
                field.setText(String.valueOf(result));
                } catch (ArithmeticException ex) {
                field.setText("Error: " + ex.getMessage());
            }
            }
            else {
            try {
                n1 = Double.parseDouble(field.getText());  // Get the first number
                op = command.charAt(0);  // Set the operator
                field.setText("");  // Clear the display for the second number
            } catch (NumberFormatException ex) {
                field.setText("Invalid input");
            }
        }
        }

    
    public static void main (String args[]){
        SwingUtilities.invokeLater(SimpleCalculator::new);
    }
}
