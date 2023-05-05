import java.util.Random;

public class Point extends Vector{
    public Point(int x, int y) {
        super(x, y);
    }
    public Point()
    {
        Random random = new Random();
        int x = random.nextInt(Obstacle.SCREEN_WIDTH);
        int y = random.nextInt(Obstacle.SCREEN_HEIGHT);
        setVector(x,y);
    }

}
