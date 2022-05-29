/**
 * @author kehat sudri
 * 318409745
 */


/**
 * interface of Collidable.
 */
public interface Collidable {
    /**
     * @return Return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();


    /**
     * @param collisionPoint  the collisionPoint
     * @param currentVelocity the velocity
     * @param hitter          the ball that hitted them
     * @return Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
