package com.ttkien.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * UnitTest class for the class {@link Rectangle}
 *
 * @author ttkien 10-31-2021
 */
public class RectangleTest {
    @Test
    public void testConstructorNoneArgument_thenAssertToString() {
        Rectangle actualRectangle = new Rectangle();
        assertEquals("Rectangle {x=0, y=0, w=0, h=0}", actualRectangle.toString());
        assertEquals("(0,0)", actualRectangle.bl.toString());
        assertEquals("(0,0)", actualRectangle.br.toString());
        assertEquals("(0,0)", actualRectangle.tl.toString());
        assertEquals("(0,0)", actualRectangle.tr.toString());
    }

    @Test
    public void testConstructorNoneArgument_thenAssertValuesOfProperty() {
        Rectangle actualRectangle = new Rectangle();
        assertEquals(0, actualRectangle.y);
        assertEquals(0, actualRectangle.x);
        assertEquals(0, actualRectangle.width);
        assertEquals(0, actualRectangle.height);
        Point point = actualRectangle.br;
        assertEquals(0L, point.x);
        Point point1 = actualRectangle.bl;
        assertEquals(0L, point1.x);
        Point point2 = actualRectangle.tr;
        assertEquals(0L, point2.x);
        assertEquals(0L, point1.y);
        Point point3 = actualRectangle.tl;
        assertEquals(0L, point3.y);
        assertEquals(0L, point2.y);
        assertEquals(0L, point.y);
        assertEquals(0L, point3.x);
    }

    @Test
    public void testConstructorWithPositiveArguments_thenAssertValueOfProperties() {
        Rectangle actualRectangle = new Rectangle(2, 3, 1, 1);

        assertEquals(3, actualRectangle.y);
        assertEquals(2, actualRectangle.x);
        assertEquals(1, actualRectangle.width);
        assertEquals(1, actualRectangle.height);
        Point point = actualRectangle.br;
        assertEquals(3L, point.x);
        Point point1 = actualRectangle.bl;
        assertEquals(2L, point1.x);
        Point point2 = actualRectangle.tr;
        assertEquals(3L, point2.x);
        assertEquals(3L, point1.y);
        Point point3 = actualRectangle.tl;
        assertEquals(4L, point3.y);
        assertEquals(4L, point2.y);
        assertEquals(3L, point.y);
        assertEquals(2L, point3.x);
    }

    @Test
    public void testConstructorWithNegativeWidth_thenAssertValuesOfProperties() {
        Rectangle actualRectangle = new Rectangle(2, 3, -1, 1);

        assertEquals(3, actualRectangle.y);
        assertEquals(2, actualRectangle.x);
        assertEquals(-1, actualRectangle.width);
        assertEquals(1, actualRectangle.height);
        Point point = actualRectangle.br;
        assertEquals(2L, point.x);
        Point point1 = actualRectangle.bl;
        assertEquals(2L, point1.x);
        Point point2 = actualRectangle.tr;
        assertEquals(2L, point2.x);
        assertEquals(3L, point1.y);
        Point point3 = actualRectangle.tl;
        assertEquals(4L, point3.y);
        assertEquals(4L, point2.y);
        assertEquals(3L, point.y);
        assertEquals(2L, point3.x);
    }

    @Test
    public void testConstructor5WithNegativeHeight_thenAssertValuesOfProperties() {
        Rectangle actualRectangle = new Rectangle(2, 3, 1, -1);

        assertEquals(3, actualRectangle.y);
        assertEquals(2, actualRectangle.x);
        assertEquals(1, actualRectangle.width);
        assertEquals(-1, actualRectangle.height);
        Point point = actualRectangle.br;
        assertEquals(3L, point.x);
        Point point1 = actualRectangle.bl;
        assertEquals(2L, point1.x);
        Point point2 = actualRectangle.tr;
        assertEquals(3L, point2.x);
        assertEquals(3L, point1.y);
        Point point3 = actualRectangle.tl;
        assertEquals(3L, point3.y);
        assertEquals(3L, point2.y);
        assertEquals(3L, point.y);
        assertEquals(2L, point3.x);
    }

