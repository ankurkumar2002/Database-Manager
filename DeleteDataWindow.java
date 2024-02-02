import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class DeleteDataWindow extends JFrame {

    private JTextField idField;

    public DeleteDataWindow() {
        setTitle("Delete Data");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 10, 10));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();

        JButton deleteDataButton = new JButton("Delete Data");

        deleteDataButton.addActionListener(e -> {
            try (Connection connection = DriverManager.getConnection(App.JDBC_URL, App.USERNAME, App.PASSWORD)) {
                deleteData(connection);
                JOptionPane.showMessageDialog(null, "Data deleted successfully.");
                dispose(); 
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error deleting data.");
            }
        });

        add(idLabel);
        add(idField);
        add(new JLabel()); 
        add(deleteDataButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void deleteData(Connection connection) {
        String deleteDataSQL = "DELETE FROM employee WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteDataSQL)) {
            int id = Integer.parseInt(idField.getText());
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
