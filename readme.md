|Benchmark                                        |  Mode | Cnt |  Score   Error | Units|
|-------------------------------------------------|-------|-----|----------------|------|
|BenchmarkBinarySearch.iterativeSearchInBigArray  |  avgt |   5 | 26.536 ± 2.979 | ns/op|
|-------------------------------------------------|-------|-----|----------------|------|
|BenchmarkBinarySearch.iterativeSearchInSmallArray|  avgt |   5 |  6.285 ± 0.152 | ns/op|
|-------------------------------------------------|-------|-----|----------------|------|
|BenchmarkBinarySearch.recursiveSearchInBigArray  |  avgt |   5 | 33.422 ± 0.582 | ns/op|
|-------------------------------------------------|-------|-----|----------------|------|
|BenchmarkBinarySearch.recursiveSearchInSmallArray|  avgt |   5 |  5.989 ± 0.391 | ns/op|
|-------------------------------------------------|-------|-----|----------------|------|

In the results of benchmarks, we can see a little difference searching in arrays with a big amount of elements: 
iterative search faster than merge search by 6.88 nanoseconds

Both algorithm will have the same time complexity O(log(n)), but they will different in term of space usage.
Recursive May reach to log(n) space, in iterative BS it should be O(1) space complexity.


