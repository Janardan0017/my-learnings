public final class Assert {

    public static void equals(String expected, String actual) {
        if(expected.equals(actual)) {
            System.out.println(true);
        } else {
            System.out.println(String.format("Expected [%s] actual [%s]", expected, actual));
        }
    }
}