package lab04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class WordUtilitiesTest {
    @ParameterizedTest
    @MethodSource("generator")
    void wordUtil(String description, String str, String expected) {
        String result = WordUtilities.swapCase(str);
        assertEquals(expected, result);
    }
    private static Stream<Arguments> generator() {

        return Stream.of(
                Arguments.of("Null String",null ,null),
                Arguments.of("All uppercase String","ABCDEFG" ,"abcdefg"),
                Arguments.of("All lowercase String","abcdefg" ,"ABCDEFG"),
                Arguments.of("lowercase and uppercase","AbCd" ,"aBcD"),
                Arguments.of("String with whitespace","ABC def" ,"abc DEF")

        );
    }
}