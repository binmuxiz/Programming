package 코딩테스트입문;

public class Main {
    public static void main(String[] args) {

//        level0_삼각형의완성조건1 p1 = new level0_삼각형의완성조건1();
//        System.out.println(p1.solution3(new int[]{1, 2, 3}));

//        level0_옹알이1 p2 = new level0_옹알이1();
//        System.out.println(p2.solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"}));


//        int[][] arr = new int[3][2];
//        arr[0] = new int[]{-1,1};
//        arr[1] = new int[]{1,3};
//        arr[2] = new int[]{3,9};
//        level0_겹치는선분의길이 p3 = new level0_겹치는선분의길이();
//        System.out.println(p3.solution(arr));

        level0_연속된수의합 p4 = new level0_연속된수의합();
        int[] results = p4.solution(4, 14);
        for (int i : results) {
            System.out.print(i);
        }
    }
}
