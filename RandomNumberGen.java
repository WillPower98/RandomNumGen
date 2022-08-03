import java.util.*;
import java.io.*;

public class RandomNumberGen {
    static int numberAmount =  1000000;

    public static void main(String args[]){
        try{

            //outputting numbers to text file named randomNums
            PrintWriter file1 = new PrintWriter(new FileWriter("./randomNums.txt"));
            outputRandomNumbers(file1);

            //inputting randomNums file, sorting them in an arrayList, then ouputting to sortedNumbers.txt
            File inputFile = new File("./randomNums.txt");
            PrintWriter file2 = new PrintWriter(new FileWriter("./sortedNumbers.txt"));
            sortNumbers(inputFile, file2);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    private static void outputRandomNumbers(PrintWriter file){
        for(int i = 0; i < numberAmount; i++){
            file.println(Math.random());
        }
        file.close();
        System.out.println("success writing random numbers.");
    }

    private static void sortNumbers(File inputFile, PrintWriter outputfile){
        ArrayList<Double> sortedNums = new ArrayList<>();
        try{
            Scanner unSortedNums = new Scanner(inputFile);

            //getting all the numbers
            while(unSortedNums.hasNext()){
                sortedNums.add(unSortedNums.nextDouble());
            }
            unSortedNums.close();

            //sort
            Collections.sort(sortedNums);
        }catch (FileNotFoundException e){
            System.out.println(e);
        }

        //adding sorted numbers to final file
        for(int i = 0; i < numberAmount; i++){
            outputfile.println(sortedNums.get(i));
        }
        outputfile.close();
        System.out.println("success writing sorted numbers.");
    }
}