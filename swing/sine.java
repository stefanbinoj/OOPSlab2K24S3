import javax.swing.*;
import java.awt.*;

public class sine extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSineWave(g);
    }

    private void drawSineWave(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLUE);

        int width = getWidth();
        int height = getHeight();
        int midY = height / 2;

        double frequency = 16 * Math.PI / width;
        int amplitude = height / 4;

        int prevX = 0;
        int prevY = midY;

        for (int x = 1; x < width; x++) {
            int y = (int) (midY + amplitude * Math.sin(frequency * x));
            g2d.drawLine(prevX, prevY, x, y);
            prevX = x;
            prevY = y;
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Sine Wave Plot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new SineWavePlot());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SineWavePlot::createAndShowGUI);
    }
}