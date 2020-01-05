package com.codepig.heapsort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] tree = new int[]{10,5,10,3,1,0,7,9};
        int length = tree.length;
        heapSort(tree,length);
        System.out.println(Arrays.toString(tree));
    }

    public static void heapSort(int[] tree,int length){
        for (int i = (length-1)/2; i>=0; i--){
            heapify(tree,i,length);
        }
    }

    public static void heapify(int[] tree,int root,int length){
        int left = 2*root+1;
        int right = 2*root+2;
        int max = tree[root];
        if (left < length && tree[left] > max){
            max = tree[left];
        }
        if (right <length && tree[right] > max){
            max = tree[right];
        }
       // if (max != tree[root]){
            if (left < length && max == tree[left]){
                tree[left] = tree[root];
                heapify(tree,left,length);
            }
            if (right < length && max == tree[right]){
                tree[right] = tree[root];
                heapify(tree,right,length);
            }
            tree[root] = max;
       // }
    }
}
