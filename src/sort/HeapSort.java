package sort;

import util.MyUtil;

/**
 * @author liuLiang
 * @create 2022/2/23 18:20
 * @Description
 * @explain
 */
public class HeapSort {
    public static void main(String[] args) {

        int[] arrays = {1,2,3,4,5,6,7};

        heapSort(arrays);
        MyUtil.showArr(arrays);
    }

    private static void heapSort(int[] arrays) {
        // 创建大根堆
        for (int i=arrays.length-1;i>=0;i--){
            check(arrays,i,arrays.length-1);
        }
        // 把0位和理论最后一位交换，然后再维护大根堆
        for (int i=arrays.length-1;i>=0;i--){
            int temp = arrays[0];
            arrays[0] = arrays[i];
            arrays[i] = temp;
            check(arrays,i,i-1);
        }
    }

    private static void check(int[] arrays, int i,int length) {
        // 父节点的位置
        int prent = (i-1)/2;
        if (prent >= 0) {
            int lChild = prent*2+1;
            int rChild = prent*2+2;
            int max = prent;
            if (lChild <= length&&arrays[lChild]>arrays[max]){
                max = lChild;
            }
            if (rChild <= length&&arrays[rChild]>arrays[max]){
                max = rChild;
            }
            if (max!=prent){
                int temp = arrays[prent];
                arrays[prent] = arrays[max];
                arrays[max] = temp;
                check(arrays,prent,length);
            }
        }
    }


}
