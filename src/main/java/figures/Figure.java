package figures;

public interface Figure {
    double area();
    double perimeter();
    Figure move(int x, int y);
    boolean isInside(Point a);
}
