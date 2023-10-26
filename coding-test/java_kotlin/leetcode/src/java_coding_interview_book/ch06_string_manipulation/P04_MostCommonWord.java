package java_coding_interview_book.ch06_string_manipulation;

import java.util.*;

public class P04_MostCommonWord {

    public static void main(String[] args) {
        solution("a, a, a, a, b,b,b,c, c", new String[]{"a"});
    }

    public static String solution(String paragraph, String[] banned) {

        List<String> banSet = new ArrayList<>(Arrays.asList(banned));

//        Set<String> banSet = new HashSet<>(Arrays.asList(banned));
        String[] strArr = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");
        Map<String, Integer> map = new HashMap<>();

        String result = "";
        int maxCount = 0;

        for (String word : strArr) {

            if (banSet.contains(word)) continue;

            int count = map.getOrDefault(word, 0) + 1;
            map.put(word, count);

            if (count > maxCount) {
                maxCount = count;
                result = word;
            }
        }
//        Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

        return result;
    }
}

