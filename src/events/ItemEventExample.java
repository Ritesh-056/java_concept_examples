package events;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemEventExample extends Frame implements ItemListener {

    Frame frame;
    Checkbox checkbox1,checkbox2;

    public ItemEventExample(){
    frame = new Frame("My checkbox frame");

    checkbox1 = new Checkbox("C++ ");
    checkbox2 = new Checkbox("JavaScript");

    frame.add(checkbox1);
    frame.add(checkbox2);

    checkbox1.addItemListener(this);
    checkbox2.addItemListener(this);

    frame.setLayout(new FlowLayout());
    frame.setSize(500,550);
    frame.setVisible(true);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == checkbox1){
            System.out.println(e.getItem().toString());
        }
        if(e.getSource() == checkbox2){
            System.out.println(e.getItem().toString());
        }

    }


    public static void main(String[] args) {
       new ItemEventExample();
    }

}
