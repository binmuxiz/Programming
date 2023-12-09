import java.util.*;

public class MapExample {
    public static void main(String[] args) {
//        Map<String, String> hashMap = new HashMap<>();
//        hashMap.put("A", "a");  // "A"를 key, "a"를 value로 하여 저장
//        String str1 = hashMap.get("A"); // 매핑한 키의 value를 가져온다
//        Collection<String> values = hashMap.values(); // Map의 value들을 추출한다.
//        Set<String> keySet = hashMap.keySet(); // Map의 key 집합들을 추출한다.
//        boolean isContainedKey = hashMap.containsKey("A"); // "A"라는 key가 존재하는지 여부
//        boolean isEmpty = hashMap.isEmpty(); // 요소의 개수가 0이면 true
//        hashMap.clear();      // Map의 모든 키-쌍 요소 제거
//        boolean isContainedValue = hashMap.containsValue("a");  // "a"라는 값이 포함되어 있으면 true 반환
//        String val = hashMap.remove("A");   // "A"라는 키가 있으면 해당 키-값 쌍을 제거하고, 값을 반환.
//                                                // 키가 없으면 null 반환
//        hashMap.size(); // Map의 모든 키-값 쌍의 개수
//        String valueOrDefault = hashMap.getOrDefault("A", "b");
//                                        // "A"라는 키가 있으면 값을 반환. 존재하지 않으면 지정한 디폴트 값 반환


        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "기호1번");
        hashMap.put(3, "기호3번");
        hashMap.put(2, "기호2번");
        hashMap.put(7, "기호7번");
        hashMap.put(4, "기호4번");
        System.out.println(hashMap);

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "기호1번");
        linkedHashMap.put(3, "기호3번");
        linkedHashMap.put(2, "기호2번");
        linkedHashMap.put(7, "기호7번");
        linkedHashMap.put(4, "기호4번");
        System.out.println(linkedHashMap);


        linkedHashMap = new LinkedHashMap<Integer,String>(16, .75f, true);
        linkedHashMap.put(1, "Ajay");
        linkedHashMap.put(2, "Vijay");
        linkedHashMap.put(3, "Kiran");
        linkedHashMap.put(4, "Faiz");

        for(String value:linkedHashMap.values()){
            System.out.println(value);
        }

        String val = linkedHashMap.get(3); // Kiran이 나중으로 이동
        System.out.println("After changes...");
        for (String value : linkedHashMap.values()) {
            System.out.println(value);
        }
    }
}
