package lab03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsTest {
    private static Stream<Arguments>correct(){
        return Stream.of(
                Arguments.of(4, "IV"),
                Arguments.of(5, "V")
        );
    }
    private static Stream<Arguments>duplicates(){
        return Stream.of(
                Arguments.of("IIII"),
                Arguments.of( "XXXX")
        );
    }

    private static Stream<Arguments>incorrectKeys(){
        return Stream.of(
                Arguments.of("VV"),
                Arguments.of( "LL")
        );
    }
    private static Stream<Arguments>wrongO(){
        return Stream.of(
                Arguments.of("DCM"),
                Arguments.of( "VIL")
        );
    }
    @ParameterizedTest
    @MethodSource("correct")
    void vNumbers(int ans, String number){
        assertEquals(ans, RomanNumerals.convert(number));
    }

    @ParameterizedTest
    @MethodSource("duplicates")
    void nVDuplicates(String number){
        assertThrows(IllegalArgumentException.class,() -> RomanNumerals.convert(number));
    }

    @ParameterizedTest
    @MethodSource("incorrectKeys")
    void iKeys(String number){
        assertThrows(IllegalArgumentException.class,() -> RomanNumerals.convert(number));
    }
    @ParameterizedTest
    @MethodSource("wrongO")
    void iOrder(String number){
        assertThrows(IllegalArgumentException.class,() -> RomanNumerals.convert(number));
    }
}
