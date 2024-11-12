import java.awt.*;
import java.awt.event.*;

class Mouse{
    public static void main(String args[]){
        Frame frame = new Frame("Mouse egg");
        frame.setSize(400,400);
        frame.setLayout(null);

        Label l = new Label("click");
        l.setBounds(200,200,500,200);
        frame.add(l);

        frame.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e ){
                l.setText("You clicked on "+e.getX()+" "+e.getY());
            }
        });

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    frame.setVisible(true);
    }
}   