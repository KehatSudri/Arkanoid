/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * class for Animation Runner.
 */
public class AnimationRunner {

    private GUI gui;
    private int framesPerSecond;

    /**
     * constructor for Animation Runner.
     *
     * @param gui gui
     * @param framesPerSecond frames Per Second
     */
    public AnimationRunner(GUI gui, int framesPerSecond) {

        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
    }

    /**
     * run the animation.
     *
     * @param animation Animation
     */
    public void run(Animation animation) {

        Sleeper sleeper = new Sleeper();
       // int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
