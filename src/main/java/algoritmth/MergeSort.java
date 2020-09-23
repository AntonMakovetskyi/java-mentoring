package algoritmth;

public class MergeSort implements Sorting {

    public void sort(int[] sourceArray) {
        sort(sourceArray, 0, sourceArray.length - 1);
    }

    public void sort(int[] sourceArray, int left, int right) {
        if (sourceArray.length <= 0) {
            return;
        }

        int mid = (left + right) / 2;
        if (left < right) {
            sort(sourceArray, left, mid);
            sort(sourceArray, mid + 1, right);
        }

        int i = 0;
        int firstIndex = left;
        int lastIndex = mid + 1;
        int[] tmp = new int[right - left + 1];
        while (firstIndex <= mid && lastIndex <= right) {
            tmp[i++] = sourceArray[firstIndex] <= sourceArray[lastIndex] ? sourceArray[firstIndex++] : sourceArray[lastIndex++];
        }
        while (firstIndex <= mid) {
            tmp[i++] = sourceArray[firstIndex++];
        }
        while (lastIndex <= right) {
            tmp[i++] = sourceArray[lastIndex++];
        }
        i = 0;
        while (left <= right) {
            sourceArray[left++] = tmp[i++];
        }
    }
}

