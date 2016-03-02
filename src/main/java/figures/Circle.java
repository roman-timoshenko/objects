package figures;

public class Circle implements Figure{
    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public double area() {
        return Math.PI*Math.pow(radius,2);
    }

    public double perimeter() {
        return 2*Math.PI*radius;
    }

    public Circle move(int x, int y) {
        return new Circle(new Point(center.getX()+x, center.getY()+y), radius);
    }

    public boolean isInside(Point a) {
        if (Math.pow((a.getY() - center.getY()),2)+(Math.pow((a.getX() - center.getX()),2)) <= Math.pow(radius,2)) return true;
        else return false;
    }


}
