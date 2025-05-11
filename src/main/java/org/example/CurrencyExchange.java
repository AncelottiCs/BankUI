package org.example;

import javax.swing.*;

public class CurrencyExchange extends JFrame {
    private JRadioButton InputYUANButton;
    private JRadioButton InputUSDButton;
    private JRadioButton InputJDButton;
    private JRadioButton InputARSButton;
    private JTextField outputField;
    private JTextField inputField;
    private JRadioButton OutputJDButton;
    private JRadioButton ARSOutputButton;
    private JRadioButton USDOutputButton;
    private JRadioButton YUANOutputButton;
    private JPanel panel1;
    private JButton convertButton;
    private JButton Back;

    public CurrencyExchange(int id) {
        setTitle("Currency Exchange Page");
        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        ButtonGroup buttonGroupInput = new ButtonGroup();
        buttonGroupInput.add(InputYUANButton);
        buttonGroupInput.add(InputUSDButton);
        buttonGroupInput.add(InputJDButton);
        buttonGroupInput.add(InputARSButton);

        ButtonGroup buttonGroupOutput = new ButtonGroup();
        buttonGroupOutput.add(OutputJDButton);
        buttonGroupOutput.add(ARSOutputButton);
        buttonGroupOutput.add(USDOutputButton);
        buttonGroupOutput.add(YUANOutputButton);

        convertButton.addActionListener(e -> convertCurrency());

        Back.addActionListener(e -> {
            new Services(id);
            dispose();
        });
    }

    private void convertCurrency() {
        try {
            float inputAmount = Float.parseFloat(inputField.getText());
            float toUSD = 0;
            float outputAmount;

            // Convert input currency to USD
            if (InputUSDButton.isSelected()) {
                toUSD = inputAmount;
            } else if (InputYUANButton.isSelected()) {
                toUSD = inputAmount * 0.14f;
            } else if (InputJDButton.isSelected()) {
                toUSD = inputAmount * 1.41f;
            } else if (InputARSButton.isSelected()) {
                toUSD = inputAmount * 0.00089f;
            }

            // Convert USD to output currency
            if (USDOutputButton.isSelected()) {
                outputAmount = toUSD;
            } else if (YUANOutputButton.isSelected()) {
                outputAmount = toUSD / 0.14f;
            } else if (OutputJDButton.isSelected()) {
                outputAmount = toUSD / 1.41f;
            } else if (ARSOutputButton.isSelected()) {
                outputAmount = toUSD / 0.00089f;
            } else {
                outputAmount = 0;
            }

            outputField.setText(String.format("%.2f", outputAmount));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
