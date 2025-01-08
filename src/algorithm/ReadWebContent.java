package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by emp350 on 5/06/20
 */
public class ReadWebContent {
    public static void main(String[] args) {
        method1();
    }

    // read data as html
    public static void method1() {
        try {
//            URL url = new URL("https://jsoup.org/download/");
//            URL url = new URL("https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-os-x/");
            URL url = new URL("https://www.google.com/");

            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            while (in.readLine() != null) {
                str = in.readLine();
                System.out.println(str);
        /*str will get each time the new line, if you want to store the whole text in str
           you can use concatenation (str+ = in.readLine().toString())*/
            }
            in.close();
        } catch (Exception e) {
        }
    }
}
