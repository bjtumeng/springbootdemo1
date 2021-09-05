package com.dudu.springbootdemo1.algorithm;

/**
 * @Description:输入一个链表，反转链表后，输出新链表的表头
 * @author:zhaomeng
 * @date:2020/8/30 6:57 下午
 */
public class Demo8 {
    public ListNode ReverseList(ListNode head) {
       if (head==null){
           return null;
       }
       ListNode pre=null;
       ListNode next;
       while(head!=null){
          next=head.next;
          head.next=pre;
          pre=head;
          head=next;
       }
      return pre;
    }
}
