import javax.swing.*;
import java.awt.*;

public class shapes extends JFrame{
    shapes(){
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void paint(Graphics g){
        g.drawOval(60,60,30,50);
        g.drawRect(40,30,40,60);
        g.drawRect(80, 30, 200, 200); // Square
        g.drawRect(200, 100, 100, 200); // Rectangle
        g.drawString("Drawing shapes", 10, 10);
        setBackground(Color.WHITE);
        g.fillRect(130, 30, 100, 80); // Rectangle
        g.drawOval(30, 130, 50, 60); // Circle
        setForeground(Color.RED);
        g.fillOval(130, 130, 50, 60); // Filled Circle
        g.drawArc(30, 200, 40, 50, 90, 60); // Arc
        g.fillArc(30, 130, 40, 50, 180, 40); // Filled Arc

    }

    public static void main(String[] args) {
        new shapes();
    }
}