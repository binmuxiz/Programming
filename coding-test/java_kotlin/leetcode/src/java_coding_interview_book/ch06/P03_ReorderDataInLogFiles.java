package java_coding_interview_book.ch06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P03_ReorderDataInLogFiles {

    public static void main(String[] args) {
        solution(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"});
        solution(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"});
    }


    public static String[] solution(String[] logs) {

        List<String> digitLogs = new ArrayList<>();
        List<String> letterLogs = new ArrayList<>();

        for (String log : logs) {
            if (Character.isLetter(log.charAt(log.length()-1)))
                letterLogs.add(log);
            else
                digitLogs.add(log);
        }

        letterLogs.sort((s1, s2) -> {
            String[] strArr1 = s1.split(" ", 2);
            String[] strArr2 = s2.split(" ", 2);

            int compared = strArr1[1].compareTo(strArr2[1]);

            if (compared == 0)
                return strArr1[0].compareTo(strArr2[0]);

            return compared;
        });

//        Collections.sort(letterLogs, new Comparator<String>() {
//            @Override
//            public int compare(String str1, String str2) {
//                String[] strArr1 = str1.split(" ", 2);
//                String[] strArr2 = str2.split(" ", 2);
//
//                int compared = strArr1[1].compareTo(strArr2[1]);
//
//                if (compared == 0)
//                    return strArr1[0].compareTo(strArr2[0]);
//
//                return compared;
//            }
//        });

        letterLogs.addAll(digitLogs);

        return letterLogs.toArray(new String[0]);
    }
}
