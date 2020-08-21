package cracking;

/*
    Implement an algorithm to determine if a string has all unique characters What if you
    can not use additional data structures?
*/
//    For simplicity, assume char set is ASCII (if not, we need to increase the storage size The rest
//            of the logic would be the same) NOTE: This is a great thing to point out to your interviewer!
public class AllUnique_Improved {

    public static void main(String[] args) {
//        String str = "something";
        String str = "opss";

        System.out.println("All unique? " + isUniqueChars2(str));
    }

    public static boolean isUniqueChars2(String str) {
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

}
