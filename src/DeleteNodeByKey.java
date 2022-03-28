import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author liuLiang
 * @create 2022/1/20 12:18
 * @Description
 * @explain
 */
public class DeleteNodeByKey {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList(Arrays.asList(1,2,3,4,6,7,3,2,4,5,7));
        list.remove();
        list.add(3);

    }
}
