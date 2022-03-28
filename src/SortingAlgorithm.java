/**
 * @author liuLiang
 * @create 2022/2/18 10:32
 * @Description 一些常见的排序算法
 * @explain
 */
public class SortingAlgorithm {
    public static SortingAlgorithm instance = new SortingAlgorithm();


    public static void main(String[] args) {
        instance.quickSort(arr,0,arr.length-1);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if (i != arr.length-1) System.out.print(",");
        }
    }
    public static int[] arr = new int[]{4,7,55,9,23,43,8,2,65,44,9,73,66,84,34};


    /**
     * 快速排序
     */
    public void quickSort(int[] arr,int l,int r){
        int i = l;
        int j = r;
        //支点数
        int point = arr[(l+r)/2];
        while (i<=j){
            while (arr[i]<point) i++;
            while (arr[j]>point) j--;
            System.out.println(i+":"+j);
            if (i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

        }
        //左半边
        if (l<j){
            System.out.println("左");
            quickSort(arr,l,j);
        }
        //右半边
        if (r>i){
            System.out.println("右");
            quickSort(arr,i,r);
        }
    }


    /**
     * 插入排序
     * 2,4,7,8,9,9,23,34,43,44,55,65,66,73,84
     */
    public int[] insertSort(int[] arr){
        for (int i=1;i<arr.length;i++){//依次从第二位当插入数
            int make = arr[i];//保存插入数
            int index = 0;
            //插入数去维护好的列表中从屁股寻找插入位置,插入位置是j+1,匹配不到说明是最小，在首位位置为0
            for (int j =i-1;j>=0;j--){
                if (arr[i] > arr[j]){
                    index = j+1;
                    break;
                }
            }
            //从已排好的队列尾部依次后移直到取到index位置(k-1取到index)，这会覆盖插入数
            for (int k=i;k>index;k--){
                arr[k] = arr[k-1];
            }
            arr[index] = make;//把存好的插入数放到目标位置处
        }
        return arr;
    }

    /**
     * 选择排序
     * 2,4,7,8,9,9,23,34,43,44,55,65,66,73,84
     */
    public int[] selectionSort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[i]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    /**
     * 冒泡排序
     * 2,4,7,8,9,9,23,34,43,44,55,65,66,73,84
     */
    public int[] bubbleSort(int[] arr){
        for (int i=0;i<arr.length-2;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int a= arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = a;
                }
            }
        }
        return arr;
    }





}
