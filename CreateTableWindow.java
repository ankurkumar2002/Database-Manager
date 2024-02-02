import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class CreateTableWindow extends JFrame {
    

    public CreateTableWindow() {
        setTitle("Create Table");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea outputArea = new JTextArea(5, 20);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JButton createTableButton = new JButton("Create Table");

        createTableButton.addActionListener(e -> {
            try (Connection connection = DriverManager.getConnection(App.JDBC_URL, App.USERNAME, App.PASSWORD)) {
                createTable(connection);
                outputArea.setText("Table created successfully.");
            } catch (SQLException ex) {
                ex.printStackTrace();
                outputArea.setText("Error creating table.");
            }
        });

        add(createTableButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createTable(Connection connection) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS employee (id INT PRIMARY KEY UNIQUE, name VARCHAR(50), age INT)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
