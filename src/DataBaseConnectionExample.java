
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;



public class DataBaseConnectionExample {

    public static void main(String[] args) {

        try {

            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            String url = "jdbc:mysql://localhost:3306/java_test";
            String username = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");


            //preparing statement
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from student");

            // Create the table model
            DefaultTableModel model = new DefaultTableModel();
            try {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                // Add the column names to the table model
                for (int i = 1; i <= columnCount; i++) {
                    model.addColumn(metaData.getColumnName(i));
                }

                // Add the data to the table model
                while (rs.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        row[i - 1] = rs.getObject(i);
                    }
                    model.addRow(row);
                }
            } catch (SQLException e) {
                System.out.println("Failed to create table model.");
                e.printStackTrace();
                return;
            }

            // Create the table
            JTable table = new JTable(model);

            // Display the table in a scroll pane
            JScrollPane scrollPane = new JScrollPane(table);

            // Show the table in a JFrame
            JFrame frame = new JFrame("Database Table");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(scrollPane);
            frame.pack();
            frame.setVisible(true);
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Error: unable to load driver class!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: unable to establish connection!");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


