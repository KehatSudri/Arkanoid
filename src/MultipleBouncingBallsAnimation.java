/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.util.Random;

/**
 * this class crate a multiple bouncing balls animation.
 */
public class MultipleBouncingBallsAnimation {
    private static final int MAX_RAD = 50;

    /**
     * @param min min of the range
     * @param max max of the range
     * @return random number in the givven range
     */
    public static double nextDoubleBetween2(double min, double max) {
        return (new Random().nextDouble() * (max - min)) + min;
    }

    /**
     * the function draw the animation.
     *
     * @param args the arguments from the cimmand line
     */
    private static void drawAnimation1(int[] args) {
        GUI gui = new GUI("MultipleBouncingBallsAnimation", 200, 200);
        Sleeper sleeper = new Sleeper();
        Ball[] ballarr = new Ball[args.length];
        Random rand = new Random();
        for (int i = 0; i < args.length; i++) {
            //double rand1=new rand.nextDouble()*200;
            ballarr[i] = new Ball(nextDoubleBetween2(args[i], 200 - args[i]),
                    nextDoubleBetween2(args[i], 200 - args[i]), args[i], java.awt.Color.BLACK);
            ballarr[i].setScreenSize(0, 0, 200, 200);
        }
        double dx = rand.nextDouble() * 100;
        double dy = rand.nextDouble() * 100;
        for (int i = 0; i < args.length; i++) {
            if (ballarr[i].getSize() > MAX_RAD) {
                ballarr[i].setVelocity(dx / MAX_RAD, dy / MAX_RAD);
            } else {
                ballarr[i].setVelocity(dx / ballarr[i].getSize(),
                        dy / ballarr[i].getSize());
            }
        }
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            for (int i = 0; i < ballarr.length; i++) {
                ballarr[i].moveOneStep();
                ballarr[i].drawOn(d);
            }
            sleeper.sleepFor(25);  // wait for 50 milliseconds.
            gui.show(d);

        }

    }

    /**
     * @param args args
     */
    public static void main(String[] args) {
        int[] array = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            if (Integer.parseInt(args[i]) <= 0) {
                System.out.println("Error - not positive radius");
                return;
            }
            if (Integer.parseInt(args[i]) > 50) {
                array[i] = 50;
            } else {
                array[i] = Integer.parseInt(args[i]);
            }
        }
        drawAnimation1(array);
    }
}