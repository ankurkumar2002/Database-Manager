import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class InsertDataWindow extends JFrame {

    private JTextField idField, nameField, ageField;

    public InsertDataWindow() {
        setTitle("Insert Data");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel idLabel = new JLabel("ID:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel ageLabel = new JLabel("Age:");

        idField = new JTextField();
        nameField = new JTextField();
        ageField = new JTextField();

        JButton insertDataButton = new JButton("Insert Data");

        insertDataButton.addActionListener(e -> {
            try (Connection connection = DriverManager.getConnection(App.JDBC_URL, App.USERNAME, App.PASSWORD)) {
                insertData(connection);
                JOptionPane.showMessageDialog(null, "Data inserted successfully.");
                dispose(); 
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error inserting data.");
            }
        });

        add(idLabel);
        add(idField);
        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(new JLabel()); 
        add(insertDataButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void insertData(Connection connection) {
        String insertDataSQL = "INSERT INTO employee (id, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
