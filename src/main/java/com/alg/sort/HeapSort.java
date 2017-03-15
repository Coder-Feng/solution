package com.alg.sort;

/**
 * 
 * 〈一句话功能简述〉<br> 
 * 堆排序
 *
 * @author coder_feng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HeapSort implements Sort {

    @Override
    public void sort(int[] array) {
        // 建立一个max 大堆
        buildMaxHeap(array);
        for (int i = array.length - 1; i >= 0; i--) {
            // 把最后一个元素与第0个元素交换，这样最大的值就放在最后了
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            // 第一个元素是变化的值，从这个节点开始建立大堆，如果不是最大的值，
            // 就会下沉到下面一层.堆的长度逐渐缩短
            this.maxHeap(array, i, 0);
        }
    }

    /**
     * 
     * 功能描述: <br>
     * 建立一个大堆，不需要处理叶子节点，所以节点从 1/2 长度处的节点开始
     *
     * @param array
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void buildMaxHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }

    /**
     * 
     * 功能描述: <br>
     * 第i个节点 与 2i+1 和 2i+2 值比较，与两者的大值交换.递归处理 2i+1或2i+2的节点<br>
     * 如第i个节点的值最大，不处理<br>
     *
     * @param array
     * @param size
     * @param i
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void maxHeap(int[] array, int size, int i) {
        int l = 2 * i + 1;
        int r = l + 1;
        int largest = i;
        if (l < size && array[l] > array[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < size && array[r] > array[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = array[largest];
            array[largest] = array[i];
            array[i] = temp;
            maxHeap(array, size, largest);
        }
    }
}
