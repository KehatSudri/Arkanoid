/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * class of block that implements Collidable and Sprite interfaces.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private List<HitListener> hitListeners;


    /**
     * constructor of Block.
     *
     * @param rectangle rectangle
     */
    public Block(Rectangle rectangle) {
        this.rectangle = rectangle;
        hitListeners = new ArrayList<>();
    }


    /**
     * drowing the block.
     *
     * @param surface DrawSurface
     */
    public void drawOn(DrawSurface surface) {

        surface.setColor(this.rectangle.getColor());
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());

    }

    /**
     * timePassed.
     */
    public void timePassed() {
    }

    /**
     * add the block to the game.
     *
     * @param g Game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * remove a block from the game.
     *
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    /**
     * Notify all listeners about a hit event.
     *
     * @param hitter the ball that hitted
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }


    @Override
    /**
     * getCollisionRectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    /**
     * set what to do with the velocity after hitting a block
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.rectangle.setSidesLRUD();
        Line[] sides = this.rectangle.getSidesLRUD();
        if (sides[0].isPointOnLine(sides[0], collisionPoint)) {
            currentVelocity.setDx(-(currentVelocity.getDx()));
        }
        if (sides[1].isPointOnLine(sides[1], collisionPoint)) {
            currentVelocity.setDx(-(currentVelocity.getDx()));

        }
        if (sides[2].isPointOnLine(sides[2], collisionPoint)) {
            currentVelocity.setDy(-(currentVelocity.getDy()));

        }
        if (sides[3].isPointOnLine(sides[3], collisionPoint)) {
            currentVelocity.setDy(-(currentVelocity.getDy()));

        }
        this.notifyHit(hitter);
        return currentVelocity;

    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
}
