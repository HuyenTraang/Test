import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPriorityQueue implements Obstacle{
    @Before
    void set_up()
    {

    }
    @Test
    public void test_line()
    {
        Line line = new Line(new Point(0,0),new Vector(1,1));
        assertArrayEquals(new double[]{-1,1}, new double[]{line.getA(),line.getB()});
    }
    @Test
    public void test_Symmetry()
    {
        Line line = new Line(-1,1,0);
        Vector vector = new Vector(1,2);
        int x = vector.VectorSymmetryFromLine(line).getX();
        int y = vector.VectorSymmetryFromLine(line).getY();
        assertEquals(new int[]{},new int[]{x,y});
    }
    @Test
    public void test_delivery()
    {
        Line line1 = new Line(4,-1,-1);
        Line line2 = new Line(2,5,-17);
        Point point1 = line1.delivery(line2);
        Point point2 = line2.delivery(line1);
        assertArrayEquals(new int[]{1,3},new int[]{point1.getX(),point1.getY()});
        assertArrayEquals(new int[]{1,3},new int[]{point2.getX(),point2.getY()});

        line1 = new Line(4,-7,-6);
        line2 = new Line(6,2,-34);
        point1 = line1.delivery(line2);
        assertArrayEquals(new int[]{5,2},new int[]{point1.getX(),point1.getY()});
    }
    public static void main(String[] args)
    {
        Ball.setObstacles(Utility.StringToBoolean2D("Wall_Rectangle"));
        Ball a = new Ball();

        System.out.println((Ball.getObstacles()).length);
//        assertArrayEquals(new boolean[][]{
//                new boolean[]{true,true,true,true,true,true,true,true,true,true},
//                new boolean[]{true,false,false,false,false,false,false,false,false,true},
//                new boolean[]{true,false,false,false,false,false,false,false,false,true},
//                new boolean[]{true,false,false,false,false,false,false,false,false,true},
//                new boolean[]{true,false,false,false,false,false,false,false,false,true},
//                new boolean[]{true,false,false,false,false,false,false,false,false,true},
//                new boolean[]{true,false,false,false,false,false,false,false,false,true},
//                new boolean[]{true,false,false,false,false,false,false,false,false,true},
//                new boolean[]{true,false,false,false,false,false,false,false,false,true},
//                new boolean[]{true,true,true,true,true,true,true,true,true,true},
//
//        },Utility.StringToBoolean2D("Wall_Rectangle"));
    }
    @Test
    public void test_Ball()
    {
        Ball.setObstacles(Utility.StringToBoolean2D("Wall_Rectangle"));
        Ball ball = new Ball(new Point(150,150),20,new Vector(5,5), Color.RED);
        ball.Info();
        Ball.TIME += ball.getTimeCollision();
        ball.collision().Info();
        ball.Info();
    }
    @Test
    public void test_Symmetry2()
    {
        Vector vector = new Vector(39,18);
        Line line = new Line(-18,39,-23862);
        System.out.println(vector.VectorSymmetryFromLine(line).getX() + " " + " "+vector.VectorSymmetryFromLine(line).getY());
    }

}
