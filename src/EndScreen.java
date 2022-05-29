/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * class for the end screen.
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private boolean win;
    private Counter score;

    /**
     * vonstructor for end screen.
     *
     * @param k     keyboard sensor
     * @param win   win or lose boolean
     * @param score acore counter
     */
    public EndScreen(KeyboardSensor k, boolean win, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.win = win;
        this.score = score;

    }

    /**
     * do one frame of the animation.
     *
     * @param d DrawSurface
     */
    @Override
    public void doOneFrame(DrawSurface d) {

        if (this.win) {
            d.drawText(d.getWidth() / 4, d.getHeight() / 2, "You Win! Your score is " + score.getValue(), 32);

        } else {
            d.drawText(d.getWidth() / 4, d.getHeight() / 2, "Game Over. Your score is " + score.getValue(), 32);

        }
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * check if ani,ation should stop.
     *
     * @return T or F
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
