/**
 * Created by Moritz on 9/22/2016.
 *
 * Superclass for Euclid's algorithms.
 */
public abstract class EuclidResult {
    public long numberOne;
    public long numberTwo;
    public long gcd;
    public Long runtimeNS;
    public double runtimeMS;

    protected void init(long num1, long num2){
        long startTime;                         //used for timing the algorithms
        numberOne = num1; numberTwo = num2;

        //calculate the GCD using Euclid's algorithm 1, and get the running time while we're at it
        startTime = System.nanoTime();
        gcd = runAlgorithm();
        runtimeNS = System.nanoTime() - startTime;
        runtimeMS = runtimeNS / 1000000.0;
    }

    public abstract long runAlgorithm();
}
