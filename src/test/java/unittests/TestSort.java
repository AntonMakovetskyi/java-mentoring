package unittests;

import algoritmth.InsertionSort;
import algoritmth.MergeSort;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;


@RunWith(Parameterized.class)
public class TestSort {
    public int[] arrayWithTestData;

    @Before
    public void printDataBefore() {
        System.out.println("Source array: " + Arrays.toString(arrayWithTestData));
    }

    public TestSort(int[] array) {
        this.arrayWithTestData = array.clone();
    }

    @Parameterized.Parameters(name = "{index} sorting test")
    public static Collection<int[]> testDataOfArrays() {
        return Arrays.asList(new int[]{23, 2, 2, 34, 1, 5, 6, 12, 45, 12, 4, 33},
                new int[]{1, 1, 1, 1, 1, 1},
                new int[]{28, 1, -14, 144, 1, 12, 234},
                new int[]{-1, 2, 3, 12, 45, 66});
    }

    @Test
    public void testMergeSort() {
        new MergeSort().sort(arrayWithTestData);
        Assert.assertThat("The array is not sorted", isSorted(arrayWithTestData), is(true));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void negativeTestMergeSortWithRange() {
        int firstIndex = 153;
        int lastIndex = 208;
        new MergeSort().sort(arrayWithTestData, firstIndex, lastIndex);
    }

    @Test
    public void testMergeSortWithRange() {
        int firstIndex = 3;
        int lastIndex = 5;
        System.out.println(String.format("Sorting from %s to %s index", firstIndex, lastIndex));
        new MergeSort().sort(arrayWithTestData, firstIndex, lastIndex);
        Assert.assertThat("The array is not sorted", isSorted(arrayWithTestData, firstIndex, lastIndex), is(true));
    }

    @Test
    public void testInsertionSort() {
        new InsertionSort().sort(arrayWithTestData);
        Assert.assertThat("The array is not sorted", isSorted(arrayWithTestData), is(true));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void negativeTesInsertionSortWithRange() {
        int firstIndex = 199;
        int lastIndex = 708;
        new InsertionSort().sort(arrayWithTestData, firstIndex, lastIndex);
    }

    @Test
    public void testInsertionSortWithRange() {
        int firstIndex = 1;
        int lastIndex = 4;
        System.out.println(String.format("Sorting from %s to %s index", firstIndex, lastIndex));
        new InsertionSort().sort(arrayWithTestData, firstIndex, lastIndex);
        Assert.assertThat("The array is not sorted", isSorted(arrayWithTestData, firstIndex, lastIndex), is(true));
    }

    @After
    public void printDataAfter() {
        System.out.println("Sorted array: " + Arrays.toString(arrayWithTestData));
    }

    private boolean isSorted(int[] arr) {
        return isSorted(arr, 0, arr.length);
    }

    private boolean isSorted(int[] arr, int left, int right) {
        for (int i = left; i < right - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}