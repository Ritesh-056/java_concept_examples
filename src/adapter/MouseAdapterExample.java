package adapter;

import java.awt.*;
import java.awt.event.*;

public class MouseAdapterExample extends MouseAdapter {
    Frame frame;
    public MouseAdapterExample() {
        frame = new Frame("Mouse Adapter");
        frame.addMouseListener(this);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                super.windowClosing(e);
            }
        });
    }

    public void mouseClicked(MouseEvent e){
        Graphics g = frame.getGraphics();
        g.setColor(Color.BLUE);
        g.fillOval(e.getX(),e.getY(),30,30);
    }

    public  static  void main(String[] args){
        new MouseAdapterExample();
    }
}
