package hackerrank_challenges;

import java.util.Arrays;

/**
 * Emma is playing a new mobile game that starts with consecutively numbered clouds.
 * Some of the clouds are thunderheads and others are cumulus. She can jump on any cumulus
 * cloud having a number that is equal to the number of the current cloud plus 1 or 2. She must
 * avoid the thunderheads. Determine the minimum number of jumps it will take Emma to jump from
 * her starting postion to the last cloud. It is always possible to win the game.
 *
 * @see - https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 */
public class JumpingClouds {

    public static void main(String[] args) throws Exception {

        int[] array = {0, 0, 1, 0, 0, 1, 0}; // min jumps: 4
//        int[] array = {0, 1, 0, 0, 0, 1, 0}; // min jumps: 3
//        int[] array = {0, 0}; // min jumps: 1
//        int[] array = {0, 0, 0}; // min jumps: 1
//        int[] array = {0, 1, 0, 1, 0}; // min jumps: 2
        int jumps = jumpingOnClouds(array);
        System.out.println("Number of jumps: " + jumps);

    }

    private static int jumpingOnClouds(int[] array)  {
        int jumps = 0;
        if (array.length < 2) { //with only one position, you're in the end, you can't jump anymore
            return 0;
        }
        for (int i = 0; i < array.length; i++) {
            int newPos = i + 2;
            if (newPos < array.length && array[newPos] == 0) {
                jumps = countJumps(array, jumps, newPos);
            } else {
                newPos = i + 1;
                if (newPos < array.length && array[newPos] == 0) {
                    jumps = countJumps(array, jumps, newPos);
                }
            }
            return jumps;
        }
        return -1;
    }

    private static int countJumps(int[] array, int jumps, int newPos) {
        jumps++;
        int[] subArray = Arrays.copyOfRange(array, newPos, array.length);
        jumps += jumpingOnClouds(subArray);
        return jumps;
    }

}
