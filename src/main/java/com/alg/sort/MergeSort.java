package com.alg.sort;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * 合并排序
 *
 * @author coder_feng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] array) {
        int[] sort = sort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            array[i] = sort[i];
        }
    }

    /**
     * 
     * 功能描述: <br>
     * 将数组
     *
     * @param array
     * @param start
     * @param end
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public int[] sort(int[] array, int start, int end) {
        int size = end - start + 1;
        if (size == 0) {
            return new int[0];
        } else if (size == 1) {
            int[] sortArray = new int[size];
            sortArray[0] = array[start];
            return sortArray;
        } else {
            return mergeArray(sort(array, start, start + (end - start) / 2), sort(array, (end + start) / 2 + 1, end));
        }
    }

    /**
     * 
     * 功能描述: <br>
     * 将两个 排好序的数组合并
     *
     * @param left
     * @param right
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private int[] mergeArray(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        for (; (i < left.length && j < right.length);) {
            if (left[i] <= right[j]) {
                merged[k++] = left[i];
                i++;
                continue;
            }
            if (left[i] > right[j]) {
                merged[k++] = right[j];
                j++;
                continue;
            }
        }

        if (i != left.length) {
            for (int m = i; m < left.length; m++) {
                merged[k++] = left[m];
            }
        }
        if (j != right.length) {
            for (int m = j; m < right.length; m++) {
                merged[k++] = right[m];
            }
        }
        return merged;
    }
}
