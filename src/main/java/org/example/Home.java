package org.example;

import javax.swing.*;
import java.sql.*;

public class Home extends JFrame {
    DataBaseConnection con = DataBaseConnection.getInstance();
    private JPanel panel1;
    private JButton button2;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel NameLabel;

    public Home() {
        setTitle("Home Page");
        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        // Button 1 Action: Open MainPage
        button2.addActionListener(e -> {
            String name = textField1.getText();
            String password = String.valueOf(passwordField1.getPassword());
            try {
                ResultSet rs = con.login(name, password);
                if (rs.next()) {
                    int id = rs.getInt("id");
                    new Services(id);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Password or Name", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        new Home(); // Run the Home form
    }

}
