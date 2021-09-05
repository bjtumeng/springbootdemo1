package com.dudu.springbootdemo1.algorithm;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2020/9/18 7:43 下午
 */
public class Demo14 {
    public ListNode rev(ListNode root){
        if (root==null){
            return root;
        }
        ListNode head=root;
        //前置指针
        ListNode pre=null;
        //后置指针
        ListNode next;
        while(head!=null){
            //保留后继指针
            next=head.next;
            //反转
            head.next=pre;
            //移动指针
            pre=head;
            head=next;
        }
        return pre;
    }
}
