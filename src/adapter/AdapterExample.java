package adapter;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdapterExample {
    Frame frame ;

    public AdapterExample(){
        frame = new Frame("Window adapter");
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                frame.dispose();
            }
        });
        frame.setSize(500,500);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        new AdapterExample();
    }
}
