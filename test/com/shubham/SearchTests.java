package com.shubham;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

import com.shubham.searching.SearchExecutor;
import com.shubham.searching.SearchTypes;
import com.shubham.utils.RandomGenerator;
import com.shubham.utils.TimingExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@ExtendWith({TimingExtension.class})
@DisplayName("Search Tests")
class SearchTests {

    private static int[] numberArr;
    private static Random random;

    @BeforeAll
    static void initSetUp() {
        random = new Random();
        numberArr = RandomGenerator.getArrayOfRandomIntegers(10);
        Arrays.sort(numberArr);
        //System.out.println(Arrays.toString(numberArr));
    }

    @DisplayName("Testing Search Types")
    @ParameterizedTest(name = "{arguments}")
    @EnumSource(SearchTypes.class)
    void searchTestCases(SearchTypes searchType) {
        SearchTestCases testCases = new SearchTestCases(searchType);
        for (Method testMethod : SearchTestCases.class.getDeclaredMethods()) {
            try {
                String testCaseName = testMethod.getName().replaceAll(String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])", "(?<=[^A-Z])(?=[A-Z])", "(?<=[A-Za-z])(?=[^A-Za-z])"), " ");
                long startTime = System.currentTimeMillis();
                Assertions.assertTrue((Boolean) testMethod.invoke(testCases), testCaseName + " test case is failed.");
                System.out.println(String.format("\t%s test case took %s ms.", testCaseName, System.currentTimeMillis() - startTime));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @RepeatedTest(value = 1000, name = "{displayName} {currentRepetition}")
    @DisplayName("Search Types Testing")
    void sortTestCases() {
        initSetUp();
        for (SearchTypes searchType : SearchTypes.values()) {
            System.out.println("Performing " + searchType + " Test Cases...");
            searchTestCases(searchType);
        }
    }

    private class SearchTestCases {

        private SearchTypes searchType;

        SearchTestCases(SearchTypes searchType) {
            this.searchType = searchType;
        }

        boolean ifArrayIsEmpty() {
            return -1 == SearchExecutor.performSearch(searchType, new int[0], 0);
        }

        boolean ifFoundAsFirstInArray() {
            return SearchExecutor.performSearch(searchType, numberArr, numberArr[0]) > -1;
        }

        boolean ifFoundAsMiddleInArray() {
            return SearchExecutor.performSearch(searchType, numberArr, numberArr[numberArr.length >>> 1]) > -1;
        }

        boolean ifFoundAsLastInArray() {
            return SearchExecutor.performSearch(searchType, numberArr, numberArr[numberArr.length - 1]) > -1;
        }

        boolean ifFoundAnywhereInArray() {
            return SearchExecutor.performSearch(searchType, numberArr, numberArr[random.nextInt(numberArr.length)]) > -1;
        }

        boolean ifNotFoundInArray() {
            return -1 == SearchExecutor.performSearch(searchType, numberArr, Integer.MAX_VALUE);
        }
    }
}