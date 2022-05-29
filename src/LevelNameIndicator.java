/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;

/**
 * class for Level Name Indicator that implements Sprite.
 */
public class LevelNameIndicator implements Sprite {
    /**
     * @author kehat sudri
     * 318409745
     */
    private ScoreTrackingListener scoreTrackingListener;
    private String name;

    /**
     * score indicator constructor.
     * @param name name
     * @param scoreTrackingListener scoreTrackingListener
     */
    public LevelNameIndicator(ScoreTrackingListener scoreTrackingListener, String name) {

        this.scoreTrackingListener = scoreTrackingListener;
        this.name = name;

    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(570, 13, "Level Name : " + this.name, 15);
    }

    @Override
    public void timePassed() {


    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}

