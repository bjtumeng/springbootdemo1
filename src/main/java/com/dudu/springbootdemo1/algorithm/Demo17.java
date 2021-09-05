package com.dudu.springbootdemo1.algorithm;

/**
 * @Description:判断是否是对称二叉树
 * @author:zhaomeng
 * @date:2020/9/20 8:03 下午
 */
public class Demo17 {
    public boolean isSymmetric (TreeNode root) {
      if (root==null){
          return true;
      }
       return solution (root.left,root.right);
    }
    public boolean solution(TreeNode left,TreeNode right){
        if (left==null&&right==null){
            return true;
        }
        if (left==null||right==null){
            return false;
        }
        if (left.val!=right.val){
            return false;
        }
       return solution(left.left,right.right)&&solution(left.right,right.left);
    }
}
