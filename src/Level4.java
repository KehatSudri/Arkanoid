/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * class for the forth level.
 */
public class Level4 implements LevelInformation {


    private Sprite background;

    /**
     * @return the numbers of the balls in the level.
     */
    @Override
    public int numberOfBalls() {
        return 13;
    }

    /**
     * @return The initial velocity of each ball in list.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l1 = new ArrayList<Velocity>();
        for (int i = 0; i < numberOfBalls(); i++) {
            Velocity v1 = new Velocity((i - 2) * (Math.pow(-1, i)), 6);
            l1.add(v1);
        }
        return l1;

    }

    /**
     * @return the speed of the paddle.
     */
    @Override
    public int paddleSpeed() {
        return 8;
    }

    /**
     * @return the width of the paddle.
     */
    @Override
    public int paddleWidth() {
        return 100;
    }

    /**
     * @return the level name.
     */
    @Override
    public String levelName() {
        return "Illusions level";
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
        int x = 17;
        Random rand = new Random();

        List<Block> blocksList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, g, b);

            Point p = new Point(x + (i * 51), 200);
            Rectangle rectangle = new Rectangle(p, 51, 25, Color.BLUE);
            Block block = new Block(rectangle);
            blocksList.add(block);
        }

        return blocksList;
    }

    /**
     * @return Number of blocks that should be removed
     * before the level is considered to be "cleared".
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 75;
    }

    /**
     * drawing the level.
     *
     * @param d DrawSurface
     */
    public void drawLevel(DrawSurface d) {

        d.setColor(Color.lightGray);
        d.fillRectangle(15, 15, 770, 585);


        d.setColor(Color.white);
        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 15; i++) {
                d.fillCircle(22 + 59 * i, 595 - j * 57, 33);
            }
        }
        d.setColor(Color.white);
    }
}


