/**
 * @author kehat sudri
 * 318409745
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Score Tracking Listener constructor.
     *
     * @param scoreCounter score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * when hit happend we add 5 points.
     *
     * @param beingHit the beingHit object
     * @param hitter   the Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {

        currentScore.increase(5);

    }

    /**
     * @return the current score.
     */
    public Counter getCurrentScore() {
        return this.currentScore;
    }
}