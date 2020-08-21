package avaya.codility;

import java.util.*;

/**
 * Returns what I have to pay in cents for my phone calls, considering rules in:
 * Phone calls.png
 */

class PhoneCallsDuration {

    //PRICE PER SECOND
    public static int SHORT_COST = 3;
    public static int LONG_COST = 150;

    public static void main(String[] args) throws Exception {

        String str = "00:01:07,400-234-090\n" +
                "00:05:01,701-080-080\n" + // 0
                "00:05:00,400-234-090\n" +
                "98:03:00,666-444-999\n" +
                "01:00:00,701-080-080";  // 0


//        String str = "00:01:07,400-234-090\n" +
//                "00:05:01,701-080-080\n" +
//                "00:05:00,400-234-090";
////        WRONG ANSWER  (got 45150 expected 900)

        //TODO - Tie case:


        PhoneCallsDuration solution2 = new PhoneCallsDuration();
        int cost = solution2.solution(str);
        System.out.println("Total cost: $" + cost);

    }

    public int solution(String S) throws Exception {

        //<phone number, call cost>
        Map<String, Integer> myCalls = new HashMap<>();

        String[] split = S.split("\n");
        List<String> list = Arrays.asList(split);
        list.forEach(e -> {
            String[] durationPhone = e.split(",");
            String key = durationPhone[1];
            int value = costs(durationPhone[0]); 
            int total = myCalls.containsKey(key) ? myCalls.get(key) + value : value;
            myCalls.put(key, total);
        });

        String maximum = myCalls.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();

        myCalls.remove(maximum); // because it's free
        Integer totalAmountCalls = myCalls.values().stream().mapToInt(Integer::intValue).sum();
        return totalAmountCalls;

    }

    /**
     * @param duration - format HH:MM:SS
     * @return
     */
    private int costs(String duration) {

        String[] durSplit = duration.split(":");
        int hours = Integer.parseInt(durSplit[0]);
        int mins = Integer.parseInt(durSplit[1]);
        int seconds = Integer.parseInt(durSplit[2]);

        if (mins * 60 + seconds < 300 && hours == 0) {
            return (mins * 60 + seconds) * SHORT_COST;
        }
        return (hours * 60 * 60 + mins * 60 + seconds) * LONG_COST;

    }

    /*
    private Integer duration(String duration) {
        int totalDuration = 0;
        String[] durSplit = duration.split(":");
        int hours = Integer.parseInt(durSplit[0]);
        int mins = Integer.parseInt(durSplit[1]);
        int seconds = Integer.parseInt(durSplit[2]);

        totalDuration += (hours * 60 * 60 + mins * 60 + seconds);
        return totalDuration;
    }

    private Integer bill(Integer seconds) {
        if (seconds < 300) {
            return seconds * SHORT_COST;
        }

        int mins = seconds / 60;
        //if there are seconds remaining, add one more minute cost
        int totalMins = seconds % 60 > 0 ? mins + 1 : mins;
        return totalMins * LONG_COST;
    }
    */

}
