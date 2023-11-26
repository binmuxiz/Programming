package practice;

import java.util.HashMap;
import java.util.Map;

// 마라톤 완주 못한 참가자 이름 출력하기 문제
public class Practice1 {
    public static void main(String[] args) {

        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"mislav","stanko","mislav","ana"}, new String[]{"stanko","mislav","ana"}));


    }

    private static String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();

        for (String name : participant) {
            participantMap.put(name, participantMap.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            participantMap.put(name, participantMap.get(name) - 1);
        }

        String result = "";
//        for (Map.Entry<String, Integer> set : participantMap.entrySet()) {
//            if (set.getValue() > 0) {
//                result = set.getKey();
//                break;
//            }
//        }
        for (String name : participant) {
            if (participantMap.get(name) > 0) {
                result = name;
            }
        }
        return result;
    }
}
