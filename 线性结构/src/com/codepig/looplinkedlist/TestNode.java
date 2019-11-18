package com.codepig.looplinkedlist;

public class TestNode {
    public static void main(String[] args) {
        LoopNode loopNode1 = new LoopNode(1);
        LoopNode loopNode2 = new LoopNode(2);
        LoopNode loopNode3 = new LoopNode(3);
        LoopNode loopNode4 = new LoopNode(4);

        loopNode1.append(loopNode2).append(loopNode3).append(loopNode4);
        System.out.println(loopNode1.next().next().next().getData());

        //判断节点是不是最后一个节点
        System.out.println(loopNode1.isLast());

        loopNode1.show();
        loopNode1.next().removeNext();
        loopNode1.show();
        loopNode1.next().next().insertNode(new LoopNode(5));
        loopNode1.show();
    }

}
