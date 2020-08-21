package tecla.io.codility;

import java.util.*;

/**
 * Write a function:
 * <code>
 * class Solution { public int solution(String S); }
 * </code>
 * That given a string of numbers , returns the number of all the possible correctly formatted ipv4 addresses that can be constructed using that string.
 * Ex.: "4216712120" can generate "42.167.12.120" and "42.167.121.20" , so the output should be two.
 *
 * @see - https://app.codility.com/
 */
public class IpAddressesMiPropiaSolucion {

    public static void main(String[] args) {
//        System.out.println(restoreIpAddresses("1234")); // 1 posibles
        System.out.println(restoreIpAddresses("4216712120")); // 2 posibles
//        System.out.println(restoreIpAddresses("12345")); // 4 posibles
//        System.out.println(restoreIpAddresses("11223344")); //  10 posibles
    }

    // Function to restore Ip Addresses
    public static int restoreIpAddresses(String A) {
        if (A.length() < 3 || A.length() > 12)
            return 0;
        return validIps(A);
    }

    private static int validIps(String s) {
        List<String> validIps = new ArrayList<>();

        for (int a = 1; a <= s.length() - 2; a++) {
            for (int b = a + 1; b <= s.length() - 1; b++) {
                for (int c = b + 1; c <= s.length(); c++) {
                    String seg4 = s.substring(c);
                    String seg3 = s.substring(b, c);
                    String seg2 = s.substring(a, b);
                    String seg1 = s.substring(0, a);
                    if (valid(seg1) && valid(seg2) && valid(seg3) && valid(seg4)) {
                        validIps.add(seg1 + "." + seg2 + "." + seg3 + "." + seg4);
                    }

                }

            }
        }

        validIps.forEach(System.out::println);
        return validIps.size();
    }

    private static boolean valid(String segment) {
        try {
            int integer = Integer.parseInt(segment);
            return integer > 0 && integer <= 255;
        } catch (Exception e) {
            return false;
        }
    }


}
