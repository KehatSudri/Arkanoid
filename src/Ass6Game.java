/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.KeyboardSensor;
import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;


/**
 * class to run the game.
 */
public class Ass6Game {
    /**
     * .
     * main function
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<LevelInformation>();

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("1")) {
                Level1 level1 = new Level1();
                levels.add(level1);

            }
            if (args[i].equals("2")) {
                Level2 level2 = new Level2();
                levels.add(level2);

            }
            if (args[i].equals("3")) {
                Level3 level3 = new Level3();
                levels.add(level3);

            }
            if (args[i].equals("4")) {
                Level4 level4 = new Level4();
                levels.add(level4);

            } else {
                continue;
            }
        }
        if (levels.size() == 0) {
            Level1 level1 = new Level1();
            Level2 level2 = new Level2();
            Level3 level3 = new Level3();
            Level4 level4 = new Level4();
            levels.add(level1);
            levels.add(level2);
            levels.add(level3);
            levels.add(level4);
        }
        GUI gui = new biuoop.GUI("Arkanoid", 800, 600);
        AnimationRunner animationRunner = new AnimationRunner(gui, 60);
        KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
        GameFlow gameFlow = new GameFlow(animationRunner, keyboardSensor, gui);
        gameFlow.runLevels(levels);

        /*AnimationRunner runner =new AnimationRunner(gui,60);
        boolean b=false ;
        Counter c=new Counter();
        Animation a1 =new EndScreen(keyboardSensor,b,c);
        Animation a2 = new PauseScreen(keyboardSensor); // also an Animation
        Animation a1k = new KeyPressStoppableAnimation(keyboardSensor,"m", a1,c);
        Animation a2k = new KeyPressStoppableAnimation(keyboardSensor,"m", a2,c);
        runner.run(a1k);
        runner.run(a2k);
        gui.close();*/

    }
}
