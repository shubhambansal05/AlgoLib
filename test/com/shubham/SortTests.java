package com.shubham;

import java.io.BufferedWriter;
import java.util.Arrays;

import com.shubham.sorting.SortExecutor;
import com.shubham.sorting.SortTypes;
import com.shubham.utils.FileUtils;
import com.shubham.utils.RandomGenerator;
import com.shubham.utils.TimingExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@ExtendWith({TimingExtension.class})
@DisplayName("Sort Tests")
class SortTests {

    private static int[] numberArr;
    private static int[] sortedArr;
    private static int[] reverseSortedArr;

    private static BufferedWriter fileWriter;

    @BeforeAll
    static void initSetUp() {
        fileWriter = FileUtils.getFileWriter("resources/Sort Test Cases.txt");
    }

    @AfterAll
    static void done() {
        FileUtils.closeWriter(fileWriter);
    }

    @BeforeEach
    void setUp() {
        numberArr = RandomGenerator.getArrayOfRandomPositiveIntegers();
        sortedArr = Arrays.copyOf(numberArr, numberArr.length);
        Arrays.parallelSort(sortedArr);
        reverseSortedArr = new int[sortedArr.length];
        for (int i = 0; i <= reverseSortedArr.length >>> 1; i++) {
            int ni = reverseSortedArr.length - i - 1;
            reverseSortedArr[i] = sortedArr[ni];
            reverseSortedArr[ni] = sortedArr[i];
        }
        FileUtils.appendWithNewLine(fileWriter, Arrays.toString(numberArr));
    }

    @DisplayName("Testing Sort Types")
    @ParameterizedTest(name = "{arguments}")
    @EnumSource(SortTypes.class)
    void sortTestCases(SortTypes sortType) {
        // Average case
        performTest(sortType, numberArr, "Average");

        // Best case
        performTest(sortType, sortedArr, "Best");

        // Worst case
        performTest(sortType, reverseSortedArr, "Worst");
    }

    @RepeatedTest(value = 500, name = "{displayName} {currentRepetition}")
    @DisplayName("Sort Types Testing")
    void sortTestCases() {
        for (SortTypes sortType : SortTypes.values()) {
            System.out.println("Performing " + sortType + " Test Cases...");
            sortTestCases(sortType);
        }
    }

    private void performTest(SortTypes sortType, int[] actualArr, String testCaseName) {
        actualArr = Arrays.copyOf(actualArr, actualArr.length);
        long startTime = System.currentTimeMillis();
        SortExecutor.performSort(sortType, actualArr);
        System.out.println(String.format("\t%s test case took %s ms.", testCaseName, System.currentTimeMillis() - startTime));
        if (!Arrays.equals(actualArr, sortedArr)) {
            System.out.println("Given Array\t\t=> " + Arrays.toString(numberArr));
            System.out.println("Resulted Array\t=> " + Arrays.toString(actualArr));
        }
        Assertions.assertArrayEquals(sortedArr, actualArr, testCaseName + " test case is failed.");
    }
}
