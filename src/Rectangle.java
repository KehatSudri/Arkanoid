/**
 * @author kehat sudri
 * 318409745
 */

import java.util.ArrayList;
import java.util.List;

/**
 * A Rectangle representation class with upperLeft point and an end point width and height.
 */
public class Rectangle {
    private double width;
    private double height;
    private Point upperLeft;
    private Line[] sides;
    private java.awt.Color color;

    /**
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft the location
     * @param width     width
     * @param height    height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.height = height;
        this.width = width;
        this.upperLeft = upperLeft;
    }

    /**
     * Create a new rectangle with location ,width ,height and color.
     *
     * @param upperLeft the location
     * @param width     width
     * @param height    height
     * @param color     color
     */
    public Rectangle(Point upperLeft, double width, double height, java.awt.Color color) {
        this.height = height;
        this.width = width;
        this.upperLeft = upperLeft;
        this.color = color;
    }

    /**
     * @return the color of the rectangle
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * @param line the specified line
     * @return Return a (possibly empty) List of intersection points
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> pointsList = new ArrayList<>();
        this.setSidesLRUD();
        if (this.sides[0].intersectionWith(line) != null) {
            pointsList.add(this.sides[0].intersectionWith(line));
        }
        if (this.sides[1].intersectionWith(line) != null) {
            pointsList.add(this.sides[1].intersectionWith(line));
        }
        if (this.sides[2].intersectionWith(line) != null) {
            pointsList.add(this.sides[2].intersectionWith(line));
        }
        if (this.sides[3].intersectionWith(line) != null) {
            pointsList.add(this.sides[3].intersectionWith(line));
        }
        if (pointsList == null || pointsList.isEmpty()) {
            return null;
        } else {
            return pointsList;
        }
    }

    /**
     * this function build an array [4] and insert in the sides of the rectangle as lines.
     */
    public void setSidesLRUD() {
        Line[] sides1 = new Line[4];
        Line leftLine = new Line(this.upperLeft, this.getDownLeft());
        Line rightLine = new Line(this.getUpperRight(), this.getDownRight());
        Line upLine = new Line(this.upperLeft, this.getUpperRight());
        Line downLine = new Line(this.getDownLeft(), this.getDownRight());
        sides1[0] = leftLine;
        sides1[1] = rightLine;
        sides1[2] = upLine;
        sides1[3] = downLine;
        this.sides = sides1;
    }

    /**
     * @return array of lines of the sides of the rectangle
     */
    public Line[] getSidesLRUD() {
        return this.sides;
    }

    /**
     * @return Return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return Return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return Returns the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * @return Returns the upper-right point of the rectangle.
     */
    public Point getUpperRight() {
        return new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
    }

    /**
     * @return Returns the down-left point of the rectangle.
     */
    public Point getDownLeft() {
        return new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
    }

    /**
     * @return Returns the down-right point of the rectangle.
     */
    public Point getDownRight() {
        return new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
    }
}