import java.util.List;
import java.util.ArrayList;

public class ArrayListEx2 {
    public static void main(String[] args) {
        final int LIMIT = 10;
        String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
        int length = source.length();

        // ArrayList를 생성할 때 저장할 요소의 개수를 고려하여 실제 저장할 개수보다 약간 여유 있는 크기로 하는 것이 좋다.
        // 지정한 크기보다 더 많은 객체를 저장하면 자동으로 크기를 늘리는 과정에서 처리시간이 더 많이 소요되기 때문이다.
        List list = new ArrayList<>(length/LIMIT +10); // 크기 약간 여유있게 잡기 왜>??????
    
        for (int i = 0; i < length; i += LIMIT) {
            if (i + LIMIT < length) {
                list.add(source.substring(i, i+LIMIT));
            } 
            else {
                list.add(source.substring(i));
            }
        }
        for (Object str : list) {
            System.out.println(str);
        }
    }
}
