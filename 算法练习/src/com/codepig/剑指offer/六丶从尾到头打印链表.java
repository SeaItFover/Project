package com.codepig.剑指offer;

import java.util.ArrayList;
import java.util.Stack;

public class 六丶从尾到头打印链表 {
    public static void main(String[] args) {
        //单链表的创建

    }

    public static ArrayList<Integer> printListFromTailToHead (ListNode listNode){
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> req = new ArrayList<>();
        while (!stack.empty()){
            req.add(stack.pop());
        }
        return req;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
    }

}