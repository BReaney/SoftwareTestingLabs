package lab03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class GameBoardTest {
    private static Stream<Arguments>goodValues(){
        return Stream.of(
                Arguments.of(1,1),
                Arguments.of( 2,2),
                Arguments.of( 3,3),
                Arguments.of( 4,4),
                Arguments.of( 5,5)
        );
    }

    private static Stream<Arguments>badValues(){
        return Stream.of(
                Arguments.of(-15,-1),
                Arguments.of( 10,10),
                Arguments.of( -5,5),
                Arguments.of( 10,-5)
        );
    }

    @ParameterizedTest
    @MethodSource("goodValues")
    void cValues(int x, int y){
        assertTrue(GameBoard.isOnBoard(x, y));
    }
    @ParameterizedTest
    @MethodSource("badValues")
    void iCValues(int x, int y){
        assertFalse(GameBoard.isOnBoard(x, y));
    }

    @Test
    void BLCW(){
        assertFalse(GameBoard.isOnBoard(-1,-1));
    }
    @Test
    void BLCR(){
        assertTrue(GameBoard.isOnBoard(0,0));
    }

    @Test
    void TRCW(){
        assertFalse(GameBoard.isOnBoard(6,6));
    }
    @Test
    void TRCR(){
        assertTrue(GameBoard.isOnBoard(5,5));
    }

    @Test
    void TLCW(){
        assertFalse(GameBoard.isOnBoard(-1,7));
    }
    @Test
    void TLCR(){
        assertTrue(GameBoard.isOnBoard(0,5));
    }

    @Test
    void BRCW(){
        assertFalse(GameBoard.isOnBoard(5,-1));
    }
    @Test
    void BRCR(){
        assertTrue(GameBoard.isOnBoard(5,0));
    }

}
