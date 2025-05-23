package org.example;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Deposit extends JFrame {
    DataBaseConnection con = DataBaseConnection.getInstance();
    private JButton DepositButton;
    private JPanel panel1;
    private JTextField textField1;
    private JButton Back;

    public Deposit(int id) {
        setContentPane(panel1);
        setTitle("Deposit Page");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        DepositButton.addActionListener(e -> {
            try {
                try {
                    int amount = Integer.parseInt(textField1.getText());
                    if (amount < 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a positive number");
                    } else {
                        ResultSet rs = con.getById(id);

                        if (rs.next()) {
                            String name = rs.getString("fname");
                            int balance = rs.getInt("balance") + amount;
                            con.updateBalance(id, balance);
                            JOptionPane.showMessageDialog(null, "Updated Balance: " + balance, "Deposit Successful", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                } catch (SQLException ex) {
                    System.out.println("SQL Error: " + ex.getMessage());
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        Back.addActionListener(e -> {
            new Services(id);
            dispose();
        });
    }
}
