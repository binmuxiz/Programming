public class Main {

    public static void main(String[] args) {
        int n = 4;
        int r = 2;

        // 1. 조합
        System.out.println("== 조합 == ");
        System.out.println("result : " + getCombination(n, r));

        // 2. 중복 조합
        System.out.println("== 중복조합 == ");
        System.out.println("result : "+ getCombination(n+r-1, r));
    }

    private static int getCombination(int n, int r) {

        int pResult = 1;
        for (int i = n; i >= n-r+1; i--) {
            pResult *= i;
        }
        int rResult = 1;
        for (int i = r; i > 1; i--) {
            rResult *= i;
        }
        return pResult / rResult;
    }
}
