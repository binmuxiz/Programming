package java_coding_interview_book.ch06_string_manipulation;

import java.util.*;
import java.util.stream.Collectors;

public class P05_GroupAnagrams {

    public static void main(String[] args) {
        solution3(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        solution3(new String[]{""});
        solution3(new String[]{"a"});

    }

    // 5ms
    public static List<List<String>> solution3(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] chars = new char[26]; // 영문자 26개
            for (char ch : str.toCharArray()) {
                chars[ch - 'a']++;
            }

            String sortedStr = String.valueOf(chars);

            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }

    // 5ms
    public static List<List<String>> solution2(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String sortedStr = String.valueOf(chars); // 이게 3ms 더 빠름

//            StringBuffer sorted = new StringBuffer();
//            for (char ch : chars) {
//                sorted.append(ch);
//            }
//            String sortedStr = sorted.toString();


            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);

            // 시간 차이 없음

//            if (map.containsKey(sortedStr)) {
//                map.get(sortedStr).add(str);
//
//            } else {
//                List<String> value = new ArrayList<>();
//                value.add(str);
//                map.put(sortedStr, value);
//            }
        }

        return new ArrayList<>(map.values());
    }

    // 시간 초과
    public static List<List<String>> solution(String[] strs) {

        List<List<String>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        results.get(0).add(strs[0]);

        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];

            boolean flag = true;
            for (List<String> result : results) {

                String word = result.get(0);
                if (word.length() != str.length()) continue;
                String temp = str;

                for (char ch : word.toCharArray()) {
                    temp = temp.replaceFirst(Character.toString(ch), "");
                }

                if (temp.length() == 0) {
                    flag = false;
                    result.add(str);
                }
            }

            if (flag) {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                results.add(newList);
            }
        }
        return results;
    }

}
