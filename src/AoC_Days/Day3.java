package AoC_Days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {
    static File input = new File("src/AoC_Day3/Input_Day3.txt");
    static String[] inputTest = {"987654321111111", "811111111111119", "234234234234278",  "818181911112111"};
    static long result = 0;

    static void main() throws FileNotFoundException {
        Scanner sc = new Scanner(input);
       while (sc.hasNextLine()) {
            result += findBiggestPart2(sc.nextLine());
       }

        System.out.println(result);
    }

    private static int findBiggest(String numSeq){
        char biggest = '0';
        char secondBiggest = '0';
        int savedIndex = 0;
        for(int i = 0; i < numSeq.length(); i++){
            if(numSeq.charAt(i) >  biggest && i < numSeq.length() - 1){
                biggest = numSeq.charAt(i);
                savedIndex = i;
            }
        }
        for(int j = savedIndex + 1; j < numSeq.length(); j++){
            if(numSeq.charAt(j) >  secondBiggest){
                secondBiggest = numSeq.charAt(j);
            }
        }
        return Integer.parseInt(biggest+""+secondBiggest);
    }

    private static long findBiggestPart2(String numSeq){
        final int LENGTH_TO_KEEP = 12;
        int digitsToDrop = numSeq.length() - LENGTH_TO_KEEP;

        StringBuilder result = new StringBuilder();

        for (char currentDigit : numSeq.toCharArray()) {
            while (digitsToDrop > 0 &&
                    !result.isEmpty() &&
                    currentDigit > result.charAt(result.length() - 1)) {

                result.deleteCharAt(result.length() - 1);
                digitsToDrop--;
            }
            result.append(currentDigit);
        }

        if (result.length() > LENGTH_TO_KEEP) {
            result.setLength(LENGTH_TO_KEEP);
        }

        return Long.parseLong(result.toString());
    }

}
