/**
 * Created by Bailey-Fawcett-Hoequist on 9/22/2016.
 *
 * Superclass for Euclid's algorithms. Computes GCD and runtime when initialized.
 */
public abstract class EuclidResult {
    //Public for convenience
    public long numberOne;
    public long numberTwo;
    public long gcd;
    public Long runtimeNS;      //Long object permits use of compareTo(Long) method. Useful when sorting later.
    public double runtimeMS;

    protected void init(long num1, long num2){
        //Initialize
        long startTime;
        numberOne = num1; numberTwo = num2;

        //Calculate the GCD and get the algorithm runtime
        startTime = System.nanoTime();
        gcd = runAlgorithm();
        runtimeNS = System.nanoTime() - startTime;
        runtimeMS = runtimeNS / 1000000.0;
    }

    public abstract long runAlgorithm();
}
