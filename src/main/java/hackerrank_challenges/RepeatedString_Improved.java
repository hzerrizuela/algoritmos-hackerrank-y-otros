package hackerrank_challenges;

/**
 * 1 <= s <= 100
 * 1 <= n <= 10^12
 *
 * @see - https://www.baeldung.com/java-inifinite-streams
 */
public class RepeatedString_Improved {


    public static void main(String[] args) throws Exception {

        long result = repeatedString("aba", 10); // result = 7
//        long result = repeatedString("a", 1000000000000L); // result =1000000000000
        System.out.println("Count = " + result);
    }

    static long repeatedString(String s, long n) {
        long numOfS = n / s.length();
        long rest = n % s.length();

        if (!s.contains("a")) return 0;
        return s.length() > n ? aCounter(s, rest)
                : numOfS * aCounter(s, s.length()) + aCounter(s, rest);
    }

    private static long aCounter(String s, long end) {
        int a = 0;
        for (int i = 0; i < end; i++) {
            if (s.charAt(i) == 'a') a++;
        }
        return a;
    }


}
