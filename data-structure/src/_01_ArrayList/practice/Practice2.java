package _01_ArrayList.practice;

public class Practice2 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 100, 1, 1, 1, 100};
        int target = 100;
        int result = -1;

        for (int i = arr.length - 1; i > -1; i--) {
            if (arr[i] == target) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
