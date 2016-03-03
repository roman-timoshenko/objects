package figures;

public class Rectangle implements Figure {
    private Point upperLeft;
    private Point bottomRight;


    public Rectangle(Point upperLeft, Point bottomRight) {
        this.upperLeft = upperLeft;
        this.bottomRight = bottomRight;
    }

    public Point getUpperLeft() {
        return upperLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public double area() {
        return getLength(upperLeft, bottomRight) * getWidth(upperLeft, bottomRight);
    }

    public double perimeter() {
        return 2 * (getLength(upperLeft, bottomRight) + getWidth(upperLeft, bottomRight));
    }

    public Rectangle move(int x, int y) {
        return new Rectangle(
                new Point(upperLeft.getX() + x, upperLeft.getY() + y),
                new Point(bottomRight.getX() + x, bottomRight.getY() + y));
    }

    public boolean isInside(Point a) {
        return upperLeft.getX() <= a.getX() &&
                bottomRight.getX() >= a.getX() &&
                upperLeft.getY() <= a.getY() &&
                bottomRight.getY() >= a.getY();
    }

    private int getLength(Point upperLeft, Point bottomRight) {

        return Math.abs(upperLeft.getX() - bottomRight.getX());
    }

    private int getWidth(Point upperLeft, Point bottomRight) {

        return Math.abs(upperLeft.getY() - bottomRight.getY());
    }
}
