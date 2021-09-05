package com.dudu.springbootdemo1.algorithm;

import java.util.HashMap;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2020/9/29 11:09 下午
 */
class LRUCache {
    //设置双向链表
    class Node{
        //前指针
        private Node pre;
        //后指针
        private Node next;
        //node节点的值
        private int value;
        //node结点的key
        private int key;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    //虚拟首节点
    private Node head;
    //虚拟尾节点
    private Node tail;
    //长度
    private int length;
    private HashMap<Integer,Node> map;

    public LRUCache(int capacity) {
        map=new HashMap<>(capacity);
        this.length=length;
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        //移动到尾部
        Node target=map.get(key);
        moveTail(target,false);
        return target.value;
    }

    public void put(int key, int value) {
        //map中有的话，直接放到最后
        Node target= map.get(key);
        if(map.containsKey(key)){
            moveTail(target,false);
            target.value=value;
            return;
        }
        //直接新增元素
        Node node1=new Node(key,value);
        map.put(key,node1);
        moveTail(node1,true);
        //超过链表长度  删除头节点
        if(length<map.size()){
            map.remove(head.next.key);
            node1.pre=head;
            node1.next=head.next.next;
            head.next=node1;
        }

    }

    public void  moveTail(Node node,boolean flag){
        //先删除节点
        if(!flag){
            node.pre.next=node.next;
            node.next.pre=node.pre;
        }
        //末尾插入结点
        tail.pre.next=node;
        node.next=tail;
        node.pre=tail.pre;
        tail.pre=node;
    }
}

