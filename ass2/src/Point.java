/**
 * @author kehat sudri
 * 318409745
 */


 //This class represents a point on the plane with X and Y values
   public class Point {
    private double x;
    private double y;

    private static final double EPSILON = Math.pow(10, -2);

    /**
     * constructor :.
     * create a point with x and y values
     *
     * @param x the x value
     * @param y the y value
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * distance -- return the distance of this point to the other point.
     *
     * @param other a point
     * @return return the distance of this point to the other point
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow((this.y - other.getY()), 2)
                + Math.pow((this.getX() - other.getX()), 2));
    }

    /**
     * equals -- return true if the points are equal, false otherwise.
     *
     * @param other a Point
     * @return true if this point equals to the other point
     * or false if not
     */
    public boolean equals(Point other) {
        if ((Math.abs(other.getX() - this.x) <= EPSILON) && (Math.abs(other.getY() - this.y) <= EPSILON)) {
            return true;
        }
        return false;
    }

    /**
     * Return the x value of this point.
     *
     * @return this.x
     */
    public double getX() {
        return this.x;
    }

    /**
     * Return the x value of this point.
     *
     * @return this .y
     */
    public double getY() {
        return this.y;
    }
}
