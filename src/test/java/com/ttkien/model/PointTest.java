package com.ttkien.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * UnitTest class for the class {@link Point}
 *
 * @author ttkien 10-31-2021
 */
public class PointTest {
    @Test
    public void testConstructor() {
        assertEquals("(0,0)", (new Point()).toString());
    }

    @Test
    public void testConstructor2() {
        Point p = new Point();
        assertEquals(0L, p.y);
        assertEquals(0L, p.x);
    }

    @Test
    public void testConstructor3() {
        Point p = new Point(1L, 1L);

        assertEquals(1L, p.y);
        assertEquals(1L, p.x);
    }

    @Test
    public void testToString() {
        Point p = new Point(-2L, 5L);

        assertEquals("(-2,5)", p.toString());
    }
}

