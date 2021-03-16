import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String iP = in.next();
            MyRegex mr = new MyRegex(iP);
            System.out.println(mr.isMatch());
        }
        in.close();
    }
}
