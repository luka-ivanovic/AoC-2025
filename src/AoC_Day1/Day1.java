package AoC_Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Day1 {
    static int counterNumberofZeros = 0;
    static int  startingPoint = 50;
    static File input = new File("src/AoC_Day1/Input_Day1.txt");

    static void main() throws FileNotFoundException {
        part1(startingPoint, counterNumberofZeros);
        part2(startingPoint, counterNumberofZeros);

    }
    private static void part1(int startingVal, int counterZ) throws FileNotFoundException {
        int startingPoint = startingVal;
        int counterNumberofZeros = counterZ;

        Scanner reader = new Scanner(input);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            if(line.charAt(0) == 'R'){
                startingPoint = (startingPoint + Integer.parseInt(line.substring(1))) % 100;
            }else{
                startingPoint = (startingPoint - Integer.parseInt(line.substring(1))) % 100;

            }
            if(startingPoint == 0){
                counterNumberofZeros++;
            }
        }
        System.out.println(counterNumberofZeros);
    }

    private static void part2(int startingVal, int counterZ) throws FileNotFoundException {
        int startingPoint = startingVal;
        int counterNumberofZeros = counterZ;

        Scanner reader = new Scanner(input);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            int code = Integer.parseInt(line.substring(1));
            int startinPointOld = startingPoint;

            if(line.charAt(0) == 'R'){
                counterNumberofZeros += ((startinPointOld + code) / 100) - (startinPointOld / 100);
                startingPoint = (startingPoint + code) % 100;
            }else{
                long currentMinusOne = (long)startinPointOld - 1;
                long targetMinusOne = (long)startinPointOld - code - 1;
                counterNumberofZeros += Math.floorDiv(currentMinusOne, 100) - Math.floorDiv(targetMinusOne, 100);

                startingPoint = ((startingPoint - code) % 100 + 100) % 100;
            }
        }
        System.out.println(counterNumberofZeros);
    }
}
