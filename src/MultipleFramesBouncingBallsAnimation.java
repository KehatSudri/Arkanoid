/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.awt.Color;
import java.util.Random;

/**
 * this class create a multiple frames bouncing balls animation.
 */
public class MultipleFramesBouncingBallsAnimation {
    private static final int MAX_RAD = 50;

    /**
     * this function draw the animation.
     *
     * @param args the arguments from the command line
     */
    private static void drawAnimationFrames(int[] args) {
        GUI gui = new GUI("MultipleFramesBouncingBallsAnimation", 1000, 1000);
        Sleeper sleeper = new Sleeper();
        Random rand = new Random();
        Ball[] ballarr1 = new Ball[args.length];
        for (int i = 0; i < args.length / 2; i++) {
            ballarr1[i] = new Ball(MultipleBouncingBallsAnimation.
                    nextDoubleBetween2(args[i] + 50, 500 - args[i]),
                    MultipleBouncingBallsAnimation.nextDoubleBetween2(
                            args[i] + 50, 500 - args[i]), args[i], java.awt.Color.blue);
            ballarr1[i].setScreenSize(50, 50, 500, 500);

        }
        for (int i = args.length / 2; i < args.length; i++) {
            ballarr1[i] =
                    new Ball(MultipleBouncingBallsAnimation.nextDoubleBetween2(
                            args[i] + 450, 600 - args[i]),
                            MultipleBouncingBallsAnimation.nextDoubleBetween2(
                                    args[i] + 450, 600 - args[i]), args[i], Color.black);
            ballarr1[i].setScreenSize(450, 450, 600, 600);

        }
        double dx = rand.nextDouble() * 100;
        double dy = rand.nextDouble() * 100;
        for (int i = 0; i < args.length; i++) {
            if (ballarr1[i].getSize() > MAX_RAD) {
                ballarr1[i].setVelocity(dx / MAX_RAD, dy / MAX_RAD);
            } else {
                ballarr1[i].setVelocity(dx / ballarr1[i].getSize(),
                        dy / ballarr1[i].getSize());
            }
        }
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            d.fillRectangle(50, 50, 450, 450);
            d.setColor(Color.yellow);
            d.fillRectangle(450, 450, 150, 150);
            d.setColor(Color.yellow);
            for (int i = 0; i < ballarr1.length; i++) {
                ballarr1[i].moveOneStep();
                ballarr1[i].drawOn(d);
            }
            sleeper.sleepFor(25);  // wait for 50 milliseconds.
            gui.show(d);

        }


    }

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        int[] array2 = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            if (Integer.parseInt(args[i]) <= 0) {
                System.out.println("Error - not positive radius");
                return;
            }
            if (Integer.parseInt(args[i]) > 50) {
                array2[i] = 50;
            } else {
                array2[i] = Integer.parseInt(args[i]);
            }
        }
        drawAnimationFrames(array2);
    }
}
