import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class UpdateDataWindow extends JFrame {

    private JTextField idField, nameField, ageField;

    public UpdateDataWindow() {
        setTitle("Update Data");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel idLabel = new JLabel("ID:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel ageLabel = new JLabel("Age:");

        idField = new JTextField();
        nameField = new JTextField();
        ageField = new JTextField();

        JButton updateDataButton = new JButton("Update Data");

        updateDataButton.addActionListener(e -> {
            try (Connection connection = DriverManager.getConnection(App.JDBC_URL, App.USERNAME, App.PASSWORD)) {
                updateData(connection);
                JOptionPane.showMessageDialog(null, "Data updated successfully.");
                dispose(); 
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error updating data.");
            }
        });

        add(idLabel);
        add(idField);
        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(new JLabel()); 
        add(updateDataButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateData(Connection connection) {
        String updateDataSQL = "UPDATE employee SET name = ?, age = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateDataSQL)) {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
