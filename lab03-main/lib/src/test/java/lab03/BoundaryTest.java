package lab03;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BoundaryTest {

    @Test
    void isUnsafe() {
        assertTrue(Boundary.isUnsafe(86));
    }

    @Test
    void isNotUnsafe() {
        assertFalse(Boundary.isUnsafe(85));
    }

    // Test lower boundary, upper boundary
    @ParameterizedTest
    @ValueSource(ints = {5,20})
    void isComfortableTemp(int temp){
        assertTrue(Boundary.isComfortable(temp));
    }
    // Test temp just off both ends of the restriction
    @ParameterizedTest
    @ValueSource(ints = {4,21})
    void isNotComfortableTemp(int temp){
        assertFalse(Boundary.isComfortable(temp));
    }
    // Testing lower condition
    @Test
    void noElevators(){
        assertEquals(0, Boundary.elevatorsRequired(1));
    }
    //Testing middle conditions
    @ParameterizedTest
    @ValueSource(ints ={3,5})
    void oneElevator(int storeys){
        assertEquals(1,Boundary.elevatorsRequired(storeys));
    }
    //Testing upper condition
    @Test
    void twoElevators(){
        assertEquals(2, Boundary.elevatorsRequired(6));
    }
    @ParameterizedTest
    @ValueSource(doubles={-0.01,100.01})
    void outOfBoundsGrade(double grade){
        assertThrows(IllegalArgumentException.class,() -> {Boundary.percentageToLetterGrade(grade);});
    }

    @ParameterizedTest
    @ValueSource(doubles = {0,49.99})
    void fGrade(double grade){
        assertEquals("F", Boundary.percentageToLetterGrade(grade));
    }
    @ParameterizedTest
    @ValueSource(doubles = {50.00,59.99})
    void dGrade(double grade){
        assertEquals("D",Boundary.percentageToLetterGrade(grade));
    }
    @ParameterizedTest
    @ValueSource(doubles = {60.00,64.99})
    void cGrade(double grade){
        assertEquals("C",Boundary.percentageToLetterGrade(grade));
    }
    @ParameterizedTest
    @ValueSource(doubles = {65,69.99})
    void cPlusGrade(double grade){
        assertEquals("C+",Boundary.percentageToLetterGrade(grade));
    }
    @ParameterizedTest
    @ValueSource(doubles = {70.00,72.99})
    void bMinusGrade(double grade){
        assertEquals("B-",Boundary.percentageToLetterGrade(grade));
    }
    @ParameterizedTest
    @ValueSource(doubles = {73.00,76.99})
    void bGrade(double grade){
        assertEquals("B",Boundary.percentageToLetterGrade(grade));
    }
    @ParameterizedTest
    @ValueSource(doubles = {77.00,79.99})
    void bPlusGrade(double grade){
        assertEquals("B+",Boundary.percentageToLetterGrade(grade));
    }
    @ParameterizedTest
    @ValueSource(doubles = {80.00,84.99})
    void aMinusGrade(double grade){
        assertEquals("A-",Boundary.percentageToLetterGrade(grade));
    }
    @ParameterizedTest
    @ValueSource(doubles = {85.00,89.99})
    void aGrade(double grade){
        assertEquals("A",Boundary.percentageToLetterGrade(grade));
    }
    @ParameterizedTest
    @ValueSource(doubles = {90.00,100.00})
    void aPlusGrade(double grade){
        assertEquals("A+",Boundary.percentageToLetterGrade(grade));
    }
}