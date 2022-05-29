/**
 * @author kehat sudri
 * 318409745
 */

import java.util.ArrayList;
import java.util.List;

/**
 * class of the game enviornment.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * constructor for game enviornment.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }


    /**
     * add the given collidable to the environment.
     *
     * @param c Collidable
     */
    public void addCollidable(Collidable c) {

        this.collidables.add(c);
    }

    /**
     * remove the given collidable from the game.
     *
     * @param c Collidable
     */
    public void removeCollidable(Collidable c) {

        this.collidables.remove(c);
    }


    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory trajectory
     * @return new collision info
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Collidable> relevantObjects = new ArrayList<>();
        for (int i = 0; i < collidables.size(); i++) {
            if (trajectory.closestIntersectionToStartOfLine(this.collidables.get(i).getCollisionRectangle()) != null) {
                relevantObjects.add(collidables.get(i));
            }
        }
        if (relevantObjects == null || relevantObjects.isEmpty()) {
            return null;
        }
        Point p1;
        p1 = trajectory.closestIntersectionToStartOfLine(relevantObjects.get(0).getCollisionRectangle());
        Collidable coObject = (relevantObjects.get(0));
        double dist = trajectory.start().distance(p1);
        for (int i = 1; i < relevantObjects.size(); i++) {
            if ((trajectory.closestIntersectionToStartOfLine(relevantObjects.get(i).getCollisionRectangle()).
                    distance(trajectory.start())) < dist) {
                p1 = trajectory.closestIntersectionToStartOfLine(relevantObjects.get(i).getCollisionRectangle());
                coObject = relevantObjects.get(i);
            }
        }
        return new CollisionInfo(p1, coObject);
    }

}