/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;

/**
 * Animation interface.
 */
public interface Animation {
    /**
     * do one frame of the animation.
     *
     * @param d DrawSurface
     */
    void doOneFrame(DrawSurface d);

    /**
     * check if ani,ation should stop.
     *
     * @return T or F
     */
    boolean shouldStop();
}
