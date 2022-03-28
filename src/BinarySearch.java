import java.util.Random;

/**
 * @author liuLiang
 * @create 2022/2/18 17:27
 * @Description 二分查找
 * @explain
 */
public class BinarySearch {
    public static BinarySearch bs = new BinarySearch();
    public static void main(String[] args) {
//        int[] arr = bs.getArr(15);
        int[] arr = new int[]{2,4,5,16,29,29,34,41,44,51,53,64,69,73,79};
        int i = bs.binFind(arr, 41);
        System.out.println(i);
        bs.showArr(arr);
    }

    private int binFind(int[] arr,int key){
        int start = 0;
        int end = arr.length-1;
        return bs.loopCall(arr,start,end,key);
    }

    private int loopCall(int[] arr,int start,int end,int key){
        // 判断区间长度是否合法
        if (start > end){
            return -1;
        }

        int mid = (end + start)/2;
        if (key > arr[mid]){ // 在右区间
            return loopCall(arr,mid+1,end,key);
        }
        else if (key < arr[mid]){ // 左区间
            return loopCall(arr,start,mid-1,key);
        }else {//相等
            return arr[mid];
        }
    }

    /**
     * 获得指定长度有序数组
     * @param n
     * @return
     */
    private int[] getArr(int n){
        int[] arr = new int[n];
        Random random = new Random();
        int i = 0;
        while (i < n){
            arr[i] = random.nextInt(80);
            i++;
        }
        SortingAlgorithm.instance.bubbleSort(arr);
        return arr;
    }

    /**
     * 显示数组
     * @param arr
     */
    private void showArr(int[] arr){
        for (int i = 0;i<arr.length;i++){
            System.out.print(arr[i]);
            if (i != arr.length-1) System.out.print(",");
        }
    }
}