    @Test
    public void testIntersectionOfTwoEmptyRectangle_thenExpectNoIntersection() {
        Rectangle rectangle = new Rectangle();
        assertEquals(0, rectangle.intersection(new Rectangle()).length);
    }

    @Test
    public void testIntersectionWithAEmptyRectangle_thenExpectNoIntersection() {
        Rectangle rectangle = new Rectangle(2, 3, 1, 1);
        assertEquals(0, rectangle.intersection(new Rectangle()).length);
    }

    @Test
    public void testIntersectionWithAEmptyRectangle2_thenExpectNoIntersection() {
        Rectangle rectangle = new Rectangle(0, 3, 1, 1);
        assertEquals(0, rectangle.intersection(new Rectangle()).length);
    }

    @Test
    public void testIntersectionWithTwoRectangles_thenExpectIntersection() {
        Rectangle rectangle = new Rectangle(2, 3, 1, 1);
        assertEquals(4, rectangle.intersection(new Rectangle(2, 3, 1, 1)).length);
    }

    @Test
    public void testIntersectionWithTwoRectangles_thenExpectNoIntersection() {
        Rectangle rectangle = new Rectangle(Integer.MIN_VALUE, 3, 1, 1);
        assertEquals(0, rectangle.intersection(new Rectangle(2, 3, 1, 1)).length);
    }

    @Test
    public void testIntersectionWithTwoRectangles_thenExpectNoIntersection2() {
        Rectangle rectangle = new Rectangle(2, 0, 1, 1);
        assertEquals(0, rectangle.intersection(new Rectangle(2, 3, 1, 1)).length);
    }

    @Test
    public void testIntersectionWithTwoRectangles_thenExpectNoIntersection3() {
        Rectangle rectangle = new Rectangle(2, Integer.MIN_VALUE, 1, 1);
        assertEquals(0, rectangle.intersection(new Rectangle(2, 3, 1, 1)).length);
    }

    @Test
    public void testIntersectionWithTwoRectangles_thenExpectIntersection2() {
        Rectangle rectangle = new Rectangle(2, 3, 4, 1);
        assertEquals(4, rectangle.intersection(new Rectangle(2, 3, 1, 1)).length);
    }

    @Test
    public void testIntersectionWithTwoRectangles_thenExpectIntersection3() {
        Rectangle rectangle = new Rectangle(2, 3, 4, 4);
        assertEquals(3, rectangle.intersection(new Rectangle(2, 3, 1, 1)).length);
    }

    @Test
    public void testIntersectTwoEmptyRectangles_ThenExpectFalse() {
        Rectangle rectangle = new Rectangle();
        assertFalse(rectangle.intersect(new Rectangle()));
    }

    @Test
    public void testIntersectWithOneEmptyRectangles_ThenExpectFalse() {
        Rectangle rectangle = new Rectangle(2, 3, 1, 1);
        assertFalse(rectangle.intersect(new Rectangle()));
    }

    @Test
    public void testIntersectTwoEmptyRectangles_ThenExpectFalse2() {
        Rectangle rectangle = new Rectangle(0, 3, 1, 1);
        assertFalse(rectangle.intersect(new Rectangle()));
    }

