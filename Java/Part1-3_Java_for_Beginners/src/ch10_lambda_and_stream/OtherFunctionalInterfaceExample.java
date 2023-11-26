package ch10_lambda_and_stream;

import java.util.function.*;

class OtherFunctionalInterfaceExample {
    public static void main(String[] args) {

        // Predicate<T> : (T) -> boolean
        Predicate<String> isEmptyString = String::isEmpty; // 문자열의 길이가 0인지
//        Predicate<String> isEmptyString2 = (str) -> str.isEmpty();
        System.out.println(isEmptyString.test(""));

        // Consumer<T> : (T) -> void
        Consumer<String> sentence = (str) -> System.out.println("+" + str);
        sentence.accept("Consumer Class");

        // Function<T, R> : (T) -> R
        Function<String, Integer> strLength = String::length;
        System.out.println(strLength.apply("123"));

        // Supplier<T> : () -> T
        Supplier<Long> currentTime = () -> System.currentTimeMillis();
        System.out.println(currentTime.get());

        // UnaryOperator<T> : (T) -> T
        UnaryOperator<Integer> twoSum = (i) -> i + i;
        System.out.println(twoSum.apply(2));

    }
}