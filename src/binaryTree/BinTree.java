package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author liuLiang
 * @create 2022/3/23 9:30
 * @Description 一个基本的二叉树节点数据结构
 * @explain
 */
public class BinTree {
    private List<Integer> valueList = null;
    private BinTree left;
    private BinTree right;

    /**
     * 添加值
     * @param value
     */
    public void addValue(Integer value){
        if (valueList == null) valueList = new ArrayList<>();
        valueList.add(value);
    }

    public Integer getValue() {
        return valueList.get(0);
    }

    public BinTree() {
    }

    @Override
    public String toString() {
        return valueList.toString();
    }

    public BinTree(BinTree left, BinTree right) {
        this.left = left;
        this.right = right;
    }

    public List<Integer> getValueList() {
        return valueList;
    }


    public BinTree getLeft() {
        return left;
    }

    public void setLeft(BinTree left) {
        this.left = left;
    }

    public BinTree getRight() {
        return right;
    }

    public void setRight(BinTree right) {
        this.right = right;
    }
}
