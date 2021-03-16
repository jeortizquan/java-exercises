import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionWiki {

    static int getTopicCount(String topic) {
        int count = 0;
        try {
            final Gson gson = new Gson();

            URL url = new URL("https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=" + topic);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            final JsonElement jsonElement = gson.fromJson(response.toString(), JsonElement.class);
            final JsonElement jsonContent = jsonElement
                    .getAsJsonObject().get("parse")
                    .getAsJsonObject().get("text")
                    .getAsJsonObject().get("*");

            final Pattern p = Pattern.compile(topic);
            final Matcher m = p.matcher(jsonContent.toString());

            while (m.find()) {
                count++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getTopicCount("Jesus"));
    }
}
