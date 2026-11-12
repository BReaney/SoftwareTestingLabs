package lab03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class SpecificationTest {
    private static Stream<Arguments>outOfBoundsHD(){
        return Stream.of(
                Arguments.of(2000, 1000),
                Arguments.of(1281, 721),
                Arguments.of(1920,1080),
                Arguments.of(3240,2560)
        );
    }
    private static Stream<Arguments>outOfBoundsFHD(){
        return Stream.of(
                Arguments.of(2000, 1000),
                Arguments.of(1921, 1081),
                Arguments.of(-1000,-1080),
                Arguments.of(3240,2560)
        );
    }
    private static Stream<Arguments>inBoundsHD(){
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(0,719),
                Arguments.of(1279,719),
                Arguments.of(1279,0)
        );
    }
    private static Stream<Arguments>inBoundsFHD(){
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(0,1079),
                Arguments.of(1919,1079),
                Arguments.of(1919,0)
        );
    }

    private static Stream<Arguments>validCar(){
        return Stream.of(
                Arguments.of("BC", false),
                Arguments.of("ABC 123", false),
                Arguments.of("ABC-123",false),
                Arguments.of("123 abc",false)
        );
    }

    private static Stream<Arguments>notValidCar(){
        return Stream.of(
                Arguments.of("A", false),
                Arguments.of("ABCD1234", false),
                Arguments.of("ABC--12",false),
                Arguments.of("123  ABC", false)
        );
    }

    private static Stream<Arguments>validBike(){
        return Stream.of(
                Arguments.of("ABC123", true),
                Arguments.of("ABC-12",true),
                Arguments.of("ABC 12",true),
                Arguments.of("A2345", true)
        );
    }

    private static Stream<Arguments>notValidBike(){
        return Stream.of(
                Arguments.of("ABC-123", true),
                Arguments.of("A", true),
                Arguments.of("ABC--2",true),
                Arguments.of("ABC  2",true)
        );
    }

    @ParameterizedTest
    @MethodSource("outOfBoundsHD")
    void notInHD(int x, int y){
        Specification.setDefinition(0);
        assertFalse(Specification.insideDisplayArea(x, y));
    }
    @ParameterizedTest
    @MethodSource("inBoundsHD")
    void InHD(int x, int y){
        Specification.setDefinition(0);
        assertTrue(Specification.insideDisplayArea(x, y));
    }
    @ParameterizedTest
    @MethodSource("outOfBoundsFHD")
    void notInFHD(int x, int y){
        Specification.setDefinition(1);
        assertFalse(Specification.insideDisplayArea(x, y));
    }



    @ParameterizedTest
    @MethodSource("inBoundsFHD")
    void InFHD(int x, int y){
        Specification.setDefinition(1);
        assertTrue(Specification.insideDisplayArea(x, y));
    }

    @ParameterizedTest
    @MethodSource("validCar")
    void vCar(String name, boolean m){
        assertTrue(Specification.messageIsValid(name, m));
    }

    @ParameterizedTest
    @MethodSource("notValidCar")
    void nVCar(String name, boolean m){
        assertFalse(Specification.messageIsValid(name, m));
    }

    @ParameterizedTest
    @MethodSource("validBike")
    void vBike(String name, boolean m){
        assertTrue(Specification.messageIsValid(name, m));
    }

    @ParameterizedTest
    @MethodSource("notValidBike")
    void nVBike(String name, boolean m){
        assertFalse(Specification.messageIsValid(name, m));
    }
}