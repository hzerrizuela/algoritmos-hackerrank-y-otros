package hackerrank_challenges;

/**
 * 1 <= s <= 100
 * 1 <= n <= 10^12
 * !!FIXME OutOfMemory for big numbers
 * @see - https://www.baeldung.com/java-inifinite-streams
 */
public class RepeatedString {


    public static void main(String[] args) throws Exception {

//        long result = repeatedString("aba", 10); // result = 7
        long result = repeatedString("a", 1000L); // result =1000000000000
        System.out.println("Count = " + result);
    }

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        StringBuffer buf = new StringBuffer();
        while (buf.length() < n) {
            buf.append(s);
        }
//
        return buf.chars().limit(n).mapToObj(c -> Character.toString((char) c)).filter(c -> c.equals("a")).count();


    }


}
