package com.dudu.springbootdemo1.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:遍历二叉树
 * 二叉树前序遍历
 * @author:zhaomeng
 * @date:2020/8/30 7:08 下午
 */
public class Demo9 {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list =new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        //终止条件
          if (root==null){
              return list;
          }
          stack.push(root);
          while(!stack.empty()){
              TreeNode pop = stack.pop();
              list.add(pop.val);
              if (pop.right!=null){
                      stack.push(pop.right);
                  }
                  if (pop.left!=null){
                      stack.push(pop.left);
                  }
              }
          return list;
    }
}
