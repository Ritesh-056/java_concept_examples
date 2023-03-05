package events;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventExample extends Frame implements KeyListener {

    Frame frame;
    TextField field;

    public KeyEventExample() {
        frame = new Frame("Main Frame for key event");
        frame.setLayout(new FlowLayout());
        field = new TextField(30);
        field.addKeyListener(this);

        frame.setSize(400,540);
        frame.add(field);
        frame.setVisible(true);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        field.setText("On key pressed");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        field.setText("On key typed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        field.setText("On key released");
    }

    public static void main(String[] args) {
        new KeyEventExample();
    }
}
