/**
 * @author kehat sudri
 * 318409745
 */
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * this class draw a bouncing ball animation.
 */
public class BouncingBallAnimation {

    /**
     * this function draw the animation.
     *
     * @param start the point where the ball first start
     * @param dx    X direction
     * @param dy    Y direction
     */
    private static void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI("title", 200, 200);
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball(start.getX(), start.getY(), 30, java.awt.Color.BLACK);
        ball.setVelocity(dx, dy);
        ball.setScreenSize(0, 0, 200, 200);
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.

        }
    }

    /**
     * @param args args
     */
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Not enough arguments or to much you need to enter exactly 4 arguments");
            return;
        }
        Point p1 = new Point(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        drawAnimation(p1, Integer.parseInt(args[2]), Integer.parseInt(args[3]));

    }
}