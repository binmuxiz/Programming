package lamda_and_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreationStreamExample1 {
    public static void main(String[] args) {
        // 배열에서 스트림 생성
        String[] arr = new String[]{"a", "b", "c", "d"};
        Stream<String> arrayToStream = Arrays.stream(arr);
        arrayToStream.forEach(System.out::println);

        // Collection에서 스트림 생성
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> listToStream = list.stream();
        listToStream.forEach(System.out::println);

        // 지정된 범위의 연속된 정수에서 스트림 생성
        IntStream continuousIntStream = IntStream.rangeClosed(1, 4);
        continuousIntStream.forEach(System.out::println);


        // 특정 타입의 난수로 이루어진 스트림 생성
        IntStream randomStream = new Random().ints(4);
         randomStream.forEach(System.out::println);


        // 람다를 이용한 스트림 생성 generate

        // iterate()의 매개변수는 seed, UnaryOperator
        //Stream<Integer> lambdaIterate = Stream.iterate(0, n -> n + 1); // 0부터 시작해서 1씩 증가하는 수열
        //lambdaIterate.forEach(System.out::println);


//        Stream<Double> lambdaGenerateStream = Stream.generate(Math::random);
//        lambdaGenerateStream.forEach(System.out::println);


        // 파일 스트림 생성
        try {
            Stream<String> fileStream = Files.lines(Paths.get("path"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // 빈 스트림 생성
        Stream<Object> emptyStream = Stream.empty();
    }
}
