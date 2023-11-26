package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort_Practice {

    public static void main(String[] args) {

        System.out.println("== Arrays.sort == ");
        Integer[] int_arr = {100, 99, 80, 60, 50, 101};
        Arrays.sort(int_arr, new iComparator());
        System.out.println(Arrays.toString(int_arr));

        String[] s_arr = {"z", "a", "v", "s", "b", "m"};
        Arrays.sort(s_arr, new sComparator());
        System.out.println(Arrays.toString(s_arr));

        int_arr = new Integer[]{100, 99, 80, 60, 50, 101};
        Arrays.sort(int_arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(int_arr));



        System.out.println("== Collections.sort == ");
        Integer[] intArr = {9, 8, 7, 6, 5};
        List<Integer> intList = Arrays.asList(intArr);

        for (int i : intList) {
            System.out.print(i + " ");
        }
        System.out.println();

        Collections.sort(intList);
        for (int i : intList) {
            System.out.print(i + " ");
        }

    }

    public static class iComparator implements Comparator<Integer> {
        // primitive 타입의 배열엔 적용이 불가능 Wrapper Class를 이용해야 함
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1; // 내림차순
        }
    }

    public static class sComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1); // 내림차순
        }
    }

}

