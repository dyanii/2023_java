package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveCar extends JFrame {
    int img_x = 200, img_y = 100;
    JButton button;
    JButton leftButton, rightButton;

    public MoveCar() {
        setSize(800, 600);

        ImageIcon originalIcon = new ImageIcon("C:/Users/kdaeu/OneDrive/바탕 화면/자동차.jpg");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        button = new JButton("");
        button.setIcon(scaledIcon);

        leftButton = new JButton("LEFT");
        rightButton = new JButton("RIGHT");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);
        panel.add(buttonPanel, BorderLayout.NORTH);

        button.setBounds(img_x, img_y, 200, 100);
        panel.add(button, BorderLayout.CENTER);

        leftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_x -= 20;
                button.setLocation(img_x, img_y);
            }
        });

        rightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_x += 20;
                button.setLocation(img_x, img_y);
            }
        });

        add(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MoveCar();
            }
        });
    }
}

