import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEventExample extends Frame implements ActionListener {
    TextField textField;

    AddEventExample(){
        textField = new TextField();
        textField.setBounds(60,50,170,20);
        Button button = new Button("Click Me");
        button.setBounds(100,120,80,30);
        button.addActionListener(this);
        add(button);
        add(textField);

        setSize(500,500);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textField.setText("I am changed By button");
    }


    public static void main(String[] args) {
        new AddEventExample();
    }
}
