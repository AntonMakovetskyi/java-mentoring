package algoritmth;

public class InsertionSort implements Sorting {

    public void sort(int[] sourceArray) {
        sort(sourceArray, 0, sourceArray.length - 1);
    }

    public void sort(int[] sourceArray, int left, int right) {
        for (int i = left; i < right; ++i) {

            int j = i;

            while (j >= left && sourceArray[j] > sourceArray[j + 1]) {
                int key = sourceArray[j];
                sourceArray[j] = sourceArray[j + 1];
                sourceArray[j + 1] = key;
                j = j - 1;
            }
        }
    }
}
