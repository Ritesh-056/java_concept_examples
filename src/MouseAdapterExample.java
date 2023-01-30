import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseAdapterExample  extends MouseAdapter {
    Frame frame;

    MouseAdapterExample(){

        frame =new Frame("Mouse adapter");
        frame.addMouseListener(this);
        frame.setSize(300,300);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public  void mouseClicked(MouseEvent event){
        Graphics g= frame.getGraphics();
        g.setColor(Color.red);
        g.fillOval(event.getX(),event.getY(),30,30);
    }

    public static void main(String[] args) {
        new MouseAdapterExample();
    }
}
