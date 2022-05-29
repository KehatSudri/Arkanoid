/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;
import java.awt.Color;


/**
 * the class represent a ball with center point ,radius ,color.
 * velocity and zone of live
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private Point screenStart;
    private Point screenEnd;
    private GameEnvironment gameEnvironment;

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
     * when time passes move on step.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * add the ball to the game.
     *
     * @param g game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
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
     * setting the game enviornment.
     *
     * @param gameEnvironment1 gameEnvironment
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment1) {
        this.gameEnvironment = gameEnvironment1;

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
     * @return the center of the ball
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface our surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) center.getX(), (int) center.getY(), r);
        surface.setColor(Color.green);
        surface.drawCircle((int) center.getX(), (int) center.getY(), r);


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
     * remove the ball from the game.
     *
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);

    }

    /**
     * moving the ball one step.
     */
    public void moveOneStep() {
        Point p1 = this.getVelocity().applyToPoint(this.center);
        // Point p = new Point(center.getX() + this.velocity.getDx(), center.getX() + this.velocity.getDx());
        Line trajectory = new Line(this.center, p1);
        if (this.gameEnvironment.getClosestCollision(trajectory) != null) {
            CollisionInfo cf1 = this.gameEnvironment.getClosestCollision(trajectory);
            this.center = trajectory.pointAfterRatio(this.getVelocity(), cf1.collisionPoint());
            this.velocity = cf1.collisionObject().hit(this, cf1.collisionPoint(), this.getVelocity());

        } else {
            this.center = this.getVelocity().applyToPoint(this.center);
        }

    }

}

