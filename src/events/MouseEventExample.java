package events;

import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventExample extends Frame implements MouseListener {
    Frame frame;
    TextField field ;
    public MouseEventExample() {
        frame = new Frame("Mouse event frame");
        field = new TextField(30);
        frame.addMouseListener(this);
        frame.add(field);
        frame.setSize(400,400);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        field.setText("Mouse clicked event");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        field.setText("Mouse pressed event");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        field.setText("Mouse released event");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        field.setText("Mouse entered event");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        field.setText("Mouse exited event");
    }

    public static void main(String[] args) {
        new MouseEventExample();
    }
}
