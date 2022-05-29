/**
 * @author kehat sudri
 * 318409745
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit the beingHit object
     * @param hitter   the Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}