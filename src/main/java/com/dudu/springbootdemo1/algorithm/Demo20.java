package com.dudu.springbootdemo1.algorithm;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2020/9/27 7:33 下午
 */
public class Demo20 {
    public ListNode fx(ListNode root1,ListNode root2){
        if (root1==null){
            return root1;
        }
        if (root2==null){
            return root2;
        }
        ListNode node1=root1;
        ListNode node2=root2;
        //首先获取链表的长度
        int count1=0;
        while(node1!=null){
            count1++;
            node1=node1.next;
        }
        int count2=0;
        while(node2!=null){
            count2++;
            node2=node2.next;
        }
        //长链表先走长度差
        int num=Math.abs(count1-count2);
        //root2链表长，先走num步
        if (count2>count1){
            while(num!=0){
                root2=root2.next;
                num--;
            }
            //两个链表同时走
            if (root1!=root2){
                root1=root1.next;
                root2=root2.next;
            }
            //假如链表没有相交元素
            if (root1==null){
                return root1;
            }
            if (root2==null){
                return root2;
            }
            return root1;
        }else{
            while(num!=0){
                root1=root1.next;
                num--;
            }
            //两个链表同时走
            if (root1!=root2){
                root1=root1.next;
                root2=root2.next;
            }
            if (root1==null){
                return root1;
            }
            if (root2==null){
                return root2;
            }
            return root1;
        }
    }

}
