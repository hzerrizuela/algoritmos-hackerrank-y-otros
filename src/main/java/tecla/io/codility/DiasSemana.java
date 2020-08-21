package tecla.io.codility;

import java.util.Arrays;
import java.util.List;

/**
 * Days of the week are represented like 3 letters strings.
 * Write a function solution that given a string S representing the day of the week and an integer K (between 0 and 500),
 * returns the day of the week that is K days later.
 * Ex:
 * S = "Wed" and K = 2 should return "Fri"
 * S = "Sat" and K = 23 should return "Mon"
 *
 */
public class DiasSemana {

    public static final int DAY_OF_WEEK = 7;
    public List<String> daysList = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");

    public static void main(String[] args) throws Exception {
        DiasSemana solution1 = new DiasSemana();
//        String result = solution1.solution("Sat", 23);
        String result = solution1.solution("Wed", 2);
        System.out.println(result);

    }

    public String solution(String S, int K) {
        int rest = K % DAY_OF_WEEK;
        int indexDay = daysList.indexOf(S);
        int newIndex = (indexDay + rest) % DAY_OF_WEEK;
        return daysList.get(newIndex);
    }


}
