/**
 * @author kehat sudri
 * 318409745
 */
/**
 * A line representation class with a starting point and an end point.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * constructor - create a new line from 2 points.
     *
     * @param start start point
     * @param end   end point
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * * constructor - create a new line from 2 points.
     * and create also these 2 points
     *
     * @param x1 x value of the first point
     * @param y1 y value of the second point
     * @param x2 x value of the first point
     * @param y2 y value of the second point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }


    /**
     * @return the length of the line
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * @return the middle point of the line
     */
    public Point middle() {
        Point middle = new Point(((this.start.getX() + this.end.getX()) / 2),
                ((this.start.getY() + this.end.getY()) / 2));
        return middle;
    }

    /**
     * @return the start point of the line
     */
    public Point start() {
        return this.start;
    }

    /**
     * @return he end point of the line
     */
    public Point end() {
        return this.end;
    }

    /**
     * @return the point with the bigger X value
     */
    public Point bigPoint() {
        if (this.start.getX() == this.end.getX()) {
            if (this.start.getY() >= this.end.getY()) {
                return this.start;
            }
            return this.end;
        } else if (this.start.getX() >= this.end.getX()) {
            return this.start;
        }
        return this.end;
    }

    /**
     * @return the point with the smaller X value
     */
    public Point littlePoint() {
        if (this.start.getX() == this.end.getX()) {
            if (this.start.getY() <= this.end.getY()) {
                return this.start;
            }
            return this.end;
        } else if (this.start.getX() <= this.end.getX()) {
            return this.start;
        }
        return this.end;
    }

    /**
     * @param other the line we want to find his incline
     * @return the incline of the line
     */
    public static double findIncline(Line other) {
        //if((other.start.getY()==other.end.getY())||(other.start.getX()==other.end.getX()))
        //return 0;
        return (other.start.getY() - other.end.getY())
                / (other.start.getX() - other.end.getX());
    }

    /**
     * @param l1 the line we want to work on
     * @param p1 the point we want to check
     * @return true if the point on the line or false if no
     */
    public static boolean pointOnLine(Line l1, Point p1) {

        //check when incline of the line is Infinite
        double inc = findIncline(l1);
        if (Double.isInfinite(findIncline(l1))) {
            if (l1.start.getY() >= l1.end.getY()) {
                if (p1.getY() <= l1.start.getY() && p1.getY() >= l1.end.getY()) {
                    return true;
                }
            } else if (p1.getY() >= l1.start.getY() && p1.getY() <= l1.end.getY()) {
                return true;
            }

            return false;
        }
        double b = l1.start.getY() - (inc * l1.start.getX());
        double line = (inc * p1.getX()) + b;
        double y = p1.getY();
        y = (double) (Math.floor(y * 100000)) / (100000);
        line = (double) (Math.floor(line * 100000)) / (100000);
        if (y != line) {
            return false;
        }

        if ((p1.getX() >= l1.start.getX() && p1.getX() <= l1.end.getX())
                || (p1.getX() <= l1.start.getX() && p1.getX() >= l1.end.getX())) {
            return true;
        }

        if (l1.start.getX() <= l1.end.getX()) {
            if (p1.getX() >= l1.start.getX() && p1.getX() <= l1.end.getX()) {
                return true;
            }

        } else if (l1.start.getX() >= l1.end.getX()) {
            if (p1.getX() <= l1.start.getX() && p1.getX() >= l1.end.getX()) {
                return true;
            }

        }
        return false;
    }

    /**
     * @param other the link we want to compare with this line
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        if (intersectionWith(other) != null) {
            return true;
        }
        return false;
    }

    /**
     * @param l1 the first line
     * @param l2 the second line
     * @return true if the lines Overlapping or partially overlapping
     * else return false
     */
    public static boolean isOverlapping(Line l1, Line l2) {
        if ((l1.start.equals(l2.start)) && ((l1.end.equals(l2.end)))) {
            return true;
        }
        if ((l1.start.equals(l2.end)) && ((l1.end.equals(l2.start)))) {
            return true;
        }
        if (l2.littlePoint().getX() < l1.bigPoint().getX()) {
            if (pointOnLine(l1, l2.littlePoint())) {
                return true;
            }
        }
        if (l1.littlePoint().getX() < l2.bigPoint().getX()) {
            if (pointOnLine(l2, l1.littlePoint())) {
                return true;
            }
        }
        if (l2.littlePoint().getY() < l1.bigPoint().getY()) {
            if (pointOnLine(l1, l2.littlePoint())) {
                return true;
            }
        }
        if (l1.littlePoint().getY() < l2.bigPoint().getY()) {
            if (pointOnLine(l2, l1.littlePoint())) {
                return true;
            }
        }

        return false;

    }

    /**
     * @param other the line we check his intersection with this line.
     * @return Returns the intersection point if the lines intersect,
     * and null otherwise.
     */
    public Point intersectionWith(Line other) {

        double b1 = this.end.getY() - (findIncline(this) * this.end.getX());
        double b2 = other.end.getY() - (findIncline(other) * other.end.getX());
        double x = ((b2 - b1) / (findIncline(this) - findIncline(other)));
        double y = (findIncline(this) * x) + b1;

        if (this.start.getX() == this.end.getX()) {
            x = this.start.getX();
            y = ((findIncline(other)) * x) + b2;

        }
        if (other.start.getX() == other.end.getX()) {
            x = other.start.getX();
            y = ((findIncline(this)) * x) + b1;

        }
        Point p1 = new Point(x, y);
        //if both are equal points
        if ((this.start().getX() == this.end.getX())
                && (this.start().getY() == this.end.getY())) {
            if ((other.start().getX() == other.end.getX())
                    && (other.start().getY() == other.end.getY())) {
                if ((this.start.getX() == other.start.getX())
                        && (this.start.getY() == other.start.getY())) {
                    return new Point(this.start.getX(), this.start.getY());
                } else {
                    return null;
                }
            }
        }

        //if one of them is a point on the other line
        if ((this.start().getX() == this.end.getX())
                && (this.start().getY() == this.end.getY())) {
            Point p = new Point(this.start.getX(), this.start.getY());
            if (pointOnLine(other, p)) {
                return p;
            } else {
                return null;
            }
        } else if ((other.start().getX() == other.end.getX())
                && (other.start().getY() == other.end.getY())) {
            if (pointOnLine(this, new Point(other.start.getX(), other.start.getY()))) {
                return new Point(other.start.getX(), other.start.getY());
            } else {
                return null;
            }
        }

        //if the lines Overlapping or partially overlapping
        if ((findIncline(this) == findIncline(other))
                || (Double.isInfinite(findIncline(this))
                && (Double.isInfinite(findIncline(other))))) {
            if (isOverlapping(this, other)) {
                return null;
            }
        }

        //if they are on the same line but not similar (one start after the other)
        if ((findIncline(this) == findIncline(other)) && (!(Double.isInfinite(findIncline(this))))) {

            if (((this.start.getX() == other.start.getX())
                    && ((this.end.getX() != other.end.getX()))
                    || (this.start.getX() == other.end.getX()))
                    && ((this.end.getX() != other.start.getX()))) {
                Point newP = new Point(this.start.getX(), this.start.getY());
                return newP;
            }
            if (((this.end.getX() == other.start.getX())
                    && ((this.start.getX() != other.end.getX()))
                    || (this.end.getX() == other.end.getX()))
                    && ((this.start.getX() != other.start.getX()))) {
                Point newP = new Point(this.end.getX(), this.end.getY());
                if (pointOnLine(this, newP) && pointOnLine(other, newP)) {
                    return newP;
                }
                return null;
            }
        }
        if ((Double.isInfinite(findIncline(this))) && (Double.isInfinite(findIncline(other)))) {
            if ((this.start.getY() == other.start.getY()) || (this.start.getY() == other.end.getY())) {
                if (this.start.getX() == other.start.getX() && !(isOverlapping(this, other))) {
                    return new Point(this.start.getX(), this.start.getY());
                }
            }
            if ((this.end.getY() == other.start.getY()) || (this.end.getY() == other.end.getY())) {
                if (this.start.getX() == other.start.getX() && !(isOverlapping(this, other))) {
                    return new Point(this.end.getX(), this.end.getY());
                }
            }


        }

        if (pointOnLine(this, p1) && pointOnLine(other, p1)) {
            return p1;
        }
        return null;
    }

    /**
     * @param other the line we want to compare to this line
     * @return true if the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        if (((this.start.equals(other.start)) && (this.end.equals(other.end)))
                || ((this.start.equals(other.end)) && (this.end.equals(other.start)))) {
            return true;
        }
        return false;
    }
}
