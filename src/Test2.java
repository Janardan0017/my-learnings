import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/janardanchaudhary/Desktop/All_Images/");
        String path = "/Users/janardanchaudhary/Desktop/All_Images/Part";
        int index = 1;
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (i % 200 == 0) {
                Files.createDirectories(new File(path + index).toPath());
                System.out.println("New dir created " + path + index);
                index++;
            }
            File file1 = new File(path + (index - 1) + "/" + files[i].getName());
            try {
                Files.move(files[i].toPath(), file1.toPath());
            } catch (IOException ex) {

            }
        }
    }


}
