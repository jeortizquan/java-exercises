import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class SolutionMinMaxSum {

    /*
     * Complete the miniMaxSum function below.
     */
    static void miniMaxSum(int[] arr) {
        /*
         * Write your code here.
         */
        int min, max, sum;
        max = 0;
        min = 0;
        for(int i = 0; i < arr.length; i++) {
            sum = 0;
            for(int j = 0; j < arr.length; j++) {
                if (i != j) {
                    sum +=arr[j];
                }
            }

            if (max < sum)
                max = sum;
            else {
                min = sum;
                if (min > sum)
                    min = sum;
            }
        }
        System.out.println(min+" "+max);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < 5; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        miniMaxSum(arr);
    }
}
