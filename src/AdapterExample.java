import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdapterExample {
 Frame frame;


 AdapterExample(){
     frame=new Frame("Window Adapter");
     frame.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
             frame.dispose();
             super.windowClosing(e);
         }
     });
     frame.setSize(400,400);
     frame.setLayout(null);
     frame.setVisible(true);

 }

    public static void main(String[] args) {
        new AdapterExample();
    }
}
