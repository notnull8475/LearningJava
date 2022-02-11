package ru.geekbrains.lesson_8;

import javax.swing.*;
import java.awt.*;

public class CounterApp extends JFrame {
    private int value;

    public CounterApp(int initialValue) {
        setBounds(500, 500, 300, 120);
        setTitle("Simple Counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Font font = new Font("Arial", Font.BOLD, 32);

        JTextField counterValueView = new JTextField();
        counterValueView.setFont(font);
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
        add(counterValueView, BorderLayout.CENTER);

        value = initialValue;
        counterValueView.setText(String.valueOf(value));

        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        add(decrementButton, BorderLayout.WEST);

        JButton incrementButton = new JButton(">");
        incrementButton.setFont(font);
        add(incrementButton, BorderLayout.EAST);

        counterValueView.addActionListener(e -> {
            try {
                int temp = Integer.parseInt(counterValueView.getText());
                value = temp;
            } catch (NumberFormatException a) {
                value = 0;
                counterValueView.setText(String.valueOf(value));
            }
        });

        decrementButton.addActionListener(e -> {
            value--;
            counterValueView.setText(String.valueOf(value));
        });

        incrementButton.addActionListener(actionEvent -> {
            value++;
            counterValueView.setText(String.valueOf(value));
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CounterApp(0);
    }
}
