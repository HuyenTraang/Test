
import java.awt.*;

import java.util.Random;


public class Ball implements Comparable<Ball>,Obstacle {
    private Point point;
    private int radius;
    private Vector vector;
    private Color color;
    private int timeCollision;
    private Line line;
    private static boolean[][] obstacles = null;
    public static int TIME;
    private Point pointCollision;
    public Ball(Point point, int radius,Vector vector,Color color)
    {
        this.point = point;
        this.radius = radius;
        this.vector = vector;
        this.color = color;
        timeCollision = (int)10e8;
        line = new Line(point,vector);
        pointCollision = new Point(0,0);
        setTimeCollision();
    }
    public Ball()
    {
        Random random = new Random();
        this.point = new Point();
        this.radius = 20;
        this.vector = new Vector();
        this.color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
        pointCollision = new Point(0,0);
        timeCollision = (int)10e8;
        line = new Line(point,vector);
        setTimeCollision();
    }
    public int getTimeCollision()
    {
        return timeCollision;
    }
    public static void setObstacles(boolean[][] obstacles)
    {
        if(Ball.obstacles == null)
        {
            Ball.obstacles = obstacles;
        }
    }

    public void setTimeCollision()
    {
        for(int i = point.getX();i >= 0 && i <=SCREEN_WIDTH; i += Math.signum(vector.getX()))
        {
            if(line.getY(i)>=0 && line.getY(i)<= SCREEN_HEIGHT)
            {
                if(obstacles[i][line.getY(i)])
                {
                    pointCollision.setVector(i,line.getY(i));
                    break;
                }
            }
        }
        timeCollision = TIME + (int)Math.floor(point.distance(pointCollision)/vector.getSize());
    }

    public Line collision()
    {
        Line lineCollision = null;
        //change vector, timeCollision, line,pointCollision
        if(true) {
            if (obstacles[Math.max(pointCollision.getX() - 1, 0)][pointCollision.getY()])

                lineCollision = new Line(pointCollision, new Point(Math.max(pointCollision.getX() - 1, 0), pointCollision.getY()));

            else if(obstacles[Math.min(pointCollision.getX() + 1, Obstacle.SCREEN_WIDTH)][pointCollision.getY()])

                lineCollision = new Line(pointCollision,new Point(Math.min(pointCollision.getX() + 1, Obstacle.SCREEN_WIDTH),pointCollision.getY()));//ok

            else if(obstacles[Math.max(pointCollision.getX() - 1, 0)][Math.max(pointCollision.getY() - 1, 0)])

                lineCollision = new Line(pointCollision,new Point(Math.max(pointCollision.getX() - 1, 0),Math.max(pointCollision.getY() - 1, 0)));//ok

            else if(obstacles[Math.min(pointCollision.getX() + 1, Obstacle.SCREEN_WIDTH)][Math.max(pointCollision.getY() - 1, 0)])

                lineCollision = new Line(pointCollision,new Point(Math.min(pointCollision.getX() + 1, Obstacle.SCREEN_WIDTH),Math.max(pointCollision.getY() - 1, 0)));//ok

            else if(obstacles[Math.max(pointCollision.getX() - 1, 0)][Math.min(pointCollision.getY()+1,Obstacle.SCREEN_HEIGHT)])

                lineCollision = new Line(pointCollision,new Point(Math.max(pointCollision.getX() - 1, 0),Math.min(pointCollision.getY()+1,Obstacle.SCREEN_HEIGHT)));

            else if(obstacles[Math.min(pointCollision.getX() + 1, Obstacle.SCREEN_WIDTH)][Math.min(pointCollision.getY()+1,Obstacle.SCREEN_HEIGHT)])

                lineCollision = new Line(pointCollision,new Point(Math.min(pointCollision.getX() + 1, Obstacle.SCREEN_WIDTH),Math.min(pointCollision.getY()+1,Obstacle.SCREEN_HEIGHT)));

            else if(obstacles[pointCollision.getX()][Math.max(pointCollision.getY() - 1, 0)])

                lineCollision = new Line(pointCollision,new Point(pointCollision.getX(),Math.max(pointCollision.getY() - 1, 0)));

            else

                lineCollision = new Line(pointCollision,new Point(pointCollision.getX(),Math.min(pointCollision.getY()+1,Obstacle.SCREEN_HEIGHT)));

            vector = vector.VectorSymmetryFromLine(lineCollision);
            setTimeCollision();
            line.setLine(point,vector);
        }
        return lineCollision;
    }

    @Override
    public int compareTo(Ball o) {
        return this.timeCollision - o.timeCollision;
    }

    public int getX()
    {
        return point.getX();
    }
    public int getY()
    {
        return point.getY();
    }
    public int getRadius()
    {
        return radius;
    }
    public Vector getVector()
    {
        return vector;
    }
    public Color getColor()
    {
        return color;
    }
    public Line getLine()
    {
        return line;
    }
    public static boolean[][] getObstacles()
    {
        return obstacles;
    }
    public void Info()
    {
        System.out.println(
                "ball:" + '\n'+
                        "toa do:" + getX()+" " + getY()+ '\n'+
                        "radius:" + radius+'\n'+
                        "vector:" + vector.getX()+ " " + vector.getY()+'\n'+
                        "timeCollision:" + timeCollision+'\n'+
                        "line:" +line.getA()+"x+"+line.getB()+"y+"+line.getC()+" = 0"+'\n'+
                        "PointCollision:"+ pointCollision.getX()+" "+pointCollision.getY()+'\n'
        );
    }
    public void move()
    {
        point.setVector(point.getX()+ vector.getX(), point.getY()+ vector.getY());
    }
}
