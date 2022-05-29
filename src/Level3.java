/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * class for the third level.
 */
public class Level3 implements LevelInformation {
    /**
     * @return the numbers of the balls in the level.
     */
    @Override
    public int numberOfBalls() {
        return 7;
    }

    /**
     * @return The initial velocity of each ball in list.
     */
    @Override
    public List<Velocity> initialBallVelocities() {

        List<Velocity> l1 = new ArrayList<Velocity>();
        for (int i = 0; i < numberOfBalls(); i++) {
            Velocity v1 = new Velocity((i - 2) * (Math.pow(-1, i)), -10);
            l1.add(v1);
        }
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
        return 320;
    }

    /**
     * @return the level name.
     */
    @Override
    public String levelName() {
        return "Stairs level";
    }

    /**
     * @return the background of the level.
     */
    @Override
    public Sprite getBackground() {
        return null;
    }

    /**
     * @return The Blocks that make up this level, each block contains
     * its size, color and location.
     */
    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<Block>();


        for (int i = 733; i > 133; i -= 50) {
            Point newPoint = new Point(i, 150);
            Rectangle rectangle11 = new Rectangle(newPoint, 50, 25, Color.cyan);
            Block block11 = new Block(rectangle11);
            blockList.add(block11);


        }
        for (int i = 733; i > 183; i -= 50) {
            Point newPoin = new Point(i, 175);
            Rectangle rectangl = new Rectangle(newPoin, 50, 25, Color.white);
            Block bloc = new Block(rectangl);
            blockList.add(bloc);


        }
        for (int i = 733; i > 233; i -= 50) {
            Point newPoint1 = new Point(i, 200);
            Rectangle rectangle12 = new Rectangle(newPoint1, 50, 25, Color.blue);
            Block block12 = new Block(rectangle12);
            blockList.add(block12);


        }
        for (int i = 733; i > 283; i -= 50) {
            Point newPoint13 = new Point(i, 225);
            Rectangle rectangle13 = new Rectangle(newPoint13, 50, 25, Color.magenta);
            Block block13 = new Block(rectangle13);
            blockList.add(block13);


        }
        for (int i = 733; i > 333; i -= 50) {
            Point newPoint14 = new Point(i, 250);
            Rectangle rectangle14 = new Rectangle(newPoint14, 50, 25, Color.green);
            Block block14 = new Block(rectangle14);
            blockList.add(block14);


        }
        for (int i = 733; i > 383; i -= 50) {
            Point newPoint15 = new Point(i, 275);
            Rectangle rectangle15 = new Rectangle(newPoint15, 50, 25, Color.red);
            Block block15 = new Block(rectangle15);
            blockList.add(block15);


        }
        return blockList;
    }

    /**
     * @return Number of blocks that should be removed
     * before the level is considered to be "cleared".
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 57;
    }

    /**
     * drawing the level.
     *
     * @param d DrawSurface
     */
    public void drawLevel(DrawSurface d) {
        d.setColor(Color.getHSBColor(1, 107, 8));
        d.fillRectangle(15, 15, 770, 585);
        d.setColor(Color.darkGray);
        d.fillRectangle(75, 450, 120, 200);
        d.setColor(Color.white);

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 9; j++) {
                d.fillRectangle(85 + 12 * j, 460 + 12 * i, 5, 10);
            }
        }
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(130, 250, 15, 200);
        d.fillRectangle(112, 420, 50, 30);
        d.setColor(Color.red);
        d.fillCircle(137, 245, 15);
        d.setColor(Color.orange);
        d.fillCircle(137, 245, 10);
        d.setColor(Color.yellow);
        d.fillCircle(137, 245, 5);
        d.setColor(Color.white);
        d.fillCircle(137, 245, 3);


    }
}
