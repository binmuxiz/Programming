package java_coding_interview_book.ch12_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 2에서 9까지 숫자가 주어졌을 때 전화번호로 조합 가능한 모든 문자를 출력하라.
public class P02_Letter_Combinations_Of_A_Phone_Number {
    public static void main(String[] args) {

        System.out.println(letterCombinations("23"));


    }

    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        Map<Character, List<Character>> dic = new HashMap<>();
        dic.put('0', List.of());
        dic.put('1', List.of());
        dic.put('2', List.of('a','b','c'));
        dic.put('3', List.of('d','e','f'));
        dic.put('4', List.of('g','h','i'));
        dic.put('5', List.of('j','k','l'));
        dic.put('6', List.of('m','n', 'o'));
        dic.put('7', List.of('p','q','r','s'));
        dic.put('8', List.of('t','u','v'));
        dic.put('9', List.of('w','x','y','z'));

        dfs(result, dic, digits, 0, new StringBuilder());
        return result;
    }

    private static void dfs(List<String> result, Map<Character, List<Character>> dic, String digits, int index, StringBuilder path) {
        // 끝까지 탐색했으면 결과를 저장하고 리턴
        if (path.length() == digits.length()) {
            result.add(String.valueOf(path));
            return;
        }

        // 현재 자리 숫자에 해당하는 모든 문자열 탐색
        for (Character x : dic.get(digits.charAt(index))) {
            // 현재 자리 +1, 지금까지 구성된 문자열 path 이용 재귀 DFS
            dfs(result, dic, digits, index + 1, new StringBuilder(path).append(x));
        }
    }
}
