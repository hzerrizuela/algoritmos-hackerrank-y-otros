package hackerrank_challenges;

/**
 * Complete the staircase function in the editor below. It should print a staircase as described above.
 * <p>
 * staircase has the following parameter(s):
 * <p>
 * n: an integer
 * <p>
 * #
 * ##
 * ###
 * ####
 * #####
 * ######
 */
public class Staircase {

    public static void main(String[] args) {
        staircase(6);
    }

    /**
     * @param n - total de # en la base
     */
    static void staircase(int n) {
        StringBuilder builder = new StringBuilder();
        for (int j = 1, i = n; j <= n; j++, i--) {
            appendCharacter(builder, i - 1, " ");
            appendCharacter(builder, j, "#");
            builder.append("\n");
        }
        System.out.println(builder);
    }

    private static StringBuilder appendCharacter(StringBuilder builder, int i, String ch) {
        if (i == 0)
            return builder;
        builder.append(ch);
        return appendCharacter(builder, i - 1, ch);
    }

}
