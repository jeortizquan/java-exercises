import java.util.regex.Pattern;

class MyRegex extends Solution {
    private static String pattern = "(([01]?[0-9][0-9]?)|([2]?[0-5][0-5]?))\\.(([01]?[0-9][0-9]?)|([2]?[0-5][0-5]?))\\.(([01]?[0-9][0-9]?)|([2]?[0-5][0-5]?))\\.(([01]?[0-9][0-9]?)|([2]?[0-5][0-5]?))";
    private String ipAddress;
    public MyRegex(String iP) {
        ipAddress = iP;
    }

    public boolean isMatch() {
        return Pattern.matches(pattern, ipAddress);
    }
}