    @Test
    public void testIntersectTwoRectangles_ThenExpectTrue() {
        Rectangle rectangle = new Rectangle(2, 3, 1, 1);
        assertTrue(rectangle.intersect(new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testIntersectTwoRectangles_ThenExpectFalse() {
        Rectangle rectangle = new Rectangle(Integer.MIN_VALUE, 3, 1, 1);
        assertFalse(rectangle.intersect(new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testIntersectTwoRectangles_ThenExpectFalse2() {
        Rectangle rectangle = new Rectangle(2, 0, 1, 1);
        assertFalse(rectangle.intersect(new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testIntersectTwoRectangles_ThenExpectFalse3() {
        Rectangle rectangle = new Rectangle(2, Integer.MIN_VALUE, 1, 1);
        assertFalse(rectangle.intersect(new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testIntersectTwoRectangles_ThenExpectTrue2() {
        Rectangle rectangle = new Rectangle(2, 3, 4, 1);
        assertTrue(rectangle.intersect(new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testIntersectTwoRectangles_ThenExpectTrue3() {
        Rectangle rectangle = new Rectangle(2, 3, 4, 4);
        assertTrue(rectangle.intersect(new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testContains() {
        assertFalse((new Rectangle()).contains(1L, 1L));
        assertFalse((new Rectangle(2, 3, 1, 1)).contains(1L, 1L));
        assertFalse((new Rectangle(0, 3, 2, 1)).contains(1L, 1L));
        assertFalse((new Rectangle(0, 0, 2, 1)).contains(1L, 1L));
        assertTrue((new Rectangle(0, 0, 2, 2)).contains(1L, 1L));
    }

    @Test
    public void testEmmptyRectanglesContainsPointAt0x0_thenExpectFalse() {
        Rectangle rectangle = new Rectangle();
        assertFalse(rectangle.contains(new Point()));
    }

    @Test
    public void testEmmptyRectanglesContainsPointAt1x1_thenExpectFalse() {
        Rectangle rectangle = new Rectangle();
        assertFalse(rectangle.contains(new Point(1L, 1L)));
    }

    @Test
    public void testRectanglesContainsAPoint_thenExpectFalse() {
        Rectangle rectangle = new Rectangle(2, 3, 1, 1);
        assertFalse(rectangle.contains(new Point(1L, 1L)));
    }

    @Test
    public void testEmptyRectangleContainsEmptyRectangle_thenExpectTrue() {
        Rectangle rectangle = new Rectangle();
        assertTrue(rectangle.contains(new Rectangle()));
    }

    @Test
    public void testARectangleContainsEmptyRectangle_thenExpectFalse() {
        Rectangle rectangle = new Rectangle(2, 3, 1, 1);
        assertFalse(rectangle.contains(new Rectangle()));
    }

    @Test
    public void testEmptyRectangleContainsARectangle_thenExpectFalse() {
        Rectangle rectangle = new Rectangle();
        assertFalse(rectangle.contains(new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testRectangleContainsEmptyRectangle_thenExpectFalse() {
        Rectangle rectangle = new Rectangle(0, 3, 1, 1);
        assertFalse(rectangle.contains(new Rectangle()));
    }

    @Test
    public void testNegativePosRectangleContainsEmptyRectangle_thenExpectFalse() {
        Rectangle rectangle = new Rectangle(-1, 3, 1, 1);
        assertFalse(rectangle.contains(new Rectangle()));
    }

    @Test
    public void testPositivePosRectangleContainsEmptyRectangle_thenExpectFalse() {
        Rectangle rectangle = new Rectangle(2, 0, 1, 1);
        assertFalse(rectangle.contains(new Rectangle()));
    }

    @Test
    public void testNegativePosRectangleContainsEmptyRectangle_thenExpectFalse2() {
        Rectangle rectangle = new Rectangle(2, -1, 1, 1);
        assertFalse(rectangle.contains(new Rectangle()));
    }

    @Test
    public void testPositivePosRectangleContainsEmptyRectangle_thenExpectFalse2() {
        Rectangle rectangle = new Rectangle();
        assertFalse(rectangle.contains(new Rectangle(0, 3, 1, 1)));
    }

    @Test
    public void testAEmptyRectangleContainsAPositivePosRectangle_thenExpectFalse() {
        Rectangle rectangle = new Rectangle();
        assertFalse(rectangle.contains(new Rectangle(2, 0, 1, 1)));
    }

    @Test
    public void testANegativePosRectangleContainsAEmptyRectangle_thenExpectFalse() {
        Rectangle rectangle = new Rectangle(-1, 3, 4, 1);
        assertFalse(rectangle.contains(new Rectangle()));
    }

    @Test
    public void testANegativePosRectangleContainsEmptyRectangle_thenExpectFalse2() {
        Rectangle rectangle = new Rectangle(-1, 0, 4, 1);
        assertTrue(rectangle.contains(new Rectangle()));
    }

    @Test
    public void testANegativePosRectangleContainsEmptyRectangle_thenExpectTrue() {
        Rectangle rectangle = new Rectangle(-1, -1, 4, 1);
        assertTrue(rectangle.contains(new Rectangle()));
    }

    @Test
    public void testANegativePosRectangleContainsEmptyRectangle_thenExpectTrue2() {
        Rectangle rectangle = new Rectangle(-1, -1, 4, 4);
        assertTrue(rectangle.contains(new Rectangle()));
    }

    @Test
    public void testAdjacentTwoEmptyRectangle_ThenExpectPROPER() {
        Rectangle rectangle = new Rectangle();
        assertEquals(Rectangle.ADJACENCY.PROPER, rectangle.adjacent(new Rectangle()));
    }

    @Test
    public void testAdjacentOfARectangleWithAEmptyRectangle_ThenExpectNONE() {
        Rectangle rectangle = new Rectangle(2, 3, 1, 1);
        assertEquals(Rectangle.ADJACENCY.NONE, rectangle.adjacent(new Rectangle()));
    }

    @Test
    public void testAdjacentOfARectangleWithAEmptyRectangle_ThenExpectNONE2() {
        Rectangle rectangle = new Rectangle(0, 3, 1, 1);
        assertEquals(Rectangle.ADJACENCY.NONE, rectangle.adjacent(new Rectangle()));
    }

    @Test
    public void testAdjacentOfARectangleWithAEmptyRectangle_ThenExpectNONE3() {
        Rectangle rectangle = new Rectangle(-1, 3, 1, 1);
        assertEquals(Rectangle.ADJACENCY.NONE, rectangle.adjacent(new Rectangle()));
    }

    @Test
    public void testAdjacentOfARectangleWithAEmptyRectangle_ThenExpectNONE4() {
        Rectangle rectangle = new Rectangle(2, 0, 1, 1);
        assertEquals(Rectangle.ADJACENCY.NONE, rectangle.adjacent(new Rectangle()));
    }

    @Test
    public void testAdjacentOfARectangleWithAEmptyRectangle_ThenExpectNONE5() {
        Rectangle rectangle = new Rectangle(2, -1, 1, 1);
        assertEquals(Rectangle.ADJACENCY.NONE, rectangle.adjacent(new Rectangle()));
    }

    @Test
    public void testAdjacentOfARectangleWithAEmptyRectangle_ThenExpectSUBLINE() {
        Rectangle rectangle = new Rectangle(0, 0, 1, 1);
        assertEquals(Rectangle.ADJACENCY.SUB_LINE, rectangle.adjacent(new Rectangle()));
    }

    @Test
    public void testAdjacentOfARectangleWithAEmptyRectangle_ThenExpectSUBLINE2() {
        Rectangle rectangle = new Rectangle(0, -1, 1, 1);
        assertEquals(Rectangle.ADJACENCY.SUB_LINE, rectangle.adjacent(new Rectangle()));
    }

    @Test
    public void testAdjacentOfARectangleWithAEmptyRectangle_ThenExpectSUBLINE3() {
        Rectangle rectangle = new Rectangle(-1, -1, 1, 1);
        assertEquals(Rectangle.ADJACENCY.SUB_LINE, rectangle.adjacent(new Rectangle()));
    }

    @Test
    public void testAdjacentOfARectangleWithAEmptyRectangle_ThenExpectSUBLINE4() {
        Rectangle rectangle = new Rectangle(-1, -1, 7, 1);
        assertEquals(Rectangle.ADJACENCY.SUB_LINE, rectangle.adjacent(new Rectangle()));
    }

    @Test
    public void testAdjacentOfARectangleWithAEmptyRectangle_ThenExpectSUBLINE5() {
        Rectangle rectangle = new Rectangle(-1, -1, 1, 7);
        assertEquals(Rectangle.ADJACENCY.SUB_LINE, rectangle.adjacent(new Rectangle()));
    }

    @Test
    public void testAdjacentOfTwoRectangles_ThenExpectPROPER() {
        Rectangle rectangle = new Rectangle(3, 3, 1, 1);
        assertEquals(Rectangle.ADJACENCY.PROPER, rectangle.adjacent(new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAdjacentOfTwoRectangles_ThenExpectSUB_LINE() {
        Rectangle rectangle = new Rectangle(3, 3, 1, 0);
        assertEquals(Rectangle.ADJACENCY.SUB_LINE, rectangle.adjacent(new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAdjacentOfTwoRectangles_ThenExpectSUB_LINE2() {
        Rectangle rectangle = new Rectangle(3, 3, 1, 4);
        assertEquals(Rectangle.ADJACENCY.SUB_LINE, rectangle.adjacent(new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testAdjacentOfTwoRectangles_ThenExpectPARITAL() {
        Rectangle rectangle = new Rectangle(3, 3, 1, 1);
        assertEquals(Rectangle.ADJACENCY.PARTIAL, rectangle.adjacent(new Rectangle(2, 4, 1, 1)));
    }

    @Test
    public void testAdjacentOfTwoRectangles_ThenExpectPARTIAL() {
        Rectangle rectangle = new Rectangle(1, 3, 1, 0);
        assertEquals(Rectangle.ADJACENCY.PARTIAL, rectangle.adjacent(new Rectangle(2, 3, 1, 1)));
    }

    @Test
    public void testGetCornersOfAEmptyRectangle_thenExpect4Points() {
        assertEquals(4, (new Rectangle()).getCorners().length);
    }

    @Test
    public void testIsEmpty() {
        assertTrue((new Rectangle()).isEmpty());
        assertFalse((new Rectangle(2, 3, 1, 1)).isEmpty());
        assertTrue((new Rectangle(2, 3, 1, 0)).isEmpty());
    }

    @Test
    public void testAPointOfXandYAreOnSidesOfRectangles() {
        assertFalse((new Rectangle()).onSides(1L, 1L));
        assertFalse((new Rectangle()).onSides(0L, 1L));
        assertFalse((new Rectangle()).onSides(1L, 0L));
        assertTrue((new Rectangle()).onSides(0L, 0L));
        assertFalse((new Rectangle()).onSides(0L, -2147483648L));
        assertFalse((new Rectangle()).onSides(-2147483648L, 0L));
        assertFalse((new Rectangle(0, 3, 1, 1)).onSides(1L, 1L));
        assertFalse((new Rectangle(2, 0, 1, 1)).onSides(1L, 1L));
    }

    @Test
    public void tetAZeroPointIsOnSideZeroEmptyRectangle_ThenExpectTrue() {
        Rectangle rectangle = new Rectangle();
        assertTrue(rectangle.onSides(new Point()));
    }

    @Test
    public void tetAZeroPointIsOnSideARectangle_ThenExpectFalse() {
        Rectangle rectangle = new Rectangle(2, 3, 1, 1);
        assertFalse(rectangle.onSides(new Point()));
    }

    @Test
    public void tetAZeroPointIsOnSideARectangle_ThenExpectFalse2() {
        Rectangle rectangle = new Rectangle(0, 3, 1, 1);
        assertFalse(rectangle.onSides(new Point()));
    }

    @Test
    public void tetAZeroPointIsOnSideARectangle_ThenExpectFalse3() {
        Rectangle rectangle = new Rectangle(-1, 3, 1, 1);
        assertFalse(rectangle.onSides(new Point()));
    }

    @Test
    public void tetAZeroPointIsOnSideARectangle_ThenExpectFalse4() {
        Rectangle rectangle = new Rectangle(2, 0, 1, 1);
        assertFalse(rectangle.onSides(new Point()));
    }

    @Test
    public void tetAZeroPointIsOnSideARectangle_ThenExpectFalse5() {
        Rectangle rectangle = new Rectangle(2, -1, 1, 1);
        assertFalse(rectangle.onSides(new Point()));
    }

    @Test
    public void tetAZeroPointIsOnSideARectangle_ThenExpectFalse6() {
        Rectangle rectangle = new Rectangle(0, Integer.MIN_VALUE, 1, 1);
        assertFalse(rectangle.onSides(new Point()));
    }

    @Test
    public void tetAZeroPointIsOnSideARectangle_ThenExpectFalse7() {
        Rectangle rectangle = new Rectangle(Integer.MIN_VALUE, 0, 1, 1);
        assertFalse(rectangle.onSides(new Point()));
    }
}

