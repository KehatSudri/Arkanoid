/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;


/**
 * class of the paddle that implements Sprite and Collidable interfaces.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;  //keyboard sensor
    private Rectangle rectangle;  //the paddle rectangle
    private int paddleSpeed;

    /**
     * constructor for paddle.
     *
     * @param rectangle rectangle
     * @param keyboard  keyboard
     */
    public Paddle(Rectangle rectangle, biuoop.KeyboardSensor keyboard) {
        this.rectangle = rectangle;
        this.keyboard = keyboard;
    }

    /**
     * constructor for paddle.
     * @param rectangle rectangle
     * @param keyboard keyboard
     * @param paddleSpeed paddleSpeed
     */
    public Paddle(Rectangle rectangle, biuoop.KeyboardSensor keyboard, int paddleSpeed) {
        this.rectangle = rectangle;
        this.keyboard = keyboard;
        this.paddleSpeed = paddleSpeed;
    }

    /**
     * moving left with the paddle.
     */
    public void moveLeft() {
        if (this.rectangle.getUpperLeft().getX() - this.paddleSpeed >= 17) {

            this.rectangle.getUpperLeft().setX(this.rectangle.getUpperLeft().getX() - this.paddleSpeed);
        } else {
            this.rectangle.getUpperLeft().setX(17);
        }
    }

    /**
     * moving right with the paddle.
     */
    public void moveRight() {
        if (this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() + this.paddleSpeed <= 783) {
            this.rectangle.getUpperLeft().setX(this.rectangle.getUpperLeft().getX() + this.paddleSpeed);
        } else {
            this.rectangle.getUpperLeft().setX(783 - this.rectangle.getWidth());
        }
    }

    /**
     * setting the place of the paddle.
     * @param rectangle1 rectangle1
     */
    public void setPlace(Rectangle rectangle1) {
        this.rectangle = rectangle1;
    }

    /**
     * Sprite function of timePassed.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }


    /**
     * Sprite interface function of drawOn.
     *
     * @param d DrawSurface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.green);
        d.drawRectangle((int) this.rectangle.getUpperLeft().getX() - 1, (int) this.rectangle.getUpperLeft().getY() - 1,
                (int) this.rectangle.getWidth() + 1, (int) this.rectangle.getHeight() + 1);
        d.setColor(Color.BLACK);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());

    }

    //Collidable

    /**
     * Collidable interface of getting Collision Rectangle.
     *
     * @return this.rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * function that set what we do if we hit the paddle (5 parts).
     *
     * @param hitter          the hitter ball
     * @param collisionPoint  collisionPoint
     * @param currentVelocity currentVelocity
     * @return new velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        double b = this.rectangle.getWidth() / 5;
        double regionn1 = this.rectangle.getUpperLeft().getX() + b;
        double regionn2 = this.rectangle.getUpperLeft().getX() + 2 * b;
        double regionn3 = this.rectangle.getUpperLeft().getX() + 3 * b;
        double regionn4 = this.rectangle.getUpperLeft().getX() + 4 * b;
        double regionn5 = this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth();


        if ((collisionPoint.getX() <= this.rectangle.getUpperLeft().getX())
                || (collisionPoint.getX() >= this.rectangle.getUpperRight().getX())) {
            return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }
        //region1
        if ((collisionPoint.getX() <= regionn1) && (collisionPoint.getX() >= this.rectangle.getUpperLeft().getX())) {
            return Velocity.fromAngleAndSpeed(300, Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
                    + Math.pow(currentVelocity.getDy(), 2)));
        }
        //region2
        if ((collisionPoint.getX() <= regionn2) && (collisionPoint.getX() >= regionn1)) {
            return Velocity.fromAngleAndSpeed(330, Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
                    + Math.pow(currentVelocity.getDy(), 2)));
        }
        //region 3
        if ((collisionPoint.getX() <= regionn3 && (collisionPoint.getX() >= regionn2))) {
            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }
        //region4
        if ((collisionPoint.getX() <= regionn4) && (collisionPoint.getX() >= regionn3)) {
            return Velocity.fromAngleAndSpeed(30, Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
                    + Math.pow(currentVelocity.getDy(), 2)));
        }
        //region5
        return Velocity.fromAngleAndSpeed(60, Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
                + Math.pow(currentVelocity.getDy(), 2)));


    }


    /**
     * Add this paddle to the game.
     * function from Sprite interface
     *
     * @param g Game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

}