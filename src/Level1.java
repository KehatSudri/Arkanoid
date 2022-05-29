/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * class for the first level.
 */
public class Level1 implements LevelInformation {

    private Sprite background;

    /**
     * @return the numbers of the balls in the level.
     */
    @Override
    public int numberOfBalls() {
        return 1;
    }

    /**
     * @return The initial velocity of each ball in list.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l1 = new ArrayList<Velocity>();
        Velocity v1 = new Velocity(0, 9);
        l1.add(v1);
        return l1;

    }

    /**
     * @return the speed of the paddle.
     */
    @Override
    public int paddleSpeed() {
        return 10;
    }

    /**
     * @return the width of the paddle.
     */
    @Override
    public int paddleWidth() {
        return 90;
    }

    /**
     * @return the level name.
     */
    @Override
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * @return the background of the level.
     */
    @Override
    public Sprite getBackground() {
        return this.background;
    }

    /**
     * @return The Blocks that make up this level, each block contains
     * its size, color and location.
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocksList = new ArrayList<>();
        Point p = new Point(390, 100);
        Rectangle rectangle = new Rectangle(p, 20, 20, Color.red);
        Block block = new Block(rectangle);
        blocksList.add(block);
        return blocksList;
    }

    /**
     * @return Number of blocks that should be removed
     * before the level is considered to be "cleared".
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

    /**
     * drawing the level.
     *
     * @param d DrawSurface
     */
    public void drawLevel(DrawSurface d) {

        d.setColor(Color.black);
        d.fillRectangle(15, 15, 770, 585);
        d.setColor(Color.white);
        d.drawLine(420, 110, 500, 110);
        d.drawLine(380, 110, 300, 110);
        d.drawLine(400, 90, 400, 20);
        d.drawLine(400, 130, 400, 210);
        d.setColor(Color.green);
        d.drawCircle(400, 110, 30);
        d.setColor(Color.yellow);
        d.drawCircle(400, 110, 40);
        d.setColor(Color.magenta);
        d.drawCircle(400, 110, 60);
        d.setColor(Color.blue);
        d.drawCircle(400, 110, 70);
        d.setColor(Color.DARK_GRAY);
        d.drawCircle(400, 110, 80);
        d.setColor(Color.orange);
        d.drawCircle(400, 110, 50);


    }
}
