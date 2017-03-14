package com.alg;

import java.util.Random;

import org.testng.annotations.Test;

import com.alg.sort.BubbleSort;
import com.alg.sort.QuckSort;
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
        sort = new QuckSort();
        doSort();

    }
    private void doSort() {

        int[] array1 = new int[10000];
        Random r = new Random();
        for (int i = 0; i < array1.length; i++) {
            array1[i] = r.nextInt(100);
        }
        int[] array2 = new int[] { 10, 9 };
        int[] array3 = new int[] { 10 };
        int[] array4 = new int[] {};
        sort.sort(array1);
        sort.sort(array2);
        sort.sort(array3);
        sort.sort(array4);
        printArray(array1);
        printArray(array2);
        printArray(array3);
        printArray(array4);
    }

    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("--------------------------");
    }
}
