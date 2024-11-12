import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class basic{
    public static void main(String args[]){
        JFrame frame = new JFrame("HEllo world");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,500);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);

    }

    public static void placeComponents(JPanel panel){


        JLabel label = new JLabel("Hey there");
        label.setBounds(100, 60, 200, 50);  // Adjust position
        panel.add(label);

        // Create a JButton and set its position
        JButton button = new JButton("Click Me");
        button.setBounds(100, 120, 100, 25);  // Adjust position to avoid overlap
        panel.add(button);

        // Add ActionListener to the button to change label text when clicked
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("NOOPPPP");
            }
        });
    }
}