package com.codepig.linkedlist;

/**
 * 一个节点
 */
public class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }

    //为节点追加节点
    public Node append(Node node){
        //当前节点
        Node currentNode = this;
        //循环向后找
        while (true){
            //取出下一个节点
            Node nextNode = currentNode.next;
            //如果下一个节点为null，说明当前节点已经是最后一个节点
            if(nextNode == null){
                break;
            }
            //如果下一个节点不为null，将下一个节点赋给当前节点
            currentNode = nextNode;
        }
        //将新节点赋给当前节点（始终指向最后一个节点）的下一个节点
        currentNode.next = node;
        return node;
    }

    public Node next(){
        return this.next;
    }

    public int getData(){

        return this.data;
    }

    public boolean isLast(){
        return next == null;
    }

    public void removeNext(){
        next = next.next;
    }

    public void show(){
        Node currentNode = this;
        while (true){
            System.out.print(currentNode.data+" ");
            currentNode = currentNode.next;
            if (currentNode == null){
                break;
            }
        }
        System.out.println();
    }

    public void insertNode(Node node){
        Node nextNext = next;
        next = node;
        node.next = nextNext;
    }
}