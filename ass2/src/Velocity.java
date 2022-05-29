/**
 * @author kehat sudri
 * 318409745
 */
/** Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;

    /** constructor.
     * this constructor set the velocity with dx and dy
     * @param dx direction on X line
     * @param dy direction on Y line
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * @return this.dx
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * @return this.dy
     */
    public double getDy() {
        return this.dy;
    }

    /** Take a point with position (x,y).
     * @param p the point we want to change
     * @return a new point with position (x+dx, y+dy)
     */
    public Point applyToPoint(Point p) {
         return new Point(p.getX() + dx , p.getY() + dy);
    }

    /**
     * @param angle - the angle of the ball
     * @param speed - the speed of the ball
     * @return the velocity of the ball based on thr angle and the speed
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double angleRad = Math.toRadians(angle);
        double dy = Math.cos(angleRad) * speed;
        double dx = Math.sin(angleRad) * speed;
        return new Velocity(dx, -dy);
    }
}