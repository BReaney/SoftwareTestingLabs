package lab04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.util.ArrayList;

class CollectionUtilsTest {
    //These will be the declared collections for use in the test cases
        // identical int lists
        private static ArrayList<Integer> i1 = new ArrayList<Integer>();
        private static ArrayList<Integer> i2 = new ArrayList<Integer>();
        private static ArrayList<Integer> S1 = new ArrayList<Integer>();
        private static ArrayList<Integer> S2 = new ArrayList<Integer>();
        private static ArrayList<Integer> E1 = new ArrayList<Integer>();
        private static ArrayList<Integer> W1 = new ArrayList<Integer>();
        private static ArrayList<Integer> W2 = new ArrayList<Integer>();
        private static ArrayList<Integer> R1 = new ArrayList<Integer>();
        private static ArrayList<Integer> R2 = new ArrayList<Integer>();

        public static void makingCollections(){
            //For i1 == i2
            i1.add(1);
            i1.add(2);
            i1.add(3);
            i2.add(1);
            i2.add(2);
            i2.add(3);

            //For S1 smaller then S2, S2 contains S1
            S1.add(1);
            S1.add(2);
            S2.add(1);
            S2.add(2);
            S2.add(3);

            //W1 smaller than W2, W2 does not contain W1
            W1.add(1);
            W2.add(2);
            W2.add(3);

            //R1 is larger then R2, R1 does not contains R2
            R1.add(1);
            R1.add(2);
            R1.add(3);
            R2.add(4);
        }

    @ParameterizedTest
    @MethodSource("generator")
    void collectionUtil(String description, Collection<?> coll1, Collection<?> coll2, boolean expected) {
        boolean result = CollectionUtils.containsAny(coll1, coll2);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> generator() {
        CollectionUtilsTest.makingCollections();
        return Stream.of(
                Arguments.of("Two identical empty Array lists",i1, i2,  true),
                Arguments.of("Coll 1 is smaller then Coll2",S1,S2,true),
                Arguments.of("Empty array not allowed",E1,S2,false),
                Arguments.of("Coll 1 is smaller, Coll 2 does not contain Coll 1", W1,W2,false),
                Arguments.of("Coll 1 is larger, Coll 1 does not contain Coll 2", R1,R2,false)
        );
    }
    }
