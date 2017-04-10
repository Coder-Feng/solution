package com.alg;

import java.util.Random;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.alg.sort.BubbleSort;
import com.alg.sort.HeapSort;
import com.alg.sort.MergeSort;
import com.alg.sort.QuickSort;
import com.alg.sort.Sort;

public class SortTest {

    Sort sort = null;

    @Test
    public void testBubbleSort() {
        sort = new BubbleSort();
        doSort();

    }

    @Test
    public void testQuickSort() {
        sort = new QuickSort();
        doSort();

    }

    @Test
    public void testHeapSort() {
        sort = new HeapSort();
        doSort();

    }

    @Test
    public void testMergeSort() {
        sort = new MergeSort();
        doSort();

    }

    private void doSort() {
        int[] array0 = new int[] {};
        int[] array1 = new int[] { 1 };
        int[] array2 = new int[] { 1, 2 };
        int[] array3 = new int[] { 2, 1 };
        int[] array4 = new int[] { 1, 2, 3, 3, 2, 1 };
        int[] array5 = new int[] { 1, 2, 3, 4, 5, 6 };
        int[] array6 = new int[] { 6, 5, 4, 3, 2, 1 };
        sort.sort(array0);
        Assert.assertEquals("", toString(array0));
        sort.sort(array1);
        Assert.assertEquals("1", toString(array1));
        sort.sort(array2);
        Assert.assertEquals("1,2", toString(array2));
        sort.sort(array3);
        Assert.assertEquals("1,2", toString(array3));
        sort.sort(array4);
        Assert.assertEquals("1,1,2,2,3,3", toString(array4));
        sort.sort(array5);
        Assert.assertEquals("1,2,3,4,5,6", toString(array5));
        sort.sort(array6);
        Assert.assertEquals("1,2,3,4,5,6", toString(array6));
    }

    private static String toString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
