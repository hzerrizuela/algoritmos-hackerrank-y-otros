package avaya.codility;

class FavoriteNumber {
    public static void main(String[] args) {
//        int[] ints = {100, 63, 1, 6, 2, 13};
//        int[] ints = {13, 13, 1, 6};
//        int[] ints = {1, 1, 0, 0, 5, 1, 5}; //OK: 3
//        int[] ints = {5, 5, 5, 1, 0}; // OK: 4
        int[] ints = {1, 3, 3, 9}; // OK: 2
        FavoriteNumber sol = new FavoriteNumber();
//        sol.solution(100, 63, ints); //OK: 5
//        sol.solution(100, 63, ints); //OK: 5
//        sol.solution(1, 0, ints); //OK: 4
        sol.solution(1, 3, ints); //?
    }

    int solution(int X, int Y, int[] A) {
        int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == X)
                nX += 1;
            if (A[i] == Y) //BOTH chose the same number
                nY += 1;
            if (nX == nY) // && (A[i] == X || A[i] == Y))
                result =  i;
        }
        System.out.println("result: " + result);
        return result;
    }
}
