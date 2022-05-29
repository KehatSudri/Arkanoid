/**
 * @author kehat sudri
 * 318409745
 */
// a BlockRemover is in charge of removing blocks from the game, as well as keeping count
// of the number of blocks that remain.
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * remove a block from the game.
     *
     * @param game          the game
     * @param removedBlocks amount of blocks that should be removed
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * Blocks that are hit should be removed.
     *
     * @param beingHit the blocks that have been hitted
     * @param hitter   the ball that hit them
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(game);
        remainingBlocks.decrease(1);


    }
}
