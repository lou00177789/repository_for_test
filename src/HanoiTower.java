/**
 * @author liuLiang
 * @create 2022/2/21 9:44
 * @Description 递归解决汉诺塔问题
 * 这个有点迷，记得看看，网上抄的代码，勉强看懂
 * @explain
 */
public class HanoiTower {


    static int nDisks = 3;

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        doTower(nDisks, 'A', 'B', 'C');
    }

    public static void doTower(int topN,char from,char inter,char to){
        if(topN == 1)
            System.out.println("Disk 1 from "+from+" to "+to);
        else{
            doTower(topN-1,from,to,inter);
            System.out.println("Disk "+topN+" from "+from+" to "+to);
            doTower(topN -1,inter,from,to);
        }
    }
}
