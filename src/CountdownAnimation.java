/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private long startTime;
    private long currentTime;
    private long beginingTime;
    private LevelInformation levelInformation;

    /**
     * contructor of  Count down Animation.
     *
     * @param numOfSeconds     num Of Seconds
     * @param countFrom        from where start count
     * @param gameScreen       the game screen
     * @param levelInformation the level Information
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen,
                              LevelInformation levelInformation) {
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.numOfSeconds = numOfSeconds;
        this.stop = false;
        this.startTime = System.currentTimeMillis();
        this.beginingTime = (long) (1000 * this.numOfSeconds / this.countFrom);
        this.currentTime = this.beginingTime;
        this.levelInformation = levelInformation;
    }

    /**
     * do one frame of the animation.
     *
     * @param d DrawSurface
     */
    public void doOneFrame(DrawSurface d) {
        levelInformation.drawLevel(d);

        this.gameScreen.drawAllOn(d);
        d.setColor(Color.GRAY);
        d.drawText(d.getWidth() / 2 - 65, d.getHeight() / 2, String.valueOf(countFrom), 200);
        long passedTime = System.currentTimeMillis() - startTime;
        if (passedTime > currentTime) {
            countFrom--;
            currentTime += beginingTime;
        }
        if (countFrom == 0) {
            stop = true;

        }

    }

    /**
     * check if ani,ation should stop.
     *
     * @return T or F
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
