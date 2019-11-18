package com.codepig.looplinkedlist;

/**
 * 一个节点
 */
public class LoopNode {
    int data;
    LoopNode next = this;

    public LoopNode(int data){
        this.data = data;
    }

    //为节点追加节点
    public LoopNode append(LoopNode loopNode){
        //当前节点
        LoopNode currentLoopNode = this;
        //循环向后找
        while (true){
            //取出下一个节点
            LoopNode nextLoopNode = currentLoopNode.next;
            //如果下一个节点为null，说明当前节点已经是最后一个节点
            if(nextLoopNode == null){
                break;
            }
            //如果下一个节点不为null，将下一个节点赋给当前节点
            currentLoopNode = nextLoopNode;
        }
        //将新节点赋给当前节点（始终指向最后一个节点）的下一个节点
        currentLoopNode.next = loopNode;
        return loopNode;
    }

    public LoopNode next(){
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
        LoopNode currentLoopNode = this;
        while (true){
            System.out.print(currentLoopNode.data+" ");
            currentLoopNode = currentLoopNode.next;
            if (currentLoopNode == null){
                break;
            }
        }
        System.out.println();
    }

    public void insertNode(LoopNode loopNode){
        LoopNode nextNext = next;
        next = loopNode;
        loopNode.next = nextNext;
    }
}
