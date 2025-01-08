class Problem12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    static int[] ints = {1000, 500, 100, 50, 10, 5, 1};
    static char[] romans = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

    public static String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        while(num > 0) {
            for(int i=0; i<7; i++) {
                if(num >= ints[i]) {
                    int firstDigit = getFirstDigit(num);
                    if(firstDigit == 4) {
                        roman.append(romans[i]).append(romans[i-1]);
                        num = removeFirstDigit(num);
                    } else if(firstDigit == 9) {
                        roman.append(romans[i+1]).append(romans[i-1]);
                        num = removeFirstDigit(num);
                    } else {
                        roman.append(romans[i]);
                        num -= ints[i];
                    }
                    break;
                }
            }
        }
        return roman.toString();
    }

    public static int getFirstDigit(int n) {
        while(n > 9) {
            n /= 10;
        }
        return n;
    }

    public static int removeFirstDigit(int n) {
        if(n < 10) {
            return 0;
        }
        int x = n % 10;
        n /= 10;
        while(n > 9) {
            int lastDigit = n % 10;
            x = lastDigit * 10 + x;
            n /= 10;
        }
        return x;
    }
}