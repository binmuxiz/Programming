package ch10_lambda_and_stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperationExample1 {
    public static void main(String[] args) {
        String[] names = {"a", "b", "ab", "ab", "c"};

        System.out.println("Filtering");

        // Stream.of랑 Arrays.stream 차이가 뭐지??
        Stream<String> filterStream = Stream.of(names);
        filterStream.filter(name -> name.contains("a")).forEach(System.out::println);

        Stream<String> arrayToStream = Arrays.stream(names);
        arrayToStream.filter(name -> name.contains("b")).forEach(System.out::println);

        System.out.println("Distinct");
        Stream<String> distinctStream = Stream.of(names);
        distinctStream.distinct().forEach(System.out::println);

        System.out.println("Map");
        IntStream mapStream = IntStream.of(1, 2, 3, 4, 5);
        mapStream.map(num -> num + 2).forEach(System.out::println);

        System.out.println("flatMap");
        String[] wordArray = {"this is", "Intermediate Operation", "java jdk1.8"};
        Stream<String> flatMapStream = Stream.of(wordArray);
        flatMapStream.flatMap(s -> Stream.of(s.split(" "))).forEach(System.out::println);
        // * 스트림의 요소 명령문을 적용해서 새로운 스트림을 반환한다. (요소 각각이 새로운 스트림으로 만들어짐)


        System.out.println("Sorted");
        IntStream unsortedStream = IntStream.of(7, 3, 5, 4, 6);
        unsortedStream.sorted().forEach(System.out::println);

        System.out.println("Limit");
        IntStream limitStream = IntStream.of(7, 3, 5, 4, 6);
        limitStream.limit(3).forEach(System.out::println);

        System.out.println("Skip");
        IntStream skipStream = IntStream.of(7, 3, 5, 4, 6);
        skipStream.skip(1).forEach(System.out::println);

        System.out.println("Peek");
        int[] arr = {7, 3, 5, 4, 6};
        IntStream peekStream = IntStream.of(arr);
        peekStream.sorted().peek(i -> System.out.println("sorted 수행 : " + i)).forEach(System.out::println);


    }
}
