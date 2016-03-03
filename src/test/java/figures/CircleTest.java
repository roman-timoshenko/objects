package figures;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CircleTest {
    public final Circle circle = new Circle(new Point(10,10),10);

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @Test
    public void testArea() throws Exception {
        assertEquals(circle.area(),314,0.3);
    }

    @Test
    public void testPerimeter() throws Exception {
        assertEquals(circle.perimeter(),62.8,0.3);

    }

    @Test
    public void testMove() throws Exception {
        Circle movedCircle = circle.move(-10, -10);
        assertEquals(movedCircle.getCenter().getX(), 0);
        assertEquals(movedCircle.getCenter().getY(), 0);
        assertEquals(movedCircle.getRadius(), 10);

    }

    @Test
    public void testIsInsidePositive() throws Exception {
        assertEquals(circle.isInside(new Point(9,9)),true);
    }

    @Test
    public void testIsInsideNegative() throws Exception {
        assertEquals(circle.isInside(new Point(100,100)),false);
    }

    @Test
    public void testBoundingBox() throws Exception {
        Rectangle rectangle = circle.boundingBox();
        assertEquals(rectangle.getBottomRight().getX(), 20);
        assertEquals(rectangle.getBottomRight().getY(), 20);
        assertEquals(rectangle.getUpperLeft().getX(), 0);
        assertEquals(rectangle.getUpperLeft().getY(), 0);




    }
}