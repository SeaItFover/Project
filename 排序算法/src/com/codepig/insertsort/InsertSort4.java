package com.codepig.insertsort;

import java.util.Arrays;

/**
 * 插入排序也就是每一次都认为前面的数据是有序的，然后依次插入。
 */
public class InsertSort4 {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,2,5,9,1,0,8,3,1,5};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[] arr){
        for (int i = 1;i <arr.length; i++){
            int temp = arr[i];
            int index = i-1;
            while (index >= 0 && arr[index] > temp){
                arr[index+1] = arr[index];
                index--;
            }
            arr[index+1] = temp;
        }
    }
}
