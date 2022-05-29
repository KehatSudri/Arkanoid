/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * game flow class.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private GUI gui;

    /**
     * game flow constructor.
     *
     * @param ar  AnimationRunner
     * @param ks  KeyboardSensor
     * @param gui gui
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.gui = gui;
    }

    /**
     * run the levels.
     *
     * @param levels list of levels
     */
    public void runLevels(List<LevelInformation> levels) {
        Counter score = new Counter();
        Counter lives = new Counter();
        lives.increase(3);

        boolean win = true;
        for (LevelInformation levelInfo : levels) {

            GameLevel game = new GameLevel(levelInfo, this.animationRunner, this.keyboardSensor, score, lives);
            game.initialize();
            while (game.getBlocksCounter().getValue() != 0 && lives.getValue() != 0) {
                game.run();
                if (game.getBlocksCounter().getValue() > 0) {
                    lives.decrease(1);
                }
                game.centerPaddle();
                game.addBalls();


            }
            if (game.getLives().getValue() == 0) {
                win = false;
                break;

            }


        }
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                "Win", new EndScreen(this.keyboardSensor, win,
                score), score));
        gui.close();

    }
}


