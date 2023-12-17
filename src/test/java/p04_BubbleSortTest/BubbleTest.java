package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {
    private static final int[] UNSORTED_ARR = {2, 3, 7, 1, 9, -3, 7};
    private static final int[] SORTED_ARR = {-3, 1, 2, 3, 7, 7, 9};


    @Test
    public void testBubbleSortArray() {
        Bubble.sort(UNSORTED_ARR);

        Assert.assertArrayEquals(SORTED_ARR, UNSORTED_ARR);
    }

}
