import java.util.Arrays;

/**
 * @author liuLiang
 * @create 2022/2/21 11:12
 * @Description 归并排序
 * @explain
 */
public class MergeSort {
    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if (left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);
            sort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        // 左序列指针
        int l = left;
        // 右序列指针
        int r = mid + 1;
        // 临时数组指针
        int t = 0;

        // 比较排序到临时数组
        while (l <= mid && r<= right){
            if (arr[l] <= arr[r]){
                temp[t++] = arr[l++];
            }
            if (arr[r] < arr[l]){
                temp[t++] = arr[r++];
            }
        }
        while (l <= mid){
            temp[t++] = arr[l++];
        }
        while (r <= right){
            temp[t++] = arr[r++];
        }

        // 复制临时数组到原数组
        t = 0;
        while (left<=right){
            arr[left++] = temp[t++];
        }
    }
}
