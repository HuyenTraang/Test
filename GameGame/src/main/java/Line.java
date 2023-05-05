public class Line {
    // ax + by +c = 0
    private double a;
    private double b;
    private double c;
    private Vector directionVector;
    public Line(Point point1,Point point2)
    {
        Vector vector = new Vector(point2.getX() - point1.getX(), point2.getY() - point1.getY());
        a = -vector.getY();
        b = vector.getX();
        c = -(a * point1.getX() + b * point1.getY());

        directionVector = vector;
    }
    public void setLine(Vector point, Vector vector)
    {
        a = -vector.getY();
        b = vector.getX();
        c = -(a * point.getX() + b * point.getY());

        directionVector = vector;
    }
    public Line(double a,double b,double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        directionVector = new Vector((int)-b,(int)a);
    }
    public Line(Vector point, Vector vector)
    {
        a = -vector.getY();
        b = vector.getX();
        c = -(a * point.getX() + b * point.getY());

        directionVector = vector;
    }
    public double getA()
    {
        return a;
    }
    public double getB()
    {
        return b;
    }
    public double getC()
    {
        return c;
    }
    public int getY(int x)
    {
        return (int)Math.floor(-(c + a*x)/b);
    }
    public int getX(int y)
    {
        return (int)Math.floor(-(c + b*y)/a);
    }
    public double distanceToPoint(Vector vector)
    {
        return (vector.getX() * a + vector.getY() * b +c)/Math.sqrt(a*a + b*b);
    }
    public double pointToLine(Vector vector)
    {
        return (vector.getX() * a + vector.getY() * b +c);
    }
    public Point delivery(Line line)
    {
        try{
            return new Point((int) Math.floor(-(line.getB() * c - b * line.getC()) / (a * line.getB() - line.getA() * b)),
                    (int) Math.floor((line.getA() * c - a * line.getC()) / (a * line.getB() - line.getA() * b)));
        }
        catch (Exception e)
        {
            throw new RuntimeException("loi khi chia cho 0");
        }
    }
    public void Info()
    {
        System.out.println(a+"x+"+b+"y+"+c+"=0");
    }
    public Vector getDirectionVector() {
        return directionVector;
    }
}
