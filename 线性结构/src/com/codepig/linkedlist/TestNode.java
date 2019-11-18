package com.codepig.linkedlist;

public class TestNode {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.append(node2).append(node3).append(node4);
        System.out.println(node1.next().next().next().getData());

        //判断节点是不是最后一个节点
        System.out.println(node1.isLast());

        node1.show();
        node1.next().removeNext();
        node1.show();
        node1.next().next().insertNode(new Node(5));
        node1.show();
    }

}
