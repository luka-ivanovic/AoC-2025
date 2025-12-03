package AoC_Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Day2 {
    static long sumOfInvalidIDs = 0;
    static File input = new File("src/AoC_Day2/Input_Day2.txt");
    static String[] inputTest = {"11-22","95-115","998-1012","1188511880-1188511890", "222220-222224", "1698522-1698528", "446443-446449", "38593856-38593862", "565653-565659", "824824821-824824827", "2121212118-2121212124"};
    static void main() throws FileNotFoundException {
      Scanner reader = new Scanner(input);
        String result = reader.nextLine();
        String[] res1 = result.split(",");
        for(String s : res1) {
            checkSeqForInvalid(s);
        }

        System.out.println(sumOfInvalidIDs);
    }



    private static void checkSeqForInvalid(String seq) {
        String[] res = seq.split("-");
        long lower = Long.parseLong(res[0]);
        long upper = Long.parseLong(res[1]);
        for (long i = lower; i <= upper; i++) {
            String val = String.valueOf(i);
            String lowerHalf = val.substring(0, val.length()/2);
            String upperHalf = val.substring(val.length()/2);

            if(lowerHalf.equals(upperHalf)) {
                sumOfInvalidIDs += i;
                continue;
            }
            if(checkForInvalidHelper(val) ) {
                sumOfInvalidIDs += i;
            }
        }
    }

    private static boolean checkForInvalidHelper(String seq) {
        int n = seq.length();

        for (int len = 1; len <= n / 2; len++) {
            if (n % len != 0) continue;

            String pattern = seq.substring(0, len);
            boolean matches = true;

            for (int i = 0; i < n; i += len) {
                if (!seq.substring(i, i + len).equals(pattern)) {
                    matches = false;
                    break;
                }
            }

            if (matches) return true;
        }

        return false;
    }
}
