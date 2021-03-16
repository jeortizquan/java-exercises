import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class SolutionString {

    private static final Scanner scanner = new Scanner(System.in);

    /*
     * Complete the arrange function below.
     */
    static String arrange(String sentence) {
        if (Pattern.matches("^[A-Z][a-z ]*\\.$", sentence)) {
            final Pattern p = Pattern.compile("\\w+");
            final Matcher m = p.matcher(sentence);
            List<String> strings = new ArrayList<>();
            while (m.find()) {
                strings.add(m.group(0).toLowerCase());
            }
            strings.sort(Comparator.comparing( o1 -> o1.length()));
            sentence = "";
            for(int k = 0; k < strings.size(); k++) {
                if ( k == 0) {
                    sentence += strings.get(k).substring(0,1).toUpperCase()+
                                strings.get(k).substring(1)+ " ";
                } else {
                    sentence += strings.get(k) + " ";
                }
            }
        }

        return sentence.trim()+".";

    }

    public static void main(String[] args) throws IOException {

        String sentence = "The lines are printed in reverse order.";

        String res = arrange(sentence);

        System.out.println(res);

    }
}
