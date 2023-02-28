import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class JavaTestForExam {

    JFrame myframe;
    JLabel idLabel;
    JLabel nameLabel;
    JLabel ageLabel;

    JTextField idTextField;
    JTextField nameTextField;
    JTextField ageTextField;

    JButton getButton;
    JButton setButton;

    JTextPane jTextPane;

    public JavaTestForExam() {
        myframe = new JFrame("Database Action frame");
        myframe.setSize(500, 500);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setLayout(new FlowLayout());

        idLabel = new JLabel("ID");
        idTextField = new JTextField(20);


        nameLabel = new JLabel("Name");
        nameTextField = new JTextField(20);


        ageLabel = new JLabel("AGE");
        ageTextField = new JTextField(20);


        getButton  = new JButton("get data");
        setButton = new JButton("set data");

        jTextPane = new JTextPane();

        myframe.add(idLabel);
        myframe.add(idTextField);
        myframe.add(nameLabel);
        myframe.add(nameTextField);
        myframe.add(ageLabel);
        myframe.add(ageTextField);
        myframe.add(getButton);
        myframe.add(setButton);
        myframe.add(jTextPane);



        myframe.setVisible(true);


        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setStudentData();
            }
        });


        getButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                getStudentData();
            }
        });
    }


    private  void setStudentData(){
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/java_test";
            String username ="root";
            String pass ="";

            Connection conn = DriverManager.getConnection(url,username,pass);
            PreparedStatement statement = conn.prepareStatement("INSERT INTO student(id,name,age) VALUES(?,?,?)");
            statement.setInt(1, Integer.parseInt(idTextField.getText()));
            statement.setString(2,nameTextField.getText());
            statement.setInt(3,Integer.parseInt(ageTextField.getText()));


            statement.executeUpdate();
            System.out.println("Data added successful");

            statement.close();
            conn.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void getStudentData(){

        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            String url = "jdbc:mysql://localhost:3306/java_test";
            String username ="root";
            String password ="";
            Connection conn = DriverManager.getConnection(url,username,password);

            Statement statement = conn.createStatement();
            String query = "select * from student";
            ResultSet rs = statement.executeQuery(query);

            String data="";
            while(rs.next()){
             String result = "ID: "+rs.getInt(1)+"Name: "+rs.getString(2)+"Age: "+rs.getInt(3);
             data +=result;
            }
            jTextPane.setText(data);

            statement.close();
            conn.close();
        }catch (ClassNotFoundException e){
            System.out.println("Class not found exception");
            e.printStackTrace();
        }catch(SQLException e){
            System.out.println("SQL exception");

            e.printStackTrace();
        }catch (Exception e){
            System.out.println(" exception");

            e.printStackTrace();

        }


    }


    public static void main(String[] args) {
        new JavaTestForExam();
    }

}
