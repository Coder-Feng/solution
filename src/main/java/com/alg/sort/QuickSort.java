package com.alg.sort;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author coder_feng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class QuickSort implements Sort {

    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int bottom, int top) {
        if (bottom < top) {
            int divdePoint = partition(array, bottom, top);
            sort(array, bottom, divdePoint - 1);
            sort(array, divdePoint + 1, top);
        }

    }

    private int partition(int[] array, int bottom, int top) {

        int divideValue = array[top];

        int i = bottom;
        for (int loopIndex = bottom; loopIndex <= top; loopIndex++) {
            if (array[loopIndex] < divideValue) {
                int temp = array[loopIndex];
                array[loopIndex] = array[i];
                array[i] = temp;
                i++;
            }
        }

        int temp = array[top];
        array[top] = array[i];
        array[i] = temp;

        return i;
    }

}
