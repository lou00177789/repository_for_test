import java.util.Stack;

/**
 * @author liuLiang
 * @create 2022/1/19 17:19
 * @Description
 * @explain
 */
public class CQueue {
    //主栈作为队列
    private Stack<Integer> stack1;
    //辅助栈
    private Stack<Integer> stack2;

    public void init(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value){
        stack1.push(value);
    }

    public int deleteHead(){
        // 如果辅助队列有数据直接弹出辅助栈数据完成删除头结点
        if (stack2.size() > 0){
            return stack2.pop();
        }
        // 辅助队列为空且主队列有数据，主栈全部出栈然后入栈到辅助栈，然后弹出
        if (stack1.size() > 0){
            while (stack1.size() > 0){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        // 如果都没得数据，return -1
        return -1;
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.init();
        cQueue.appendTail(5);
        cQueue.appendTail(53);
        cQueue.appendTail(54);
        cQueue.appendTail(55);cQueue.appendTail(59);cQueue.appendTail(57);
        cQueue.appendTail(56);
        for (int i=1;i < 5;i++){
            int x = cQueue.deleteHead();
            System.out.println(x);
        }
    }
}
