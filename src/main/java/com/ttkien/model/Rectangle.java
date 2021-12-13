package com.ttkien.model;

import java.util.LinkedList;
import java.util.List;

/**
 * A Rectangle is an area in a coordinate space that is presented by its lower-left point (x,y) in the coordinate space,
 * its width, and its height.
 * <p>
 * A Rectangle whose width or height is negative or zero are consider as empty rectangles. If its width is zero or, the
 * rectangle becomes a vertical line along y-axis. If its height is zero or less, it becomes a horizontal line along the
 * x-axis. If both width and height are zero or less, the rectangle becomes a point(x, y) on coordinate space.
 * <p>
 * After being created, the rectangle contains 4 corner points {@link Point} which are created based on its lower-left
 * point (x,y) and its width and height.
 *
 * @author ttkien - 10-31-2021
 */
public class Rectangle {

    /*
     * This enum is used to present the adjacent type of two rectangles
     * SUB_LINE: One side of rectangle A is a line that exists as a set of points wholly contained on some other sides
     * of rectangle B
     * PARTIAL: Some line segments on a side of rectangle A exists as a set of points on some side of rectangle B.
     * PROPER: One side of this rectangle is exactly the same with one side of rectangle B
     * NONE: There is no adjacency between two rectangles
     * */
    public enum ADJACENCY {
        SUB_LINE,
        PROPER,
        PARTIAL,
        NONE
    }

    public int x;
    public int y;
    public int width;
    public int height;

    //The top left corner point
    public Point tl;
    //The top right corner point
    public Point tr;
    //The bottom left conner point
    public Point bl;
    //The bottom right conner point
    public Point br;

    public Rectangle() {
        this(0, 0, 0, 0);
    }

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        /*
         * Create 4 conner points for this rectangle
         * If width is less than zero, the rectangle becomes a vertical line - (empty rectangle)
         * if height is less than zero, the rectangle becomes a horizontal line - (empty rectangle)
         * if both width and height are less than zero, the rectangle becomes a point (x, y) - (empty rectangle)
         */
        int x1 = width < 0 ? x : x + width;
        int y1 = height < 0 ? y : y + height;

