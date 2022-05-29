/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * class for Pause Screen that implements Animation.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * constructor for pause screen.
     *
     * @param k KeyboardSensor
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * do one frame of the animation.
     *
     * @param d DrawSurface
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(d.getHeight() / 2, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }


    }

    /**
     * check if the animation should stop.
     *
     * @return T or F
     */
    public boolean shouldStop() {
        return this.stop;
    }
}