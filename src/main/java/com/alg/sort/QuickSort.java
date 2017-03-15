package com.alg.sort;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * 〈快速排序实现〉
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

    /**
     * 
     * 功能描述: <br>
     * 将数组从小到大排序
     *
     * @param array
     * @param bottom
     * @param top
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void sort(int[] array, int bottom, int top) {
        if (bottom < top) {
            int divdePoint = partition(array, bottom, top);
            sort(array, bottom, divdePoint - 1);
            sort(array, divdePoint + 1, top);
        }

    }

    /**
     * 
     * 功能描述: <br>
     * 将top所在是索引值作为一个基础值,将小于这个值的数据放在左边，大于这个值的放右边<br>
     * 
     *
     * @param array
     * @param bottom
     * @param top
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
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
