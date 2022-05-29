/**
 * @author kehat sudri
 * 318409745
 */
import biuoop.DrawSurface;

/**
 * the class represent a ball with center point ,radius ,color.
 * velocity and zone of live
 */
public class Ball {
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private Point screenStart;
    private Point screenEnd;

    /**
     * constructor to build a ball.
     *
     * @param center the middle of the ball
     * @param r      radius
     * @param color  color
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * constructor to build a ball.
     *
     * @param x     X value of the center
     * @param y     Y value of the center
     * @param r     radius
     * @param color color
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        Point p = new Point(x, y);
        this.center = p;
        this.r = r;
        this.color = color;
    }

    /**
     * setting the creen zone of the ball.
     *
     * @param x  X value of the first corner (up left)
     * @param y  Y value of the first corner
     * @param x1 X value of the second corner (down right)
     * @param y1 Y value of the second corner
     */
    public void setScreenSize(int x, int y, int x1, int y1) {
        this.screenStart = new Point(x, y);
        this.screenEnd = new Point(x1, y1);
    }

    /**
     * @return the width of the screen
     */
    public double getWidth() {
        return this.screenEnd.getX() - this.screenStart.getX();
    }

    /**
     * @return the height of the screen
     */
    public double getHeight() {
        return this.screenEnd.getY() - this.screenStart.getY();
    }

    /**
     * @return the start point of the screen (up left)
     */
    public Point getscreenStart() {
        return this.screenStart;
    }

    /**
     * @return the end point of the screen (down right)
     */
    public Point getscreenEnd() {
        return this.screenEnd;
    }

    /**
     * @return the X value of the center of the ball
     */
    public double getX() {
        return this.center.getX();
    }

    /**
     * @return the Y value of the center of the ball
     */
    public double getY() {
        return this.center.getY();
    }

    /**
     * @return the radius of the ball
     */
    public int getSize() {
        return this.r;
    }

    /**
     * @return the color of the ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface our surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) center.getX(), (int) center.getY(), r);

    }

    /**
     * set the velocity of the ball with given velocity.
     *
     * @param v velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * set the velocity of the ball with dx and dy.
     *
     * @param dx X direction
     * @param dy y direction
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * @return the ball velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * moving the ball one step.
     */
    public void moveOneStep() {
        if (this.velocity == null) {
            return;
        }
        if (center.getY() - getSize() <= this.getscreenStart().getY() && this.velocity.getDy() < 0) {
            this.setVelocity(this.velocity.getDx(), -(this.velocity.getDy()));
        } else if (center.getY() + getSize() >= this.getscreenEnd().getY() && this.velocity.getDy() > 0) {
            this.setVelocity(this.velocity.getDx(), -(this.velocity.getDy()));
        }
        if (center.getX() + getSize() >= this.getscreenEnd().getX() && this.velocity.getDx() > 0) {
            this.setVelocity(-(this.velocity.getDx()), this.velocity.getDy());
        } else if ((center.getX() - getSize() <= this.getscreenStart().getX() && this.velocity.getDx() < 0)) {
            this.setVelocity(-(this.velocity.getDx()), this.velocity.getDy());
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

}

