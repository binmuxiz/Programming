package TreePractice.BinaryTree.practice;

/**
 * 각각의 엣지에 가중치가 있는 포화 이진 트리가 있다.
 * 루트에서 각 리프까지의 경로 길이를 모두 같게 설정하고 (리프까지의 경로 길이가 가장 큰 수로 같게 설정함.),
 * 이 때, 모든 가중치들의 총합이 최소가 되도록 하는 프로그램을 작성하세요.
 */

/**
 * 모든 가중치들의 총합이 최소가 되려면
 * 위에서부터 가중치를 증가시켜야 한다.
 * 아래쪽에서 증가시키면 총합이 더 커짐.
 */
public class Practice2_엣지에가중치있는포화이진트리 {
    public static void main(String[] args) {
        // Test code
        int h = 2; // 트리의 높이
        int[] w = {2, 2, 2, 1, 1, 3}; // 트리에서 각각 엣지의 가중치
        solution(h, w);
        System.out.println();

        h = 3;
        w = new int[]{1, 2, 1, 3, 2, 4, 1, 1, 1, 1, 1, 1, 1, 1};
        solution(h, w);
    }

    private static void solution(int h, int[] w) {
        BinaryTree bt = new BinaryTree(h, w);
        int max = bt.dfs(1, 0);
        System.out.println(max);
        System.out.println(bt.res);
    }

    static class BinaryTree {
        int h;
        int[] arr;
        int res;

        BinaryTree(int h, int[] w) {
            this.h = h;
            this.arr = new int[(int) Math.pow(2, h + 1)];
            res = 0;

            for (int i = 2; i < (int) Math.pow(2, h + 1); i++) {
                arr[i] = w[i - 2];
            }
        }

        int dfs(int idx, int h) {
            if (this.h == h) {
                res += arr[idx];
                return arr[idx];
            }

            int left = dfs(idx * 2, h + 1);
            int right = dfs(idx * 2 + 1, h + 1);

            res += arr[idx] + Math.abs(left - right);
            return arr[idx] + Math.max(left, right);
        }
    }
}
