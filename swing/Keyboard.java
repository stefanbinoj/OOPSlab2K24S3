import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Keyboard{
    public static void main(String args[]){
        JFrame frame = new JFrame("hey");
        frame.setSize(499,5000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel label=new JLabel("hii");
        label.setBounds(300,300,90,90);
        panel.add(label);

        frame.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e ){
                label.setText("pressed "+e.getKeyCode());
            }
        });
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e ){
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }
}