import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by emp350 on 3/04/20
 */
public class Test {

    public static void main(String[] args) {

        try {

            URL url = new URL("https://jsonmock.hackerrank.com/api/football_matches?year=2011&page=1&team2goals=0&team1goals=0");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            OutputStream os = connection.getOutputStream();
            os.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (connection.getInputStream()))); // Getting the response from the webservice

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output); // Instead of this, you could append all your response to a StringBuffer and use `toString()` to get the entire JSON response as a String.
                // This string json response can be parsed using any json library. Eg. GSON from Google.
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}