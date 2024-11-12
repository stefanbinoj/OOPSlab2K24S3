import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Traffic extends JFrame implements ActionListener{
    JRadioButton red;
    JRadioButton yellow;
    JRadioButton green;
    JPanel lpanel;

    public Traffic(){
        red = new JRadioButton("red");
        green = new JRadioButton("green");
        yellow = new JRadioButton("ywlloq");

        ButtonGroup group = new ButtonGroup();
        group.add(red);
        group.add(yellow);
        group.add(green);

        red.addActionListener(this);
        yellow.addActionListener(this);
        green.addActionListener(this);

        JPanel bpanel = new JPanel();
        bpanel.setLayout(new FlowLayout());
        bpanel.add(red);
        bpanel.add(yellow);
        bpanel.add(green);

         lpanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                drawLights(g);
            }
        };
        lpanel.setPreferredSize(new Dimension(100,300));

        setLayout(new BorderLayout());
        add(bpanel,BorderLayout.SOUTH);
        add(lpanel,BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);


    }
    void drawLights(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(30,30,40,200);

        g.setColor(red.isSelected() ? Color.RED : Color.GRAY);
        g.fillOval(40,40,20,20);

        g.setColor(yellow.isSelected() ? Color.YELLOW : Color.GRAY);
        g.fillOval(40,100,20,20);

        g.setColor(green.isSelected() ? Color.GREEN : Color.GRAY);
        g.fillOval(40,140,20,20);

        

        
    }
      @Override
    public void actionPerformed(ActionEvent e) {
        // Repaint the light panel when a button is pressed
        lpanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Traffic::new);
    }

}