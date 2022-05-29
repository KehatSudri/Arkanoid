/**
 * @author kehat sudri
 * 318409745
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     *
     * @param hl hit listener
     */
    void addHitListener(HitListener hl);

    /**
     * @param hl hit listener.
     * Remove hl from the list of listeners to hit events.
     */
    void removeHitListener(HitListener hl);
}