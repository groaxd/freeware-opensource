package freeware.helper;

public class Timer
{
    private long timeD;
    public long time;
    
    public Timer() {
        this.timeD = 0L;
        this.time = System.currentTimeMillis();
    }
    
    public void reset() {
        this.time = System.currentTimeMillis();
    }
    
    public boolean hasTimePassed(final long ms, final boolean shouldReset) {
        if (System.currentTimeMillis() - this.time > ms) {
            if (shouldReset) {
                this.reset();
            }
            return true;
        }
        return false;
    }
    
    public boolean hasTimePassed0(final double n) {
        return this.getTime0() - this.timeD >= n;
    }
    
    public void reset0() {
        this.timeD = this.getTime0();
    }
    
    public long getTime0() {
        return System.nanoTime() / 1000000L;
    }
    
    public long getTime() {
        return this.getTime0() - this.timeD;
    }
}
