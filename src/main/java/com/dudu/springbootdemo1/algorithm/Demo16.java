package com.dudu.springbootdemo1.algorithm;

/**
 * @Description:二叉树镜像
 * @author:zhaomeng
 * @date:2020/9/20 7:28 下午
 */
public class Demo16 {
    public void Mirror(TreeNode root) {
       if (root==null){
           return ;
       }
       Mirror(root.left);
       Mirror(root.right);
       //交换左右两边位置
        TreeNode temp=root.right;
        root.right=root.left;
        root.left=temp;
    }
}
