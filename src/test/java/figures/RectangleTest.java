package figures;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RectangleTest {
    public final Rectangle rectangle = new Rectangle(new Point(0, 0), new Point(10, 5));

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @Test
    public void testArea() throws Exception {
        assertEquals(rectangle.area(), 50, 0.3);
    }

    @Test
    public void testPerimeter() throws Exception {
        assertEquals(rectangle.perimeter(),30,0.3);
    }

    @Test
    public void testMove() throws Exception {
        assertEquals(rectangle.move(1,1).getUpperLeft().getX(),1);
        assertEquals(rectangle.move(1,1).getUpperLeft().getY(),1);
        assertEquals(rectangle.move(1,1).getBottomRight().getX(),11);
        assertEquals(rectangle.move(1,1).getBottomRight().getY(),6);

    }

    @Test
    public void testIsInside() throws Exception {
        assertEquals(rectangle.isInside(new Point(5,2)),true);

    }

}