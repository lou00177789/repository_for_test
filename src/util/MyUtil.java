package util;

/**
 * @author liuLiang
 * @create 2022/2/23 19:42
 * @Description
 * @explain
 */
public class MyUtil {
    public static void swapArrChild(int[] arr,int i,int j){
        int temp = arr[i];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    public static void showArr(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if (i != arr.length-1){
                System.out.print(",");
            }
        }
        System.out.println();
    }
}
