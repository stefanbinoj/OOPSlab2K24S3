import javax.swing.*;
import java.awt.*;

public class ShapesExample extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Always call the super method first
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smoother graphics
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw a blue line
        g2d.setColor(Color.BLUE);
        g2d.drawLine(10, 10, 200, 10);

        // Draw a red rectangle (outline) and filled red rectangle
        g2d.setColor(Color.RED);
        g2d.drawRect(10, 30, 100, 50);
        g2d.fillRect(120, 30, 100, 50);

        // Draw a green oval (outline) and filled green oval
        g2d.setColor(Color.GREEN);
        g2d.drawOval(10, 90, 100, 50);
        g2d.fillOval(120, 90, 100, 50);

        // Draw an orange arc (outline) and filled arc (half circle)
        g2d.setColor(Color.ORANGE);
        g2d.drawArc(10, 150, 100, 100, 0, 180);
        g2d.fillArc(120, 150, 100, 100, 0, 180);

        // Draw a magenta triangle (outline) and filled magenta triangle
        int[] xPoints = {10, 60, 110};
        int[] yPoints = {300, 250, 300};
        g2d.setColor(Color.MAGENTA);
        g2d.drawPolygon(xPoints, yPoints, 3);
        g2d.fillPolygon(new int[]{120, 170, 220}, new int[]{300, 250, 300}, 3);

        // Draw a cyan round rectangle (outline) and filled round rectangle
        g2d.setColor(Color.CYAN);
        g2d.drawRoundRect(10, 320, 100, 50, 20, 20);
        g2d.fillRoundRect(120, 320, 100, 50, 20, 20);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Shapes Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);  // Set the size of the window
        frame.add(new ShapesExample());  // Add the ShapesExample panel
        frame.setVisible(true);  // Make the frame visible
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShapesExample::createAndShowGUI);  // Safe GUI update on the EDT
    }
}
