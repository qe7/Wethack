package wethack.utils;

// Create a new instance to use
public class Stopwatch {

    // The start time
    private long start;

    // Constructor
    public Stopwatch() {
        reset();
    }

    // Reset the stopwatch
    public void reset() {
        start = System.currentTimeMillis();
    }

    // Check if the stopwatch has elapsed
    public boolean hasElapsed(final long ms) {
        return System.currentTimeMillis() - start > ms;
    }

    // Check if the stopwatch has elapsed and reset
    public boolean hasElapsed(final long ms, final boolean reset) {
        if (hasElapsed(ms)) {
            if (reset) {
                reset();
            }
            return true;
        }
        return false;
    }
}
