
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class MovieRecommendationSystemExample {
    private JFrame mainFrame;
    private JLabel idLabel;
    private JLabel titleLabel;
    private JLabel genreLabel;
    private JLabel languageLabel;
    private JLabel lengthLabel;
    private JTextField idField;
    private JTextField titleField;
    private JTextField genreField;
    private JTextField languageField;
    private JTextField lengthField;
    private JButton okButton;
    private JButton updateButton;
    private JButton deleteButton;

    public MovieRecommendationSystemExample() {
        prepareGUI();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Movie Rental System");
        mainFrame.setSize(500, 400);
        mainFrame.setLayout(new FlowLayout());

        //fields label
        idLabel = new JLabel("ID: ");
        titleLabel = new JLabel("Title: ");
        genreLabel = new JLabel("Genre: ");
        languageLabel = new JLabel("Language: ");
        lengthLabel = new JLabel("Length: ");

        //text field
        idField = new JTextField(20);
        titleField = new JTextField(20);
        genreField = new JTextField(20);
        languageField = new JTextField(20);
        lengthField = new JTextField(20);
        okButton = new JButton("OK");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        //adding label & fields in frame
        mainFrame.add(idLabel);
        mainFrame.add(idField);
        mainFrame.add(titleLabel);
        mainFrame.add(titleField);
        mainFrame.add(genreLabel);
        mainFrame.add(genreField);
        mainFrame.add(languageLabel);
        mainFrame.add(languageField);
        mainFrame.add(lengthLabel);
        mainFrame.add(lengthField);

        mainFrame.add(okButton);
        mainFrame.add(updateButton);
        mainFrame.add(deleteButton);

        mainFrame.setVisible(true);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertIntoDb();
            }
        });


        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateIntoDb();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFromDb();
            }
        });
    }

    private void insertIntoDb() {
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            String url = "jdbc:mysql://localhost:3306/mrs";
            String username = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, username, password);

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Movie(id, Title, Genre, Language, Length) VALUES(?,?,?,?,?)");
            stmt.setInt(1, Integer.parseInt(idField.getText()));
            stmt.setString(2, titleField.getText());
            stmt.setString(3, genreField.getText());
            stmt.setString(4,languageField.getText());
            stmt.setInt(5,Integer.parseInt(lengthField.getText()));

            if(stmt.executeUpdate() > 0){
                System.out.println("Data successful inserted!");
            }else{
                System.out.println("Data insertion failed");
            }


            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateIntoDb() {
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            String url = "jdbc:mysql://localhost:3306/mrs";
            String username = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, username, password);

            PreparedStatement stmt = conn.prepareStatement("UPDATE Movie SET Title =?,Genre=?,Language=?, Length=? WHERE id=?");
            stmt.setString(1, titleField.getText());
            stmt.setString(2, genreField.getText());
            stmt.setString(3,languageField.getText());
            stmt.setInt(4,Integer.parseInt(lengthField.getText()));
            stmt.setInt(5, Integer.parseInt(idField.getText()));
            stmt.executeUpdate();
            System.out.println("Data updated successful");
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteFromDb() {
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            String url = "jdbc:mysql://localhost:3306/mrs";
            String username = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, username, password);

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Movie WHERE id=?");
            stmt.setInt(1, Integer.parseInt(idField.getText()));
            stmt.executeUpdate();
            System.out.println("Data deleted successful");
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
         new MovieRecommendationSystemExample();
    }
}