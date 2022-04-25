import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liuLiang
 * @create 2022/1/19 8:49
 * @Description
 * @explain
 */
public class Learn1 {
    public static void main( String[] args ){
        Learn1 learn1 = new Learn1();
        int power = learn1.power(5, 0);
        System.out.println(power);
    }
    public int power(int num,int n){
        if (n == 1) return n;
        else return n*power(num,n-1);
    }


    /**
     * 反射改一个字符串的值
     * @throws Exception
     */
    public void test() throws Exception{
        String str = "123";
        System.out.println(str);
        Class<? extends String> aClass = str.getClass();
        Field value = aClass.getDeclaredField("value");
        value.setAccessible(true);
        char[] o = (char[]) value.get(str);
        o[1] = 68;
        System.out.println(str);
    }

    public static String getNextMarkCode(String preCode) throws Exception {

        // 按指定模式在字符串查找
        String strPattern = "([A-Z]+)[0-9]{6}([A-Z]?)(\\d{4})";


        // 创建 Pattern 对象
        Pattern r = Pattern.compile(strPattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(preCode);
        if (m.find()){
            // 首拼
            String head = m.group(1);
            // 当前年月日
            String yyMMdd = "220106";
            // 字母标识
            char letter = m.group(2).toCharArray()[0];
            // 数字序号
            int index = Integer.parseInt(m.group(3)) + 1;

            if (index >= 10000){
                letter = ++letter;
                index = 1;
            }
            // 序号变成字符串，位数4不够前面补0
            StringBuilder sb  = new StringBuilder(String.valueOf(index));

            int length = sb.length();
            for (int i=0;i<4-length;i++){
                sb.insert(0,"0");
            }

            return head + yyMMdd + letter + sb;
        }
       return null;
    }

    public static void testEl(){

        String str = "JQ220106X0000";
        String el = "^[A-Z]+[0-9]{6}[A-Z][0-9]{4}";
        Pattern pattern = Pattern.compile(el);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()){

        }
        boolean matches = str.matches(el);
        System.out.println(matches);

    }
    public static char[][] matrix = new char[][]{
            {'w', '4', '7', 'e', 'h'},
            {'g', 'j', 'b', 'n', 'm'},
            {'t', 'l', 'v', 'k', 'p'},
            {'q', 'x', 'r', 'j', 'o'},
            {'l', 'h', 'a', 'v', 'n'}
    };

    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
     * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
     * @param matrix
     * @param word
     * @return
     */
    public  static  boolean findWordInMatrix(char[][] matrix,String word){
        char[] words = word.toCharArray();

        for (int i = 0;i<matrix.length;i++){
            for (int j = 0;j<matrix[0].length;j++){
                if (dfs(matrix,words,i,j,0))return true;
            }
        }
        return false;
    }
    public static boolean dfs(char[][] matrix,char[] words,int i,int j,int k){
        // 越界或者不匹配直接返回false
        if(i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0 || matrix[i][j] != words[k] )return false;
        // 上一次的匹配是最后一个匹配返回匹配成功
        if (k == words.length - 1)return true;
        // 防止重复匹配
        matrix[i][j] = '#';
        boolean res = dfs(matrix,words,i-1,j,k+1)//上
                ||dfs(matrix,words,i,j-1,k+1)// 左
                ||dfs(matrix,words,i+1,j,k+1)// 下
                ||dfs(matrix,words,i,j+1,k+1);// 右

        // 修改回来防止重复匹配而改变的值
        matrix[i][j] = words[k];
        return res;
    }


    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，
     * 我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
     * 输出旋转数组的最小元素。
     * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，
     * 该数组的最小值为 1。
     * @param rotateArray
     * @return
     */
    public static int getMinForRotateArray(int[] rotateArray){
        int right = rotateArray.length -1;
        int left = 0;
        while (right > left){
            int mid = (right + left)/2;
            if (rotateArray[mid] > rotateArray[left]) {
                left = mid + 1;
            }else if (rotateArray[mid] < rotateArray[left]){
                right = mid -1;
            }else {
                return Learn1.findMin(rotateArray,left,right);
            }
        }
        return rotateArray[left];
    }
    public static int findMin(int[] ints,int left,int right){
        int min = ints[left];
        for (int i:ints){
            if (i < min){
                min = i;
            }
        }
        return min;
    }

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     */
    public static Iterator<Integer> list = Arrays.asList(1,2,3,3,4,4,44).iterator();
    public static void reversePrintLink(Iterator<Integer> list){
        Stack<Integer> stack = new Stack<>();
        while (list.hasNext()){
            stack.push(list.next());
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }

    }

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * @param str
     * @return
     */
    public static String replaceSpace(String str){
        StringBuilder res = new StringBuilder();
        for (Character c : str.toCharArray()){
            if (c == ' '){
                res.append("%20");
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }


    public static int[][] nums = new int[][]{
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
    };

    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
     * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param matrix
     * @param target
     * @return
     */
    public static boolean isExist(int[][] matrix,int target){

        int i = matrix.length -1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length){
            if (matrix[i][j] > target){
                i--;
            }else if(matrix[i][j] < target){
                j++;
            }else {
                return true;
            }
        }
        return false;
    }

    /**
     * 找出数组中重复的数字。
     *  *
     *  * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
     *  *
     *  * 请找出数组中任意一个重复的数字。
     * @param nums
     * @return
     */
    public static int findRepeatNum(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int num:nums){
            if (set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }


}
