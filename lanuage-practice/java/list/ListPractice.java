import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListPractice {
    
    public static void main(String[] args) {
        
        // List list = new List();

        ArrayList arrayList = new ArrayList<>(10);

        System.out.println(".size : " + arrayList.size()); // 리스트에 저장된 element의 개수
        System.out.println(".isEmpty : " + arrayList.isEmpty()); // 리스트에 저장된 element 개수 == 0?

        // int를 추가하면 Integer 타입으로 변환되어 저장된다.
        arrayList.add(1); 
        // arrayList.add(1.1); // 동일 타입의 element만 저장 가능
        for (Object o : arrayList) {
            System.out.println(o.getClass()); // class java.lang.Integer
        }
        
    
        // Interger contructor는 deprecated 되었음
        arrayList.add(Integer.valueOf(3));
        arrayList.add(Integer.valueOf(2));
        arrayList.add(Integer.valueOf(5));

        int i = 0;
        for (Object o : arrayList) {
            System.out.println(i++ + ": " + o); 
        }

        // Collections.sort
        System.out.println(arrayList);
        Collections.sort(arrayList);
        System.out.println(arrayList);

        // index 0부터 2-1까지의 element
        ArrayList arrayList2 = new ArrayList<>(arrayList.subList(0, 2));
        System.out.println(arrayList2);

        System.out.println(arrayList.contains(arrayList2));  // false
        System.out.println(arrayList.containsAll(arrayList2));  // true

        arrayList.add(0, 9);  // i번째에 element를 추가
        arrayList.set(0, 8);  // i번째의 element를 교체
        System.out.println(arrayList);

        arrayList.retainAll(arrayList2); // array2와 겹치는 부분 빼고 삭제
        System.out.println(arrayList);

        ArrayList cloneArr = (ArrayList) arrayList.clone();
        System.out.println("cloneArr : " + cloneArr);

        arrayList.add(3);
        arrayList.add(4);

        System.out.println("arrayList.remove(index: int)");
        // for (int j = 0; j < arrayList.size(); j++) {
        //     arrayList.remove(i);
        //     System.out.println(arrayList);
        // } 
        // IndexOutOfBoundsException이 발생하는 이유: 
        // 배열에서 하나의 원소가 삭제될 때마다 삭제된 부분을 채우기 위해 뒤의 원소들이 한칸씩 앞으로 이동함.

        for (int j = arrayList.size()-1; j > -1; j--) {
            arrayList.remove(j);
            System.out.println(arrayList);
        } 
        // IndexOutOfBoundsException
    }
}
