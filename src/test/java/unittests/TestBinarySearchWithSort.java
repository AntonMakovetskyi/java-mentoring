package unittests;

import algoritmth.BinarySearch;
import algoritmth.InsertionSort;
import algoritmth.MergeSort;
import algoritmth.Sorting;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestBinarySearchWithSort {
    public int[] arrayWithTestData;
    public int expectedIndex, searchNumber, actualIndex;
    public Sorting typeOfSort;

    @Before
    public void setUp() {
        arrayWithTestData = new int[]{12, 13, 42, 21, 11, 1, 3, 3, 3, 123, 53, 86, 23, 4534, 234, 13, 132, 145};
    }

    public TestBinarySearchWithSort(int expectedIndex, int searchNumber, Sorting typeOfSort) {
        this.expectedIndex = expectedIndex;
        this.searchNumber = searchNumber;
        this.typeOfSort = typeOfSort;
    }

    @Parameterized.Parameters(name = "{index} searching test")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{{3, 3, new InsertionSort()},
                {3, 3, new MergeSort()},
                {12, 86, new MergeSort()},
                {12, 86, new InsertionSort()},
                {-1, 5, new InsertionSort()},
                {-1, 5, new MergeSort()},
        });
    }

    @Test
    public void testRecursiveSearchWithSorting() {
        actualIndex = BinarySearch.recursiveSearch(searchNumber, arrayWithTestData, typeOfSort);
        Assert.assertEquals(expectedIndex, actualIndex);

    }

    @Test
    public void testIterativeSearchWithSorting() {
        actualIndex = BinarySearch.iterativeSearch(searchNumber, arrayWithTestData, typeOfSort);
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @After
    public void printResults() {
        System.out.println(String.format("The index of \"%s\" element in %s array is \"%s\"",
                searchNumber, Arrays.toString(arrayWithTestData), actualIndex));
    }
}
