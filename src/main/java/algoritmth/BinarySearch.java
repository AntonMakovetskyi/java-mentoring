package algoritmth;

public class BinarySearch {

    /**
     * Searches the specified array of ints for the specified value using the
     * binary recursive search algorithm. The array must be sorted
     *
     * @param searchNumber the value to be searched for
     * @param array        the array to be searched
     * @return index of the search key, if it is contained in the array;
     * otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.
     */
    public static int recursiveSearch(int searchNumber, int[] array) {
        return recursiveSearch(searchNumber, array, 0, array.length - 1);
    }

    /**
     * Searches the specified array of ints for the specified value using the
     * binary recursive search algorithm. The array will be sorted by sortingType
     *
     * @param searchNumber the value to be searched for
     * @param array        the array to be searched
     * @param sortingType  the type of sorting array
     * @return index of the search key, if it is contained in the array;
     * otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.
     */
    public static int recursiveSearch(int searchNumber, int[] array, Sorting sortingType) {
        sortingType.sort(array);
        return recursiveSearch(searchNumber, array);
    }

    /**
     * Searches a range of the specified array of ints for the specified value using the
     * binary recursive search algorithm. The array be sorted by sortingType
     *
     * @param searchNumber the value to be searched for
     * @param array        the array to be searched
     * @param left         the index of the first element (inclusive) to be
     *                     searched
     * @param right        the index of the last element (exclusive) to be searched
     * @param sortingType  the type of sorting array
     * @return index of the search key, if it is contained in the array;
     * otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.
     */
    public static int recursiveSearch(int searchNumber, int[] array, int left, int right, Sorting sortingType) {
        sortingType.sort(array);
        return recursiveSearch(searchNumber, array, left, right);
    }

    /**
     * Searches a range of the specified array of ints for the specified value using the
     * binary recursive search algorithm. The array must be sorted
     *
     * @param searchNumber the value to be searched for
     * @param array        the array to be searched
     * @param left         the index of the first element (inclusive) to be
     *                     searched
     * @param right        the index of the last element (exclusive) to be searched
     * @return index of the search key, if it is contained in the array;
     * otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.
     */
    public static int recursiveSearch(int searchNumber, int[] array, int left, int right) {
        int mid = (left + right) / 2;

        if (right < left) {
            return -1;
        }

        if (searchNumber < array[mid]) {
            return recursiveSearch(searchNumber, array, left, mid - 1);
        }

        if (searchNumber > array[mid]) {
            return recursiveSearch(searchNumber, array, mid + 1, right);
        }

        if (searchNumber == array[mid]) {
            return mid;
        }
        return -1;
    }

    /**
     * Searches the specified array of ints for the specified value using the
     * binary iterative search algorithm. The array must be sorted
     *
     * @param searchNumber the value to be searched for
     * @param array        the array to be searched
     * @return index of the search key, if it is contained in the array;
     * otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.
     */
    public static int iterativeSearch(int searchNumber, int[] array) {
        return iterativeSearch(searchNumber, array, 0, array.length - 1);
    }

    /**
     * Searches the specified array of ints for the specified value using the
     * binary iterative search algorithm. The array will be sorted by sortingType
     *
     * @param searchNumber the value to be searched for
     * @param array        the array to be searched
     * @param sortingType  the type of sorting array
     * @return index of the search key, if it is contained in the array;
     * otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.
     */
    public static int iterativeSearch(int searchNumber, int[] array, Sorting sortingType) {
        sortingType.sort(array);
        return iterativeSearch(searchNumber, array);
    }

    /**
     * Searches a range of the specified array of ints for the specified value using the
     * binary iterative search algorithm. The array be sorted by sortingType
     *
     * @param searchNumber the value to be searched for
     * @param array        the array to be searched
     * @param left         the index of the first element (inclusive) to be
     *                     searched
     * @param right        the index of the last element (exclusive) to be searched
     * @param sortingType  the type of sorting array
     * @return index of the search key, if it is contained in the array;
     * otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.
     */
    public static int iterativeSearch(int searchNumber, int[] array, int left, int right, Sorting sortingType) {
        sortingType.sort(array);
        return iterativeSearch(searchNumber, array, left, right);
    }

    /**
     * Searches a range of the specified array of ints for the specified value using the
     * binary iterative search algorithm. The array must be sorted
     *
     * @param searchNumber the value to be searched for
     * @param array        the array to be searched
     * @param left         the index of the first element (inclusive) to be
     *                     searched
     * @param right        the index of the last element (exclusive) to be searched
     * @return index of the search key, if it is contained in the array;
     * otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.
     */
    public static int iterativeSearch(int searchNumber, int[] array, int left, int right) {
        while (left <= right) {

            int middle = (left + right) / 2;

            if (searchNumber < array[middle]) {
                right = middle - 1;
            }

            if (searchNumber > array[middle]) {
                left = middle + 1;
            }

            if (searchNumber == array[middle]) {
                return middle;
            }
        }
        return -1;
    }
}
