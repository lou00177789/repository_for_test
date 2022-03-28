/**
 * @author liuLiang
 * @create 2022/1/19 16:03
 * @Description 打印从 1到n位数的值 如 n = 2, 输出：1,2,3,...18,19,...98,99
 * @explain
 */
public class Solution {
    public static Solution solution = new Solution();
    public static void main(String[] args) {
        solution.printOneToN(-3);
    }

    /**
     * 打印从 1到n位数的值 如 n = 2, 输出：1,2,3,...18,19,...98,99
     * @param n
     */
    public void printOneToN(int n){
        if (n <= 0) throw new RuntimeException("参数错误！");
        char[] charNum = new char[n + 1];
        charNum[n] = '\0';
        for (int i = 0; i < charNum.length - 1; i++) {
            charNum[i] = '0';
        }
        while (!increment(charNum)){
            printCharNam(charNum);
        }
    }

    /**
     * 加一操作
     * @param charNum
     * @return
     */
    private boolean increment(char[] charNum){
        boolean isOverFlow = false;
        char char10 = '9' + 1;

        int nLength = charNum.length -1;
        for (int i = nLength - 1;i >= 0;i--){
            char nSum = charNum[i];
            nSum ++;
            if (nSum >= char10){   // 如果要进位
                if (i==0){              // 要是进位后循环到了第一位代表溢出了
                    isOverFlow  = true;
                }else {                 // 没有溢出，把当前位置的数字变成对10求模进位
                    charNum[i] = '0';
                }
            }else {            // 不进位，直接改变值
                charNum[i] = nSum;
                break;
            }
        }
        return isOverFlow;
    }

    /**
     * 打印操作
     * @param chars
     */
    private void printCharNam(char[] chars){
        boolean isPrint = false;
        for (int i = 0;i<chars.length-1;i++){
            if (chars[i] != '0') isPrint = true;
            if (isPrint) System.out.print(chars[i]);
        }
        System.out.println("");
    }
}
