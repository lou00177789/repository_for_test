import java.util.Arrays;
import java.util.Collections;

/**
 * @author liuLiang
 * @create 2022/2/21 11:49
 * @Description 背包问题
 * @explain
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] knapsack = new int[]{11,8,7,6,5};
        int[] temp = new int[knapsack.length];
        KnapsackProblem problem = new KnapsackProblem();
        problem.find(20,knapsack,temp);
    }

    private void find(int value, int[] knapsack,int[] temp) {
        if (value == 0){
            System.out.println(Collections.singletonList(temp));
        }
        for (int i=0;i<knapsack.length;i++){
            find(value-knapsack[i],knapsack,temp);
        }
    }
}
