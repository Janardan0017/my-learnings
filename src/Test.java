import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

/**
 * Created by emp350 on 3/04/20
 */
public class Test {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
//        System.out.println(getDifference(1617596294000L, System.currentTimeMillis()));
//        System.out.println(getDifference(1618201094000L, System.currentTimeMillis()));
//        System.out.println(getDifference(1618373894000L, System.currentTimeMillis()));
//        System.out.println(getDifference(1618633094000L, System.currentTimeMillis()));
//        System.out.println(getDifference(1618719494000L, System.currentTimeMillis()));
//        System.out.println(getDifference(1618805894000L, System.currentTimeMillis()));

        System.out.println(getDifference2(1616127494000L, System.currentTimeMillis()));
        System.out.println(getDifference2(1617596294000L, System.currentTimeMillis()));
        System.out.println(getDifference2(1618201094000L, System.currentTimeMillis()));
        System.out.println(getDifference2(1618373894000L, System.currentTimeMillis()));
        System.out.println(getDifference2(1618633094000L, System.currentTimeMillis()));
        System.out.println(getDifference2(1618719494000L, System.currentTimeMillis()));
        System.out.println(getDifference2(1618805894000L, System.currentTimeMillis()));
    }

    static int getDifference(long start, long end) {
        String startDate = simpleDateFormat.format(start);
        String endDate = simpleDateFormat.format(end);

        String[] split1 = startDate.split("/");
        String[] split2 = endDate.split("/");
        int yearDiff = Integer.parseInt(split1[2]) - Integer.parseInt(split2[2]);
        int monthDiff = Integer.parseInt(split1[1]) - Integer.parseInt(split2[1]);
        int dayDiff = Integer.parseInt(split1[0]) - Integer.parseInt(split2[0]);
        System.out.println("Y: " + yearDiff);
        System.out.println("M: " + monthDiff);
        System.out.println("D: " + dayDiff);
        if (yearDiff == 0 && monthDiff == 0) {
            if (dayDiff == 0)
                return 1;
            else if (dayDiff == -1)
                return 2;
            else if (dayDiff == -2)
                return 3;
            else if (dayDiff == -5)
                return 4;
            else if (dayDiff == -7)
                return 5;
            else if (dayDiff == -14)
                return 6;
        } else if (yearDiff == 0) {
            if (monthDiff == -1)
                return 7;
        }
        return 0;
    }

    static int getDifference2(long start, long end) {
        LocalDate localDate1 = LocalDate.of(2021, 4, 18);
        LocalDate localDate2 = LocalDate.of(2021, 4, 19);

        System.out.println(localDate1);
        System.out.println(localDate2);

        Period diff = Period.between(localDate1, localDate2);

        int yearDiff = diff.getYears();
        int monthDiff = diff.getMonths();
        int dayDiff = diff.getDays();
        System.out.println("Y: " + yearDiff);
        System.out.println("M: " + monthDiff);
        System.out.println("D: " + dayDiff);
        if (yearDiff == 0 && monthDiff == 0) {
            if (dayDiff == 0)
                return 1;
            else if (dayDiff == -1)
                return 2;
            else if (dayDiff == -2)
                return 3;
            else if (dayDiff == -5)
                return 4;
            else if (dayDiff == -7)
                return 5;
            else if (dayDiff == -14)
                return 6;
        } else if (yearDiff == 0) {
            if (monthDiff == -1)
                return 7;
        }
        return 0;
    }

}