import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1,2,3,4를 이용하여 세자리 자연수를 만드는 방법 (순서 0 , 중복 x)의 각 결과를 출력하시오
// 방법 1
public class Practice1 {
    int n;
    int r;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        Practice1 p = new Practice1();
        System.out.println(p.permute(arr,3, 2));
    }

    private List<List<Integer>> permute(int[] nums, int n, int r) {
        this.n = n;
        this.r = r;

        List<List<Integer>> result = new ArrayList<>();

        return solution1(result, nums, 0);
//        System.out.println(solution2(result, nums, 0));
    }

    private List<List<Integer>> solution1(List<List<Integer>> result, int[] nums, int depth) {
        if (depth == r) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                list.add(nums[i]);
            }
            result.add(list);
            return result;
        }

        for (int i = depth; i < n; i++) {
            swap(nums, depth, i);
            solution1(result, nums, depth + 1);
            swap(nums, depth, i);
        }

        return result;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
