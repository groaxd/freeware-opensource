package freeware;

public class Timer
{
    private long AL;
    public long AM;
    
    public Timer() {
        this.AL = 0L;
        this.AM = System.currentTimeMillis();
    }
    
    public void Ag() {
        this.AM = System.currentTimeMillis();
    }
    
    public boolean Ah(final long n, final boolean b) {
        if (System.currentTimeMillis() - this.AM > n) {
            if (b) {
                this.Ag();
            }
            return true;
        }
        return false;
    }
    
    public boolean Ai(final double n) {
        return this.Ak() - this.AL >= n;
    }
    
    public void Aj() {
        this.AL = this.Ak();
    }
    
    public long Ak() {
        return System.nanoTime() / 1000000L;
    }
    
    public long Al() {
        return this.Ak() - this.AL;
    }
}
