import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class RetrieveDataWindow extends JFrame {

    public RetrieveDataWindow() {
        setTitle("Retrieve Data");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea outputArea = new JTextArea(8, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JButton retrieveDataButton = new JButton("Retrieve Data");

        retrieveDataButton.addActionListener(e -> {
            try (Connection connection = DriverManager.getConnection(App.JDBC_URL, App.USERNAME, App.PASSWORD)) {
                retrieveData(connection, outputArea);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error retrieving data.");
            }
        });

        add(retrieveDataButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void retrieveData(Connection connection, JTextArea outputArea) {
        String retrieveDataSQL = "SELECT * FROM employee";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(retrieveDataSQL)) {

            outputArea.setText("Retrieving and printing data from the table:\n");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                outputArea.append("ID: " + id + ", Name: " + name + ", Age: " + age + "\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
