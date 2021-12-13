package com.ttkien.utils;

import com.ttkien.model.Rectangle;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * The utility class includes methods to support {@link Rectangle} manipulation such as reading use input to create a
 * rectangle, analyzing features among rectangles, or visualizing rectangles on x-y axis coordinate space
 *
 * @author ttkien - 10-31-2021
 */

public class RectangleUtil {
    /**
     * This support method is used to read the input string from a {@link Scanner}, then transform the values to an
     * array of 4 integers which can be used to create a {@link Rectangle}
     *
     * @param in {@link Scanner}
     * @return an array of integer
     */
    public static int[] readInput(Scanner in) {

        int[] value = new int[4];

        while (true) {
            boolean isValid = true;

            String v = in.nextLine();
            String[] arr = v.split(" ");
            if (arr.length == 4) {
                for (int i = 0; i < 4; i++) {
                    try {
                        value[i] = Integer.parseInt(arr[i]);
                    } catch (NumberFormatException ex) {
                        isValid = false;
                        break;
                    }
                }
            } else {
                isValid = false;
            }

            if (!isValid) {
                Utils.printMsg("input.value.error.msg");
                Utils.printMsg("input.value.again.msg");
            } else {
                break;
            }
        }

        return value;
    }

    /**
     * This utility method analyze features among two rectangles. Those features include intersection, containment and
     * adjacency. The result will a presentable string which can be print on output stream.
     *
     * @param r1 the first rectangle
     * @param r2 the second rectangle
     * @return a presentable string
     */
    public static String analyzeFeatures(Rectangle r1, Rectangle r2) {
        StringBuilder result = new StringBuilder();

        result.append(Utils.getMessage("rectangle.intersection.title",
                new Object[]{r1.intersect(r2) ? 1 : 0}));
        result.append(
                Utils.getMessage("rectangle.intersection.points.title",
                        new Object[]{Arrays.toString(r1.intersection(r2))}));

        if (r1.contains(r2)) {
            result.append(
                    Utils.getMessage("rectangle.containment.title",
                            new Object[]{1, r1.toString(), r2.toString()}));
        } else if (r2.contains(r1)) {
            result.append(
                    Utils.getMessage("rectangle.containment.title",
                            new Object[]{1, r2.toString(), r1.toString()}));
        } else {
            result.append(
                    Utils.getMessage("rectangle.containment.title", new Object[]{0}));
        }

        result.append(
                Utils.getMessage("rectangle.adjacency.title",
                        new Object[]{r1.adjacent(r2)}));

        return result.toString();
    }

    /**
     * Visualize two rectangles on the x-y axis coordinate space. This method will create a presentable string from
     * "_" and "|" characters and ANSI color codes which can be used to print on output stream. The purpose is to make
     * a visual presentation of the relation of two rectangle on the x-y axis coordinate space. However, this method is
     * limited to small rectangles which can be presented on 80x80 grids which normally is the terminal screen.
     *
     * @param r1 the first rectangles
     * @param r2 the second rectangles
     * @return the presentable string
     */

    public static String visualizeOnConsole(Rectangle r1, Rectangle r2) {

        /*
         * Check whether it is possible to render two rectangles in a coordinate space of 80x80 dimension grids
         * if it is not, just return with a message to inform caller
         */
        if (IntStream.of(r1.x, r1.y, r2.x, r2.y).min().getAsInt() < -40
                || LongStream.of(r1.tr.x, r1.tr.y, r2.tr.x, r2.tr.y).max().getAsLong() > 40) {
            return Utils.getMessage("rectangle.visualize.error.msg");
        }

        /*
         * Create a coordinate space to render two rectangles.
         * The width is 80 which is suitable for the width of the console
         * The height is calculated based on the height of rectangles and
         * their relative positions on the grids
         */
        int x = -40, y, width = 80, height;

        y = Math.min(r1.y, r2.y) - 2;
        y = (-1 <= y) ? -2 : y;

        height = Math.abs(y) + Math.max(r1.y, r2.y) + Math.max(r1.height, r2.height);
        height = 2 + ((0 <= y + height) ? height : height + Math.abs(y + height));

        //Create the rectangle that present the coordinate space
        Rectangle pf = new Rectangle(x, y, width, height);

        /*
         * Again, if target rectangles are too larges (is not fit in the coordinate space)
         * We can not render them on the console. Just need to return a message to inform
         */
        if (!pf.contains(r1) || !pf.contains(r2)) {
            return Utils.getMessage("rectangle.visualize.error.msg");
        }

        /*
         * Approximately render the x, y axis and rectangles using character "|" and "_"
         * The final result is a string that can be printed on the console
         */
        StringBuilder result = new StringBuilder();

        for (long i = pf.tl.y + 1; i > pf.bl.y; i--) {

            for (long j = pf.x; j <= pf.br.x; j++) {

                if (((j == r1.x || j == r1.tr.x) && (i < r1.tl.y && i >= r1.y))
                        || ((j == r2.x || j == r2.tr.x) && (i < r2.tl.y && i >= r2.y))) {
                    result.append("\u001B[32m|\u001B[0m");

                } else if (j == 0) {
                    if (i == pf.tl.y + 1) {
                        result.append("\u001B[31m^ (y)\u001B[0m");
                    } else {
                        result.append("\u001B[31m|\u001B[0m");
                    }

                } else if (((i == r1.y || i == r1.tl.y) && (j >= r1.tl.x && j <= r1.tr.x))
                        || ((i == r2.y || i == r2.tl.y) && (j >= r2.tl.x && j <= r2.tr.x))) {
                    result.append("\u001B[32m_\u001B[0m");
                } else if (i == 0) {
                    if (j == pf.br.x) {
                        result.append("\u001B[31m_(x)\u001B[0m");
                    } else {
                        result.append("\u001B[31m_\u001B[0m");
                    }
                } else {
                    result.append(" ");
                }
            }
            result.append("\n");
        }

        return result.toString();
    }
}
