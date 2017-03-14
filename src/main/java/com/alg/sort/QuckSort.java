/*
 * Copyright (C), 2002-2017, 苏宁易购电子商务有限公司
 * FileName: QuckSort.java
 * Author:   15041206
 * Date:     2017年3月12日 上午10:07:04
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.alg.sort;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author 15041206
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class QuckSort implements Sort {

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
