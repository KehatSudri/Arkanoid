/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;

/**
 * class for Lives Indicator that implements Sprite.
 */
public class LivesIndicator implements Sprite {
    /**
     * @author kehat sudri
     * 318409745
     */
    private ScoreTrackingListener scoreTrackingListener;
    private Counter lives;

    /**
     * score indicator constructor.
     *
     * @param lives                 lives
     * @param scoreTrackingListener scoreTrackingListener
     */
    public LivesIndicator(ScoreTrackingListener scoreTrackingListener, Counter lives) {

        this.scoreTrackingListener = scoreTrackingListener;
        this.lives = lives;


    }

    @Override
    public void drawOn(DrawSurface d) {

        d.drawText(100, 13, "Lives : " + this.lives.getValue(), 15);
    }

    @Override
    public void timePassed() {


    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}



