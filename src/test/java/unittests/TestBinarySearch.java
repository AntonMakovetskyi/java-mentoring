package unittests;

import algoritmth.BinarySearch;
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

@RunWith(Parameterized.class)
public class TestBinarySearch {
    private int[] sortedArray;
    public int searchNumber, expectedIndex, actualIndex;

    @Before
    public void setUp() {
        sortedArray = new int[]{2, 4, 6, 8, 8, 13, 15, 45, 67, 89, 98, 98, 101, 123};
    }

    public TestBinarySearch(int searchNumber, int expectedIndex) {
        this.searchNumber = searchNumber;
        this.expectedIndex = expectedIndex;
    }

    @Parameterized.Parameters(name = "{index} searching test")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{{8, 4},
                {101, 12},
                {5, -1},

        });
    }

    @Test
    public void testRecursiveSearch() {
        actualIndex = BinarySearch.recursiveSearch(searchNumber, sortedArray);
        Assert.assertEquals(actualIndex, expectedIndex);
    }

    @Test
    public void testIterativeSearch() {
        actualIndex = BinarySearch.recursiveSearch(searchNumber, sortedArray);
        Assert.assertEquals(actualIndex, expectedIndex);
    }

    @After
    public void printResults() {
        System.out.println(String.format("The index of \"%s\" element in %s array is \"%s\"",
                searchNumber, Arrays.toString(sortedArray), actualIndex));
    }
}
