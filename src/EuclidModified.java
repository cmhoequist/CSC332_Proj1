/**
 * Created by Bailey-Fawcett-Hoequist on 9/22/2016.
 *
 * Modified Euclid's algorithm.
 */
public class EuclidModified extends EuclidResult{
    public EuclidModified(long num1, long num2) {
        init(num1, num2);
    }

    @Override
    public long runAlgorithm() {
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
            remainder = numberOne - numberTwo;
            if(remainder >= numberTwo){
                remainder = remainder - numberTwo;
                if(remainder >= numberTwo){
                    remainder = remainder - numberTwo;
                    if(remainder > numberTwo){
                        remainder = numberOne - numberTwo * (numberOne / numberTwo);
                    }
                }
            }
            numberOne = numberTwo;
            numberTwo = remainder;
        }

        //Return gcd
        return numberOne;
    }

}
