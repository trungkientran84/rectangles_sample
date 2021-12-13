package com.ttkien.model;

/**
 * This class defines a point representing a location in (x,y) coordinate space. The Point class is used in {@link Rectangle}
 * to present its corners
 *
 * @author ttkien - 10-31-2021
 */
public class Point {
    public long x;
    public long y;

    public Point() {
        this(0, 0);
    }

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
