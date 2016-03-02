package figures;

public interface Figure {
    int area();
    int perimeter();
    Figure move(int x, int y);
    boolean isInside(Point a);
}
