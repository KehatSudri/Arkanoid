/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;

/**
 * Interface of Sprite in the game.
 */
public interface Sprite {


    /**
     * draw the sprite to the screen.
     *
     * @param d DrawSurface
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * add sprite to game.
     *
     * @param g the game
     */
    void addToGame(GameLevel g);
}
