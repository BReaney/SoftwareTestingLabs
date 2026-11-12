package lab01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ArrayUtilsTest {
    @Test
    void sayHi() {
        System.out.println("Hello from the test.");
    }

    // A sorted array
    @Test
    void sortedAAA() {
        int[] someArray = {1,2,3,4};       // arrange
        boolean someArraySorted = ArrayUtils.isSorted(someArray);  // act
        assertTrue(someArraySorted);       // assert
    }

    // Empty arrays are sorted by definition
    @Test
    void EmptyArrays(){
        int[] emptyArray = {};
        boolean emptyArraySorted = ArrayUtils.isSorted(emptyArray);
        assertTrue(emptyArraySorted);

    }

    // Arrays of one element are sorted by definition
    @Test
    void sizeOfOne(){
        int[] array = {1};
        boolean sizeOfOneSorted = ArrayUtils.isSorted(array);
        assertTrue(sizeOfOneSorted);


    }

    // A partially sorted array (some elements are in sorted order, but some aren't)
    @Test
    void partiallySorted(){
        int[] partiallySortedArray = {5,6,7,4,3,2};
        boolean partiallySortedArraySorted = ArrayUtils.isSorted(partiallySortedArray);
        assertFalse(partiallySortedArraySorted);




    }
    // A completely unsorted array (no elements are in sorted order)
    @Test
    void unsortedArray(){
        int[] unsortedArray = {5,4,3,2,1};
        boolean unsortedArraySorted = ArrayUtils.isSorted(unsortedArray);
        assertFalse(unsortedArraySorted);
    }
    // An array with duplicate values (may be sorted or not depending on the values chosen)
    @Test
    void duplicateValues(){
        int[] duplicateArray1 = {1, 1, 2, 2, 3, 3};
        boolean duplicateArray1Sorted = ArrayUtils.isSorted(duplicateArray1);
        assertTrue(duplicateArray1Sorted);

        int[] duplicateArray2 = {2,2, 1,1};
        boolean duplicateArray2Sorted = ArrayUtils.isSorted(duplicateArray2);
        assertFalse(duplicateArray2Sorted);




    }
}



