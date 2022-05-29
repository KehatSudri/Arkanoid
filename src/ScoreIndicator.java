/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;

/**
 * Score Indicator class.
 */
public class ScoreIndicator implements Sprite {
    private ScoreTrackingListener scoreTrackingListener;

    /**
     * score indicator constructor.
     *
     * @param scoreTrackingListener scoreTrackingListener
     */
    public ScoreIndicator(ScoreTrackingListener scoreTrackingListener) {

        this.scoreTrackingListener = scoreTrackingListener;

    }

    @Override
    public void drawOn(DrawSurface d) {
        String string = String.valueOf(this.scoreTrackingListener.getCurrentScore().getValue());
        d.drawText(370, 13, "score :" + string, 15);
    }

    @Override
    public void timePassed() {


    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
