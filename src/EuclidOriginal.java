/**
 * Created by Bailey-Fawcett-Hoequist on 9/20/16.
 *
 * Container for a set of integers, their GCD, and the time in MS to calculate GCD using two different Euclid algorithms
 * Includes methods to computer the GCD using both algorithms
 *
 */
public class EuclidOriginal extends EuclidResult{
    public EuclidOriginal(long num1, long num2) {
        init(num1, num2);
    }

    @Override
    public long runAlgorithm(){
        long quotient;
        long remainder;

        //Preprocessing
        if(numberOne < 1 || numberTwo < 1)          //Ensure both a and b are greater than 0
            return 0;
        if(numberOne < numberTwo){                  //Ensure a > b
            long z = numberOne;
            numberOne = numberTwo;
            numberTwo = z;
        }
        remainder = -1;                             //Ensure we start with a non-zero remainder

        //Calculate
        while(remainder != 0){
            quotient = numberOne / numberTwo;
            remainder = numberOne - quotient * numberTwo;  //possibility for overflow error here...
            numberOne = numberTwo;
            numberTwo = remainder;
        }

        //Return gcd
        return numberOne;
    }
}