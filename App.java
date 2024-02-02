import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class App extends JFrame {

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/project";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "Admin";
    

    private JTextArea outputArea;

    public App() {
        setTitle("Simple JDBC Operations");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

     
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Simple JDBC Operations");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JButton createTableButton = new JButton("Create Table");
        JButton insertDataButton = new JButton("Insert Data");
        JButton deleteDataButton = new JButton("Delete Data");
        JButton updateDataButton = new JButton("Update Data");
        JButton retrieveDataButton = new JButton("Retrieve Data");

        outputArea = new JTextArea(8, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        mainPanel.add(createTableButton, gbc);

        gbc.gridy = 2;
        mainPanel.add(insertDataButton, gbc);

        gbc.gridy = 3;
        mainPanel.add(deleteDataButton, gbc);

        gbc.gridy = 4;
        mainPanel.add(updateDataButton, gbc);

        gbc.gridy = 5;
        mainPanel.add(retrieveDataButton, gbc);

        add(mainPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        createTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCreateTableWindow();
            }
        });

        insertDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openInsertDataWindow();
            }
        });

        deleteDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDeleteDataWindow();
            }
        });

        updateDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openUpdateDataWindow();
            }
        });

        retrieveDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRetrieveDataWindow();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void openCreateTableWindow() {
        new CreateTableWindow();
    }

    private void openInsertDataWindow() {
        new InsertDataWindow();
    }

    private void openDeleteDataWindow() {
        new DeleteDataWindow();
    }

    private void openUpdateDataWindow() {
        new UpdateDataWindow();
    }

    private void openRetrieveDataWindow() {
        new RetrieveDataWindow();
    }

    private void appendOutput(String text) {
        outputArea.append(text + "\n");
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
}
