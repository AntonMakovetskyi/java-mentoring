package benchmarks;

import algoritmth.BinarySearch;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 3)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class BenchmarkBinarySearch {
    private int[] smallArrayWithTestData;
    private int[] bigArrayWithTestData;
    private int searchNumber;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(BenchmarkBinarySearch.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void setup() {
        smallArrayWithTestData = new int[]{2, 3, 5, 14, 65, 78, 82, 84, 89, 95, 102, 134, 234, 534, 123, 1234, 1444, 13233};
        bigArrayWithTestData = generateSortedArray(15000);
        searchNumber = 1234;
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void recursiveSearchInSmallArray() {
        BinarySearch.recursiveSearch(searchNumber, smallArrayWithTestData);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void iterativeSearchInSmallArray() {
        BinarySearch.iterativeSearch(searchNumber, smallArrayWithTestData);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void recursiveSearchInBigArray() {
        BinarySearch.recursiveSearch(searchNumber, bigArrayWithTestData);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void iterativeSearchInBigArray() {
        BinarySearch.iterativeSearch(searchNumber, bigArrayWithTestData);
    }

    private int[] generateSortedArray(int amountOfElements) {
        int[] sortedArray = new int[amountOfElements];
        for (int i = 0; i < amountOfElements; i++) {
            sortedArray[i] = i;
        }
        return sortedArray;
    }
}
