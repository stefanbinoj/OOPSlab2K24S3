import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Swings {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Hello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(null); // Absolute positioning
        panel.setSize(300, 300);
        frame.add(panel);

        // Add components to the panel
        addComponents(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    public static void addComponents(JPanel panel) {
        // Create the button
        JButton btn = new JButton("Click me");
        btn.setBounds(100, 100, 120, 40); // Position the button inside the panel's bounds
        panel.add(btn);

        // Add action listener to the button
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Change the text of the button when it's clicked
                btn.setText("BRR");
            }
        });
    }
}
