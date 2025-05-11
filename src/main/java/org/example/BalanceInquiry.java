package org.example;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceInquiry extends JFrame {
    DataBaseConnection con = DataBaseConnection.getInstance();
    private JButton Back;
    private JTextField PhoneField;
    private JTextField BalanceField;
    private JTextField NameField;
    private JPanel panel1;

    public BalanceInquiry(int id) {
        setContentPane(panel1);
        setTitle("BalanceInquiry Page");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        try {
            ResultSet rs = con.getById(id);

            if (rs.next()) {
                String name = rs.getString("fname") + " " + rs.getString("lname");
                String phone = rs.getString("phone_num");
                String balance = rs.getString("balance");

                PhoneField.setText(phone);
                BalanceField.setText(balance);
                NameField.setText(name);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        Back.addActionListener(e -> {
            new Services(id);
            dispose();
        });
    }
}
