package zero_base.practice;

import java.util.*;
import java.util.stream.Stream;

// 2020 카카오 인턴십 - 어피치 보석 쇼핑
public class Practice2 {
    public static void main(String[] args) {

        int[] result = solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        System.out.println(Arrays.toString(result));

        result = solution(new String[]{"AA", "AB", "AC", "AA", "AC"});
        System.out.println(Arrays.toString(result));

        result = solution(new String[]{"XYZ", "XYZ", "XYZ"});
        System.out.println(Arrays.toString(result));

        result = solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"});
        System.out.println(Arrays.toString(result));

        result = solution(new String[]{"A", "B", "A", "B", "C"});
        System.out.println(Arrays.toString(result));

        result = solution(new String[]{"A", "A", "B", "B", "A", "A", "C", "A", "C"});
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(String[] gems) {
        // 진열대 번호 쌍을 저장할 List를 선언한다.
        ArrayList<Integer[]> candidates = new ArrayList<>();

        // 모든 보석 종류를 중복이 발생하지 않는 HashSet에 저장한다.
        HashSet<String> set = new HashSet();
        Stream.of(gems).forEach(x -> set.add(x));
        int setSize = set.size();

        // 만약 보석의 종류가 하나라면 {1,1}를 바로 리턴한다.
        if (setSize == 1)
            return new int[]{1, 1};

        // 보석을 key, 개수를 value로 가지는 hashtable을 선언한다.
        Hashtable<String, Integer> ht = new Hashtable<>();
        // 현재 구간이 후보가 될 수 있는지를 확인하는 변수를 선언한다.
        boolean isCandidate = false;

        int left = 0;
        int right = 0;
        // 처음 보석을 먼저 hashTable에 넣는다.
        ht.put(gems[0], 1);

        while (true) {
            if (!isCandidate) { // 현재 구간이 후보가 될 수 없으면 right를 오른쪽으로 이동한다.
                right++;

                if (right >= gems.length) {
                    break;
                }
                ht.put(gems[right], ht.getOrDefault(gems[right], 0) + 1);

                if (ht.size() == setSize) {
                    isCandidate = true;
                    candidates.add(new Integer[]{left, right});
                }
            } else {
                left++;
                int cnt = ht.get(gems[left - 1]) -1 ;
                if (cnt == 0) {
                    // hashtable에서 제거하고, isCandidate가 false가 되면 위의 if문을 다시 수행함.
                    // 만약 gems를 다 돌때까지 제거한 보석이 다시 나타나서 ht에 추가가 되지 않는다면 이전에 추가되었던 후보들 중에서 결과가 나오게 됨.
                    ht.remove(gems[left - 1]);
                    isCandidate = false;
                } else {
                    ht.put(gems[left - 1], cnt);
                    candidates.add(new Integer[]{left, right});
                }
            }
        }

        int minIdx = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < candidates.size(); i++) {
            Integer[] cur = candidates.get(i);
            if (minValue > cur[1] - cur[0]) {
                minValue = cur[1] - cur[0];
                minIdx = i;
            }
        }

        Integer[] res = candidates.get(minIdx);
        return new int[]{res[0] + 1, res[1] + 1};
    }

//    private static int[] solution(String[] gems) {
//        int[] result = new int[2];
//        Map<String, Integer> map = new HashMap<>();
//
//        for (String gem : gems) {
//            map.put(gem, 0);
//        }
//
//        int end = -1;
//        for (String gem : gems) {
//            if (map.values().stream().allMatch(x -> x > 0))
//                break;
//            map.put(gem, map.get(gem) + 1);
//            end++;
//        }
//
//        ArrayList<Integer[]> candidateList = new ArrayList<>();
//        candidateList.add(new Integer[]{0, end});
//
//        for (int i = 1; i <= end; i++) {
//            if (map.get(gems[i-1]) - 1 < 1) {
//                break;
//            }
//            map.put(gems[i-1], map.get(gems[i-1]) - 1);
//            candidateList.add(new Integer[]{i, end});
//        }
//
//        int min = 100000;
//        for (Integer[] cand : candidateList) {
//            if (min > cand[1] - cand[0]) {
//                result[0] = cand[0];
//                result[1] = cand[1];
//            }
//        }
//        result[0]++;
//        result[1]++;
//
//        return result;
//    }
}