        bl = new Point(x, y);
        br = new Point(x1, y);
        tl = new Point(x, y1);
        tr = new Point(x1, y1);

    }

    /**
     * Computes the intersection of this Rectangle with the provided Rectangle. Returns an array of intersect points
     * {@link Point} between two rectangles. If they do not intersect, the result will be an empty array.
     *
     * @param r - the provided Rectangle
     * @return an array of intersect points {@link Point} between two rectangles. An empty array in case not intersect
     */
    public Point[] intersection(Rectangle r) {

        int tx = Math.max(this.x, r.x);
        int ty = Math.max(this.y, r.y);
        long tw = Math.min(this.br.x, r.br.x) - tx;
        long th = Math.min(this.tl.y, r.tl.y) - ty;

        /*
         * The width and height of the intersection rectangle might be underflow because of the subtraction operation
         * If they are underflow, set the value to the MIN_VALUE of Integer to avoid incorrect casting from long to int
         * while create the intersection rectangle
         */
        if (tw < Integer.MIN_VALUE) tw = Integer.MIN_VALUE;
        if (th < Integer.MIN_VALUE) th = Integer.MIN_VALUE;

        //Create a new rectangle that contains the intersection of two rectangles
        Rectangle intersection = new Rectangle(tx, ty, (int) tw, (int) th);

        if (intersection.isEmpty()) {
            return new Point[0];
        } else {

            /*
             * Check all the conner points of the intersection rectangle to find points
             * that are located on the sides of both target rectangles.
             * The result will be intersection points of target rectangles
             */
            List<Point> result = new LinkedList<>();
            for (Point p : intersection.getCorners()) {
                if (this.onSides(p) && r.onSides(p)) {
                    result.add(p);
                }
            }

            return result.toArray(new Point[0]);
        }

    }

    /**
     * Check if this rectangle and provided one are intersected
     *
     * @param r - the provided Rectangle
     * @return true if two rectangles are intersected, otherwise return false
     */
    public boolean intersect(Rectangle r) {
        return (intersection(r).length > 0);
    }

    /**
     * Check if this rectangle contains the provided rectangle. The rectangle is contained in another rectangle if all
     * of its corner points are contained in or on the sides of another one.
     *
     * @param r the rectangle to test
     * @return true if this rectangle contains r, otherwise return false
     */
    public boolean contains(Rectangle r) {
        Point[] points = r.getCorners();
        for (Point p : points) {
            if (!contains(p) && !(onSides(p))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if this rectangle contains the provided point {@link Point}
     *
     * @param p the point to check
     * @return true if it contains the point, otherwise return false
     */
    public boolean contains(Point p) {
        return contains(p.x, p.y);
    }

    /**
     * Check if this rectangle contains the point which is created by the provided value x and y
     *
     * @param x the value on the x-axis
     * @param y the value on the y-axis
     * @return true if it contains the point, otherwise return false
     */
    public boolean contains(long x, long y) {
        return x > this.x
                && x < br.x
                && y > this.y
                && y < tl.y;
    }

    /**
     * Check if this rectangle and provided one are adjacent. Adjacency is defined as the sharing of at least one side.
     * Side sharing may be proper, sub-line or partial. A sub-line share is a share where one side of rectangle A is
     * a line that exists as a set of points wholly contained on some other side of rectangle B, where partial is one
     * where some line segments on a side of rectangle A exists as a set of points on some side of Rectangle B.
     *
     * @param r the target rectangle
     * @return One value of the {@link ADJACENCY} enum,
     */
    public ADJACENCY adjacent(Rectangle r) {

        Rectangle r1 = this;
        Rectangle r2 = r;
        if (this.y == r.tl.y || this.x == r.br.x) {
            r1 = r;
            r2 = this;
        }

        if (r1.tl.y == r2.y) {
            //r2 is on top of r1
            if (r1.x == r2.x && r1.width == r2.width) {
                return ADJACENCY.PROPER;
            } else if (r1.onSides(r2.bl) && r1.onSides(r2.br) || r2.onSides(r1.tl) && r2.onSides(r1.tr)) {
                return ADJACENCY.SUB_LINE;
            } else if ((r1.onSides(r2.bl) && !r1.onSides(r2.br)) || (!r1.onSides(r2.bl) && r1.onSides(r2.br))) {
                return ADJACENCY.PARTIAL;
            }
        } else if (r1.br.x == r2.x) {
            //r2 is on the right side of r1
            if (r1.y == r2.y && r1.height == r2.height) {
                return ADJACENCY.PROPER;
            } else if (r1.onSides(r2.bl) && r1.onSides(r2.tl) || r2.onSides(r1.br) && r2.onSides(r1.tr)) {
                return ADJACENCY.SUB_LINE;
            } else if ((r1.onSides(r2.bl) && !r1.onSides(r2.tl)) || (!r1.onSides(r2.bl) && r1.onSides(r2.tl))) {
                return ADJACENCY.PARTIAL;
            }
        }

        return ADJACENCY.NONE;
    }

    /**
     * Get the array of corners points of this rectangle.
     *
     * @return array of {@link Point}
     */
    public Point[] getCorners() {
        return new Point[]{bl, tl, tr, br};
    }

    /**
     * Check if this rectangle is empty. A rectangle is empty if its width or height or both are less than zero
     *
     * @return true if it is empty, otherwise, false
     */
    public boolean isEmpty() {
        return (this.width <= 0 || this.height <= 0);
    }

    /**
     * Check if the provided point is on any sides of this rectangle
     *
     * @param p the {@link Point} to test
     * @return true if the point is on any side, otherwise return false
     */
    public boolean onSides(Point p) {
        return onSides(p.x, p.y);
    }

    /**
     * Check if the provided point created by provided x and y is on any sides of this rectangle
     *
     * @param x the value on x-axis
     * @param y the value on y-axis
     * @return true if the point is on any side, otherwise return false
     */
    public boolean onSides(long x, long y) {
        return ((x == this.x || x == this.br.x) && y >= this.y && y <= this.tl.y)
                || ((y == this.y || y == this.tl.y) && x >= this.x && x <= this.br.x);
    }

    @Override
    public String toString() {
        return "Rectangle {" +
                "x=" + x +
                ", y=" + y +
                ", w=" + width +
                ", h=" + height +
                '}';
    }

}
