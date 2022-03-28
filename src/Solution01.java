import java.util.Arrays;

/**
 * @author liuLiang
 * @create 2022/1/19 16:03
 * @Description 打印从 1到n位数的值 如 n = 2, 输出：1,2,3,...18,19,...98,99
 * 递归实现
 * @explain
 */
public class Solution01 {
    public static Solution01 solution = new Solution01();

    public static void main(String[] args) {
        solution.printToMax(3);
    }

    public void printToMax(int n) {
        if (n <= 0) {
            System.out.println("输入不合法");
            return;
        }
        byte[] number = new byte[n];
        printNumber(number,n,0);
    }

    private void printNumber(byte[] number, int n, int loc) {
        if (loc == n){
            return;
        }
        for (int i=0;i<10;i++){
            number[loc] = (byte) i;
            if (loc == n-1) printCharNam(number);
            printNumber(number,n,loc+1);
        }
    }

    /**
     * 打印操作
     * @param chars
     */
    private void printCharNam(byte[] chars){
        boolean isPrint = false;
        for (int i = 0;i<chars.length;i++){
            if (chars[i] != 0) isPrint = true;
            if (isPrint) System.out.print(chars[i]);
        }
        if (isPrint) System.out.println("");
    }
}
