package org.example.exercise3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void testSolutionWithValidPair() {
        Solution solution = new Solution();

        int[] A1 = {130, 191, 200, 10};
        assertEquals(140, solution.solution(A1));
    }

    @Test
    public void testSolutionWithMultipleValidPairs() {
        Solution solution = new Solution();

        int[] A2 = {405, 45, 300, 300};
        assertEquals(600, solution.solution(A2));
    }

    @Test
    public void testSolutionWithNoValidPair() {
        Solution solution = new Solution();

        int[] A3 = {50, 222, 49, 52, 25};
        assertEquals(-1, solution.solution(A3));
    }

    @Test
    public void testSolutionWithSingleElement() {
        Solution solution = new Solution();

        int[] A4 = {30, 909, 3190, 99, 3990, 9009};
        assertEquals(9918, solution.solution(A4));
    }

//    ===============================================================================================

    @Test
    public void testSolutionWithEmptyArray() {
        Solution solution = new Solution();

        int[] A = {};
        assertEquals(-1, solution.solution(A));
    }

    @Test
    public void testSolutionWithSingleNumber() {
        Solution solution = new Solution();

        int[] A = {1234};
        assertEquals(-1, solution.solution(A));
    }

    @Test
    public void testSolutionWithNoValidPairsInLargerArray() {
        Solution solution = new Solution();

        int[] A = {123, 456, 789, 321};
        assertEquals(-1, solution.solution(A));
    }

    @Test
    public void testSolutionWithValidPairAndEdgeCase() {
        Solution solution = new Solution();

        int[] A = {10007, 10007, 1007, 107, 17};
        assertEquals(20014, solution.solution(A));
    }

}
