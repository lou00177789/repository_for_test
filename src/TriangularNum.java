/**
 * @author liuLiang
 * @create 2022/2/18 15:15
 * @Description 三角数字序列：1、2+1、3+(前一个数)、4+(前一个数)、5+(前一个数)、、、n+(n-1)
 *                           1、3、6、10、、、、、n
 * @explain
 */
public class TriangularNum {
    public static TriangularNum triNum = new TriangularNum();

    public static void main(String[] args) {
        triNum.showNumList(5);
    }

    public void showNumList(int n){
        for (int i=1;i<=n;i++){
            int triaNum = triNum.loopCallTriaNum(i);
            System.out.print(triaNum);
            if (i != n) System.out.print(",");
        }
    }

    /**
     * 三角数核心递归
     * @param n
     * @return
     */
    public int loopCallTriaNum(int n){
        if (n == 1){
            return 1; //结束条件
        }else {
            return n + loopCallTriaNum(n-1);
        }
    }

    /**
     * 阶乘核心递归
     * @param n
     * @return
     */
    public int loopCallFactorial(int n){
        if (n == 1){
            return 1; //结束条件
        }else {
            return n * loopCallFactorial(n-1);
        }
    }

}
