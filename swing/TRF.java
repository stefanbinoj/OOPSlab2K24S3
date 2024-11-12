import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TRF extends JFrame implements ActionListener{
    JPanel lpanel;
    JRadioButton red;
    JRadioButton yellow;
    JRadioButton green;

    public TRF(){
        red = new JRadioButton("red");
        yellow = new JRadioButton("Yellow");
        green = new JRadioButton("green");

        ButtonGroup group = new ButtonGroup();
        group.add(red);
        group.add(yellow);
        group.add(green);

        red.addActionListener(this);
        green.addActionListener(this);
        yellow.addActionListener(this);

        JPanel bpanel = new JPanel();
        bpanel.setLayout(new FlowLayout());
        bpanel.add(red);
        bpanel.add(yellow);
        bpanel.add(green);

        lpanel =new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                drawLights(g);
            }
        };

        lpanel.setPreferredSize(new Dimension(300,400));

        //setLayout(new BorderLayout());
        add(bpanel,BorderLayout.SOUTH);
        add(lpanel,BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    void drawLights(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(100,100,30,200);

        g.setColor(red.isSelected() ? Color.RED:Color.GRAY);
        g.fillOval(110,110,20,20);

        g.setColor(green.isSelected() ? Color.GREEN:Color.GRAY);
        g.fillOval(110,140,20,20);

        g.setColor(yellow.isSelected() ? Color.YELLOW:Color.GRAY);
        g.fillOval(110,170,20,20);



    }

    @Override 
    public void actionPerformed(ActionEvent e ){
        lpanel.repaint();
    }

    public static void main (String args[]){
        SwingUtilities.invokeLater(TRF::new);
    }
}