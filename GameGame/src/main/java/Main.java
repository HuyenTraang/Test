//import org.example.BallCollision;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.PriorityQueue;
//import java.util.Random;
//
//public class Main extends JPanel implements ActionListener {
//    //static Toolkit toolkit = Toolkit.getDefaultToolkit();
//    //static Dimension screenSize = toolkit.getScreenSize();
//    //public static final int SCREEN_WIDTH = screenSize.width;
//    //public static final int SCREEN_HEIGHT = screenSize.height;
//    static Color color1 = new Color(0xB2263B);
////    static Color color2 = new Color(0xB25026);
////    static Color color3 = new Color(0x83266CB2, true);
////    Ball[] balls = new Ball[10];
////    boolean obstacle[][] = new boolean[Obstacle.SCREEN_WIDTH][Obstacle.SCREEN_HEIGHT];
////    PriorityQueue<Ball> priorityQueue = new PriorityQueue<>();
//    public Main()
//    {
////        Ball.setObstacles(Utility.StringToBoolean2D("Wall_Rectangle"));
////        for(Ball i : balls)
////        {
////            i = new Ball();
////            priorityQueue.add(i);
////        }
//        Timer timer = new Timer(Obstacle.TIME_DELAY, this);
//        timer.start();
//    }
//    @Override
//    public void paintComponents(Graphics g) {
//        //Draw Ball
////        for(Ball i : balls)
////        {
////            g.setColor(i.getColor());
////            g.fillOval(i.getX(),i.getY(),i.getRadius(),i.getRadius());
////        }
//        super.paintComponents(g);
//        g.setColor(Color.RED);
//        g.fillOval(50,50,20,20);
//    }
//
//    public static void main(String[] args)
//    {
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        frame.getContentPane().add(new Main());
//        frame.pack();
//        frame.setSize(Obstacle.SCREEN_WIDTH, Obstacle.SCREEN_HEIGHT);
//        frame.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
//}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

public class Main extends JPanel implements ActionListener {
    public static int Ball_count = 1;
    Ball[] balls = new Ball[Ball_count];
    PriorityQueue<Ball> priorityQueue = new PriorityQueue<>();
    static Color color1 = new Color(0xB2263B);
    public Main()
    {
        Ball.setObstacles(Utility.StringToBoolean2D("Wall_Rectangle"));
        for(int i = 0; i < Ball_count; i++)
        {
            balls[i] = new Ball(new Point(150,150),20,new Vector(5,5),Color.RED);
            priorityQueue.add(balls[i]);
        }
        Timer timer = new Timer(Obstacle.TIME_DELAY, this);
        Ball.TIME = 0;
        timer.start();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(int i = 0; i < Ball_count; i++)
        {
            g.setColor(Color.RED);
            g.fillOval(balls[i].getX(),balls[i].getY(),balls[i].getRadius(),balls[i].getRadius());
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new Main());
        frame.pack();
        frame.setSize(600, 800);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(Ball ball : balls)
        {
            ball.move();
            ball.collision();
        }
        Ball.TIME += Obstacle.TIME_DELAY;
        repaint();
    }
}


