/**
 * @author kehat sudri
 * 318409745
 */


/**
 * class of collision Info.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * constructor for CollisionInfo.
     *
     * @param collisionPoint  collisionPoint
     * @param collisionObject collisionObject
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }


    /**
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }


    /**
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }

    /**
     * setting the CollisionPoint.
     *
     * @param collisionPoint1 collisionPoint
     */
    public void setCollisionPoint(Point collisionPoint1) {
        this.collisionPoint = collisionPoint1;
    }

    /**
     * setting the CollisionObject.
     *
     * @param collisionObject1 CollisionObject
     */
    public void setCollisionObject(Collidable collisionObject1) {
        this.collisionObject = collisionObject1;
    }

}