package lab04;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @ParameterizedTest
    @MethodSource("generator")
    void calculatorTest(int a, int b, int expected){
        int result = Calculator.complexAdd(a, b);
        assertEquals(expected,result);
    }

    private static Stream<Arguments> generator() {
        return Stream.of(
                Arguments.of(5,5,10),
                Arguments.of(1,5,-6),
                Arguments.of(3,2,5),
                Arguments.of(1,1,-2)
        );
        //achieved 100% mutation coverage for calculator tests with the above cases.
    }
}
