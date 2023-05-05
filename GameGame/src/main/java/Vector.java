import java.util.Random;

public class Vector {
    private int x;
    private int y;
    public Vector(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    public Vector(Point point1,Point point2)
    {
        x = point2.getX() - point1.getX();
        y = point2.getY() - point1.getY();
    }
    public Vector()
    {
        Random random = new Random();
        this.x = random.nextInt(10,40);
        this.y = random.nextInt(10,40);
    }

    public Vector normalVector()
    {
        return new Vector(-y,x);
    }
    public Vector getVector()
    {
        return this;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void setVector(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    public double getSize()
    {
        return Math.sqrt(x*x + y*y);
    }
    public double dotProduct(Vector o)
    {
        return this.x*o.x + this.y+o.y;
    }
    public double angleTwoVector(Vector o)
    {
        return Math.acos(dotProduct(o)/(getSize() * o.getSize()));
    }
    public Point PointSymmetryFromLine(Line line)
    {
        double distance = line.pointToLine(this);
        return new Line(this,line.getDirectionVector().normalVector()).delivery(new Line(line.getA(),line.getB(),line.getC()+distance));
    }
    public Vector VectorSymmetryFromLine(Line line)
    {
        Point point2 = PointSymmetryFromLine(line);
        Point point1 = new Point(0,0).PointSymmetryFromLine(line);
        return new Vector(point1,point2);
    }
    public double distance(Vector other)
    {
        return Math.sqrt(Math.pow(this.getX() - other.getX(),2) + Math.pow(this.getY() - other.getY(),2));
    }
}
