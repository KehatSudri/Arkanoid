/**
 * @author kehat sudri
 * 318409745
 */

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * this class is for SpriteCollection.
 */
public class SpriteCollection {
    private List<Sprite> spriteList;

    /**
     * constructor for SpriteCollection.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<>();
    }

    /**
     * this function add Sprite to the Sprite list.
     *
     * @param s Sprite
     */
    public void addSprite(Sprite s) {
        this.spriteList.add(s);
    }

    /**
     * this function remove Sprite from the Sprite list.
     *
     * @param s Sprite
     */
    public void removeSprite(Sprite s) {
        this.spriteList.remove(s);
    }


    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.spriteList.size(); i++) {
            this.spriteList.get(i).timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d DrawSurface
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.spriteList.size(); i++) {
            this.spriteList.get(i).drawOn(d);
        }
    }
}