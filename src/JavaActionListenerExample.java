import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaActionListenerExample extends Frame implements ActionListener {

    TextField textField;
    public JavaActionListenerExample(){
        textField = new TextField(30);
        Button btn  = new Button("Click me please");
        btn.setBounds(60,50,170,20);
        btn.addActionListener(this);
        add(btn);
        add(textField);
        setSize(300,300);
        setLayout(new FlowLayout());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textField.setText("Welcome to java application action handler event");
        dispose();
    }


    public static void main(String[] args) {
        new JavaActionListenerExample();
    }
}
