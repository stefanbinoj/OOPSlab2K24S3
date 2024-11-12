import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class add extends JFrame implements ActionListener{
    JTextField f1;
    JTextField f2;
    int n1,n2,result;
    JButton btn ;
    JLabel label;

    public add(){
        f1=new JTextField("Number1");
        f2=new JTextField("NUmber 2 ");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());  // FlowLayout for better component alignment

         panel.add(new JLabel("Number 1:"));  // Add label for the first text field
        panel.add(f1);
        panel.add(new JLabel("Number 2:"));  // Add label for the second text field
        panel.add(f2);

        setLayout(new BorderLayout());
        add(panel,BorderLayout.NORTH);

        

        btn = new JButton("Add");
        add(btn,BorderLayout.CENTER);
        btn.addActionListener(this);

         label = new JLabel("sum");
        add(label,BorderLayout.SOUTH);
        setSize(300, 200);

        pack();
        setVisible(true);
        

    }
    @Override

    public void actionPerformed(ActionEvent e ){
        String num1 ;
        String num2;
        num1=f1.getText();
        num2 = f2.getText();

        n1=Integer.parseInt(num1);
        n2=Integer.parseInt(num2);

        result=n1+n2;

        label.setText(String.valueOf(result));



        
    }
    public static void main(String args[]){
        SwingUtilities.invokeLater(add::new);
    }
}