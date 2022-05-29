/**
 * @author kehat sudri
 * 318409745
 */
public class Counter {
    private int current;

    /**
     * constructor for Counter.
     */
    public Counter() {
        this.current = 0;
    }

    /**
     * add number to current count.
     *
     * @param number the ammount we want to add
     */
    void increase(int number) {
        current += number;
    }


    /**
     * subtract number from current count.
     *
     * @param number the amount we want to decrease
     */
    void decrease(int number) {
        current -= number;
    }

    /**
     * @return the current count.
     */
    int getValue() {
        return current;
    }
}
