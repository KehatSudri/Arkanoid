/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.Color;
import java.util.Random;

/**
 * this class draw abstract line and dots in their middles and.
 * intersection points
 */
public class AbstractArtDrawing {

    static final int X_SIZE = 200, Y_SIZE = 200;
    private Line[] lines = new Line[10];

    /**
     * this function draw the animation.
     */
    public void drawRandomLines() {
        Random rand = new Random();
        GUI gui = new GUI("Random Lines and points", X_SIZE, Y_SIZE);
        DrawSurface d = gui.getDrawSurface();
        for (int i = 0; i < 10; ++i) {
            int x1 = rand.nextInt(X_SIZE);
            int y1 = rand.nextInt(Y_SIZE);
            int x2 = rand.nextInt(X_SIZE);
            int y2 = rand.nextInt(Y_SIZE);
            d.drawLine(x1, y1, x2, y2);
            d.setColor(Color.BLUE);
            Line l1 = new Line(x1, y1, x2, y2);
            lines[i] = l1;
            double x = (l1.middle().getX());
            double y = (l1.middle().getY());
            int r = 3;
            d.fillCircle((int) x, (int) y, r);
            d.setColor(Color.BLACK);

        }
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                if (lines[j].isIntersecting(lines[k])) {
                    double x = (lines[j].intersectionWith(lines[k]).getX());
                    double y = (lines[j].intersectionWith(lines[k]).getY());
                    int r = 3;
                    d.fillCircle((int) x, (int) y, r);
                    d.setColor(Color.RED);
                }

            }
        }
        gui.show(d);
    }

    /**
     * @param args args
     */
    public static void main(String[] args) {
        AbstractArtDrawing example1 = new AbstractArtDrawing();
        example1.drawRandomLines();
    }

}
