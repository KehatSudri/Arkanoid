/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;

import java.util.List;

/**
 * interface for Level Information.
 */
public interface LevelInformation {
    /**
     *
     * @return nuber of balls.
     */
    int numberOfBalls();

    /**
     * @return The initial velocity of each ball.
     * Note that initialBallVelocities().size() == numberOfBalls()
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return the paddle speed.
     */
    int paddleSpeed();

    /**
     * @return paddle width
     */
    int paddleWidth();

    /**
     * @return the level name will be displayed at the top of the screen.
     */
    String levelName();

    /**
     * @return Returns a sprite with the background of the level.
     */
    Sprite getBackground();


    /**
     * @return The Blocks that make up this level, each block contains.
     * its size, color and location.
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return number Of Blocks To Remove
     */
    int numberOfBlocksToRemove();

    /**
     * dreaw the level.
     *
     * @param d DrawSurface
     */
    void drawLevel(DrawSurface d);
}
