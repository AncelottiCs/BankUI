package org.example;

import javax.swing.*;

public class Services extends JFrame {
    private JButton withDrawButton;
    private JButton DepositButton;
    private JButton balanceInquiryButton;
    private JButton currencyExchangeButton;
    private JPanel panel1;
    private JButton Logout;

    public Services(int id) {
        setTitle("Services Page");
        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        withDrawButton.addActionListener(e -> {
            new WithDraw(id);
            dispose();
        });

        Logout.addActionListener(e -> {
            new Home();
            dispose();
        });

        DepositButton.addActionListener(e -> {
            new Deposit(id);
            dispose();
        });
        balanceInquiryButton.addActionListener(e -> {
            new BalanceInquiry(id);
            dispose();
        });

        currencyExchangeButton.addActionListener(e -> {
            new CurrencyExchange(id);
            dispose();
        });
    }
}
