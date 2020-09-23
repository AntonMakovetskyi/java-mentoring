package benchmarks;

import algoritmth.BinarySearch;
import algoritmth.InsertionSort;
import algoritmth.MergeSort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 3)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class BenchmarkSort {
    private int[] smallArrayWithTestData;
    private int[] bigArrayWithTestData;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(BenchmarkBinarySearch.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void setup() {
        smallArrayWithTestData = new int[]{212, 74, 4, 5, 83, -1, 335, 123, 231, 213, 112, 45, 209, 22, 1, 1, 1, 56};
        bigArrayWithTestData = generateArrayWithRandomElements(15000);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void insertionSortInSmallArray() {
        new InsertionSort().sort(smallArrayWithTestData);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void mergeSortInSmallArray() {
        new MergeSort().sort(smallArrayWithTestData);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void insertionSortInBigArray() {
        new InsertionSort().sort(bigArrayWithTestData);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void mergeSortInBigArray() {
        new MergeSort().sort(bigArrayWithTestData);
    }

    private int[] generateArrayWithRandomElements(int amountOfElements) {
        int[] arrayWithRandomElements = new int[amountOfElements];
        Random random = new Random();
        for (int i = 0; i < amountOfElements; i++) {
            arrayWithRandomElements[i] = random.nextInt(999);
        }
        return arrayWithRandomElements;
    }
}
