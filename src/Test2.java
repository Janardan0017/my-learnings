import java.util.Random;

/**
 * Created for interview-preperation on 23/07/20
 */
public class Test2 {

    public static void main(String[] args) {

        Random random = new Random();
        for(int i=0; i<10; i++){
            System.out.println(random.nextInt(10));
        }

    }
}
