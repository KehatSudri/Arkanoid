/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * calss for Key Press Stoppable Animation.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private Counter score;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * constructor for Key Press Stoppable Animation.
     *
     * @param sensor sensor
     * @param key key
     * @param animation animation
     * @param score score counter
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation, Counter score) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.score = score;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    /**
     * do one frame of the animation.
     *
     * @param d DrawSurface
     */
    @Override
    public void doOneFrame(DrawSurface d) {

        this.animation.doOneFrame(d);

        if (!(this.sensor.isPressed(KeyboardSensor.SPACE_KEY))) {
            isAlreadyPressed = false;
        }

        if ((this.sensor.isPressed(KeyboardSensor.SPACE_KEY)) && (!isAlreadyPressed)) {
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
