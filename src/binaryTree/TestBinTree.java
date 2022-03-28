package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuLiang
 * @create 2022/3/23 9:31
 * @Description 一些二叉树的基本操作
 * @explain
 */
public class TestBinTree {
    public static int[] arr = new int[]{4,7,55,9,23,43,8,2,65,44,9,73,66,84,34};

    public static void main(String[] args) {
        TestBinTree test = new TestBinTree();
        BinTree binTree = test.createBinTree(arr);
        test.leftFirstShow(binTree);
        System.out.println();
        test.rightFirstShow(binTree);
    }

    /**
     * 传入树节点的根节点，输出平衡二叉树的根节点
     * @param root
     * @return
     */
    public BinTree madeBalance(BinTree root){

        return root;
    }

    /**
     * 传入数组，构造左大右小的大小关系的非平衡二叉树
     * @param arr
     * @return
     */
    public BinTree createBinTree(int[] arr){
        BinTree root = null;
        for (int i=0;i<arr.length;i++){
            //如果是第一个节点,设置成根节点
            if (root==null){
                root = new BinTree();
                root.addValue(arr[i]);
                continue;
            }else {//不是的话就添加
                BinTree node = new BinTree();
                node.addValue(arr[i]);
                addNode(root,node);
            }
        }
        return root;
    }

    /**
     * 构造左大右小的大小关系的非平衡二叉树的递归
     * @param root
     * @param node
     */
    public void addNode(BinTree root,BinTree node){
        Integer rootValue = root.getValue();
        Integer nodeValue = node.getValue();

        //如果节点值大,放右边
        if (nodeValue>rootValue){
            //没有右节点
            if (root.getRight()==null) {
                root.setRight(node);
            }else {
                addNode(root.getRight(),node);
            }
        }
        //如果节点值小,放左边
        if (nodeValue<rootValue){
            //没有左节点
            if (root.getLeft()==null){
                root.setLeft(node);
            } else {
                addNode(root.getLeft(),node);
            }
        }

        //如果节点值相等,放一起
        if (nodeValue.equals(rootValue)){
            root.addValue(nodeValue);
        }
    }

    /**
     * 中序遍历 左中右
     */
    public void leftFirstShow(BinTree root){
        if (root.getLeft()!=null){
            leftFirstShow(root.getLeft());
        }

        System.out.print(root);

        if (root.getRight()!=null){
            leftFirstShow(root.getRight());
        }
    }

    /**
     * 中序遍历 右中左
     */
    public void rightFirstShow(BinTree root){
        if (root.getRight()!=null){
            rightFirstShow(root.getRight());
        }

        System.out.print(root);

        if (root.getLeft()!=null){
            rightFirstShow(root.getLeft());
        }
    }

    /**
     * 先序遍历  中左右
     */
    public void midFirstShow(BinTree root){
        System.out.print(root);

        if (root.getLeft()!=null){
            midFirstShow(root.getLeft());
        }

        if (root.getRight()!=null){
            midFirstShow(root.getRight());
        }

    }
}
