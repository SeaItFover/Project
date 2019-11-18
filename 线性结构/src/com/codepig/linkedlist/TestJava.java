package com.codepig.linkedlist;

/**
 * 类加载时会执行方法块中的内容
 */
public class TestJava {
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.append(node2);
        System.out.println(2);
    }

    public static void main(String[] args) {
        TestJava j = new TestJava();
    }
}
