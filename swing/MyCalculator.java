import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyCalculator extends JFrame implements ActionListener{
    double n1,n2,result;
    char op;
    JTextField field = null;

    public MyCalculator(){
        field = new JTextField();
        field.setEditable(false);
        add(field,BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4,5,5));
        add(panel,BorderLayout.CENTER);

        String [] btnlabels ={
            "9","8","7",
            "6","5","4","C",
            "3","2","1","=",
            "0","/","*","+"
        };

        for(String l : btnlabels){
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
        String command = e.getActionCommand();
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
                case '/':

                    if(n2==0){
                        throw new ArithmeticException ("zero division");

                    }
                    result=n1/n2;
                    break;
            } 
            field.setText(String.valueOf(result));
            }catch(ArithmeticException a ){
                field.setText("Got error "+a.getMessage());
            }
        }
        else{
            
                try {
                if (field.getText().isEmpty()) {
                    return;  // Ignore if no number is entered yet
                }
                n1 = Double.parseDouble(field.getText());  // Store the first operand
                op = command.charAt(0);  // Store the operator
                field.setText("");  // Clear the field for the second operand
            } catch (NumberFormatException ex) {
                field.setText("Invalid input");
            }
            
        }
    }

    public static void main(String args[]){
        SwingUtilities.invokeLater(MyCalculator::new);
    }
}