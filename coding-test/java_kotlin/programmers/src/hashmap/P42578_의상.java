package hashmap;

import java.util.HashMap;
import java.util.Map;

public class P42578_의상 {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        /* 예를 들어, 옷의 종류가 3개이고,
            각 옷 종류 2, 3, 4개라고 할 때,
            선택할 수 있는 경우의 수는 3 * 4 * 5이다. (선택하지 않는 경우를 포함)
            하지만 무조건 하나의 옷은 선택해야 하므로 -1을 해준다.
        */
        for (int num : map.values()) {
            answer *= (num + 1);
        }

        return answer - 1;
    }
}
