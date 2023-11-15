package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {

        // Function takes 1 argument and produces 1 result
        int increment = incrementByOne(1);
        System.out.println(increment);

        Integer increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyByTenFunction.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> addByOneAndThenMultiplyByTen =
                incrementByOneFunction.andThen(multiplyByTenFunction);
        System.out.println(addByOneAndThenMultiplyByTen.apply(1));

        // BiFunction takes 2 argument and produces 1 result
        System.out.println(
        incrementByOneAndMultiply(4,100)
        );

        System.out.println(
                incrementByOneAndMultiplyBiFunction.apply(4,100)
        );
    }

    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> multiplyByTenFunction =
            number -> number * 10;

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOne(int number) {
        return number + 1;
    }
    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }
}
