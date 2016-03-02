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
        assertEquals(circle.area(),314,0.1);
    }

    @Test
    public void testPerimeter() throws Exception {
        assertEquals(circle.perimeter(),62.8,0.1);

    }

    @Test
    public void testMove() throws Exception {
        assertEquals(circle.move(-10,-10), new Circle(new Point(0,0),10));

    }

    @Test
    public void testIsInside() throws Exception {
        assertEquals(circle.isInside(new Point(9,9)),true);
    }

    @Test
    public void testBoundingBox() throws Exception {


    }
}