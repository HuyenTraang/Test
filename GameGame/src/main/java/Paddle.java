import javax.swing.*;
import java.awt.*;

public class Paddle implements Obstacle {
    private int x;
    private int y;
    private int height;
    private int width;
    private Color color;
    public Paddle(int x,int y,int height,int width,Color color)
    {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = color;
    }
}
