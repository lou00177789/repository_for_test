import java.util.HashSet;

/**
 * @author liuLiang
 * @create 2022/2/18 15:52
 * @Description 输出给定单词的所有变位字 word
 * @explain
 */
public class DisplayFullWord {
    public static DisplayFullWord fullWord = new DisplayFullWord();
    public static char[] word = "hpp".toCharArray();
    public static HashSet<String> set = new HashSet();

    public static void main(String[] args) {
        fullWord.showFull(word, 0);
        System.out.println(set);
    }

    /**
     * 求全排列
     */
    public void showFull(char[] chars,int index){
        // index=length说明到最后一个了就打印
        if (chars.length == index){
            set.add(String.copyValueOf(chars));
        }
        // 对字符数据轮换操作,换length次
        for (int i=0;i<chars.length-index;i++){
            //对这个词的右边的n-1进行全排列
            showFull(chars,index+1);
            //轮换一次
            rotation(chars,index);
        }
    }

    /**
     * 轮换数组操作
     */
    public void rotation(char[] chars,int index){
        //头拿出来
        char tem = chars[index];
        //前移
        for (int i=index+1;i<chars.length;i++){
            chars[i-1] = chars[i];
        }
        //放头到屁股
        chars[chars.length-1] = tem;
    }

}
