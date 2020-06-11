package stack;

import java.io.*;
import java.util.Stack;

public class ManageDocument {

    public static void main(String[] args) throws FileNotFoundException {
        ManageDocument read = new ManageDocument();
        read.ReadTxt("src/stack/text.txt");
//        File file = new File("src/stack/text.txt");
//        System.out.println(file.getName());
//        System.out.println(file.getPath());
//        FileReader fileReader = new FileReader(file.getAbsolutePath());
//        System.out.println(fileReader.getEncoding());
    }

    public void ReadTxt(String NombreArchivo) {
        try {
            Stack<String> stacks = new Stack<String>();

            FileReader read = new FileReader(NombreArchivo);
            BufferedReader buffer = new BufferedReader(read);
            String temp = "";

            do {
                temp = buffer.readLine();
                //System.out.println("" + temporal);
                String x;
                x = temp;
                String[] tokens = x.split(" ");
                //System.out.println("Length: " + arreglo.length);                
                for (int i = 0; i < tokens.length; i++) {
                    //System.out.println("" + arreglo[i]);
                    String xx = tokens[i];
                    //System.out.println("" + xx);
                    //stacks.push(xx);
                    if (xx != null) {
                        //stacks.add(xx);
                        stacks.push(xx);
                        //System.out.println("Stack: " + stacks);
                    }
                }
            } while (temp != null);
            //always show null value in stacks
            System.out.println("Stack: " + stacks);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}