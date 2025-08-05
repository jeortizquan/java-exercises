package chocolate;

import java.io.*;
import java.util.stream.IntStream;

class Result {

    /**
     * Chocolate feast int.
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * @param n the n
     * @param c the c
     * @param m the m
     * @return the int
     */
    public static int chocolateFeast(int n, int c, int m) {
        int chocolateEaten = n / c;
        int totalEaten = 0;
        int wrappers = n / c;
        int wrappersLeft = wrappers % m;
        do {
            totalEaten += chocolateEaten ;
            chocolateEaten = wrappers / m;
            wrappers = chocolateEaten + wrappersLeft;
            wrappersLeft = wrappers % m;
        } while (chocolateEaten > 0);

        return totalEaten ;
    }
    public static void RenameToMain(String[] args) {
        System.out.println(chocolateFeast(41894,36,640));
        System.out.println(chocolateFeast(14440,3,275));
        System.out.println(chocolateFeast(20373, 18211, 10188));
        System.out.println(chocolateFeast(15, 3, 2));
        System.out.println(chocolateFeast(10, 2, 5));
        System.out.println(chocolateFeast(12, 4, 4));
        System.out.println(chocolateFeast(6, 2, 2));
    }
}

public class ChocolateFeast {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int c = Integer.parseInt(firstMultipleInput[1]);

                int m = Integer.parseInt(firstMultipleInput[2]);

                int result = Result.chocolateFeast(n, c, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
