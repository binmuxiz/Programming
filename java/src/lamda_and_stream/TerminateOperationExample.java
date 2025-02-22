package lamda_and_stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TerminateOperationExample {
    public static void main(String[] args) {
        int[] arr = {7, 3, 5, 4, 6};

        System.out.println("== count == ");
        IntStream countStream = Arrays.stream(arr);
        System.out.println(countStream.skip(2).count());

        System.out.println("== average ==");
        IntStream averageStream = IntStream.of(arr);
        OptionalDouble averageResult = averageStream.skip(2).average();
        System.out.println(averageResult.getAsDouble());

        System.out.println("== collect ==");
        IntStream collectStream = IntStream.of(arr);
        List<Integer> collectedList = collectStream.sorted().boxed().collect(Collectors.toList());
        for (int item : collectedList) {
            System.out.println(item);
        }

        System.out.println("== reduce ==");
        IntStream reduceStream = IntStream.of(arr);
        Optional<Integer> reduceResult = reduceStream.boxed().reduce((num1, num2) -> num1 * num2);
        System.out.println(reduceResult.get());

        /*
         boxed()는 머임??
         boxed() 메소드는 IntStream과 같이 원시 타입의 스트림을 Stream<Integer>로 변환해준다.
         int 자체로는 Collection에 못 담기 떄문에 Integer 클래스로 변환하여 List<Integer>로 담기 위해 존재한다.

         그니까, IntStream은 원시 타입 int를 요소로 갖는 Stream이고, Collection에는 원시타입을 못 담기 떄문에,
         클래스 타입인 Integer를 요소로 갖는 Stream으로 변환시켜 주는 메소드이다.

         */



        System.out.println("== anyMatch ==");
        IntStream anyMatchStream = IntStream.of(arr);
        System.out.println(anyMatchStream.anyMatch(n -> n % 2 == 1));

        System.out.println("== allMatch ==");
        // stream has already been operated upon or closed. 스트림은 일회성의 특징을 가짐ㅁ
//        System.out.println(intStream.allMatch(n -> n % 2 == 1));
        IntStream allMatchStream = IntStream.of(arr);
        System.out.println(allMatchStream.allMatch(n -> n % 2 == 1));

        System.out.println("== findFirst ==");
        IntStream findFirstStream = IntStream.of(arr);
        System.out.println(findFirstStream.sorted().findFirst().getAsInt());

        System.out.println("== findAny ==");
        IntStream findAnyStream = IntStream.of();
        OptionalInt findAnyResult = findAnyStream.sorted().findAny();
        System.out.println(findAnyResult.getAsInt());

    }
}
