/**
 * @author kehat sudri
 * 318409745
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * removing the ball from the game.
     *
     * @param game         the game
     * @param removedBalls the amiunt we want to remove
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }


    /**
     * Balls that are hit should be removed.
     *
     * @param beingHit the block being hit
     * @param hitter   the ball that hit
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(game);
        remainingBalls.decrease(1);


    }
}

