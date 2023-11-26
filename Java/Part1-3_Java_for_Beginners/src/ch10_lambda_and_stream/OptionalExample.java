package ch10_lambda_and_stream;

import java.util.Optional;
import java.util.OptionalDouble;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optionalNullStr = Optional.ofNullable(null);
        // Optional 객체의 값이 존재하는지 여부 반환
        System.out.println(optionalNullStr.isPresent());
        System.out.println(optionalNullStr.orElse("NULL값"));

        Optional<String> optionalStr = Optional.ofNullable("null");
        // 값이 null이면 매개변수 리턴
        System.out.println(optionalStr.orElse("NULL값"));

        Optional<Integer> optionalInt = Optional.of(0);
        // 값이 존재하면 매개변수로 전달된 명령문 수행
        optionalInt.ifPresent(System.out::println);
        // Optional 값 리턴
        System.out.println(optionalInt.get());

        OptionalDouble optionalDouble = OptionalDouble.of(3.14);
        // OptionalDouble 값 리턴
        System.out.println(optionalDouble.getAsDouble());

    }
}
