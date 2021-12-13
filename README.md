# Rectangles

This program provides certain algorithms that analyze rectangles and features that exist among rectangles. A Rectangle is an area in a coordinate space that is presented by its lower-left point (x,y) in the coordinate space, its width, and its height. A Rectangle whose width or height is negative or zero are consider as empty rectangles. If its width is zero or, the rectangle becomes a vertical line along y-axis. If its height is zero or less, it becomes a horizontal line along the x-axis. If both width and height are zero or less, the rectangle becomes a point(x, y) on coordinate space. After being created, the rectangle contains 4 corner points which are created based on its lower-left point (x,y) and its width and height.

The features that exist among rectangles include following:
- **Intersection:** Two rectangles have one or more intersecting lines and produce a result identifying the points of intersection
- **Containment:** Determine whether a rectangle is wholly contained within another rectangle. A rectangle is contains in another rectangle if all its points are contained in another one.
- **Adjacency:** Detect whether two rectangles are adjacent. Adjacency is defined as the sharing of at least one side. Side sharing may be proper, sub-line or partial. A sub-line share is a share where one side of rectangle A is a line that exists as a set of points wholly contained on some other side of rectangle B, where partial is one where some line segment on a side of rectangle A exists as a set of points on some side of Rectangle B.

The program run on a terminal that allow user to input values to create two rectangles. The program then analyze the features between rectangles and print the result on the terminal. The program also tries to visualize the drawing of rectangles on the x-y axis coordinate space if the two rectangles are small enough to draw on 80x80 dimension grids

### Tech

The program is writen in Java

### Dependencies
- Java 1.8
- Apache Maven 3.8.1
- Maven-assembly-plugin 3.3.0
- Junit 4.13.2

### Run
This program requires Java 1.8+ to run

Make sure you have the Java installed in classpath.

```sh
$ java --version
```
Run the program
```sh
$ cd rectangles
$ java -jar target/rectangles-1.0.0.jar
```

#### Building from source
This program use Apache Maven to manage dependencies and build
Make sure you have Apache Maven 3x in your classpath
```sh
$ mvn -v
$ cd rectangles
$ mvn clean install
```
Find the rectangles-1.0.0.jar in the folder [rectangles/target]

**Enjoy, Yeah!**
