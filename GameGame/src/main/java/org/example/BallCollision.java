package org.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BallCollision extends JPanel implements ActionListener {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BALL_COUNT = 10;
    private static final int BALL_RADIUS = 10;
    private static final int WALL_THICKNESS = 20;

    private Rectangle[] walls = new Rectangle[4];
    private Ball[] balls = new Ball[BALL_COUNT];

    private Timer timer;

    public BallCollision() {

        // Create walls
        walls[0] = new Rectangle(0, 0, WIDTH, WALL_THICKNESS);
        walls[1] = new Rectangle(0, 0, WALL_THICKNESS, HEIGHT);
        walls[2] = new Rectangle(WIDTH - WALL_THICKNESS, 0, WALL_THICKNESS, HEIGHT);
        walls[3] = new Rectangle(0, HEIGHT - WALL_THICKNESS, WIDTH, WALL_THICKNESS);

        // Create balls
        Random random = new Random();
        for (int i = 0; i < BALL_COUNT; i++) {
            int x = random.nextInt(WIDTH - BALL_RADIUS * 2) + BALL_RADIUS;
            int y = random.nextInt(HEIGHT - BALL_RADIUS * 2) + BALL_RADIUS;
            int xSpeed = random.nextInt(10) - 5; // Random speed between -5 and 5
            int ySpeed = random.nextInt(10) - 5;
            balls[i] = new Ball(x, y, BALL_RADIUS, xSpeed, ySpeed);
        }

        // Start timer to update ball positions
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw walls
        g.setColor(Color.GRAY);
        for (Rectangle wall : walls) {
            g.fillRect(wall.x, wall.y, wall.width, wall.height);
        }

        // Draw balls
        g.setColor(Color.RED);
        for (Ball ball : balls) {
            g.fillOval(ball.x - ball.radius, ball.y - ball.radius, ball.radius * 2, ball.radius * 2);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update ball positions
        for (Ball ball : balls) {
            ball.x += ball.xSpeed;
            ball.y += ball.ySpeed;

            // Check collision with walls
            for (Rectangle wall : walls) {
                if (ball.intersects(wall)) {
                    if (wall == walls[0] || wall == walls[3]) {
                        ball.ySpeed = -ball.ySpeed;
                    } else {
                        ball.xSpeed = -ball.xSpeed;
                    }
                }
            }
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ball Collision");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new BallCollision());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static class Ball extends Rectangle {
        private int xSpeed;
        private int ySpeed;
        private int radius;

        public Ball(int x, int y, int radius, int xSpeed, int ySpeed) {
            super(x, y, radius * 2, radius * 2);
            this.xSpeed = xSpeed;
            this.ySpeed = ySpeed;
            this.radius = radius;
        }
    }
}