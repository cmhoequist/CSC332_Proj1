import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Author: Bailey-Fawcett-Hoequist
 */
public class Main {
    private static int numPairs = 100;
    private static String resultsHeader = "Number One,Number Two,GCD,Time (ms)";
    private static String tableHeader = "Statistics,Milliseconds";

    public static void main(String[] args) {
        EuclidOriginal[] originalRuns = new EuclidOriginal[numPairs];
        EuclidModified[] modifiedRuns = new EuclidModified[numPairs];

        //GENERATE 100 pairs of random integers
        Random rand = new Random();
        for(int i = 0; i < numPairs; i++){
            long num1 = rand.nextInt(Integer.MAX_VALUE) + 1, num2 = rand.nextInt(Integer.MAX_VALUE) + 1;
            originalRuns[i] = new EuclidOriginal(num1, num2);
            modifiedRuns[i] = new EuclidModified(num1, num2);
        }

        Arrays.sort(originalRuns, (EuclidOriginal a, EuclidOriginal b) -> a.runtimeNS.compareTo(b.runtimeNS));
        Arrays.sort(modifiedRuns, (EuclidModified a, EuclidModified b) -> a.runtimeNS.compareTo(b.runtimeNS));

        //For debugging
        printResults(originalRuns);
        printTable(originalRuns);
        printResults(modifiedRuns);
        printTable(modifiedRuns);

        //Writing
        writeResults("Original_Euclid_Results.csv", originalRuns);
        writeTable("Original_Euclid_Statistics.csv", originalRuns);
        writeResults("Improved_Euclid_Results.csv", modifiedRuns);
        writeTable("Improved_Euclid_Statistics.csv", modifiedRuns);
    }

    private static void printResults(EuclidResult[] results){
        System.out.format("%-10s\t%-10s\t%-10s\t%-10s\n","Number One","Number Two","GCD","Runtime (ms)");
        for(EuclidResult e : results){
            System.out.format("%-10d\t%-10d\t%-10d\t%-10f\n",e.numberOne,e.numberTwo, e.gcd, e.runtimeMS);
        }
    }

    private static void printTable(EuclidResult[] results){
        long max, min, average, median;
        min = results[0].runtimeNS;
        max = results[numPairs -1].runtimeNS;
        long sum = 0;
        for(EuclidResult e : results){
            sum += e.runtimeNS;
        }
        average = sum / numPairs;
        median = (results[49].runtimeNS + results[50].runtimeNS) / 2;
        System.out.format("%-10s\t%-10s\n","Statistic","Milliseconds");
        System.out.format("%-10s\t%-10f\n%-10s\t%-10f\n%-10s\t%-10f\n%-10s\t%-10f\n","Min",min/1000000.0,"Max",max/1000000.0,"Average",average/1000000.0,"Median",median/1000000.0);
    }

    private static void writeResults(String filename, EuclidResult[] results){
        try(FileWriter writer = new FileWriter(new File(filename))){
            writer.write(resultsHeader + "\n");
            for(int i = 0; i < numPairs; i++){
                EuclidResult e = results[i];
                writer.write(e.numberOne+","+e.numberTwo+","+e.gcd+","+e.runtimeMS+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeTable(String filename, EuclidResult[] results){
        long max, min, average, median;
        min = results[0].runtimeNS;
        max = results[numPairs -1].runtimeNS;
        long sum = 0;
        for(EuclidResult e : results){
            sum += e.runtimeNS;
        }
        average = sum / numPairs;
        median = (results[49].runtimeNS + results[50].runtimeNS) / 2;

        try(FileWriter writer = new FileWriter(new File(filename))){
            writer.write(tableHeader + "\n");
            writer.write("Minimum Time,"+min/1000000.0);
            writer.write("Maximum Time,"+max/1000000.0);
            writer.write("Average Time,"+average/1000000.0);
            writer.write("Median Time,"+median/1000000.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

