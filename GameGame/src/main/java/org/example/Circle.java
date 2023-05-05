package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Circle extends JPanel implements ActionListener {
    static Color color1 = new Color(0xB2263B);
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(color1);
        g.fillOval(50,50,20,20);
    }
    public Circle()
    {
        Timer timer = new Timer(10, this);
        timer.start();
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new Circle());
        frame.pack();
        frame.setSize(600, 800);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
