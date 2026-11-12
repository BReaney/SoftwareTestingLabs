package lab04;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMaxMinTest {
    private static List<Float> I1 = new ArrayList<Float>();
    private static ArrayList<Float> W1 = new ArrayList<Float>();
    private static ArrayList<Float> P1 = new ArrayList<Float>();
    private static ArrayList<Float> E1 = new ArrayList<Float>();


    public static void makingCollections(){
        I1.add(52.00F);
        I1.add(55.00F);
        I1.add(65.00F);

        W1.add(100.00F);
        W1.add(65.00F);
        W1.add(110.00F);
        W1.add(15.00F);

        P1.add(50.00F);
        P1.add(50.00F);
        P1.add(50.00F);
    }
    @ParameterizedTest
    @MethodSource("generator")
    void findMinMax( Collection<?> coll1) {
        FindMaxMin.findMaxMin((List) coll1);
    }
    private static Stream<Arguments> generator() {
        FindMaxMinTest.makingCollections();
        return Stream.of(
                Arguments.of(I1),
                Arguments.of(W1),
                Arguments.of(P1),
                Arguments.of(E1)

        );
    }
}
